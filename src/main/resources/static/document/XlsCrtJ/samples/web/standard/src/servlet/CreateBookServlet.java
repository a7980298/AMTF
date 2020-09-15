package servlet;

import java.awt.Color;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.adv.excelcreator.creator.ErrorListener;
import jp.co.adv.excelcreator.creator.ExcelCreatorException;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.BorderStyle;
import jp.co.adv.excelcreator.enums.BoxType;
import jp.co.adv.excelcreator.enums.ExcelColor;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.FontStyle;
import jp.co.adv.excelcreator.enums.HorizontalAlignment;
import model.SampleWork;


public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;

	public CreateBookServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse  response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 指定した環境変数から一時ディレクトリを取得
		String outFileName = SampleWork.getFileOutputDirectory();
		if (outFileName == null) {
			SampleWork.writeDescription(response,"一時ディレクトリの取得に失敗しました。<br />SampleWork.getFileOutputDirectory メソッド内の環境変数を調整してください");
			return;
		}
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

		// サンプル(明細書形式) Excel ファイル作成
		if (request.getParameter("createtype").equals("sample") == true) {
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'createbook(sample)'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.setDefaultFontName("メイリオ");	// デフォルトフォント
			xlsxCreator.setDefaultFontPoint(10);	// デフォルトフォントポイント
			xlsxCreator.setSheetName("商品売上明細書");	// シート名
			// 行の高さ、列幅の調整
			xlsxCreator.getCell("1").setRowHeight(30);
			xlsxCreator.getCell("2").setRowHeight(15);
			xlsxCreator.getCell("3").setRowHeight(18);
			xlsxCreator.getCell("4:12").setRowHeight(15);
			xlsxCreator.getCell("A").setColWidth(1.88);
			xlsxCreator.getCell("B:R").setColWidth(3.13);
			xlsxCreator.getCell("S").setColWidth(1.88);
			// 値、書式設定
			xlsxCreator.getCell("B1").setValue("商品売上明細書");
			xlsxCreator.getCell("B1:R1").getAttr().setMergeCells(true);
			xlsxCreator.getCell("B1").getAttr().setFontPoint(18);
			xlsxCreator.getCell("B1").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("B1").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);
			xlsxCreator.getCell("B1").getAttr().setFontColor(ExcelColor.White);
			xlsxCreator.getCell("B1").getAttr().setBackColor(new Color(91, 155, 213));
			xlsxCreator.getCell("B3").setValue("商品名");
			xlsxCreator.getCell("B3:G3").getAttr().setMergeCells(true);
			xlsxCreator.getCell("H3").setValue("数量");
			xlsxCreator.getCell("H3:J3").getAttr().setMergeCells(true);
			xlsxCreator.getCell("K3").setValue("単価");
			xlsxCreator.getCell("K3:N3").getAttr().setMergeCells(true);
			xlsxCreator.getCell("O3").setValue("金額");
			xlsxCreator.getCell("O3:R3").getAttr().setMergeCells(true);
			xlsxCreator.getCell("B3:R3").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);
			xlsxCreator.getCell("B3:R3").getAttr().setFontColor(ExcelColor.White);
			xlsxCreator.getCell("B4:G4").getAttr().setMergeCells(true);
			xlsxCreator.getCell("H4:J4").getAttr().setMergeCells(true);
			xlsxCreator.getCell("K4:N4").getAttr().setMergeCells(true);
			xlsxCreator.getCell("O4:R4").getAttr().setMergeCells(true);
			for (int i = 0; i < 5; i++) {
				xlsxCreator.rowCopy(3, 4 + i);
			}
			xlsxCreator.getCell("B3:R3").getAttr().setBackColor(new Color(91, 155, 213));
			xlsxCreator.getCell("B3:R9").getAttr().box(BoxType.Ltc, BorderStyle.Thin, new Color(91, 155, 213));
			xlsxCreator.getCell("B3:R9").getAttr().box(BoxType.Box, BorderStyle.Medium, new Color(91, 155, 213));
			xlsxCreator.getCell("B4").setValue("ExcelCreator for Java");
			xlsxCreator.getCell("H4").setValue(10);
			xlsxCreator.getCell("K4").setValue(40000);
			xlsxCreator.getCell("O4").setFunc("=H4*K4", null);
			xlsxCreator.getCell("B5").setValue("VB-Report 8");
			xlsxCreator.getCell("H5").setValue(8);
			xlsxCreator.getCell("K5").setValue(85000);
			xlsxCreator.getCell("O5").setFunc("=H5*K5", null);
			xlsxCreator.getCell("B6").setValue("ExcelWebForm");
			xlsxCreator.getCell("H6").setValue(5);
			xlsxCreator.getCell("K6").setValue(70000);
			xlsxCreator.getCell("O6").setFunc("=H6*K6", null);
			xlsxCreator.getCell("K4:N9").getAttr().setFormat("#,##0_ ");
			xlsxCreator.getCell("O4:R9").getAttr().setFormat("\\#,##0;[赤]\\#,##0");
			xlsxCreator.getCell("B4:R4").getAttr().lineBottom(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B5:R5").getAttr().lineTop(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B5:R5").getAttr().lineBottom(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B6:R6").getAttr().lineTop(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B6:R6").getAttr().lineBottom(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B7:R7").getAttr().lineTop(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B7:R7").getAttr().lineBottom(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B8:R8").getAttr().lineTop(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B8:R8").getAttr().lineBottom(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B9:R9").getAttr().lineTop(BorderStyle.Dotted, new Color(91, 155, 213));
			xlsxCreator.getCell("B5:R5").getAttr().setBackColor(new Color(221, 235, 247));
			xlsxCreator.getCell("B7:R7").getAttr().setBackColor(new Color(221, 235, 247));
			xlsxCreator.getCell("B9:R9").getAttr().setBackColor(new Color(221, 235, 247));
			xlsxCreator.getCell("K10:N10").getAttr().setMergeCells(true);
			xlsxCreator.getCell("K10:N10").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);
			xlsxCreator.getCell("K10:N10").getAttr().setFontColor(ExcelColor.White);
			xlsxCreator.getCell("K10:N10").getAttr().setBackColor(new Color(91, 155, 213));
			xlsxCreator.getCell("O10:R10").getAttr().setMergeCells(true);
			xlsxCreator.getCell("O10:R10").getAttr().setFormat("\\#,##0;[赤]\\#,##0");
			xlsxCreator.getCell("K10:R10").getAttr().box(BoxType.Ltc, BorderStyle.Thin, new Color(91, 155, 213));
			xlsxCreator.getCell("K10:R10").getAttr().box(BoxType.Box, BorderStyle.Medium, new Color(91, 155, 213));
			for (int i = 0; i < 2; i++) {
				xlsxCreator.rowCopy(9, 10 + i);
			}
			xlsxCreator.getCell("K10").setValue("小計");
			xlsxCreator.getCell("O10").setFunc("=SUM(O4:R8)", null);
			xlsxCreator.getCell("K11").setValue("消費税");
			xlsxCreator.getCell("O11").setFunc("=O10*0.08", null);
			xlsxCreator.getCell("K12").setValue("合計");
			xlsxCreator.getCell("O12").setFunc("=O10+O11", null);

			//【3】===========================================================//
			// Excel ファイルクローズ
			//================================================================//
			xlsxCreator.closeBook(true);
		}
		// カスタム設定
		else {
			Integer sheetCount;
			try {
				sheetCount = SampleWork.parseInt(request.getParameter("sheetcount"));
			} catch (NumberFormatException ex) {
				sheetCount = 1;
			}
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'createbook(custom)'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			ExcelVersion[] versionList = ExcelVersion.values();
			int excelVersionIndex = SampleWork.parseInt(request.getParameter("excelversion"));
			xlsxCreator.createBook(outFileName, sheetCount, versionList[excelVersionIndex]);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// サンプルレイアウト用処理
			xlsxCreator.getCell("A1").setValue("■ExcelCreator for Java - 新規作成（カスタム）");
			xlsxCreator.getCell("A1").getAttr().setFontColor(new Color(54, 96, 146));
			xlsxCreator.getCell("A").setColWidth(18.0);
			xlsxCreator.getCell("A2").setValue("Excel バージョン");
			xlsxCreator.getCell("B2").setValue(versionList[excelVersionIndex].toString());
			xlsxCreator.getCell("A3").setValue("シート数");
			xlsxCreator.getCell("B3").setValue(sheetCount);

			//【3】===========================================================//
			// Excel ファイルクローズ
			//================================================================//
			xlsxCreator.closeBook(true);
		}

		if (result.equals("") == false) {
			SampleWork.writeDescription(response, result);
			return;
		}

		// 生成ファイルをクライアントに転送
		SampleWork.executeFileTrasfer(response, outFileName);
	}

}