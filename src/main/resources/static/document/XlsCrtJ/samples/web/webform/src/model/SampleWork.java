package model;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class SampleWork {

	/**
	 * 引数で指定された環境変数の一時ディレクトリを検索し、サンプル用ファイル出力ディレクトリの作成と
	 * パスを返します。
	 * 指定した環境変数のディレクトリを検索し、該当がない場合は既定のディレクトリに生成します。
	 * @return サンプル用ファイル出力ディレクトリのパス。出力ディレクトリの生成ができない場合は null
	 */
	public static String getFileOutputDirectory() {
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
	 * クライアントへのファイル送信
	 * @param response サーブレットクラスの response
	 * @param filePath 送信対象のファイルパス
	 */
	public static void executeFileTrasfer(HttpServletResponse response, String filePath) {
		ServletOutputStream outputStream = null;
		FileInputStream     fileInputStream = null;
		DataInputStream     inputStream  = null;
		try {
			java.io.File file = new java.io.File(filePath);
			if (file.exists()) {
				//レスポンスヘッダーの作成
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setContentLength((int) file.length());
				response.setContentType("text/plain");
				response.setHeader("Content-Disposition", "attachment; filename=\""	+ file.getName() + "\"");
				int length = 0;
				outputStream = response.getOutputStream();
				byte[] buf = new byte[1024];
				fileInputStream = new FileInputStream(file);
				inputStream = new DataInputStream(fileInputStream);
				while ((inputStream != null) && ((length = inputStream.read(buf)) != -1)) {
					outputStream.write(buf, 0, length);
				}
				outputStream.flush();
			}
		}
		catch (Exception e) {
			writeDescription(response, e.getMessage() + e.getStackTrace().toString());
		}
		closeStreamQuietly(fileInputStream);
		fileInputStream = null;
		closeStreamQuietly(inputStream);
		inputStream = null;
		closeStreamQuietly(outputStream);
		outputStream = null;
	}

	/**
	 * ブラウザへのエラー出力
	 * @param response サーブレットクラスの response
	 * @param message エラー内容
	 */
	public static void writeDescription(HttpServletResponse response,String message) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("<!DOCTYPE html>");
			response.getWriter().println("<html lang=\"ja\">");
			response.getWriter().println("<head>");
			response.getWriter().println("<meta charset=\"UTF-8\">");
			response.getWriter().println("</head>");
			response.getWriter().println("<body>");
			response.getWriter().println(message);
			response.getWriter().println("</body>");
			response.getWriter().println("</html>");
		}
		catch (Exception e) { }

	}

	public static void closeStreamQuietly(Closeable stream) {
		if (stream == null) return;
		try { stream.close(); } catch (IOException e) { }
	}
}
