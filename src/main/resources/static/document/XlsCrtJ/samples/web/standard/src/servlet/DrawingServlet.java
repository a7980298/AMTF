package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.adv.barcode.BarCodeCreator;
import jp.co.adv.barcode.enums.BarCodeType;
import jp.co.adv.barcode.enums.CheckPattern;
import jp.co.adv.barcode.enums.Codeset;
import jp.co.adv.barcode.enums.MessageAlign;
import jp.co.adv.barcode.enums.PDFModel;
import jp.co.adv.barcode.enums.QRConnect;
import jp.co.adv.barcode.enums.QRLevel;
import jp.co.adv.barcode.enums.QRMask;
import jp.co.adv.barcode.enums.QRModel;
import jp.co.adv.barcode.enums.QRVersion;
import jp.co.adv.barcode.enums.Rotate;
import jp.co.adv.barcode.enums.Unit;
import jp.co.adv.barcode.shared.BarCodeSizeD;
import jp.co.adv.excelcreator.creator.Drawing;
import jp.co.adv.excelcreator.creator.ErrorListener;
import jp.co.adv.excelcreator.creator.ExcelCreatorException;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.ArrowType;
import jp.co.adv.excelcreator.enums.BorderStyle;
import jp.co.adv.excelcreator.enums.BoxType;
import jp.co.adv.excelcreator.enums.ExcelColor;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.FontStyle;
import jp.co.adv.excelcreator.enums.FontULine;
import jp.co.adv.excelcreator.enums.HorizontalAlignment;
import jp.co.adv.excelcreator.enums.LineStyle;
import jp.co.adv.excelcreator.enums.PageOrientation;
import jp.co.adv.excelcreator.enums.PaperKind;
import jp.co.adv.excelcreator.enums.ScaleMode;
import jp.co.adv.excelcreator.enums.ShapeType;
import jp.co.adv.excelcreator.enums.TextAlign;
import jp.co.adv.excelcreator.enums.TextAnchor;
import jp.co.adv.excelcreator.enums.TextBoxFontStyle;
import jp.co.adv.excelcreator.enums.TextVertical;
import model.SampleWork;


