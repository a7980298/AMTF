package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.adv.excelcreator.creator.ErrorListener;
import jp.co.adv.excelcreator.creator.ExcelCreatorException;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import model.SampleWork;


public class CellPosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String fileName;
	private String outFileName;

	public CellPosServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse  response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 指定した環境変数から一時ディレクトリを取得
		outFileName = SampleWork.getFileOutputDirectory();
		if (outFileName == null) {
			SampleWork.writeDescription(response,"一時ディレクトリの取得に失敗しました。<br />SampleWork.getFileOutputDirectory メソッド内の環境変数を調整してください");
			return;
		}
		// テンプレートファイルパスの取得
		ServletContext context = this.getServletContext();
		// Excelファイル生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		xlsxCreator.setKeyword("**");
		// Error イベント
		result = "";
		xlsxCreator.addErrorEvent(new ErrorListener(){
			@Override
			public void error(ExcelCreatorException e) {
				result += e.getErrorMessage() + "<br />";
			}
		}
				);

		// セルの指定方法
		if (request.getParameter("cellpos") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatecellpos.xlsx");	// テンプレート Excel ファイル
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'cellpos'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// オーバーレイオープン
			//================================================================//
			xlsxCreator.openBook(outFileName, fileName);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// A1 参照形式
			// セル位置を "A1" のように直接文字列で指定できます。
			xlsxCreator.getCell("A1").setValue("A1参照形式");

			// 座標形式
			// セル位置を(0, 0)のように座標形式で指定できます。
			xlsxCreator.getPos(0, 1).setValue("座標形式");

			// 変数名
			// セルに設定した特定のキーワード文字列 (デフォルトで"**") から始まる
			// 文字列(例:“**金額”)で指定できます。テンプレートで変数名の位置を
			// 変更すれば、プログラムを変更せずにデータの設定位置を変えることがで
			// き、さらに複数のセルに同じデータを設定したい場合などに便利な機能です。
			xlsxCreator.getCell("**Name").setValue("変数名");

			// セルの名前
			// Excel の名前ボックスに入力したセルの名前で指定できます。テンプレー
			// トで名前の位置を変更すれば、プログラムを変更せずにデータの設定位置
			// を変えることができます。
			xlsxCreator.getCell("セル名").setValue("セル名");

			//【3】===========================================================//
			// Excel ファイルクローズ
			//================================================================//
			xlsxCreator.closeBook(true);

			if (result.equals("") == false) {
				SampleWork.writeDescription(response, result);
				return;
			}

			// 生成ファイルをクライアントに転送
			SampleWork.executeFileTrasfer(response, outFileName);
		}
		// テンプレート Excel ファイルオープン
		else if (request.getParameter("templateopen") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatecellpos.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
	}

}