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
import jp.co.adv.excelcreator.enums.ExcelVersion;
import model.SampleWork;


public class AttributeRowColServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String fileName;
	private String outFileName;

	public AttributeRowColServlet() {
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

		// 行の操作
		if (request.getParameter("editrow") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templaterow.xlsx");	// テンプレート Excel ファイル
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'editrow'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// オーバーレイオープン
			//================================================================//
			xlsxCreator.openBook(outFileName, fileName);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// 行の挿入（RowInsert）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "行の挿入");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.rowInsert(2, 4);			// 3行目に 3行入れる(第2引数省略時は 1行のみ挿入)
			xlsxCreator.getCell("B3:B6").setValue("3行目から 4行挿入");
			xlsxCreator.getCell("B3:B6").getAttr().setFontColor(Color.red);

			// 行のクリア（RowClear）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "行のクリア");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.rowClear(2, 1);				// 3行目を1行クリア(第2引数省略時は 1行のみクリア)
			xlsxCreator.getCell("A3").setValue("クリアされた行");
			xlsxCreator.getCell("A3").getAttr().setFontColor(Color.red);

			// 行の削除（RowDelete）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "行の削除");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.rowDelete(2, 1);			// 3行目から 1行削除(第2引数省略時は 1行のみ削除)

			// 行のコピー・貼り付け（RowCopy, RowPaste）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "行のコピー・貼り付け");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.rowCopy(2);					// 3行目をコピー
			xlsxCreator.rowPaste(4);				// 5行目に貼り付け
			//xlsxCreator.rowCopy(2, 4);			// RowPaste メソッド省略(上記と同じ結果)
			xlsxCreator.getCell("A5").setValue("コピーされた行");
			xlsxCreator.getCell("A5").getAttr().setFontColor(Color.red);

			// コピーした行の挿入（RowInsertCopied）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "コピーした行の挿入");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.rowCopy(2);					// 3行目をコピー
			xlsxCreator.rowInsertCopied(3);			// 4行目に挿入
			//xlsxCreator.rowInsertCopied(2, 3);	// RowCopy メソッド省略(上記と同じ)
			xlsxCreator.getCell("A4").setValue("挿入された行");
			xlsxCreator.getCell("A4").getAttr().setFontColor(Color.red);

			xlsxCreator.deleteSheet(0, 1);

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
		// 列の操作
		else if (request.getParameter("editcol") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatecolumn.xlsx");	// テンプレート Excel ファイル
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'editcol'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// オーバーレイオープン
			//================================================================//
			xlsxCreator.openBook(outFileName, fileName);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// 列の挿入（ColumnInsert）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "列の挿入");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.columnInsert(2, 4);				// 3列目に 3列入れる(第2引数省略時は 1列のみ挿入)
			xlsxCreator.getCell("C2:F2").setValue("3列目から 4列挿入");
			xlsxCreator.getCell("C2:F2").getAttr().setFontColor(Color.red);

			// 列のクリア（ColumnDelete）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "列のクリア");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.columnClear(2, 1);				// 3列目から 1列削除(第2引数省略時は 1列のみ削除)
			xlsxCreator.getCell("C1").setValue("クリアされた列");
			xlsxCreator.getCell("C1").getAttr().setFontColor(Color.red);

			// 列の削除（ColumnDelete）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "列の削除");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.columnDelete(2, 1);				// 3列目から 1列削除(第2引数省略時は 1列のみ削除)

			// 列のコピー・貼り付け（ColumnCopy, ColumnPaste）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "列のコピー・貼り付け");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.columnCopy(2);					// 3列目をコピー
			xlsxCreator.columnPaste(4);					// 5列目に貼り付け
			//xlsxCreator.columnCopy(2, 4);				// ColumnPaste メソッド省略(上記と同じ)
			xlsxCreator.getCell("E1").setValue("コピーされた列");
			xlsxCreator.getCell("E1").getAttr().setFontColor(Color.red);

			// コピーした列の挿入（ColumnInsertCopied）
			xlsxCreator.copySheet(0, xlsxCreator.getSheetCount(), "コピーした列の挿入");
			xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
			xlsxCreator.columnCopy(2);					// 3列目をコピー
			xlsxCreator.columnInsertCopied(3);			// 4列目に挿入
			//xlsxCreator.columnInsertCopied(2, 3);		// ColumnCopy メソッド省略(上記と同じ)
			xlsxCreator.getCell("D1").setValue("挿入された列");
			xlsxCreator.getCell("D1").getAttr().setFontColor(Color.red);

			xlsxCreator.deleteSheet(0, 1);

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
		// 行の高さ・列幅の操作
		else if (request.getParameter("editrowcol") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'roweheightcolwidth'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.getCell("B1").setValue("非表示列");
			xlsxCreator.getCell("C1").setValue("←B列非表示");
			xlsxCreator.getCell("F1").setValue("列幅 15.25 文字");
			xlsxCreator.getCell("A5").setValue("非表示行");
			xlsxCreator.getCell("A5").setValue("非表示行");
			xlsxCreator.getCell("A6").setValue("↑5行目非表示");
			xlsxCreator.getCell("A10").setValue("行の高さ 36 ポイント");

			// 行の高さをポイント(0～409)で設定します。
			xlsxCreator.getCell("5").setRowHeight(0);   // 0 で非表示;
			xlsxCreator.getCell("10").setRowHeight(36.0);
			// 列の幅を半角文字数(0～255文字)で設定します。
			xlsxCreator.getCell("B").setColWidth(0);    // 0 で非表示;
			xlsxCreator.getCell("F").setColWidth(15.25);

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
			fileName = context.getRealPath("/WEB-INF/data/templaterow.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
		// テンプレート Excel ファイルオープン
		else if (request.getParameter("templateopen2") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templatecolumn.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
	}

}