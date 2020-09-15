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
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.HorizontalAlignment;
import jp.co.adv.excelcreator.enums.PdfEncryptionType;
import jp.co.adv.excelcreator.enums.PdfPermit;
import jp.co.adv.excelcreator.enums.VerticalAlignment;
import model.SampleWork;


public class PdfOption1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String outPdfFileName;

	public PdfOption1Servlet() {
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
		// Error イベント
		result = "";
		xlsxCreator.addErrorEvent(new ErrorListener(){
			@Override
			public void error(ExcelCreatorException e) {
				result += e.getErrorMessage() + "<br />";
			}
		}
				);

		// PDF ファイルの暗号化
		if (request.getParameter("pdfencryption") != null) {
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'pdfencryption'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));
			outPdfFileName = outFileName.replace(".xlsx", ".pdf");

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2013);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.getCell("A1").setValue("PDF ファイルの「文書のプロパティ」で権限をご確認ください。");
			xlsxCreator.getCell("A1").setRowHeight(20);
			xlsxCreator.getCell("A1").getAttr().setFontName("Meiryo");
			xlsxCreator.getCell("A1").getAttr().setFontColor(Color.RED);
			xlsxCreator.getCell("A1").getAttr().setFontPoint(16);
			xlsxCreator.getCell("A:B").setColWidth(28);
			xlsxCreator.getCell("6").setRowHeight(150);
			xlsxCreator.getCell("A3:A6").getAttr().setHorizontalAlignment(HorizontalAlignment.Right);
			xlsxCreator.getCell("A6:B6").getAttr().setVerticalAlignment(VerticalAlignment.Top);
			xlsxCreator.getCell("A3").setValue("暗号化強度：");
			xlsxCreator.getCell("A4").setValue("オーナーパスワード：");
			xlsxCreator.getCell("A5").setValue("ユーザーパスワード：");
			xlsxCreator.getCell("A6").setValue("ユーザーパスワードの権限：");

			// PDF の暗号化強度を設定します。
			// ※デフォルト：Acrobat6_RC4_128
			switch (SampleWork.parseInt(request.getParameter("encryptiontype"))) {
			// PDFEncryptionType.NoPassword
			case 0:
				xlsxCreator.getPdf().setEncryptionType(PdfEncryptionType.NoPassword);
				xlsxCreator.getCell("B3").setValue("PdfEncryptionType.NoPassword");
				break;
			// PDFEncryptionType.Acrobat3_RC4_40
			case 1:
				xlsxCreator.getPdf().setEncryptionType(PdfEncryptionType.Acrobat3_RC4_40);
				xlsxCreator.getCell("B3").setValue("PdfEncryptionType.Acrobat3_RC4_40");
				break;
			// PDFEncryptionType.Acrobat5_RC4_128
			case 2:
				xlsxCreator.getPdf().setEncryptionType(PdfEncryptionType.Acrobat5_RC4_128);
				xlsxCreator.getCell("B3").setValue("PdfEncryptionType.Acrobat5_RC4_128");
				break;
			// PDFEncryptionType.Acrobat6_RC4_128(デフォルト)
			case 3:
				xlsxCreator.getPdf().setEncryptionType(PdfEncryptionType.Acrobat6_RC4_128);
				xlsxCreator.getCell("B3").setValue("PdfEncryptionType.Acrobat6_RC4_128");
				break;
			}

			// PDF のオーナーパスワードを設定します。
			// ユーザーパスワードは省略可能ですが、両方を設定しない場合、
			// パスワードなしのファイルが生成されます。
			xlsxCreator.getPdf().setOwnerPassword(request.getParameter("ownerpassword"));
			xlsxCreator.getPdf().setUserPassword(request.getParameter("userpassword"));
			if (request.getParameter("ownerpassword").equals("") && request.getParameter("userpassword").equals(""))
				xlsxCreator.getCell("B3").setValue("PdfEncryptionType.NoPassword");
			xlsxCreator.getCell("B4").setValue(request.getParameter("ownerpassword"));
			xlsxCreator.getCell("B5").setValue(request.getParameter("userpassword"));

			// ユーザーパスワードで PDF ファイルを閲覧する際の権限を設定します。
			// 必要な権限を論理和で連結して、Permitに設定します。
			String strPermit = "";
			int permit = 0;
			if (request.getParameter("print") != null) {             // Print
				permit = permit | PdfPermit.Print.getValue();
				strPermit += "Print" + "\r\n";
			}
			if (request.getParameter("change") != null) {            // Change
				permit = permit | PdfPermit.Change.getValue();
				strPermit += "Change" + "\r\n";
			}
			if (request.getParameter("copy") != null) {              // Copy
				permit = permit | PdfPermit.Copy.getValue();
				strPermit += "Copy" + "\r\n";
			}
			if (request.getParameter("comment") != null) {           // Comment
				permit = permit | PdfPermit.Comment.getValue();
				strPermit += "Comment" + "\r\n";
			}
			if (request.getParameter("formfield") != null) {         // FormField
				permit = permit | PdfPermit.FormField.getValue();
				strPermit += "FormField" + "\r\n";
			}
			if (request.getParameter("contentaccess") != null) {     // ContentAccess
				permit = permit | PdfPermit.ContentAccess.getValue();
				strPermit += "ContentAccess" + "\r\n";
			}
			if (request.getParameter("documentassembly") != null) {  // DocumentAssembly
				permit = permit | PdfPermit.DocumentAssembly.getValue();
				strPermit += "DocumentAssembly" + "\r\n";
			}
			if (request.getParameter("printhigh") != null) {         // PrintHigh
				permit = permit | PdfPermit.PrintHigh.getValue();
				strPermit += "PrintHigh";
			}
			xlsxCreator.getPdf().setPermit(permit);
			xlsxCreator.getCell("B6").setValue(strPermit);
			permit = xlsxCreator.getPdf().getPermit();

			//【3】===========================================================//
			// Excel ファイルクローズ、PDF 出力
			//================================================================//
			xlsxCreator.closeBook(true, outPdfFileName, false);
		}
		// PDF 文書のプロパティ
		else if (request.getParameter("pdfproperty") != null) {
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'pdfproperty'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));
			outPdfFileName = outFileName.replace(".xlsx", ".pdf");

			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2013);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			xlsxCreator.getCell("A1").setValue("PDF ファイルのプロパティをご確認ください。");
			xlsxCreator.getCell("A1").setRowHeight(20);
			xlsxCreator.getCell("A1").getAttr().setFontName("Meiryo");
			xlsxCreator.getCell("A1").getAttr().setFontColor(Color.RED);
			xlsxCreator.getCell("A1").getAttr().setFontPoint(16);
			xlsxCreator.getCell("A").setColWidth(20);
			xlsxCreator.getCell("A3:A7").getAttr().setHorizontalAlignment(HorizontalAlignment.Right);
			xlsxCreator.getCell("A3").setValue("タイトル：");
			xlsxCreator.getCell("A4").setValue("サブタイトル：");
			xlsxCreator.getCell("A5").setValue("作成者：");
			xlsxCreator.getCell("A6").setValue("アプリケーション：");
			xlsxCreator.getCell("A7").setValue("PDF 変換：");
			xlsxCreator.getCell("B3").setValue(request.getParameter("title"));
			xlsxCreator.getCell("B4").setValue(request.getParameter("subtitle"));
			xlsxCreator.getCell("B5").setValue(request.getParameter("author"));
			xlsxCreator.getCell("B6").setValue(request.getParameter("application"));
			xlsxCreator.getCell("B7").setValue(request.getParameter("producer"));

			// PDF 文書のプロパティを設定します。
			// タイトル
			xlsxCreator.getPdf().setTitle(request.getParameter("title"));
			// 作成者
			xlsxCreator.getPdf().setAuthor(request.getParameter("author"));
			// サブタイトル
			xlsxCreator.getPdf().setSubject(request.getParameter("subtitle"));
			// アプリケーション
			xlsxCreator.getPdf().setApplication(request.getParameter("application"));
			// PDF 変換
			xlsxCreator.getPdf().setProducer(request.getParameter("producer"));

			//【3】===========================================================//
			// Excel ファイルクローズ、PDF 出力
			//================================================================//
			xlsxCreator.closeBook(true, outPdfFileName, false);
		}

		if (result.equals("") == false) {
			SampleWork.writeDescription(response, result);
			return;
		}

		// 生成ファイルをクライアントに転送
		SampleWork.executeFileTrasfer(response, outPdfFileName);
	}

}