package donotedit;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class SampleWork {

	/**
	 * メンバ変数
	 */
	private static String inDirectory = null;			// 入力ディレクトリ
	private static String outDirectory = null;			// ファイル生成先
	private static String sampleErrorMessage = null;	// サンプル用のエラー処理

	/**
	 * スタティックイニシャライザ
	 * (入力ディレクトリと出力ディレクトリのパスを取得)
	 */
	static  {
		// 入力ディレクトリを取得
		// ※※※直に指定する場合は下記を書き換えてください。※※※
		inDirectory = getRootDirectoryPath("data");
		//inDirectory = "C:\\Program Files\\xlscrtj\\samples\\client\\data\\";

		// ファイル生成先を取得
		// ※※※直に指定する場合は下記を書き換えてください。※※※
		outDirectory = getFileOutputDirectory();
		//outDirectory = "C:\\windows\\temp\\excelcreatorsample\\";

		// サンプルで参照するディレクトリのチェック
		validateSampleDirectory();
	}

	/**
	 * サンプルのファイル入力ディレクトリのパスを取得します。
	 * ※既定では ecjavaclient/data が取得されます。
	 */
	public static String getInDirectory() {
		return inDirectory;
	}

	/**
	 * サンプルのファイル出力ディレクトリのパスを取得します。
	 * ※既定では 一時ディレクトリ内の 「excelcreatorsample」 ディレクトリが取得されます。
	 */
	public static String getOutDirectory() {
		return outDirectory;
	}

	/**
	 * 生成ファイル(Excel/PDF/HTML)のオープン処理
	 */
	public static void fileOpen(String outFileName) {
		try {
			final File file = new File(outFileName);
			final Desktop desktop = Desktop.getDesktop();
			desktop.open(file);
		}
		catch (final IOException ex) { }
	}

	/**
	 * jar ファイル、または eclipse , NetBeans デバッグ実行時の root ディレクトリパスを取得します。
	 * 引数のサブディレクトリのパスを指定することで、サブディレクトリまでのパスが取得できます。
	 * ※デバッグ時と実行時でファイル入出力ディレクトリを統一するためのサンプル用の処理です。
	 * @return ルートディレクトリ＋サブディレクトリのフルパス。
	 * 取得パスの存在チェックは行いません。パスが不正な場合は nullを返します。
	 */
	private static String getRootDirectoryPath(String subDirectory) {
		try {
			// 【取得文字列1】"/donotedit/SampleWork.class"
			String resourceName = "/" + SampleWork.class.getName().replaceAll("\\.", "/") + ".class";
			// 【取得文字列1】file:/D:/※配置パス※/ecjavaclient.jar!/donotedit/SampleWork.class
			// 【取得文字列2】/D:/※配置パス※/ecjavaclient/bin/donotedit/SampleWork.class
			// 【取得文字列3】/D:/※配置パス※/ecjavaclient/build/classes/donotedit/SampleWork.class
			// 【取得文字列4】file:/home/※配置パス※/ecjavaclient.jar!/donotedit/SampleWork.class
			String resourcePath = SampleWork.class.getResource(resourceName).getPath();
			// 先頭から 1文字目の "/" までを削除
			String  path = resourcePath.replaceFirst("^.*?/", "");
			// 末尾の "!" ＋ リソース名を削除
			path = path.replaceFirst("!" + resourceName + "$","");
			// 末尾のリソース名を削除
			path = path.replaceFirst(resourceName + "$","");
			// 末尾の "/classes" を削除(NetBeans用)
			path = path.replaceFirst("/classes$","");
			if ((path == null) || ("".equals(path) == true)) return null;
			boolean isWindows = ("\\".equals(File.separator));
			if ((!isWindows) && (!path.startsWith("/"))) path = "/" + path;
			java.io.File tempDirectory = new File(path);
			if (tempDirectory.exists() == false) return null;
			path = tempDirectory.getAbsolutePath();
			tempDirectory = new File(path);
			path = tempDirectory.getParent();
			if (path.endsWith(File.separator) == false) path +=  File.separator;
			if ((subDirectory != null) && ("".equals(subDirectory) == false)) {
				if (isWindows == true) subDirectory = subDirectory.replace("/", File.separator);
				else subDirectory = subDirectory.replace("\\", File.separator);
				if (subDirectory.startsWith(File.separator) == true) subDirectory = subDirectory.substring(1, subDirectory.length());
				path += subDirectory;
				if (path.endsWith(File.separator)==false) path += File.separator;
			}
			return path;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 引数で指定された環境変数の一時ディレクトリを検索し、サンプル用ファイル出力ディレクトリの作成と
	 * パスを返します。
	 * 指定した環境変数のディレクトリを検索し、該当がない場合は既定のディレクトリに生成します。
	 * @return サンプル用ファイル出力ディレクトリのパス。出力ディレクトリの生成ができない場合は null
	 */
	private static String getFileOutputDirectory() {
		try {
			String pathSeparator = System.getProperty("path.separator");
			String fileSeparator = File.separator;
			String[] envArray = new String[] {"CATALINA_TMPDIR","TEMP","TMP"};
			String path = null;
			boolean isWindows = ("\\".equals(fileSeparator));
			for (String env : envArray) {
				path = System.getenv(env);
				if ((path == null) || ("".equals(path) == true)) {
					path = null;
					continue;
				}
				break;
			}
			if (path == null) {
				if (isWindows == false) path = "/var/tmp/";
				else path = "c:\\Windows\\Temp\\";
			}
			else {
				path = path.split(pathSeparator)[0];
				if (path.endsWith(fileSeparator)==false) path += fileSeparator;
			}
			java.io.File tempDirectory = new File(path);
			if (tempDirectory.exists() == false) return null;
			if (tempDirectory.isDirectory() == false) return null;
			path += "excelcreatorsample" + fileSeparator;
			java.io.File workDirectory = new java.io.File(path);
			if (workDirectory.exists() == false) {
				workDirectory.mkdir();
			}
			else {
				if (workDirectory.isDirectory() == false) return null;
			}
			return path;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * サンプルのエラーメッセージを取得
	 */
	public static String getSampleErrorMessage() {
		return sampleErrorMessage;
	}

	/**
	 * サンプルのエラーの有無を取得
	 */
	public static boolean isSampleError() {
		return (sampleErrorMessage != null);
	}

	/**
	 * サンプルで参照するディレクトリのチェック
	 */
	private static void validateSampleDirectory() {
		sampleErrorMessage = "";
		// 入力ディレクトリの確認
		if ((inDirectory == null) || ("".equals(inDirectory) == true)) {
			sampleErrorMessage += "【入力ディレクトリ】\r\n";
			sampleErrorMessage += "「client」サンプルの動作に必要な「data」ディレクトリがありません。\r\n";
			sampleErrorMessage += "サンプルのディレクトリ内の「data」ディレクトリのパスを\r\n";
			sampleErrorMessage += "/donotedit/SampleWork.javaの スタティックコンストラクタに指定してください。\r\n\r\n";
		}
		else {
			java.io.File workDirectory = new java.io.File(inDirectory);
			if ((workDirectory.exists() == false) || (workDirectory.isDirectory() == false)) {
				java.io.File workParentDirectory = new java.io.File(workDirectory.getParent());
				sampleErrorMessage += "【入力ディレクトリ】\r\n";
				sampleErrorMessage += "「client」サンプルの動作に必要な「data」ディレクトリがありません。\r\n";
				sampleErrorMessage += "サンプルディレクトリ内の「data」ディレクトリを\r\n";
				sampleErrorMessage += "「" + workParentDirectory.getAbsolutePath() + "」\r\n";
				sampleErrorMessage += "に配置してください。 \r\n\r\n";
			}
		}
		// ファイル生成先の確認
		if ((outDirectory == null) || ("".equals(outDirectory) == true)) {
			sampleErrorMessage += "【ファイル生成先】\r\n";
			sampleErrorMessage += "「client」サンプルのファイル生成先の参照が出来ません。\r\n";
			sampleErrorMessage += "/donotedit/SampleWork.javaのスタティックコンストラクタ内でパスを指定してください。 \r\n\r\n";
		}
		if ("".equals(sampleErrorMessage)==true) sampleErrorMessage = null;
	}

}
