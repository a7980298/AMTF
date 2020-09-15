package servlet;

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
import jp.co.adv.excelcreator.enums.ExcelColor;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.HeaderFooterMode;
import jp.co.adv.excelcreator.enums.HeaderFooterType;
import jp.co.adv.excelcreator.enums.PageCenter;
import jp.co.adv.excelcreator.enums.PageOrder;
import jp.co.adv.excelcreator.enums.PageOrientation;
import jp.co.adv.excelcreator.enums.PaperKind;
import model.SampleWork;


public class AttributeSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String outFileName;

	public AttributeSheetServlet() {
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

		// 操作対象シート
		if (request.getParameter("sheetattr1") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'sheetattr1'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 3, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// 先頭シートにサンプルの説明を設定
			xlsxCreator.setSheetNo(0);
			xlsxCreator.getCell("A1").setValue("「Sheet2」、「Sheet3」にも値を設定しています。");
			// 左側から 2 番目のシートを選択します。
			xlsxCreator.setSheetNo(1);
			xlsxCreator.getCell("A1").setValue("Sheet2 に値を設定");
			// Sheet3 のシートNo を取得し選択します。
			xlsxCreator.setSheetNo(xlsxCreator.getSheetNo2("Sheet3"));
			xlsxCreator.getCell("A1").setValue("Sheet3 に値を設定");

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
		// ヘッダー/フッター
		else if (request.getParameter("sheetattr2") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'sheetattr2'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 4, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// データ、改ページ設定
			for (int i = 0; i <= 3; i++) {
				xlsxCreator.setSheetNo(i);
				xlsxCreator.getCell("A1").setStr("１ページ");
				xlsxCreator.getCell("A10").setBreak(true);
				xlsxCreator.getCell("A10").setStr("２ページ");
				xlsxCreator.getCell("A20").setBreak(true);
				xlsxCreator.getCell("A20").setStr("３ページ");
				xlsxCreator.getCell("A30").setBreak(true);
				xlsxCreator.getCell("A30").setStr("４ページ");
				xlsxCreator.getCell("A40").setBreak(true);
				xlsxCreator.getCell("A40").setStr("５ページ");
			}
			xlsxCreator.setSheetNo(0);										// 1番目(先頭)のシート
			xlsxCreator.setSheetName("全ページ指定");
			xlsxCreator.setHeader("&I&D", "&20&U全ページ", "&B&P/&N");
			xlsxCreator.setFooter("&I&D", "&20&U全ページ", "&B&P/&N");

			xlsxCreator.setSheetNo(1);										// 2番目のシート
			xlsxCreator.setSheetName("奇数・偶数ページ別指定");
			xlsxCreator.setHeaderFooterMode(HeaderFooterMode.OddEven);		// 奇数/偶数ページ別指定
			xlsxCreator.setHeader("&I&D", "&20&U奇数ページ", "&B&P/&N", HeaderFooterType.Normal);
			xlsxCreator.setFooter("&I&D", "&20&U奇数ページ", "&B&P/&N", HeaderFooterType.Normal);
			xlsxCreator.setHeader("&I&D", "&20&U偶数ページ", "&B&P/&N", HeaderFooterType.Even);
			xlsxCreator.setFooter("&I&D", "&20&U偶数ページ", "&B&P/&N", HeaderFooterType.Even);

			xlsxCreator.setSheetNo(2);										// 3番目のシート
			xlsxCreator.setSheetName("先頭ページのみ別指定");
			xlsxCreator.setHeaderFooterMode(HeaderFooterMode.FirstPage);	// 先頭ページのみ別指定
			xlsxCreator.setHeader("&I&D", "&20&U先頭ページ", "&B&P/&N", HeaderFooterType.First);
			xlsxCreator.setFooter("&I&D", "&20&U先頭ページ", "&B&P/&N", HeaderFooterType.First);
			xlsxCreator.setHeader("&I&D", "&20&U全ページ", "&B&P/&N", HeaderFooterType.Normal);
			xlsxCreator.setFooter("&I&D", "&20&U全ページ", "&B&P/&N", HeaderFooterType.Normal);

			xlsxCreator.setSheetNo(3);										// 4番目のシート
			xlsxCreator.setSheetName("奇数・偶数ページ別指定＋先頭ページのみ別指定");
			xlsxCreator.setHeaderFooterMode(HeaderFooterMode.All);			// 奇数/偶数ページ別指定＋先頭ページのみ別指定
			xlsxCreator.setHeader("&I&D", "&20&U先頭ページ", "&B&P/&N", HeaderFooterType.First);
			xlsxCreator.setFooter("&I&D", "&20&U先頭ページ", "&B&P/&N", HeaderFooterType.First);
			xlsxCreator.setHeader("&I&D", "&20&U奇数ページ", "&B&P/&N", HeaderFooterType.Normal);
			xlsxCreator.setFooter("&I&D", "&20&U奇数ページ", "&B&P/&N", HeaderFooterType.Normal);
			xlsxCreator.setHeader("&I&D", "&20&U偶数ページ", "&B&P/&N", HeaderFooterType.Even);
			xlsxCreator.setFooter("&I&D", "&20&U偶数ページ", "&B&P/&N", HeaderFooterType.Even);

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
		// シート名、ページ設定（ページタブ）、グリッド線（枠線）
		else if (request.getParameter("sheetattr3") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'sheetattr3'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 4, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.setSheetNo(0);												// 1番目(先頭)のシート
			xlsxCreator.setSheetName("シート１");									// シート名
			xlsxCreator.setPaperSize(PageOrientation.Landscape, 100, PaperKind.A4);	// ページ設定
			xlsxCreator.setMargin(10, 10, 10, 10, 10, 10);							// 余白
			xlsxCreator.setCenter(PageCenter.None);									// ページ中央（なし）
			xlsxCreator.setModeGrid(true);											// グリッド線の表示モード
			xlsxCreator.getCell("B1").setStr("用紙サイズ：A4");
			xlsxCreator.getCell("B2").setStr("拡大縮小/倍率：100%");
			xlsxCreator.getCell("B3").setStr("用紙の向き：横");
			xlsxCreator.getCell("B4").setStr("余白（左・上・右・下）：10mm");
			xlsxCreator.getCell("B5").setStr("余白（ヘッダー/フッター）：10mm");
			xlsxCreator.getCell("B6").setStr("水平/垂直：指定なし");
			xlsxCreator.getCell("B7").setStr("グリッド線：表示");

			xlsxCreator.setSheetNo(1);												// 2番目のシート
			xlsxCreator.setSheetName("シート２");									// シート名
			xlsxCreator.setPaperSize(120, PaperKind.A3);							// ページ設定
			xlsxCreator.setMargin(20, 20, 20, 20, 20, 20);							// 余白
			xlsxCreator.setCenter(PageCenter.Horz);									// ページ中央（水平）
			xlsxCreator.setModeGrid(false);											// グリッド線の表示モード
			xlsxCreator.getCell("B1").setStr("用紙サイズ：A3");
			xlsxCreator.getCell("B2").setStr("拡大縮小/倍率：120%");
			xlsxCreator.getCell("B3").setStr("用紙の向き：標準");
			xlsxCreator.getCell("B4").setStr("余白（左・上・右・下）：20mm");
			xlsxCreator.getCell("B5").setStr("余白（ヘッダー/フッター）：20mm");
			xlsxCreator.getCell("B6").setStr("水平/垂直：水平");
			xlsxCreator.getCell("B7").setStr("グリッド線：非表示");

			xlsxCreator.setSheetNo(2);												// 3番目のシート
			xlsxCreator.setSheetName("シート３");									// シート名
			xlsxCreator.setPaperSize(PageOrientation.Portrait , 80, PaperKind.B5);	// ページ設定
			xlsxCreator.setMargin(5, 5, 5, 5, 5, 5);								// 余白
			xlsxCreator.setCenter(PageCenter.Vert);									// ページ中央（垂直）
			xlsxCreator.setModeGrid(true);											// グリッド線の表示モード
			xlsxCreator.getCell("B1").setStr("用紙サイズ：B5");
			xlsxCreator.getCell("B2").setStr("拡大縮小/倍率：80%");
			xlsxCreator.getCell("B3").setStr("用紙の向き：縦");
			xlsxCreator.getCell("B4").setStr("余白（左・上・右・下）：5mm");
			xlsxCreator.getCell("B5").setStr("余白（ヘッダー/フッター）：5mm");
			xlsxCreator.getCell("B6").setStr("水平/垂直：垂直");
			xlsxCreator.getCell("B7").setStr("グリッド線：表示");

			xlsxCreator.setSheetNo(3);															// 4番目のシート
			xlsxCreator.setSheetName("シート４");												// シート名
			xlsxCreator.setPaperSize(100, PaperKind.B4);										// ページ設定
			xlsxCreator.setMargin(15, 15, 15, 15, 15, 15);										// 余白
			xlsxCreator.setCenter(PageCenter.Horz.getValue() +  PageCenter.Vert.getValue());	// ページ中央（水平 + 垂直）
			xlsxCreator.setModeGrid(false);														// グリッド線の表示モード
			xlsxCreator.getCell("B1").setStr("用紙サイズ：B4");
			xlsxCreator.getCell("B2").setStr("拡大縮小/倍率：100%");
			xlsxCreator.getCell("B3").setStr("用紙の向き：標準");
			xlsxCreator.getCell("B4").setStr("余白（左・上・右・下）：15mm");
			xlsxCreator.getCell("B5").setStr("余白（ヘッダー/フッター）：15mm");
			xlsxCreator.getCell("B6").setStr("水平/垂直：水平、垂直");
			xlsxCreator.getCell("B7").setStr("グリッド線：非表示");

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
		// 印刷タイトル、ページ方向、印刷範囲
		else if (request.getParameter("sheetattr4") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'sheetattr4'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 3, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.setSheetNo(0);							// 1番目(先頭)のシート
			xlsxCreator.setSheetName("行タイトル");
			xlsxCreator.setPrintTitle(0, -1, -1, -1);			// 1行目を印刷タイトル（行）に設定
			xlsxCreator.setPageOrder(PageOrder.RightFromLeft);	// ページ方向（左から右）
			xlsxCreator.getCell("A1").setValue("行タイトル");
			xlsxCreator.getCell("A2").setValue("１ページ");
			xlsxCreator.getCell("11").setBreak(true);
			xlsxCreator.getCell("A11").setValue("２ページ");

			xlsxCreator.setSheetNo(1);							// 2番目のシート
			xlsxCreator.setSheetName("列タイトル");
			xlsxCreator.setPrintTitle(-1, -1, 0, -1);			// 1列目を印刷タイトル（列）に設定
			xlsxCreator.setPageOrder(PageOrder.BottomFromTop);	// ページ方向（上から下）
			xlsxCreator.getCell("A1").setValue("列タイトル");
			xlsxCreator.getCell("B1").setValue("１ページ");
			xlsxCreator.getCell("F").setBreak(true);
			xlsxCreator.getCell("F1").setValue("２ページ");

			xlsxCreator.setSheetNo(2);							// 3番目のシート
			xlsxCreator.setSheetName("印刷範囲");
			xlsxCreator.setPrintArea(0, 12, 8, 22);				// "A13:I23"を印刷範囲に設定
			xlsxCreator.getCell("A13:I23").getAttr().setBackColor(ExcelColor.Yellow);
			xlsxCreator.getCell("A13").setValue("印刷範囲(A13:I23)");

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
		// シート追加
		else if (request.getParameter("sheetattr5") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'sheetattr5'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 3, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.getCell("A2").setValue("3 シートの Excel ファイルを新規作成し、末尾に 1 シート追加しています。");
			for (int i = 0; i <= 2; i++) {
				xlsxCreator.setSheetNo(i);
				xlsxCreator.getCell("A1").setValue("既存のシート" + (i + 1));
			}
			xlsxCreator.addSheet(1);									// 最後尾に1シート新規追加
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);	// 追加したシート
			xlsxCreator.getCell("A1").setValue("追加したシート");

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
		// シート削除
		else if (request.getParameter("sheetattr6") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'sheetattr6'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 3, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.getCell("A1").setValue("3 シートの Excel ファイルを新規作成し、2 シート目を削除しています。");
			xlsxCreator.deleteSheet(1, 1);	// 2番目のシート削除

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
		// シートコピー
		else if (request.getParameter("sheetattr7") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'sheetattr7'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 3, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.setSheetNo(0);
			xlsxCreator.getCell("A1").setValue("コピー元シート");
			xlsxCreator.getCell("A2").setValue("3 シートの Excel ファイルを新規作成し、1 シート目をコピーして末尾に挿入しています。");
			int nSCnt = xlsxCreator.getSheetCount();					// 現在のブックのシート数を取得
			xlsxCreator.copySheet(0, nSCnt, "CopySheet");				// 1番目のシートを最後尾にコピー
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);	// コピー先シート
			xlsxCreator.getCell("A1").setValue("コピー先シート");

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
		// アクティブシート
		else if (request.getParameter("sheetattr8") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'sheetattr8'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 3, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.setSheetNo(2);
			xlsxCreator.getCell("A1").setValue("Excel で最初に表示されるシート");
			xlsxCreator.getCell("A2").setValue("3 シートの Excel ファイルを新規作成し、生成 Excel ファイルオープン時に Sheet3 を表示するよう設定しています。");
			int nSCnt = xlsxCreator.getSheetCount();    // 現在のブックのシート数を取得
			xlsxCreator.setActiveSheet(nSCnt - 1);	    // 最後尾のシートを選択シートに設定

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
	}

}