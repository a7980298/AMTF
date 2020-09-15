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


public class HensuuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String fileName;
	private String outFileName;

	public HensuuServlet() {
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

		// 変数名を使用した値の設定
		if (request.getParameter("hensuu") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatehensuu.xlsx");	// テンプレート Excel ファイル
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'varname'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// オーバーレイオープン
			//================================================================//
			xlsxCreator.openBook(outFileName, fileName);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.getCell("**TextBox").setValue("テキストボックス");
			xlsxCreator.getCell("**Name").setValue("同一変数名");
			xlsxCreator.getCell("**Shouhin").setValue("ExcelCreator for Java");
			xlsxCreator.getCell("**Suuryou").setValue(10);
			xlsxCreator.getCell("**Tanka").setValue(40000);
			xlsxCreator.getCell("**Shouhin", 0, 1).setValue("VB-Report 8");
			xlsxCreator.getCell("**Suuryou", 0, 1).setValue(8);
			xlsxCreator.getCell("**Tanka", 0, 1).setValue(85000);
			xlsxCreator.getCell("**Shouhin", 0, 2).setValue("ExcelWebForm");
			xlsxCreator.getCell("**Suuryou", 0, 2).setValue(5);
			xlsxCreator.getCell("**Tanka", 0, 2).setValue(70000);
			xlsxCreator.setFullCalcOnLoad(true);

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
		// 変数名キーワード文字列の変更
		else if (request.getParameter("keyword") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatehensuu2.xlsx");	// テンプレート Excel ファイル
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'keyword'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));
			String keyword = request.getParameter("strkeyword");

			//【1】===========================================================//
			// オーバーレイオープン
			//================================================================//
			xlsxCreator.setKeyword(keyword);	// キーワード文字列変更
			xlsxCreator.openBook(outFileName, fileName);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.getCell(keyword + "Name").setValue("キーワード文字列変更サンプル");

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
		else if (request.getParameter("templateopen1") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatehensuu.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
		// テンプレート Excel ファイルオープン
		else if (request.getParameter("templateopen2") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatehensuu2.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
	}

}