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
import jp.co.adv.excelcreator.html.enums.DocType;
import model.SampleWork;


public class HtmlOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String fileName;
	private String outFileName;
	private String outHtmlFileName;

	public HtmlOptionServlet() {
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
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		// Error イベント
		result = "";
		xlsxCreator.addErrorEvent(new ErrorListener(){
			@Override
			public void error(ExcelCreatorException e) {
				result += e.getErrorMessage() + "<br />";
			}
		}
				);

		// HTML オプション
		if (request.getParameter("htmloutput") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templateoverlay.xlsx");	// テンプレート Excel ファイル
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'overlay'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));
			outHtmlFileName = outFileName.replace(".xlsx", ".html");

			//【1】===========================================================//
			// オーバーレイオープン
			//================================================================//
			xlsxCreator.openBook(outFileName, fileName);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.getCell("B4").setValue("ExcelCreator for Java");
			xlsxCreator.getCell("H4").setValue(10);
			xlsxCreator.getCell("K4").setValue(40000);
			xlsxCreator.getCell("O4").setFunc("=H4*K4", 400000);
			xlsxCreator.getCell("B5").setValue("VB-Report 8");
			xlsxCreator.getCell("H5").setValue(8);
			xlsxCreator.getCell("K5").setValue(85000);
			xlsxCreator.getCell("O5").setFunc("=H5*K5", 680000);
			xlsxCreator.getCell("B6").setValue("ExcelWebForm");
			xlsxCreator.getCell("H6").setValue(5);
			xlsxCreator.getCell("K6").setValue(70000);
			xlsxCreator.getCell("O6").setFunc("=H6*K6", 350000);
			xlsxCreator.getCell("O10").setFunc("=SUM(O4:R8)", 1430000);
			xlsxCreator.getCell("O11").setFunc("=O10*0.08", 114400);
			xlsxCreator.getCell("O12").setFunc("=O10+O11", 1544400);

			// HTML オプション
			// DocType
			switch (SampleWork.parseInt(request.getParameter("doctype"))) {
			case 0:
				xlsxCreator.getHtml().setDocType(DocType.Html4);
				break;
			case 1:
				xlsxCreator.getHtml().setDocType(DocType.Html5);
				break;
			}
			// HTML タイトル
			xlsxCreator.getHtml().setTitle(request.getParameter("title"));
			// HTML ヘッダ
			String strHead;
			strHead = "<meta name=\"author\" content=\"アドバンスソフトウェア株式会社\">";
			strHead += "\r\n" + "<meta name=\"copyright\" content=\"アドバンスソフトウェア株式会社\">";
			xlsxCreator.getHtml().addHeader(strHead);

			//【3】===========================================================//
			// Excel ファイルクローズ、HTML 出力
			//================================================================//
			xlsxCreator.setFullCalcOnLoad(true);
			xlsxCreator.closeBook(true, "", outHtmlFileName, false);

			if (result.equals("") == false) {
				SampleWork.writeDescription(response, result);
				return;
			}

			// 生成ファイルをクライアントに転送
			SampleWork.executeFileTrasfer(response, outHtmlFileName);
		}
		// テンプレート Excel ファイルオープン
		else if (request.getParameter("templateopen") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templateoverlay.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
	}

}