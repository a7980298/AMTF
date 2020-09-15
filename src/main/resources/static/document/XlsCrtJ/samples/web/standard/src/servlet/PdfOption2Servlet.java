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


public class PdfOption2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String fileName;
	private String outPdfFileName;

	public PdfOption2Servlet() {
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
		// テンプレートファイルパスの取得
		ServletContext context = this.getServletContext();
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

		// フォント・外字の埋め込み
		if (request.getParameter("pdfembed") != null) {
			fileName = context.getRealPath("/WEB-INF/data/templatepdf.xlsx");	// テンプレート Excel ファイル
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'pdfembed'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));
			outPdfFileName = outFileName.replace(".xlsx", ".pdf");

			//【1】===========================================================//
			// オーバーレイオープン
			//================================================================//
			xlsxCreator.openBook(outFileName, fileName);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// サンプル説明用の処理
			switch (SampleWork.parseInt(request.getParameter("embedfont"))) {
			case 0:
				xlsxCreator.getCell("E8:E10").setValue("設定なし(OSの外字)");
				break;
			case 1:
				xlsxCreator.getCell("E8").setValue("gaiji1.tte");
				xlsxCreator.getCell("E9").setValue("設定なし(OSの外字)");
				xlsxCreator.getCell("E10").setValue("gaiji2.tte");
				break;
			case 2:
				xlsxCreator.getCell("E8:E10").setValue("gaiji1.tte");
				break;
			}

			//================================================================//
			// PDF ファイル出力の詳細機能は、closeBook 前に設定します。
			// Pdf.EmbedFonts でフォントの埋め込みに対応します。
			// 文字列型の配列に埋め込みたいフォント名の列挙を指定する方法と、
			// "*"で使用されたすべてのフォントを埋め込む方法があります。
			//================================================================//
			switch (SampleWork.parseInt(request.getParameter("embedfont"))) {
			// 埋め込まない(デフォルト)
			case 0:
				xlsxCreator.getPdf().setEmbedFonts(null);
				break;
			// 埋め込むフォント名を指定(ＭＳ Ｐゴシックと メイリオ)
			case 1:
				xlsxCreator.getPdf().setEmbedFonts(new String[] { "ＭＳ Ｐゴシック", "メイリオ" });
				break;
			// 使用されたすべてのフォントを埋め込む
			case 2:
				xlsxCreator.getPdf().setEmbedFonts(new String[] { "*" });
				break;
			}

			//================================================================//
			// Pdf.EUDCFiles で PDF ファイルで使用する外字ファイルの埋込みを行い
			// ます。
			// 指定方法は、第 1 要素に[対象のフォント名]、第 2 要素に[外字ファイ
			// ルパス]の string 配列をリストで格納したものを使用します。
			// 外字の指定がないフォントでは、システムの外字設定が使用されます。
			// また、すべてのフォントに同一の外字を使用する場合、フォント名を
			// "SystemDefaultEUDCFont"に設定します。
			//================================================================//
			String gaiji1 = context.getRealPath("/WEB-INF/data/gaiji1.tte");
			String gaiji2 = context.getRealPath("/WEB-INF/data/gaiji2.tte");
			switch (SampleWork.parseInt(request.getParameter("embedeudcfiles"))) {
			// 埋め込まない(デフォルト)
			case 0:
				xlsxCreator.getPdf().setEudcFiles(null);
				break;
			// 埋め込むフォント名を指定(ＭＳ Ｐゴシックで gaiji1.tte 、メイリオで gaiji2.tte)
			case 1:
				xlsxCreator.getPdf().setEudcFiles(new String[][] {
					new String[] { "ＭＳ Ｐゴシック", gaiji1 },
					new String[] { "メイリオ", gaiji2 } });
				break;
			// 使用されたすべてのフォントの外字でgaiji1を使用。
			case 2:
				// "SystemDefaultEUDCFont" の外字と個別のフォントの外字を設定した場合、個別のフォントの設定が優先されます。
				xlsxCreator.getPdf().setEudcFiles(new String[][] { new String[] { "SystemDefaultEUDCFont", gaiji1 } });
				break;
			}

			//【3】===========================================================//
			// Excel ファイルクローズ
			//================================================================//
			xlsxCreator.closeBook(true, outPdfFileName, false);
		}
		// PDF 文書のプロパティ
		else if (request.getParameter("templateopen") != null) {
			fileName = context.getRealPath("/WEB-INF/data/templatepdf.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}

		if (result.equals("") == false) {
			SampleWork.writeDescription(response, result);
			return;
		}

		// 生成ファイルをクライアントに転送
		SampleWork.executeFileTrasfer(response, outPdfFileName);
	}

}