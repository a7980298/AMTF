package servlet;

import java.awt.Color;
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
import jp.co.adv.excelcreator.enums.BorderStyle;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import model.SampleWork;


public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String fileName;
	private String outFileName;

	public CalculateServlet() {
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

		// 計算式の設定
		if (request.getParameter("calculate1") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'calculate1'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// サンプル用データの設定
			for (int i = 1; i <= 10; i++) {
				xlsxCreator.getCell("A1", 0, i - 1).setValue(i);
			}
			// 第 1 引数に計算式文字列、第 2 引数に計算結果を指定(省略可)
			xlsxCreator.getCell("A10").getAttr().lineBottom(BorderStyle.Double, Color.BLACK);
			xlsxCreator.getCell("A11").setFunc("=SUM(A1:A10)", 100);
			// Excel ファイルオープン時の再計算実行有無
			if (request.getParameter("fullcalconload") != null) {
				xlsxCreator.getCell("B11").setValue("← Excel 側の機能で再計算された結果");
				xlsxCreator.setFullCalcOnLoad(true);
			} else {
				xlsxCreator.getCell("B11").setValue("← setFunc メソッドで指定した計算結果");
			}
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
		// 計算式セルのコピー・移動
		else if (request.getParameter("calculate2") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatecalculate.xlsx");	// テンプレート Excel ファイル
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'calculate2'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// オーバーレイオープン
			//================================================================//
			xlsxCreator.openBook(outFileName, fileName);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// サンプル用データの設定
			xlsxCreator.getCell("6").setRowHeight(0);
			xlsxCreator.getCell("C8").setValue("↑計算式のセル範囲が挿入した行数分拡張されます。\n　C5:C6→C5:C15");
			xlsxCreator.getCell("E8").setValue("↑テンプレートに設定された計算式もセルの移動に対応します。\n　C7:D7→C16:D16");
			xlsxCreator.getCell("F8").setValue("↑Func メソッドで設定した計算式もセル範囲の移動・拡張に対応します。\n　C7:D7→C16:D16");

			// 計算式の設定
			xlsxCreator.getCell("**func").setFunc("SUM(C5:D5)", null);		// 一覧(行コピーでセル範囲が調整)
			xlsxCreator.getCell("**funcsum").setFunc("SUM(C7:D7)", null);	// 合計(セル位置の移動でセル範囲が調整)

			// 一行目の明細を 9 行分挿入(※列コピー、セルコピー、削除処理にも対応)
			for (int index = 0; index < 9; index++) {
				xlsxCreator.rowCopy(4);
				xlsxCreator.rowInsertCopied(5 + index);
			}
			xlsxCreator.getCell("G6").setValue("←コピー先で計算式が再調整(C5:D5→C6:D6)");
			xlsxCreator.getCell("G6").getAttr().setFontColor(new Color(92, 84, 36));

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
		// テンプレート Excel ファイルオープン
		else if (request.getParameter("templateopen") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatecalculate.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
	}

}