public class DrawingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String outFileName;
	private Image imageBmp;
	private XlsxCreator xlsxCreator = new XlsxCreator();
	private BarCodeCreator barCode = new BarCodeCreator(); // バーコードクラス

	public DrawingServlet() {
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
		xlsxCreator = new XlsxCreator();
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

		// 図、シェイプの設定
		if (request.getParameter("drawing") != null)
		{
			// 日付をキーとしたファイル名を生成
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'drawing'_yyyyMMdd_HHmmss'.xlsx'");
			outFileName += simpleDateFormat.format(new Date(System.currentTimeMillis()));

			// Excel ファイル新規作成
			//================================================================//
			xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);
			xlsxCreator.setScaleMode(ScaleMode.Pixel);  // オブジェクト描画時のサイズ単位(Pixel)

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// 図の挿入
			if (request.getParameter("image") != null) {
				// 「画像の挿入」用のシートを作成
				AddSheet("画像の挿入");
				xlsxCreator.setMargin(5, 5, 5, 5, 5, 5);
				xlsxCreator.setPaperSize(PageOrientation.Landscape , PaperKind.A4);
				xlsxCreator.getCell("B1").setStr("(1) 図の設定方法");
				xlsxCreator.getCell("B1").getAttr().setFontStyle(FontStyle.Bold);

				xlsxCreator.getCell("A30").setBreak(true);
				xlsxCreator.getCell("B30").setStr("(2) 対応する画像形式");
				xlsxCreator.getCell("B30").getAttr().setFontStyle(FontStyle.Bold);

				// (1) 図の設定方法
				xlsxCreator.getCell("B2").setStr("1-1. サイズ（幅・高さ）で貼り付け(画像ファイル)");
				xlsxCreator.getCell("B3").setStr("B4 セルを基点に幅(320px)、高さ(240px)");
				xlsxCreator.getCell("B4").getDrawing().addImage(context.getRealPath("/WEB-INF/data/image.bmp"), 320, 240);

				xlsxCreator.getCell("G2").setStr("1-2. オフセット座標で貼り付け(画像ファイル)");
				xlsxCreator.getCell("G3").setStr("G4 セルを基点に開始位置を調整(20px, 30px)");
				xlsxCreator.getCell("G4").getDrawing().addImage(context.getRealPath("/WEB-INF/data/image.bmp"), 20, 30, -1, -1, 320, 240);

				xlsxCreator.getCell("L2").setStr("1-3. セルサイズに合わせて貼り付け(画像ファイル)");
				xlsxCreator.getCell("L3").setStr("L4:O13 セル範囲指定");
				xlsxCreator.getCell("L4:O13").getDrawing().addImage(context.getRealPath("/WEB-INF/data/image.bmp"));

				xlsxCreator.getCell("B16").setStr("1-4. 画像(Image)オブジェクトでの挿入");
				xlsxCreator.getCell("B17").setStr("B18 セルを基点に幅(320px)、高さ(240px)");
				// イメージの初期化(サンプル用の処理)
				if (imageBmp != null) {
					imageBmp = null;
				}
				try {
					imageBmp = ImageIO.read(new File(context.getRealPath("/WEB-INF/data/image.bmp")));
				} catch (Exception e) {
					imageBmp = null;
				}
				xlsxCreator.getCell("B18").getDrawing().addImage(imageBmp, 320, 240);

				// (2) emf ファイル以外の対応する画像形式
				xlsxCreator.getCell("B31").setStr("2-1. bmp 形式");
				xlsxCreator.getCell("B32").getDrawing().addImage(context.getRealPath("/WEB-INF/data/image.bmp"), 320, 240);

				xlsxCreator.getCell("G31").setStr("2-2. png 形式(透過)");
				xlsxCreator.getCell("G32").getDrawing().addImage(context.getRealPath("/WEB-INF/data/image.png"), 320, 240);
				xlsxCreator.getCell("H36").setValue("セルの文字列が透過");

				xlsxCreator.getCell("L31").setStr("2-3. gif 形式(透過)");
				xlsxCreator.getCell("L32").getDrawing().addImage(context.getRealPath("/WEB-INF/data/image.gif"), 320, 240);
				xlsxCreator.getCell("M36").setValue("セルの文字列が透過");

				xlsxCreator.getCell("B45").setStr("2-4. jpg 形式");
				xlsxCreator.getCell("B46").getDrawing().addImage(context.getRealPath("/WEB-INF/data/image.jpg"), 320, 240);
			}
			// バーコード
			if (request.getParameter("barcode") != null) {
				xlsxCreator.setScaleMode(ScaleMode.Millimeter);  // オブジェクト描画時のサイズ単位(Millimeter)
				AddSheet("バーコード");
				xlsxCreator.setMargin(5, 5, 5, 5, 5, 5);
				xlsxCreator.setPaperSize(PageOrientation.Landscape , PaperKind.A4);
				xlsxCreator.getCell("B1").setStr("バーコードクラスで作成可能なバーコードの種類を出力します。");
				xlsxCreator.getCell("B1").getAttr().setFontStyle(FontStyle.Bold);

				// 各バーコードの作成イメージ設定
				BarCodeSizeD size;
				JAN13();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("B3").setValue("JAN13");
				xlsxCreator.getCell("B3", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				JAN8();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("G3").setValue("JAN8");
				xlsxCreator.getCell("G3", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				UPCA();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("B9").setValue("UPC-A");
				xlsxCreator.getCell("B9", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				UPCE();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("G9").setValue("UPC-E");
				xlsxCreator.getCell("G9", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				ITF6();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("B15").setValue("ITF(6桁)");
				xlsxCreator.getCell("B15", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				ITF14();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("G15").setValue("ITF(14桁)");
				xlsxCreator.getCell("G15", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				ITF16();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("B20").setValue("ITF(16桁)");
				xlsxCreator.getCell("B20", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				ITFFree();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("G20").setValue("ITF(自由桁)");
				xlsxCreator.getCell("G20", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				Codabar();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("B25").setValue("Codabar");
				xlsxCreator.getCell("B25", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				Code39();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("G25").setValue("Code39");
				xlsxCreator.getCell("G25", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				Code128();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("B29").setValue("Code128");
				xlsxCreator.getCell("B29", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				GS1128();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("G29").setValue("GS1-128");
				xlsxCreator.getCell("G29", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				GS1128Fixed();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("B33").setValue("料金代理収納用バーコード");
				xlsxCreator.getCell("B33", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				CustomerBarCode();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("G33").setValue("カスタマバーコード");
				xlsxCreator.getCell("G33", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				QRCode();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("B37").setValue("QRコード");
				xlsxCreator.getCell("B37", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				PDF417();
				size = barCode.getScaleSize(Unit.Millimeter);
				xlsxCreator.getCell("G37").setValue("PDF417");
				xlsxCreator.getCell("G37", 0, 1).getDrawing().addImage(barCode.getImage(), size.getWidth(), size.getHeight());

				xlsxCreator.setScaleMode(ScaleMode.Pixel);  // オブジェクト描画時のサイズ単位(Pixel)へ戻す ※その他の処理用
			}
			// ライン
			if (request.getParameter("line") != null) {
				AddSheet("線の挿入");
				xlsxCreator.setMargin(5, 5, 5, 5, 5, 5);
				xlsxCreator.setPaperSize(PageOrientation.Landscape, PaperKind.A4);
				xlsxCreator.getCell("B1").setStr("(1) 線の挿入方法(Drawing オブジェクトの使い方)");
				xlsxCreator.getCell("B1").getAttr().setFontStyle(FontStyle.Bold);

				xlsxCreator.getCell("B9").setStr("(2) 対応する線のスタイル");
				xlsxCreator.getCell("B9").getAttr().setFontStyle(FontStyle.Bold);

				xlsxCreator.getCell("B31").setStr("(3) 太さと修飾を組み合わせた設定例");
				xlsxCreator.getCell("B31").getAttr().setFontStyle(FontStyle.Bold);

				xlsxCreator.getCell("A43").setBreak(true);
				xlsxCreator.getCell("B43").setStr("(4) 対応する線の矢印");
				xlsxCreator.getCell("B43").getAttr().setFontStyle(FontStyle.Bold);

				xlsxCreator.getCell("B52").setStr("(5) 矢印の大きさと太さを組み合わせた設定例");
				xlsxCreator.getCell("B52").getAttr().setFontStyle(FontStyle.Bold);
				xlsxCreator.getCell("B53").setStr("※大きさ・太さ、修飾のそれぞれの設定をパイプ(\"|\")で連結し、矢印のサイズを調整します。(スタイルには[Arrow]を使用)");
				xlsxCreator.getCell("C54").setRowHeight(60);
				xlsxCreator.getCell("C54:E54").getAttr().box(BoxType.Box, BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("C54:E54").getAttr().setMergeCells(true);
				xlsxCreator.getCell("C54:E54").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);
				xlsxCreator.getCell("C54").setValue("短い\n(Short)\n[標準]");
				xlsxCreator.getCell("F54:H54").getAttr().box(BoxType.Box, BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("F54:H54").getAttr().setMergeCells(true);
				xlsxCreator.getCell("F54:H54").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);
				xlsxCreator.getCell("F54").setValue("普通\n(Normal)");
				xlsxCreator.getCell("I54:K54").getAttr().box(BoxType.Box, BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("I54:K54").getAttr().setMergeCells(true);
				xlsxCreator.getCell("I54:K54").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);
				xlsxCreator.getCell("I54").setValue("長い\n(Long)");
				xlsxCreator.getCell("B55:B57").getAttr().box(BoxType.Box, BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("B55:B57").getAttr().setMergeCells(true);
				xlsxCreator.getCell("B55:B57").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);
				xlsxCreator.getCell("B55").setValue("小さく\n(Small)\n[標準]");
				xlsxCreator.getCell("B58:B60").getAttr().box(BoxType.Box, BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("B58:B60").getAttr().setMergeCells(true);
				xlsxCreator.getCell("B58:B60").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);
				xlsxCreator.getCell("B58").setValue("普通\n(Medium)");
				xlsxCreator.getCell("B61:B63").getAttr().box(BoxType.Box, BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("B61:B63").getAttr().setMergeCells(true);
				xlsxCreator.getCell("B61:B63").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);
				xlsxCreator.getCell("B61").setValue("大きく\n(Large)");
				xlsxCreator.getCell("C57:K57").getAttr().lineBottom(BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("C60:K60").getAttr().lineBottom(BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("C63:K63").getAttr().lineBottom(BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("B55:B63").getAttr().lineRight(BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("E55:E63").getAttr().lineRight(BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("H55:H63").getAttr().lineRight(BorderStyle.Medium, ExcelColor.Auto);
				xlsxCreator.getCell("K55:K63").getAttr().lineRight(BorderStyle.Medium, ExcelColor.Auto);

				xlsxCreator.getCell("A66").setBreak(true);
				xlsxCreator.getCell("B66").setStr("(6) 折れ線の描画");
				xlsxCreator.getCell("B66").getAttr().setFontStyle(FontStyle.Bold);

				// (1) 線の挿入方法(Drawing オブジェクトの使い方)
				xlsxCreator.getCell("B2").setStr("1-1. 単純な線の挿入");
				xlsxCreator.getCell("B4:C8").getDrawing().addLine(ShapeType.Line);
				xlsxCreator.getCell("B4:C8").getDrawing().init();

				xlsxCreator.getCell("F2").setStr("1-2. 複数の修飾を設定した線の挿入");
				xlsxCreator.getCell("F3").setStr("     (矢印(始点:終点) + 破線 + 青色 + 3pt)");
				xlsxCreator.getCell("F4:G8").getDrawing().setLineColor(Color.BLUE);				// 線の色
				xlsxCreator.getCell("F4:G8").getDrawing().setLineWeight(3);						// 線の太さ
				xlsxCreator.getCell("F4:G8").getDrawing().setLineStyle(LineStyle.Dash);			// 線のスタイル
				xlsxCreator.getCell("F4:G8").getDrawing().setArrowTypeS(ArrowType.Diamond);		// 線の矢印(始点)
				xlsxCreator.getCell("F4:G8").getDrawing().setArrowTypeE(ArrowType.Oval);		// 線の矢印(終点)
				xlsxCreator.getCell("F4:G8").getDrawing().addLine(ShapeType.Line);
				//xlsxCreator.getCell("J4:K9").getDrawing().init();								// 設定の初期化(あえて初期化しない)

				xlsxCreator.getCell("J2").setStr("1-3. 前項の初期化を行わないで線の挿入");
				xlsxCreator.getCell("J3").setStr("     (前項の設定内容が反映される)");
				xlsxCreator.getCell("J4:K8").getDrawing().addLine(ShapeType.Line);
				xlsxCreator.getCell("J4:K8").getDrawing().init();
				// ※線の挿入は、修飾(setLineColor)→線の挿入(addLine)→修飾の初期化(init)
				//   の流れで処理を行ってください。

				xlsxCreator.getCell("N2").setStr("1-4. 二つの線のスタイル");
				xlsxCreator.getCell("N3").setStr("     [破線 + 二重線]");
				// ※ポイント：Cell.Drawing クラスをエイリアスで操作することも可能。
				Drawing drawing;
				drawing = xlsxCreator.getCell("N4:O9").getDrawing();
				drawing.setLineColor(Color.GREEN);
				drawing.setLineStyle(LineStyle.Dash.getValue() | LineStyle.Double.getValue());
				drawing.addLine(ShapeType.Line);
				drawing.init();

				// (2) 対応する線のスタイル
				xlsxCreator.getCell("B10").setStr("種類:なし");
				xlsxCreator.getCell("B11").setStr("LineStyle,No=[None,0]");
				drawing = xlsxCreator.getCell("B12:C16").getDrawing();
				drawing.setLineStyle(LineStyle.None);
				// addShape メソッドでも、線を挿入することも可能です。
				drawing.addLine(ShapeType.Line);
				//drawing.addShape(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("F10").setStr("種類:実線");
				xlsxCreator.getCell("F11").setStr("LineStyle,No=[Normal,1]");
				drawing = xlsxCreator.getCell("F12:G16").getDrawing();
				drawing.setLineStyle(LineStyle.Normal);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("J10").setStr("種類:丸点線");
				xlsxCreator.getCell("J11").setStr("LineStyle,No=[SysDot,2]");
				drawing = xlsxCreator.getCell("J12:K16").getDrawing();
				drawing.setLineStyle(LineStyle.SysDot);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("N10").setStr("種類:角点線");
				xlsxCreator.getCell("N11").setStr("LineStyle,No=[SysDash,3]");
				drawing = xlsxCreator.getCell("N12:O16").getDrawing();
				drawing.setLineStyle(LineStyle.SysDash);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("B17").setStr("種類:破線");
				xlsxCreator.getCell("B18").setStr("LineStyle,No=[Dash,4]");
				drawing = xlsxCreator.getCell("B19:C23").getDrawing();
				drawing.setLineStyle(LineStyle.Dash);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("F17").setStr("種類:一点鎖線");
				xlsxCreator.getCell("F18").setStr("LineStyle,No=[DashDot,5]");
				drawing = xlsxCreator.getCell("F19:G23").getDrawing();
				drawing.setLineStyle(LineStyle.DashDot);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("J17").setStr("種類:長破線");
				xlsxCreator.getCell("J18").setStr("LineStyle,No=[LongDash,6]");
				drawing = xlsxCreator.getCell("J19:K23").getDrawing();
				drawing.setLineStyle(LineStyle.LongDash);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("N17").setStr("種類:長一点鎖線");
				xlsxCreator.getCell("N18").setStr("LineStyle,No=[LongDashDot,7]");
				drawing = xlsxCreator.getCell("N19:O23").getDrawing();
				drawing.setLineStyle(LineStyle.LongDashDot);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("B24").setStr("種類:長二点鎖線");
				xlsxCreator.getCell("B25").setStr("LineStyle,No=[LongDashDotDot,8]");
				drawing = xlsxCreator.getCell("B26:C30").getDrawing();
				drawing.setLineStyle(LineStyle.LongDashDotDot);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("F24").setStr("種類:Round");
				xlsxCreator.getCell("F25").setStr("LineStyle,No=[Round,9]");
				drawing = xlsxCreator.getCell("F26:G30").getDrawing();
				drawing.setLineStyle(LineStyle.Round);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				// (3) 太さと修飾を組み合わせた設定例
				xlsxCreator.getCell("B32").setStr("種類:二重線(一点鎖線)");
				xlsxCreator.getCell("B33").setStr("LineStyle,No=[Double | DashDot,32 | 5]");
				drawing = xlsxCreator.getCell("B34:C38").getDrawing();
				drawing.setLineStyle(LineStyle.Double.getValue() | LineStyle.DashDot.getValue());
				drawing.setLineWeight(4);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("F32").setStr("種類:下が太い二重線(一点鎖線)");
				xlsxCreator.getCell("F33").setStr("LineStyle,No=[ThickThin | DashDot,48 | 5]");
				drawing = xlsxCreator.getCell("F34:G38").getDrawing();
				drawing.setLineStyle(LineStyle.ThickThin.getValue() | LineStyle.DashDot.getValue());
				drawing.setLineWeight(4);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("J32").setStr("種類:上が太い二重線(一点鎖線)");
				xlsxCreator.getCell("J33").setStr("LineStyle,No=[ThinThick | DashDot,64 | 5]");
				drawing = xlsxCreator.getCell("J34:K38").getDrawing();
				drawing.setLineStyle(LineStyle.ThinThick.getValue() | LineStyle.DashDot.getValue());
				drawing.setLineWeight(4);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("N32").setStr("種類:三重線(一点鎖線)");
				xlsxCreator.getCell("N33").setStr("LineStyle,No=[Triple | DashDot,80 | 5]");
				drawing = xlsxCreator.getCell("N34:O38").getDrawing();
				drawing.setLineStyle(LineStyle.Triple.getValue() | LineStyle.DashDot.getValue());
				drawing.setLineWeight(4);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				// (4) 対応する線の矢印
				xlsxCreator.getCell("B44").setStr("始点:三角形 ArrowType,No=[Triangle,1]");
				xlsxCreator.getCell("B45").setStr("終点:ひし形 ArrowType,No=[Diamond,3]");
				drawing = xlsxCreator.getCell("B46:C50").getDrawing();
				drawing.setArrowTypeS(ArrowType.Triangle);
				drawing.setArrowTypeE(ArrowType.Diamond);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("F44").setStr("始点:ライン ArrowType,No=[Arrow,5]");
				xlsxCreator.getCell("F45").setStr("終点:鋭角　ArrowType,No=[Stealth,2]");
				drawing = xlsxCreator.getCell("F46:G50").getDrawing();
				drawing.setArrowTypeS(ArrowType.Arrow);
				drawing.setArrowTypeE(ArrowType.Stealth);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				xlsxCreator.getCell("J44").setStr("始点:丸  ArrowType,No=[Oval,4]");
				xlsxCreator.getCell("J45").setStr("終点:なし  ArrowType,No=[None,0]");
				drawing = xlsxCreator.getCell("J46:K50").getDrawing();
				drawing.setArrowTypeS(ArrowType.Oval);
				drawing.setArrowTypeE(ArrowType.None);
				drawing.addLine(ShapeType.Line);
				drawing.init();

				// (5) 矢印の大きさと太さを組み合わせた設定例
				// ※大きさ(Short/Normal/Long)・太さ(Small/Medium/Large)、修飾のそれぞれの設定を
				//   パイプ("|")で連結し、矢印のサイズを調整します。(スタイルには[Arrow]を使用)
				drawing = xlsxCreator.getCell("D56").getDrawing();
				drawing.setArrowTypeE(ArrowType.Small.getValue() | ArrowType.Short.getValue() | ArrowType.Arrow.getValue());
				drawing.addLine(ShapeType.Line, 0, 0, 50, 0);
				drawing.init();

				drawing = xlsxCreator.getCell("G56").getDrawing();
				drawing.setArrowTypeE(ArrowType.Small.getValue() | ArrowType.Normal.getValue() | ArrowType.Arrow.getValue());
				drawing.addLine(ShapeType.Line, 0, 0, 50, 0);
				drawing.init();

				drawing = xlsxCreator.getCell("J56").getDrawing();
				drawing.setArrowTypeE(ArrowType.Small.getValue() | ArrowType.Long.getValue() | ArrowType.Arrow.getValue());
				drawing.addLine(ShapeType.Line, 0, 0, 50, 0);
				drawing.init();

				drawing = xlsxCreator.getCell("D59").getDrawing();
				drawing.setArrowTypeE(ArrowType.Medium.getValue() | ArrowType.Short.getValue() | ArrowType.Arrow.getValue());
				drawing.addLine(ShapeType.Line, 0, 0, 50, 0);
				drawing.init();

				drawing = xlsxCreator.getCell("G59").getDrawing();
				drawing.setArrowTypeE(ArrowType.Medium.getValue() | ArrowType.Normal.getValue() | ArrowType.Arrow.getValue());
				drawing.addLine(ShapeType.Line, 0, 0, 50, 0);
				drawing.init();

				drawing = xlsxCreator.getCell("J59").getDrawing();
				drawing.setArrowTypeE(ArrowType.Medium.getValue() | ArrowType.Long.getValue() | ArrowType.Arrow.getValue());
				drawing.addLine(ShapeType.Line, 0, 0, 50, 0);
				drawing.init();

				drawing = xlsxCreator.getCell("D62").getDrawing();
				drawing.setArrowTypeE(ArrowType.Large.getValue() | ArrowType.Short.getValue() | ArrowType.Arrow.getValue());
				drawing.addLine(ShapeType.Line, 0, 0, 50, 0);
				drawing.init();

				drawing = xlsxCreator.getCell("G62").getDrawing();
				drawing.setArrowTypeE(ArrowType.Large.getValue() | ArrowType.Normal.getValue() | ArrowType.Arrow.getValue());
				drawing.addLine(ShapeType.Line, 0, 0, 50, 0);
				drawing.init();

				drawing = xlsxCreator.getCell("J62").getDrawing();
				drawing.setArrowTypeE(ArrowType.Large.getValue() | ArrowType.Long.getValue() | ArrowType.Arrow.getValue());
				drawing.addLine(ShapeType.Line, 0, 0, 50, 0);
				drawing.init();

				// (6) 折れ線の描画(線をつなぎ合せることで、折れ線の作成が可能です)
				drawing = xlsxCreator.getCell("B66").getDrawing();

				// 予め、修飾の設定を行います。
				drawing.setLineColor(new Color(173, 216, 230));
				drawing.setLineWeight(4);
				drawing.setLineStyle(LineStyle.LongDashDot);

				// 始点と終点をの x座標、y 座標の変数を用意します。
				int startX, startY, endX, endY;
				// 始点の位置(オフセット)を設定します。
				startX = 0;
				startY = 800;
				// 終点の位置(オフセット)を設定します。
				endX = 80;
				endY = 40;

				// 始点とサイズで設定する場合、次の始点を求めることが難しいため、始点と終点で設定することをお勧めします。
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);
				// 終点が、次の線の始点になります。
				startX = endX;
				startY = endY;
				endX += 80;
				endY = 400;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 160;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 600;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 480;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 560;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 520;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 680;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 400;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 400;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 400;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 80;
				endY = 200;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				// 最後に矢印を設定します。
				drawing.setArrowTypeE(ArrowType.Stealth);
				startX = endX;
				startY = endY;
				endX += 80;
				endY = 320;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);
				drawing.init();

				// 折れ線の挿入
				drawing.setArrowTypeS(ArrowType.Diamond);
				drawing.setLineStyle(LineStyle.Normal);
				drawing.setLineWeight(0.5);
				drawing.setLineColor(new Color(144, 255, 59));

				startX = 0;
				startY = 40;
				endX = 200;
				endY = 160;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 200;
				endY = 80;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 200;
				endY = 240;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 200;
				endY = 520;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 200;
				endY = 560;
				drawing.setArrowTypeE(ArrowType.Triangle);
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);
				drawing.init();

				drawing.setArrowTypeS(ArrowType.Oval);
				drawing.setLineStyle(LineStyle.LongDash);
				drawing.setLineWeight(4);
				drawing.setLineColor(Color.BLACK);
				startX = 0;
				startY = 400;
				endX = 160;
				endY = 600;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 160;
				endY = 200;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 160;
				endY = 120;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 160;
				endY = 720;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 160;
				endY = 360;
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);

				startX = endX;
				startY = endY;
				endX += 160;
				endY = 480;
				drawing.setArrowTypeE(ArrowType.Arrow);
				drawing.addLine(ShapeType.Line, startX, startY, endX, endY);
				drawing.init();
			}
			// オートシェイプ
			if (request.getParameter("shape") != null) {
				AddSheet("オートシェイプ");
				xlsxCreator.setMargin(5, 5, 5, 5, 5, 5);
				xlsxCreator.setPaperSize(PageOrientation.Landscape, PaperKind.A4);
				xlsxCreator.getCell("B1").setStr("(1) オートシェイプの設定");
				xlsxCreator.getCell("B1").getAttr().setFontStyle(FontStyle.Bold);

				// (1) オートシェイプの設定
				xlsxCreator.getCell("B2").setStr("1-1. 線の色(緑)");
				xlsxCreator.getCell("B3:E14").getDrawing().setLineColor(Color.GREEN);
				xlsxCreator.getCell("B3:E14").getDrawing().addShape(ShapeType.Ellipse);
				xlsxCreator.getCell("B3:E14").getDrawing().init();

				xlsxCreator.getCell("G2").setStr("1-2. 塗りつぶしの色(青)");
				xlsxCreator.getCell("G3:J14").getDrawing().setFillColor(Color.BLUE);
				xlsxCreator.getCell("G3:J14").getDrawing().addShape(ShapeType.Ellipse);
				xlsxCreator.getCell("G3:J14").getDrawing().init();

				xlsxCreator.getCell("L2").setStr("1-3. 線のスタイルと幅[上が太い二重線(5pt)]");
				xlsxCreator.getCell("L3:O14").getDrawing().setLineWeight(5);
				xlsxCreator.getCell("L3:O14").getDrawing().setLineStyle(LineStyle.Normal.getValue() | LineStyle.ThickThin.getValue());
				xlsxCreator.getCell("L3:O14").getDrawing().addShape(ShapeType.Ellipse);
				xlsxCreator.getCell("L3:O14").getDrawing().init();

				xlsxCreator.getCell("B16").setStr("1-4. サイズの指定");
				xlsxCreator.getCell("B17").getDrawing().addShape(ShapeType.Ellipse, 200, 200);
				xlsxCreator.getCell("B17").getDrawing().init();

				xlsxCreator.getCell("G16").setStr("1-5. 塗りつぶしあり(明示的に指定)");
				xlsxCreator.getCell("G17:J28").getDrawing().setShapeNoFill(false);
				xlsxCreator.getCell("G17:J28").getDrawing().addShape(ShapeType.Ellipse);
				xlsxCreator.getCell("G17:J28").getDrawing().init();

				// (2) 対応するオートシェイプ
				xlsxCreator.getCell("A31").setBreak(true);
				xlsxCreator.getCell("B31").setStr("(2) 対応するオートシェイプ");
				xlsxCreator.getCell("B31").getAttr().setFontStyle(FontStyle.Bold);
				InsertShape(1, 32, ShapeType.Rect, "四角形", new Color(158, 204, 233));
				InsertShape(5, 32, ShapeType.RoundRect, "角丸四角形", new Color(244, 244, 220));
				InsertShape(9, 32, ShapeType.Ellipse, "楕円", new Color(165, 42, 42));
				InsertShape(13, 32, ShapeType.Diamond, "ひし形", Color.CYAN);
				InsertShape(1, 38, ShapeType.Triangle, "二等辺三角形", new Color(0, 100, 0));
				InsertShape(5, 38, ShapeType.RtTriangle, "直角三角形", Color.PINK);
				InsertShape(9, 38, ShapeType.Parallelogram, "平行四辺形", new Color(221, 160, 221));
				InsertShape(13, 38, ShapeType.Trapezoid, "台形", Color.ORANGE);
				InsertShape(1, 44, ShapeType.Hexagon, "六角形", new Color(128, 128, 0));
				InsertShape(5, 44, ShapeType.Octagon, "八角形", new Color(0, 255, 0));
				InsertShape(9, 44, ShapeType.Plus, "十字形", new Color(255, 255, 240));
				InsertShape(13, 44, ShapeType.Cube, "直方体", new Color(255, 127, 80));
				InsertShape(1, 50, ShapeType.Line, "線", Color.RED);
				InsertShape(5, 50, ShapeType.Plaque, "ブローチ", new Color(128, 0, 128));
				InsertShape(9, 50, ShapeType.Can, "円柱", new Color(46, 139, 87));
				InsertShape(13, 50, ShapeType.Pentagon, "五角形", new Color(255, 255, 224));
				InsertShape(1, 56, ShapeType.FoldedCorner, "メモ", new Color(255, 255, 240));
				InsertShape(5, 56, ShapeType.Bevel, "額縁", Color.LIGHT_GRAY);
				InsertShape(9, 56, ShapeType.LeftBracket, "大括弧(左)", Color.WHITE);
				InsertShape(13, 56, ShapeType.RightBracket, "大括弧(右)", Color.WHITE);
				InsertShape(1, 62, ShapeType.BracketPair, "大括弧", new Color(230, 230, 250));
				InsertShape(5, 62, ShapeType.BracePair, "中括弧", Color.WHITE);
			}
			// テキストボックス
			if (request.getParameter("textbox") != null) {
				AddSheet("テキストボックス");
				xlsxCreator.setMargin(5, 5, 5, 5, 5, 5);
				xlsxCreator.setPaperSize(PageOrientation.Landscape, PaperKind.A4);
				xlsxCreator.getCell("B2").setStr("(1) テキストボックスの設定");
				xlsxCreator.getCell("B2").getAttr().setFontStyle(FontStyle.Bold);

				xlsxCreator.getCell("B16").setStr("(2) テキストの位置");
				xlsxCreator.getCell("B16").getAttr().setFontStyle(FontStyle.Bold);

				// (1) テキストボックスの設定
				xlsxCreator.getCell("B3").setStr("1-1. フォントの色(赤)");
				xlsxCreator.getCell("B4").setStr("     FontColor[xlColor.Red]");
				xlsxCreator.getCell("B5:E15").getDrawing().setFontColor(Color.RED);
				xlsxCreator.getCell("B5:E15").getDrawing().addTextBox(ShapeType.Rect, "ExcelCreator for Java");
				xlsxCreator.getCell("B5:E15").getDrawing().init();

				xlsxCreator.getCell("G3").setStr("1-2. フォント名とサイズ[MS 明朝(15)]");
				xlsxCreator.getCell("G4").setStr("FontName[ＭＳ 明朝] , FontPoint[15]");
				xlsxCreator.getCell("G5:J15").getDrawing().setFontName("ＭＳ 明朝");
				xlsxCreator.getCell("G5:J15").getDrawing().setFontPoint(15);
				xlsxCreator.getCell("G5:J15").getDrawing().addTextBox(ShapeType.Rect, "ExcelCreator for Java");
				xlsxCreator.getCell("G5:J15").getDrawing().init();

				xlsxCreator.getCell("L3").setStr("1-3. フォントのスタイルと下線[太字 斜体＋二重下線]");
				xlsxCreator.getCell("L4").setStr("FontStyle[Bold | Italic] , FontULine[Double]");
				xlsxCreator.getCell("L5:O15").getDrawing().setFontStyle(TextBoxFontStyle.Bold.getValue() | TextBoxFontStyle.Italic.getValue());
				xlsxCreator.getCell("L5:O15").getDrawing().setFontULine(FontULine.Double);
				xlsxCreator.getCell("L5:O15").getDrawing().addTextBox(ShapeType.Rect, "ExcelCreator for Java");
				xlsxCreator.getCell("L5:O15").getDrawing().init();

				// (2) テキストの位置
				xlsxCreator.getCell("B17").setStr("横位置:左詰め、縦位置:上詰め、横書き");
				xlsxCreator.getCell("A18").setStr("TextAlign,TextAnchor,TextVertical=[Left,Top,Horz]");
				xlsxCreator.getCell("B19:E29").getDrawing().setTextAlign(TextAlign.Left);
				xlsxCreator.getCell("B19:E29").getDrawing().setTextAnchor(TextAnchor.Top);
				xlsxCreator.getCell("B19:E29").getDrawing().setTextVertical(TextVertical.Horz);
				xlsxCreator.getCell("B19:E29").getDrawing().addTextBox(ShapeType.Rect, "aaa");
				xlsxCreator.getCell("B19:E29").getDrawing().init();

				xlsxCreator.getCell("G17").setStr("横位置:中央、縦位置：中央、縦書き");
				xlsxCreator.getCell("F18").setStr("TextAlign,TextAnchor,TextVertical=[Center,Center,EaVert]");
				xlsxCreator.getCell("G19:J29").getDrawing().setTextAlign(TextAlign.Center);
				xlsxCreator.getCell("G19:J29").getDrawing().setTextAnchor(TextAnchor.Center);
				xlsxCreator.getCell("G19:J29").getDrawing().setTextVertical(TextVertical.EaVert);
				xlsxCreator.getCell("G19:J29").getDrawing().addTextBox(ShapeType.Rect, "aaa");
				xlsxCreator.getCell("G19:J29").getDrawing().init();

				xlsxCreator.getCell("L17").setStr("横位置:右詰め、縦位置：下詰め、右へ90°回転");
				xlsxCreator.getCell("L18").setStr("TextAlign,TextAnchor,TextVertical=[Right,Bottom,Vert]");
				xlsxCreator.getCell("L19:O29").getDrawing().setTextAlign(TextAlign.Right);
				xlsxCreator.getCell("L19:O29").getDrawing().setTextAnchor(TextAnchor.Bottom);
				xlsxCreator.getCell("L19:O29").getDrawing().setTextVertical(TextVertical.Vert);
				xlsxCreator.getCell("L19:O29").getDrawing().addTextBox(ShapeType.Rect, "aaa");
				xlsxCreator.getCell("L19:O29").getDrawing().init();

				xlsxCreator.getCell("B31").setStr("横位置:左揃え、縦位置：両端揃え、左へ90°回転");
				xlsxCreator.getCell("B32").setStr("TextAlign,TextAnchor,TextVertical[Right,Justify,Vert270]");
				xlsxCreator.getCell("B33:E43").getDrawing().setTextAlign(TextAlign.Right);
				xlsxCreator.getCell("B33:E43").getDrawing().setTextAnchor(TextAnchor.Justify);
				xlsxCreator.getCell("B33:E43").getDrawing().setTextVertical(TextVertical.Vert270);
				xlsxCreator.getCell("B33:E43").getDrawing().addTextBox(ShapeType.Rect, "1行目\n2行目");
				xlsxCreator.getCell("B33:E43").getDrawing().init();
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
	}

	// JAN13
	private void JAN13()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.JAN13);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);

		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Zoomが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可)  [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードメッセージ(チェックデジットなし12ケタ)
		barCode.setValue("490123456789");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードイメージの倍率 (省略可) JAN / UPC の場合、設定範囲は 80% ～ 200% です。
		barCode.setZoom(100);
		// JAN, UPC のガードバー均等化 (省略可)
		barCode.setFlatHeight(true);
		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);
		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// JAN8
	private void JAN8()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.JAN8);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);

		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Zoomが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードメッセージ(チェックデジットなし7ケタ)
		barCode.setValue("4901234");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードイメージの倍率 (省略可) JAN / UPC の場合、設定範囲は 80% ～ 200% です。
		barCode.setZoom(100);
		// JAN, UPC のガードバー均等化 (省略可)
		barCode.setFlatHeight(true);
		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);
		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// UPCA
	private void UPCA()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.UPCA);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);

		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Zoomが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可)  [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードメッセージ(チェックデジットなし7ケタ)
		barCode.setValue("0123456");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードイメージの倍率 (省略可) JAN / UPC の場合、設定範囲は 80% ～ 200% です。
		barCode.setZoom(100);
		// JAN, UPC のガードバー均等化 (省略可)
		barCode.setFlatHeight(true);
		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);
		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// UPCE
	private void UPCE()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.UPCE);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);

		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Zoomが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可)  [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードメッセージ(チェックデジットなし11ケタ)
		barCode.setValue("01234567890");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードイメージの倍率 (省略可) JAN / UPC の場合、設定範囲は 80% ～ 200% です。
		barCode.setZoom(100);
		// JAN, UPC のガードバー均等化 (省略可)
		barCode.setFlatHeight(true);
		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);
		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// ITF6
	private void ITF6()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.ITF6);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);

		// バーコードメッセージ(チェックデジットなし5桁)
		barCode.setValue("12345");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードイメージの倍率 (省略可) 設定範囲は 25% ～ 120% です。
		barCode.setZoom(40);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Zoomが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);
		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);
		// ベアラバーの表示モード (省略可)
		barCode.setShowBearer(true);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// ITF14
	private void ITF14()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.ITF14);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);

		// バーコードメッセージ(チェックデジットなし14桁)
		barCode.setValue("1234567890123");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードイメージの倍率 (省略可) 設定範囲は 25% ～ 120% です。
		barCode.setZoom(40);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Zoomが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);
		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);
		// ベアラバーの表示モード (省略可)
		barCode.setShowBearer(true);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// ITF16
	private void ITF16()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.ITF16);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);

		// バーコードメッセージ(チェックデジットなし16桁)
		barCode.setValue("123456789012345");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードイメージの倍率 (省略可) 設定範囲は 25% ～ 120% です。
		barCode.setZoom(40);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Zoomが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);
		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);
		// ベアラバーの表示モード (省略可)
		barCode.setShowBearer(true);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// ITF(自由桁)
	private void ITFFree()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.ITF);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);

		// バーコードメッセージ(チェックデジットなし18桁)
		barCode.setValue("12345678901234567");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードイメージの倍率 (省略可) 設定範囲は 25% ～ 120% です。
		barCode.setZoom(40);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Zoomが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);
		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);
		// ベアラバーの表示モード (省略可)
		barCode.setShowBearer(true);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// CodaBar
	private void Codabar()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.CodaBar);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);
		// チェックデジットの計算方法 (省略可)
		barCode.setCheckPattern(CheckPattern.Modulus16);
		// スタートコード (省略可)
		barCode.setStartChar('a');
		// ストップコード (省略可)
		barCode.setStopChar('e');

		// バーコードメッセージ
		barCode.setValue("1234567890123");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードの最小モジュール値 (エレメント) (省略可)
		barCode.setElement(8);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Elementが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードの余白幅 (省略可) [0] で"自動設定"となります。
		barCode.setQuiet(0);
		// バーの間隔 (省略可) [0] で"自動設定"となります。
		barCode.setCharGap(0);
		// 太バーのエレメント率 (省略可)
		barCode.setBarRatio(2);
		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// Code39
	private void Code39()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.Code39);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// チェックデジットの付加 (省略可)
		barCode.setCheckCharMode(true);

		// バーコードメッセージ
		barCode.setValue("1234567890123");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードの最小モジュール値 (エレメント) (省略可)
		barCode.setElement(7);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Elementが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可)  [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードの余白幅 (省略可) [0] で "自動設定" となります。
		barCode.setQuiet(0);
		// バーの間隔 (省略可) [0] で "自動設定" となります。
		barCode.setCharGap(0);
		// 太バーのエレメント率 (省略可)
		barCode.setBarRatio(2);
		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// Code128
	private void Code128()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.Code128);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);
		// スタートコードセット (省略可)
		barCode.setCodeset(Codeset.Auto);

		// バーコードメッセージ
		barCode.setValue("1234567890123");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードの最小モジュール値 (エレメント) (省略可)
		barCode.setElement(8);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Elementが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードの余白幅 (省略可) [0] で "自動設定" となります。
		barCode.setQuiet(0);
		// バーコードメッセージの付加 (省略可)
		barCode.setShowMessage(true);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// GS1128
	private void GS1128()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		// GS1-128に設定した場合、スタートコードセットの既定値は、コードセット C になります。
		barCode.setType(BarCodeType.GS1);
		// コードセット C に設定(省略可)
		barCode.setCodeset(Codeset.CodesetC);

		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);

		// バーコードメッセージ
		// 括弧()は、バーコードキャラクタに含まれません。
		barCode.setValue("(01)14912345678904(17)140331(30)2613(10)53521128");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードの最小モジュール値(エレメント) (省略可)
		barCode.setElement(4);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Elementが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードの余白幅 (省略可) [0] で "自動設定" となります。
		barCode.setQuiet(0);
		// バーコードメッセージの付加 (省略可) false でバーコードメッセージを非表示にします。
		barCode.setShowMessage(true);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// GS1128(料金代理収納用バーコード)
	private void GS1128Fixed()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.GS1Fixed);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);

		// バーコードメッセージ ※括弧()は自動で付加されます。
		barCode.setValue("9191234512345678901234567892110203310123456");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードの最小モジュール値(エレメント) (省略可)
		barCode.setElement(4);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Elementが有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// バーコードの余白幅 (省略可) [0] で "自動設定" となります。
		barCode.setQuiet(0);
		// バーコードメッセージの付加 (省略可) false でバーコードメッセージを非表示にします。
		barCode.setShowMessage(true);
		// バーコードメッセージの表示位置 (省略可)
		barCode.setMessageAlign(MessageAlign.Center);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
		// フォント (省略可)
		barCode.setFont(new Font("ＭＳ 明朝", Font.BOLD, 9));
	}

	// カスタマバーコード
	private void CustomerBarCode()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.CustomerBarCode);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);

		// バーコードメッセージ (郵便番号 + 住所表示番号)
		barCode.setValue("918-82391-2816");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードイメージの倍率 (省略可) カスタマバーコード の場合、設定範囲は 80% ～ 200% です。
		barCode.setZoom(100);
		// ポイント (省略可) 設定範囲は 8 ～ 20 です。
		barCode.setPoint(8);
		// ----------------------------------------------------------
		// カスタマバーコードの場合、Point プロパティと
		// Zoom プロパティの値が相互にリンクされております
		// ので、後に設定した方が有効となります。
		// ----------------------------------------------------------

		//【注意】========================================================//
		// BarWidth  で生成されるバーコードのサイズの指定が可能です。
		// その場合、Unit に Millimeter を指定してください。
		// BarWidth に [0] 以外を設定した場合、 Zoom,Point が有効になりません。
		//================================================================//
		//// バーコードの高さ (省略可) [0] で "自動設定" となります。
		//barCode1.BarHeight = 0;
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
	}

	// QR コード
	private void QRCode()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.QRCode);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiY(600);

		// バーコードメッセージ
		barCode.setValue("VB-Report 8.0 for .NET Sample");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードの最小モジュール値 (エレメント) (省略可)
		barCode.setElement(16);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Elementが有効になりません。
		//================================================================//
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);
		// バーコードの余白幅 (省略可) [0] で "自動設定" となります。
		barCode.setQuiet(0);

		// QR コードモデル (省略可)
		barCode.setQRModel(QRModel.Model2);
		// QR コード型番 (省略可)
		barCode.setQRVersion(QRVersion.VersionAuto);
		// QR コード誤り訂正レベル (省略可)
		barCode.setQRLevel(QRLevel.LevelM);
		// QR コードマスクパターン (省略可)
		barCode.setQRMask(QRMask.MaskAuto);
		// QR コード連結モード (省略可)
		barCode.setQRConnect(QRConnect.NotConnect);
		// QR コード連結番号 (省略可)
		barCode.setQRSymbolNumber(0);
		// QR コードのエスケープコード (省略可)
		barCode.setQREscapeCode((byte)0);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
	}

	// PDF417
	private void PDF417()
	{
		//【1】===========================================================//
		// プログラム例内に記述された [(省略可)] と記載のある関数、プロパティ
		// については、省略した場合、既定値か前回使用された値が使用されます。
		//================================================================//

		// バーコード種別
		barCode.setType(BarCodeType.PDF417);
		// サイズ単位 (省略可ですがなるべく設定してください)
		barCode.setUnit(Unit.Pixel);
		// x , y 方向の解像度
		barCode.setDpiX(600);
		barCode.setDpiX(600);

		// バーコードメッセージ
		barCode.setValue("VB-Report 8.0 for .NET Sample");

		// バーコードの回転方向 (省略可)
		barCode.setRotate(Rotate.Rotate0);
		// バーコードの最小モジュール値 (エレメント) (省略可)
		barCode.setElement(8);
		//【注意】========================================================//
		// BarWidth、BarHeightで生成されるバーコードのサイズの指定が可能です。
		// その場合、UnitにMillimeterを指定してください。
		// BarWidthに[0]以外を設定した場合、Elementが有効になりません。
		//================================================================//
		//// バーコードの幅 (省略可) [0] で "自動設定" となります。
		//barCode1.BarWidth = 0;

		// 黒バーの太さの比率 (省略可)
		barCode.setBlackRatio(100);
		// バーコードの余白幅 (省略可) [0] で "自動設定" となります。
		barCode.setQuiet(0);

		// PDF417 モデル (省略可)
		barCode.setPDFModel(PDFModel.Default);
		// PDF417 列数 (省略可) [0] で "自動設定" となります。
		barCode.setPDFColumn(0);
		// PDF417 行数 (省略可) [0] で "自動設定" となります。
		barCode.setPDFRow(0);
		// PDF417 誤り訂正レベル (省略可)
		barCode.setPDFLevel(0);
		// PDF417 初期化シンボルの付加 (省略可)
		barCode.setPDFInitialSymbol(false);
		// PDF417 の 1 モジュールの高さ (省略可)
		barCode.setPDFRatio(7.5f);

		// バーの色 (省略可)
		barCode.setBarColor(Color.black);
		// バーコードの背景色 (省略可)
		barCode.setBackColor(Color.white);
	}

	// Excel シートを新規に追加します。シート名が Sheet1 の場合、追加しません。
	private void AddSheet(String sheetName) {
		if (xlsxCreator.getSheetName().equals("Sheet1") != true) {
			xlsxCreator.addSheet(1);
		}
		xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
		xlsxCreator.setSheetName(sheetName);
	}
	// 対応するオートシェイプの挿入
	private void InsertShape(int x, int y, ShapeType shapetype, String message, Color color) {
		xlsxCreator.getPos(x, y).setStr("種類:" + message);
		xlsxCreator.getPos(x, y + 1).setStr("設定 [" + shapetype.toString() + "]  番号 [" + shapetype.getValue() + "]");
		Drawing drawing;
		if ((shapetype != ShapeType.LeftBracket) && (shapetype != ShapeType.RightBracket)) {
			drawing = xlsxCreator.getPos(x, y + 2, x + 2, y + 5).getDrawing();
		} else {
			drawing = xlsxCreator.getPos(x, y + 2, x, y + 5).getDrawing();
		}
		drawing.setFillColor(color);
		drawing.addShape(shapetype);
		drawing.init();
	}
}