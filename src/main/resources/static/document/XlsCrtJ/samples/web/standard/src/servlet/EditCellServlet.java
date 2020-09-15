package servlet;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.adv.excelcreator.creator.ErrorListener;
import jp.co.adv.excelcreator.creator.ExcelCreatorException;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.CellClearMode;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.HorizontalAlignment;
import model.SampleWork;


public class EditCellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String fileName;
	private String outFileName;

	public EditCellServlet() {
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

		// セル範囲、オフセット指定
		if (request.getParameter("editcell1") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'editcell1'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// セル範囲(A1:C3)に値を設定
			xlsxCreator.getCell("A1:C3").setValue("セル範囲指定");
			// A1参照形式によるオフセット指定
			xlsxCreator.getCell("A1", 1, 4).setValue("A1 セルを基点とし、列方向に 1、行方向に 4 移動した B5 セルに値を設定");

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
		// 値の設定、取得
		else if (request.getParameter("editcell2") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'editcell2'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// サンプル用レイアウト設定
			xlsxCreator.getCell("A:B").setColWidth(15.0);
			xlsxCreator.getCell("A1").setValue("データ型");
			xlsxCreator.getCell("B1").setValue("値");
			xlsxCreator.getCell("A2").setValue("Integer");
			xlsxCreator.getCell("A3").setValue("Long");
			xlsxCreator.getCell("A4").setValue("Double");
			xlsxCreator.getCell("A5").setValue("String (Str)");
			xlsxCreator.getCell("A6").setValue("Integer(Value)");
			xlsxCreator.getCell("A7").setValue("String (Value)");
			// 数値の設定
			xlsxCreator.getCell("B2").setInteger(1234567890);	// int
			xlsxCreator.getCell("B3").setLong(1234567890123L);	// long
			xlsxCreator.getCell("B4").setDouble(123.456D);		// double
			// 文字列の設定
			xlsxCreator.getCell("B5").setStr("Str プロパティで文字列設定");
			// Value プロパティ(Object)を使用した値の設定
			xlsxCreator.getCell("B6").setValue(1234567890);    // int
			xlsxCreator.getCell("B7").setValue("Value プロパティで文字列設定");
			// 値の取得
			//int num = xlsxCreator.getCell("B2").getInteger();
			//String str = xlsxCreator.getCell("B5").getStr();
			//Object val = xlsxCreator.getCell("B6").getValue();

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
		// 日付の設定、取得
		else if (request.getParameter("editcell3") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'editcell3'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// 現在時刻のシリアル値を取得し、複数セルに設定
			Date date = new Date();
			// 86400000d = 1 日のミリ秒数(60s * 60m * 24h * 1000ms)
			// 25569d = Java と Excel の基準日の違いによる日数差
			// 0.375d = Java(GMT) と Excel(JST) の標準時の仕様の差異による時刻差(9 時間)
			double time = date.getTime() / 86400000d + 25569d + 0.375d;

			// サンプル用レイアウト設定
			xlsxCreator.getCell("A").setColWidth(20.0);
			xlsxCreator.getCell("B").setColWidth(35.0);
			xlsxCreator.getCell("B2:B15").getAttr().setHorizontalAlignment(HorizontalAlignment.Right);
			xlsxCreator.getCell("A1").setValue("日付");
			xlsxCreator.getCell("B1").setValue("表示形式");
			// すべてのセルに同じ日付を設定
			xlsxCreator.getCell("A2:A15").setDouble(time);
			// 表示形式【2001/3/14 1:30 PM】
			xlsxCreator.getCell("A2").getAttr().setFormat("[$-409]yyyy/m/d h:mm AM/PM;@");
			xlsxCreator.getCell("B2").setValue("[$-409]yyyy/m/d h:mm AM/PM;@");
			// 表示形式【2001年3月14日】
			xlsxCreator.getCell("A3").getAttr().setFormat("yyyy\"年\"m\"月\"d\"日\";@");
			xlsxCreator.getCell("B3").setValue("yyyy\"年\"m\"月\"d\"日\";@");
			// 表示形式【2001年3月】
			xlsxCreator.getCell("A4").getAttr().setFormat("yyyy\"年\"m\"月\";@");
			xlsxCreator.getCell("B4").setValue("yyyy\"年\"m\"月\";@");
			// 表示形式【3月14日】
			xlsxCreator.getCell("A5").getAttr().setFormat("m\"月\"d\"日\";@");
			xlsxCreator.getCell("B5").setValue("m\"月\"d\"日\";@");
			// 表示形式【2001/3/14】
			xlsxCreator.getCell("A6").getAttr().setFormat("yyyy/m/d;@");
			xlsxCreator.getCell("B6").setValue("yyyy/m/d;@");
			// 表示形式【3/14】
			xlsxCreator.getCell("A7").getAttr().setFormat("m/d;@");
			xlsxCreator.getCell("B7").setValue("m/d;@");
			// 表示形式【H13.3.14】
			xlsxCreator.getCell("A8").getAttr().setFormat("[$-411]ge.m.d;@");
			xlsxCreator.getCell("B8").setValue("[$-411]ge.m.d;@");
			// 表示形式【平成13年3月14日】
			xlsxCreator.getCell("A9").getAttr().setFormat("[$-411]ggge\"年\"m\"月\"d\"日\";@");
			xlsxCreator.getCell("B9").setValue("[$-411]ggge\"年\"m\"月\"d\"日\";@");
			// 表示形式【13:30:55】
			xlsxCreator.getCell("A10").getAttr().setFormat("h:mm:ss;@");
			xlsxCreator.getCell("B10").setValue("h:mm:ss;@");
			// 表示形式【13時30分55秒】
			xlsxCreator.getCell("A11").getAttr().setFormat("h\"時\"mm\"分\"ss\"秒\";@");
			xlsxCreator.getCell("B11").setValue("h\"時\"mm\"分\"ss\"秒\";@");
			// 表示形式【金曜日】
			xlsxCreator.getCell("A12").getAttr().setFormat("aaaa");
			xlsxCreator.getCell("B12").setValue("aaaa");
			// 表示形式【金】
			xlsxCreator.getCell("A13").getAttr().setFormat("aaa");
			xlsxCreator.getCell("B13").setValue("aaa");
			// 表示形式【Friday】
			xlsxCreator.getCell("A14").getAttr().setFormat("dddd");
			xlsxCreator.getCell("B14").setValue("dddd");
			// 表示形式【Fri】
			xlsxCreator.getCell("A15").getAttr().setFormat("ddd");
			xlsxCreator.getCell("B15").setValue("ddd");

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
		// セルの操作
		else if (request.getParameter("editcell4") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templateeditcell.xlsx");	// テンプレート Excel ファイル
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'editcell4'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// オーバーレイオープン
			//================================================================//
			xlsxCreator.openBook(outFileName, fileName);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// セルのコピー・貼り付け
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "セルのコピー・貼り付け");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.getCell("B2:D9").copy();							// セル範囲をコピー(Pos も使用可能)
			xlsxCreator.getCell("B11").paste();								// 先頭セルを指定して貼り付け(Pos も使用可能)
			//xlsxCreator.getCell("B2:D9").copy("B11");						// Paste メソッド省略(上記と同じ)
			xlsxCreator.getCell("A11:A18").setValue("コピーしたセル→");
			xlsxCreator.getCell("A11:A18").getAttr().setFontColor(Color.BLUE);

			// セルのクリア
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "セルのクリア");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.getCell("B3").clear();								// 引数なしの場合、値と書式をクリア
			//xlsxCreator.getCell("B3").Clear(CellClearMode.Attr);			// 値と書式をクリア※引数なしと同じ
			xlsxCreator.getCell("C3").clear(CellClearMode.Attr);			// 書式のみをクリア
			xlsxCreator.getCell("D3").clear(CellClearMode.Value);			// 値のみをクリアし
			// 結合セルの解除(Clear メソッドでなくAttr.MergeCells メソッドで対応)
			xlsxCreator.getCell("B2:D2").clear();							// 結合セルが残った状態となる
			xlsxCreator.getCell("B4:D4").getAttr().setMergeCells(false);		// 結合セルが解除される
			xlsxCreator.getCell("E2").setValue("　← ※注意 - Clear メソッドでは結合セルを解除できない。");
			xlsxCreator.getCell("E2").getAttr().setFontColor(Color.BLUE);
			xlsxCreator.getCell("E3").setValue("　← B3:値と書式をクリア　C3:書式をクリア　D3:値をクリア。");
			xlsxCreator.getCell("E3").getAttr().setFontColor(Color.BLUE);
			xlsxCreator.getCell("E4").setValue("　← 結合セルのクリアは Attr.MergeCells プロパティで行なう。");
			xlsxCreator.getCell("E4").getAttr().setFontColor(Color.BLUE);

			xlsxCreator.deleteSheet(0, 1);
			// 再計算実行フラグを設定
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
		// 改ページの挿入
		else if (request.getParameter("editcell5") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'editcell5'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.getCell("A1").setValue("1 ページ目");
			xlsxCreator.getCell("A1:E10").getAttr().setBackColor(Color.YELLOW);
			xlsxCreator.getCell("A11").setValue("2 ページ目");
			xlsxCreator.getCell("A11:E20").getAttr().setBackColor(Color.GREEN);
			xlsxCreator.getCell("F1").setValue("3 ページ目");
			xlsxCreator.getCell("F1:J10").getAttr().setBackColor(Color.BLUE);
			// セル指定による改ページの挿入(行列方向に改ページ)
			xlsxCreator.getCell("F11").setBreak(true);
			// 行指定による改ページの挿入
			xlsxCreator.getCell("21").setBreak(true);
			// 列指定による改ページの挿入
			xlsxCreator.getCell("K").setBreak(true);

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
			fileName = context.getRealPath("/WEB-INF/data/templateeditcell.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
	}

}