package panel;

import java.awt.Color;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

import donotedit.SampleWork;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.BorderStyle;
import jp.co.adv.excelcreator.enums.BoxType;
import jp.co.adv.excelcreator.enums.ExcelColor;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.FontStyle;
import jp.co.adv.excelcreator.enums.FontULine;
import jp.co.adv.excelcreator.enums.HorizontalAlignment;
import jp.co.adv.excelcreator.enums.Orientation;
import jp.co.adv.excelcreator.enums.Pattern;
import jp.co.adv.excelcreator.enums.VerticalAlignment;

public class AttributeCellJPanel extends JPanel {

	private String outFileName;
	private XlsxCreator xlsxCreator;
	private JCheckBox jCheckBoxFormat;
	private JCheckBox jCheckBoxStringAlignment;
	private JCheckBox jCheckBoxStringOrientation;
	private JCheckBox jCheckBoxStringControl;
	private JCheckBox jCheckBoxFont;
	private JCheckBox jCheckBoxRuledLine;
	private JCheckBox jCheckBoxBackColor;
	private JCheckBox jCheckBoxPattern;

	/**
	 * Create the panel.
	 */
	public AttributeCellJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonAttributeCell = new JButton();
		JLabel jLabel1 = new JLabel();
		jCheckBoxFormat = new JCheckBox();
		jCheckBoxFont = new JCheckBox();
		jCheckBoxStringAlignment = new JCheckBox();
		jCheckBoxRuledLine = new JCheckBox();
		jCheckBoxStringOrientation = new JCheckBox();
		jCheckBoxBackColor = new JCheckBox();
		jCheckBoxStringControl = new JCheckBox();
		jCheckBoxPattern = new JCheckBox();

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13));
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("Excel 操作・編集 - セルの書式設定");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setRows(2);
		jTextArea1.setText("ExcelCreator の機能でセルの各書式設定を行います。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "セルの書式設定", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonAttributeCell.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonAttributeCell.setText("Excel ファイル作成");
		jButtonAttributeCell.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonAttributeCell.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAttributeCellActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel1.setText("チェック ON の書式を設定した Excel ファイルを作成します。");

		jCheckBoxFormat.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jCheckBoxFormat.setSelected(true);
		jCheckBoxFormat.setText("表示形式");
		jCheckBoxFormat.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxFont.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jCheckBoxFont.setSelected(true);
		jCheckBoxFont.setText("フォント");
		jCheckBoxFont.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxStringAlignment.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jCheckBoxStringAlignment.setSelected(true);
		jCheckBoxStringAlignment.setText("配置 - 文字の配置");
		jCheckBoxStringAlignment.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxRuledLine.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jCheckBoxRuledLine.setSelected(true);
		jCheckBoxRuledLine.setText("罫線");
		jCheckBoxRuledLine.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxStringOrientation.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jCheckBoxStringOrientation.setSelected(true);
		jCheckBoxStringOrientation.setText("配置 - 方向");
		jCheckBoxStringOrientation.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxBackColor.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jCheckBoxBackColor.setSelected(true);
		jCheckBoxBackColor.setText("塗りつぶし - 背景色");
		jCheckBoxBackColor.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxStringControl.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jCheckBoxStringControl.setSelected(true);
		jCheckBoxStringControl.setText("配置 - 文字の制御");
		jCheckBoxStringControl.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxPattern.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jCheckBoxPattern.setSelected(true);
		jCheckBoxPattern.setText("塗りつぶし - パターン");
		jCheckBoxPattern.setBackground(new java.awt.Color(248, 248, 255));

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(33, 33, 33)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jCheckBoxStringOrientation)
												.addComponent(jCheckBoxFormat)
												.addComponent(jCheckBoxStringAlignment)
												.addComponent(jCheckBoxStringControl))
										.addGap(11, 11, 11)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jCheckBoxPattern)
												.addComponent(jCheckBoxRuledLine)
												.addComponent(jCheckBoxFont)
												.addComponent(jCheckBoxBackColor)))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jButtonAttributeCell, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addGap(6, 6, 6)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jCheckBoxFormat)
								.addComponent(jCheckBoxFont))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jCheckBoxStringAlignment)
								.addComponent(jCheckBoxRuledLine))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jCheckBoxStringOrientation)
								.addComponent(jCheckBoxBackColor))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jCheckBoxStringControl)
								.addComponent(jCheckBoxPattern))
						.addGap(18, 18, 18)
						.addComponent(jButtonAttributeCell, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 507, Short.MAX_VALUE))
				);
	}
	// セルの書式設定
	private void jButtonAttributeCellActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "attributecell.xlsx";	// 生成 Excel ファイル

		//【1】===========================================================//
		// Excel ファイル新規作成
		//================================================================//
		xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		// 表示形式
		if (jCheckBoxFormat.isSelected() == true) {
			// 「表示形式」用のシートを作成
			AddSheet("表示形式");
			xlsxCreator.getCell("A").setColWidth(24);
			xlsxCreator.getCell("B").setColWidth(21.75);
			xlsxCreator.getCell("A1").getAttr().setFontPoint(14);
			xlsxCreator.getCell("A1").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("A1").setStr("表示形式の設定");

			// 標準
			xlsxCreator.getCell("A2").setStr("標準");
			xlsxCreator.getCell("B2").getAttr().setFormat("G/標準");
			xlsxCreator.getCell("B2").setStr("ExcelCreator for Java");
			// 数値
			xlsxCreator.getCell("A3").setStr("数値（桁区切りを使用する）");
			xlsxCreator.getCell("B3").getAttr().setFormat("#,##0_ ");
			xlsxCreator.getCell("B3").setInteger(1000000000);
			// 通貨
			xlsxCreator.getCell("A4").setStr("通貨（記号￥）");
			xlsxCreator.getCell("B4").getAttr().setFormat("\"\\\"#,##0;\"\\\"-#,##0");
			xlsxCreator.getCell("B4").setInteger(1000000);
			// 日付
			xlsxCreator.getCell("A5").setStr("日付（yyyy/m/d）");
			xlsxCreator.getCell("B5").getAttr().setFormat("yyyy/m/d");
			Date date = new Date();
			double doubleDate = (date.getTime() / (60 * 60 * 24 * 1000)) + 25569;   // 現在時刻のシリアル値を取得
			xlsxCreator.getCell("B5").setValue(doubleDate);
			// パーセンテージ
			xlsxCreator.getCell("A6").setStr("パーセンテージ");
			xlsxCreator.getCell("B6").getAttr().setFormat("0%");
			xlsxCreator.getCell("B6").setDouble(0.5);
			// ユーザー定義1
			xlsxCreator.getCell("A7").setStr("値がマイナスの時に赤色");
			xlsxCreator.getCell("B7").getAttr().setFormat("#.#0;[赤]-#.#0");
			xlsxCreator.getCell("B7").setInteger(-123456);
			// ユーザー定義2
			xlsxCreator.getCell("A8").setStr("値が0の時にZERO ");
			xlsxCreator.getCell("B8").getAttr().setFormat(";;\"ZERO\"");
			xlsxCreator.getCell("B8").setInteger(0);
		}
		// 配置 - 文字の配置
		if (jCheckBoxStringAlignment.isSelected() == true) {
			// 「配置 - 文字の配置」用のシートを作成
			AddSheet("配置(文字の配置)");
			int x, y;
			xlsxCreator.setZoom(85);
			xlsxCreator.getCell("A1").getAttr().setFontPoint(14);
			xlsxCreator.getCell("A1").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("A1").setStr("文字の配置の設定");
			xlsxCreator.getCell("B1").setStr("（x軸→縦位置、y軸→横位置）");
			xlsxCreator.getCell("A2:F11").setRowHeight(40);
			xlsxCreator.getCell("A2:F11").setColWidth(20);
			for (x = 1; x <= 5; x++) {
				for (y = 2; y <= 10; y++) {
					xlsxCreator.getPos(x, y).setStr("あいうえお");
				}
			}
			xlsxCreator.getCell("B2:F2").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("A2:A11").getAttr().setFontStyle(FontStyle.Bold);

			// 文字の縦位置を設定します
			xlsxCreator.getCell("B2").setStr("上詰め");
			xlsxCreator.getCell("B3:B11").getAttr().setVerticalAlignment(VerticalAlignment.Top);

			xlsxCreator.getCell("C2").setStr("中央揃え");
			xlsxCreator.getCell("C3:C11").getAttr().setVerticalAlignment(VerticalAlignment.Center);

			xlsxCreator.getCell("D2").setStr("下詰め");
			xlsxCreator.getCell("D3:D11").getAttr().setVerticalAlignment(VerticalAlignment.Bottom);

			xlsxCreator.getCell("E2").setStr("両端揃え");
			xlsxCreator.getCell("E3:E11").getAttr().setVerticalAlignment(VerticalAlignment.Justify);

			xlsxCreator.getCell("F2").setStr("均等割付");
			xlsxCreator.getCell("F3:F11").getAttr().setVerticalAlignment(VerticalAlignment.Distributed);

			// 文字の横位置を設定します
			xlsxCreator.getCell("A3").setStr("標準");
			xlsxCreator.getCell("B3:F3").getAttr().setHorizontalAlignment(HorizontalAlignment.General);

			xlsxCreator.getCell("A4").setStr("左詰め");
			xlsxCreator.getCell("B4:F4").getAttr().setHorizontalAlignment(HorizontalAlignment.Left);

			xlsxCreator.getCell("A5").setStr("中央揃え");
			xlsxCreator.getCell("B5:F5").getAttr().setHorizontalAlignment(HorizontalAlignment.Center);

			xlsxCreator.getCell("A6").setStr("右詰め");
			xlsxCreator.getCell("B6:F6").getAttr().setHorizontalAlignment(HorizontalAlignment.Right);

			xlsxCreator.getCell("A7").setStr("繰り返し");
			xlsxCreator.getCell("B7:F7").getAttr().setHorizontalAlignment(HorizontalAlignment.Fill);

			xlsxCreator.getCell("A8").setStr("両端揃え");
			xlsxCreator.getCell("B8:F8").getAttr().setHorizontalAlignment(HorizontalAlignment.Justify);

			xlsxCreator.getCell("A9").setStr("選択範囲内で中央");
			xlsxCreator.getCell("B9:F9").getAttr().setHorizontalAlignment(HorizontalAlignment.CenterContinuous);

			xlsxCreator.getCell("A10").setStr("均等割付");
			xlsxCreator.getCell("B10:F10").getAttr().setHorizontalAlignment(HorizontalAlignment.Distributed);

			xlsxCreator.getCell("A11").setStr("インデント3");
			xlsxCreator.getCell("B11:F11").getAttr().setHorizontalAlignment(3);
		}
		// 配置 - 方向
		if (jCheckBoxStringOrientation.isSelected() == true) {
			// 「配置 - 方向」用のシートを作成
			AddSheet("配置(方向)");
			xlsxCreator.getCell("A1").getAttr().setFontPoint(14);
			xlsxCreator.getCell("A1").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("A1").setStr("方向の設定");
			xlsxCreator.getCell("A:F").setColWidth(16.5);
			xlsxCreator.getCell("A2").setRowHeight(120);
			xlsxCreator.getCell("A4").setRowHeight(120);

			// 方向を定数で設定します
			xlsxCreator.getCell("A2").setStr("横方向");
			xlsxCreator.getCell("A2").getAttr().setOrientation(Orientation.Horz);

			xlsxCreator.getCell("B2").setStr("縦方向");
			xlsxCreator.getCell("B2").getAttr().setOrientation(Orientation.Vert);

			xlsxCreator.getCell("C2").setStr("反時計回りに90度");
			xlsxCreator.getCell("C2").getAttr().setOrientation(Orientation.RvTurn90);

			xlsxCreator.getCell("D2").setStr("時計回りに90度");
			xlsxCreator.getCell("D2").getAttr().setOrientation(Orientation.Turn90);

			// 方向を値で設定します
			xlsxCreator.getCell("A4").setStr("値で指定(15度)");
			xlsxCreator.getCell("A4").getAttr().setOrientation(15);

			xlsxCreator.getCell("B4").setStr("値で指定(-15度)");
			xlsxCreator.getCell("B4").getAttr().setOrientation(-15);

			xlsxCreator.getCell("C4").setStr("値で指定(45度)");
			xlsxCreator.getCell("C4").getAttr().setOrientation(45);

			xlsxCreator.getCell("D4").setStr("値で指定(-45度)");
			xlsxCreator.getCell("D4").getAttr().setOrientation(-45);

			xlsxCreator.getCell("E4").setStr("値で指定(60度)");
			xlsxCreator.getCell("E4").getAttr().setOrientation(60);

			xlsxCreator.getCell("F4").setStr("値で指定(-60度)");
			xlsxCreator.getCell("F4").getAttr().setOrientation(-60);
		}
		// 配置 - 文字の制御
		if (jCheckBoxStringControl.isSelected() == true) {
			// 「配置 - 文字の制御」用のシートを作成
			AddSheet("配置(文字の制御)");
			xlsxCreator.getCell("A1").getAttr().setFontPoint(14);
			xlsxCreator.getCell("A1").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("A1").setStr("文字の制御の設定");
			xlsxCreator.getCell("A").setColWidth(16);

			// 折り返して全体を表示する
			xlsxCreator.getCell("A2").setStr("折り返し（ON）");
			xlsxCreator.getCell("B2").getAttr().setWrapText(true);
			xlsxCreator.getCell("B2").setStr("abcdefghijklmnopqrstuvwxyz");

			xlsxCreator.getCell("A3").setStr("折り返し（OFF）");
			xlsxCreator.getCell("B3").getAttr().setWrapText(false);
			xlsxCreator.getCell("B3").setStr("abcdefghijklmnopqrstuvwxyz");

			// 縮小して全体を表示する
			xlsxCreator.getCell("A5").setStr("縮小（ON）");
			xlsxCreator.getCell("B5").getAttr().setShrinkToFit(true);
			xlsxCreator.getCell("B5").setStr("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

			xlsxCreator.getCell("A6").setStr("縮小（OFF）");
			xlsxCreator.getCell("B6").getAttr().setShrinkToFit(false);
			xlsxCreator.getCell("B6").setStr("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

			// セルを結合する
			xlsxCreator.getCell("A8").setStr("B8:C8セルを結合");
			xlsxCreator.getCell("B8:C8").getAttr().setMergeCells(true);
			xlsxCreator.getCell("B8:C8").setLong(1234567890);
		}
		// フォント
		if (jCheckBoxFont.isSelected() == true) {
			// 「フォント」用のシートを作成
			AddSheet("フォント");
			xlsxCreator.getCell("A1").getAttr().setFontPoint(14);
			xlsxCreator.getCell("A1").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("A1").setStr("フォントの設定");
			xlsxCreator.getCell("A").setColWidth(18);
			xlsxCreator.getCell("B:D").setColWidth(33);
			xlsxCreator.getCell("A2").setStr("フォント名（サイズ）");
			xlsxCreator.getCell("A6").setStr("スタイル、文字飾り");
			xlsxCreator.getCell("A10").setStr("下線");
			xlsxCreator.getCell("A12").setStr("色（xlColor）");
			xlsxCreator.getCell("A14").setStr("色（Color）");

			// B2:B4 セルに対してフォント "ＭＳ Ｐ明朝" を設定します
			xlsxCreator.getCell("B2:B4").getAttr().setFontName("ＭＳ Ｐ明朝");
			// 各セルに異なるフォントサイズを設定します
			xlsxCreator.getCell("B2").setStr("ＭＳ Ｐ明朝（8）");
			xlsxCreator.getCell("B2").getAttr().setFontPoint(8);

			xlsxCreator.getCell("B3").setStr("ＭＳ Ｐ明朝（11）");
			xlsxCreator.getCell("B3").getAttr().setFontPoint(11);

			xlsxCreator.getCell("B4").setStr("ＭＳ Ｐ明朝（20）");
			xlsxCreator.getCell("B4").getAttr().setFontPoint(20);

			// C2:C4 セルに対してフォント "ＭＳ ゴシック" を設定します
			xlsxCreator.getCell("C2:C4").getAttr().setFontName("ＭＳ ゴシック");
			// 各セルに異なるフォントサイズを設定します
			xlsxCreator.getCell("C2").setStr("ＭＳ ゴシック（8）");
			xlsxCreator.getCell("C2").getAttr().setFontPoint(8);

			xlsxCreator.getCell("C3").setStr("ＭＳ ゴシック（11）");
			xlsxCreator.getCell("C3").getAttr().setFontPoint(11);

			xlsxCreator.getCell("C4").setStr("ＭＳ ゴシック（20）");
			xlsxCreator.getCell("C4").getAttr().setFontPoint(20);

			// D2:D4 セルに対してフォント "Arial" を設定します
			xlsxCreator.getCell("D2:D4").getAttr().setFontName("Arial");
			// 各セルに異なるフォントサイズを設定します
			xlsxCreator.getCell("D2").setStr("Arial (8)");
			xlsxCreator.getCell("D2").getAttr().setFontPoint(8);

			xlsxCreator.getCell("D3").setStr("Arial (11)");
			xlsxCreator.getCell("D3").getAttr().setFontPoint(11);

			xlsxCreator.getCell("D4").setStr("Arial (20)");
			xlsxCreator.getCell("D4").getAttr().setFontPoint(20);

			// スタイル、文字飾り
			xlsxCreator.getCell("B6").setStr("標準");
			xlsxCreator.getCell("B6").getAttr().setFontStyle(FontStyle.Normal);

			xlsxCreator.getCell("C6").setStr("斜体");
			xlsxCreator.getCell("C6").getAttr().setFontStyle(FontStyle.Italic);

			xlsxCreator.getCell("D6").setStr("太字");
			xlsxCreator.getCell("D6").getAttr().setFontStyle(FontStyle.Bold);

			xlsxCreator.getCell("B7").setStr("太字 斜体");
			xlsxCreator.getCell("B7").getAttr().setFontStyle(FontStyle.Bold.getValue() + FontStyle.Italic.getValue());

			xlsxCreator.getCell("B8").setStr("取り消し線");
			xlsxCreator.getCell("B8").getAttr().setFontStyle(FontStyle.Strike);

			xlsxCreator.getCell("C8").setStr("上付き");
			xlsxCreator.getCell("C8").getAttr().setFontStyle(FontStyle.Up);

			xlsxCreator.getCell("D8").setStr("下付き");
			xlsxCreator.getCell("D8").getAttr().setFontStyle(FontStyle.Down);

			// 下線
			xlsxCreator.getCell("B10").setStr("下線");
			xlsxCreator.getCell("B10").getAttr().setFontULine(FontULine.Normal);

			xlsxCreator.getCell("C10").setStr("二重下線");
			xlsxCreator.getCell("C10").getAttr().setFontULine(FontULine.Double);

			// フォント色(ExcelCreator定数)を設定します（AdvanceSoftwera.ExcelCreator.xlColor）
			xlsxCreator.getCell("B12").setStr("赤（ExcelColor.Red）");
			xlsxCreator.getCell("B12").getAttr().setFontColor(ExcelColor.Red);

			xlsxCreator.getCell("C12").setStr("緑（ExcelColor.Green）");
			xlsxCreator.getCell("C12").getAttr().setFontColor(ExcelColor.Green);

			xlsxCreator.getCell("D12").setStr("青（ExcelColor.Blue）");
			xlsxCreator.getCell("D12").getAttr().setFontColor(ExcelColor.Blue);

			// フォント色(RGB)を設定します（System.Drawing.Color）
			xlsxCreator.getCell("B14").setStr("紫（Color.MAGENTA）");
			xlsxCreator.getCell("B14").getAttr().setFontColor(Color.MAGENTA);

			xlsxCreator.getCell("C14").setStr("グレー（Color.GRAY）");
			xlsxCreator.getCell("C14").getAttr().setFontColor(Color.GRAY);

			xlsxCreator.getCell("D14").setStr("オレンジ（Color.ORANGE）");
			xlsxCreator.getCell("D14").getAttr().setFontColor(Color.ORANGE);
		}
		// 罫線
		if (jCheckBoxRuledLine.isSelected() == true) {
			// 「罫線」用のシートを作成
			AddSheet("罫線");
			xlsxCreator.setZoom(85);
			xlsxCreator.getCell("A1").getAttr().setFontPoint(14);
			xlsxCreator.getCell("A1").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("A1").setStr("罫線の設定");
			xlsxCreator.getCell("B").setColWidth(18);
			xlsxCreator.getCell("D").setColWidth(18);
			xlsxCreator.getCell("F").setColWidth(18);

			// 実線（黒）の罫線（上下左右）
			xlsxCreator.getCell("B3").setStr("実線");
			xlsxCreator.getCell("B3").getAttr().lineLeft(BorderStyle.Thin, ExcelColor.Black);
			xlsxCreator.getCell("B3").getAttr().lineTop(BorderStyle.Thin, ExcelColor.Black);
			xlsxCreator.getCell("B3").getAttr().lineRight(BorderStyle.Thin, ExcelColor.Black);
			xlsxCreator.getCell("B3").getAttr().lineBottom(BorderStyle.Thin, ExcelColor.Black);

			// 太線（黒）の罫線（上下左右）
			xlsxCreator.getCell("D3").setStr("太線");
			xlsxCreator.getCell("D3").getAttr().lineLeft(BorderStyle.Medium, ExcelColor.Black);
			xlsxCreator.getCell("D3").getAttr().lineTop(BorderStyle.Medium, ExcelColor.Black);
			xlsxCreator.getCell("D3").getAttr().lineRight(BorderStyle.Medium, ExcelColor.Black);
			xlsxCreator.getCell("D3").getAttr().lineBottom(BorderStyle.Medium, ExcelColor.Black);

			// 破線（黒）の罫線（上下左右）
			xlsxCreator.getCell("F3").setStr("破線");
			xlsxCreator.getCell("F3").getAttr().lineLeft(BorderStyle.Dashed, ExcelColor.Black);
			xlsxCreator.getCell("F3").getAttr().lineTop(BorderStyle.Dashed, ExcelColor.Black);
			xlsxCreator.getCell("F3").getAttr().lineRight(BorderStyle.Dashed, ExcelColor.Black);
			xlsxCreator.getCell("F3").getAttr().lineBottom(BorderStyle.Dashed, ExcelColor.Black);

			// 点線（黒）の罫線（上下左右）
			xlsxCreator.getCell("B5").setStr("点線");
			xlsxCreator.getCell("B5").getAttr().lineLeft(BorderStyle.Dotted, ExcelColor.Black);
			xlsxCreator.getCell("B5").getAttr().lineTop(BorderStyle.Dotted, ExcelColor.Black);
			xlsxCreator.getCell("B5").getAttr().lineRight(BorderStyle.Dotted, ExcelColor.Black);
			xlsxCreator.getCell("B5").getAttr().lineBottom(BorderStyle.Dotted, ExcelColor.Black);

			// 極太線（黒）の罫線（上下左右）
			xlsxCreator.getCell("D5").setStr("極太線");
			xlsxCreator.getCell("D5").getAttr().lineLeft(BorderStyle.Thick, ExcelColor.Black);
			xlsxCreator.getCell("D5").getAttr().lineTop(BorderStyle.Thick, ExcelColor.Black);
			xlsxCreator.getCell("D5").getAttr().lineRight(BorderStyle.Thick, ExcelColor.Black);
			xlsxCreator.getCell("D5").getAttr().lineBottom(BorderStyle.Thick, ExcelColor.Black);

			// 二重線（黒）の罫線（上下左右）
			xlsxCreator.getCell("F5").setStr("二重線");
			xlsxCreator.getCell("F5").getAttr().lineLeft(BorderStyle.Double, ExcelColor.Black);
			xlsxCreator.getCell("F5").getAttr().lineTop(BorderStyle.Double, ExcelColor.Black);
			xlsxCreator.getCell("F5").getAttr().lineRight(BorderStyle.Double, ExcelColor.Black);
			xlsxCreator.getCell("F5").getAttr().lineBottom(BorderStyle.Double, ExcelColor.Black);

			// 細実線（黒）の罫線（上下左右）
			xlsxCreator.getCell("B7").setStr("細実線");
			xlsxCreator.getCell("B7").getAttr().lineLeft(BorderStyle.Hair, ExcelColor.Black);
			xlsxCreator.getCell("B7").getAttr().lineTop(BorderStyle.Hair, ExcelColor.Black);
			xlsxCreator.getCell("B7").getAttr().lineRight(BorderStyle.Hair, ExcelColor.Black);
			xlsxCreator.getCell("B7").getAttr().lineBottom(BorderStyle.Hair, ExcelColor.Black);

			// 中破線（黒）の罫線（上下左右）
			xlsxCreator.getCell("D7").setStr("中破線");
			xlsxCreator.getCell("D7").getAttr().lineLeft(BorderStyle.MediumDashed, ExcelColor.Black);
			xlsxCreator.getCell("D7").getAttr().lineTop(BorderStyle.MediumDashed, ExcelColor.Black);
			xlsxCreator.getCell("D7").getAttr().lineRight(BorderStyle.MediumDashed, ExcelColor.Black);
			xlsxCreator.getCell("D7").getAttr().lineBottom(BorderStyle.MediumDashed, ExcelColor.Black);

			// 細一点鎖線（黒）の罫線（上下左右）
			xlsxCreator.getCell("F7").setStr("細一点鎖線");
			xlsxCreator.getCell("F7").getAttr().lineLeft(BorderStyle.DashDot, ExcelColor.Black);
			xlsxCreator.getCell("F7").getAttr().lineTop(BorderStyle.DashDot, ExcelColor.Black);
			xlsxCreator.getCell("F7").getAttr().lineRight(BorderStyle.DashDot, ExcelColor.Black);
			xlsxCreator.getCell("F7").getAttr().lineBottom(BorderStyle.DashDot, ExcelColor.Black);

			// 中一点鎖線（黒）の罫線（上下左右）
			xlsxCreator.getCell("B9").setStr("中一点鎖線");
			xlsxCreator.getCell("B9").getAttr().lineLeft(BorderStyle.MediumDashDot, ExcelColor.Black);
			xlsxCreator.getCell("B9").getAttr().lineTop(BorderStyle.MediumDashDot, ExcelColor.Black);
			xlsxCreator.getCell("B9").getAttr().lineRight(BorderStyle.MediumDashDot, ExcelColor.Black);
			xlsxCreator.getCell("B9").getAttr().lineBottom(BorderStyle.MediumDashDot, ExcelColor.Black);

			// 細二点鎖線（黒）の罫線（上下左右）
			xlsxCreator.getCell("D9").setStr("細二点鎖線");
			xlsxCreator.getCell("D9").getAttr().lineLeft(BorderStyle.DashDotDot, ExcelColor.Black);
			xlsxCreator.getCell("D9").getAttr().lineTop(BorderStyle.DashDotDot, ExcelColor.Black);
			xlsxCreator.getCell("D9").getAttr().lineRight(BorderStyle.DashDotDot, ExcelColor.Black);
			xlsxCreator.getCell("D9").getAttr().lineBottom(BorderStyle.DashDotDot, ExcelColor.Black);

			// 中二点鎖線（黒）の罫線（上下左右）
			xlsxCreator.getCell("F9").setStr("中二点鎖線");
			xlsxCreator.getCell("F9").getAttr().lineLeft(BorderStyle.MediumDashDotDot, ExcelColor.Black);
			xlsxCreator.getCell("F9").getAttr().lineTop(BorderStyle.MediumDashDotDot, ExcelColor.Black);
			xlsxCreator.getCell("F9").getAttr().lineRight(BorderStyle.MediumDashDotDot, ExcelColor.Black);
			xlsxCreator.getCell("F9").getAttr().lineBottom(BorderStyle.MediumDashDotDot, ExcelColor.Black);

			// 中一点斜鎖線（黒）の罫線（上下左右）
			xlsxCreator.getCell("B11").setStr("中一点斜鎖線");
			xlsxCreator.getCell("B11").getAttr().lineLeft(BorderStyle.SlantDashDot, ExcelColor.Black);
			xlsxCreator.getCell("B11").getAttr().lineTop(BorderStyle.SlantDashDot, ExcelColor.Black);
			xlsxCreator.getCell("B11").getAttr().lineRight(BorderStyle.SlantDashDot, ExcelColor.Black);
			xlsxCreator.getCell("B11").getAttr().lineBottom(BorderStyle.SlantDashDot, ExcelColor.Black);

			// 実線（赤）の罫線（上下左右）
			xlsxCreator.getCell("B13").setStr("実線（赤）");
			xlsxCreator.getCell("B13").getAttr().lineLeft(BorderStyle.Thin, ExcelColor.Red);
			xlsxCreator.getCell("B13").getAttr().lineTop(BorderStyle.Thin, ExcelColor.Red);
			xlsxCreator.getCell("B13").getAttr().lineRight(BorderStyle.Thin, ExcelColor.Red);
			xlsxCreator.getCell("B13").getAttr().lineBottom(BorderStyle.Thin, ExcelColor.Red);

			// 太線（緑）の罫線（上下左右）
			xlsxCreator.getCell("D13").setStr("太線（緑）");
			xlsxCreator.getCell("D13").getAttr().lineLeft(BorderStyle.Medium, ExcelColor.Green);
			xlsxCreator.getCell("D13").getAttr().lineTop(BorderStyle.Medium, ExcelColor.Green);
			xlsxCreator.getCell("D13").getAttr().lineRight(BorderStyle.Medium, ExcelColor.Green);
			xlsxCreator.getCell("D13").getAttr().lineBottom(BorderStyle.Medium, ExcelColor.Green);

			// 破線（青）の罫線（上下左右）
			xlsxCreator.getCell("F13").setStr("破線（青）");
			xlsxCreator.getCell("F13").getAttr().lineLeft(BorderStyle.Dashed, ExcelColor.Blue);
			xlsxCreator.getCell("F13").getAttr().lineTop(BorderStyle.Dashed, ExcelColor.Blue);
			xlsxCreator.getCell("F13").getAttr().lineRight(BorderStyle.Dashed, ExcelColor.Blue);
			xlsxCreator.getCell("F13").getAttr().lineBottom(BorderStyle.Dashed, ExcelColor.Blue);

			// 点線（紫）の罫線（上下左右）
			xlsxCreator.getCell("B15").setStr("点線（紫）");
			xlsxCreator.getCell("B15").getAttr().lineLeft(BorderStyle.Dotted, ExcelColor.Purple);
			xlsxCreator.getCell("B15").getAttr().lineTop(BorderStyle.Dotted, ExcelColor.Purple);
			xlsxCreator.getCell("B15").getAttr().lineRight(BorderStyle.Dotted, ExcelColor.Purple);
			xlsxCreator.getCell("B15").getAttr().lineBottom(BorderStyle.Dotted, ExcelColor.Purple);

			// 極太線（グレー）の罫線（上下左右）
			xlsxCreator.getCell("D15").setStr("極太線（グレー）");
			xlsxCreator.getCell("D15").getAttr().lineLeft(BorderStyle.Thick, Color.GRAY);
			xlsxCreator.getCell("D15").getAttr().lineTop(BorderStyle.Thick, Color.GRAY);
			xlsxCreator.getCell("D15").getAttr().lineRight(BorderStyle.Thick, Color.GRAY);
			xlsxCreator.getCell("D15").getAttr().lineBottom(BorderStyle.Thick, Color.GRAY);

			// 二重線（オレンジ）の罫線（上下左右）
			xlsxCreator.getCell("F15").setStr("二重線（オレンジ）");
			xlsxCreator.getCell("F15").getAttr().lineLeft(BorderStyle.Double, Color.ORANGE);
			xlsxCreator.getCell("F15").getAttr().lineTop(BorderStyle.Double, Color.ORANGE);
			xlsxCreator.getCell("F15").getAttr().lineRight(BorderStyle.Double, Color.ORANGE);
			xlsxCreator.getCell("F15").getAttr().lineBottom(BorderStyle.Double, Color.ORANGE);

			// 実線（黒）の罫線（左上がり斜線）
			xlsxCreator.getCell("B17").getAttr().lineLeftUp(BorderStyle.Thin, ExcelColor.Black);

			// 太線（黒）の罫線（右上がり斜線）
			xlsxCreator.getCell("D17").getAttr().lineRightUp(BorderStyle.Medium, ExcelColor.Black);

			// 破線（黒）の罫線（左上がり斜線）
			xlsxCreator.getCell("F17").getAttr().lineLeftUp(BorderStyle.Dashed, ExcelColor.Black);

			// 点線（黒）の罫線（右上がり斜線）
			xlsxCreator.getCell("B19").getAttr().lineRightUp(BorderStyle.Dotted, ExcelColor.Black);

			// 極太線（黒）の罫線（左上がり斜線）
			xlsxCreator.getCell("D19").getAttr().lineLeftUp(BorderStyle.Thick, ExcelColor.Black);

			// 二重線（黒）の罫線（右上がり斜線）
			xlsxCreator.getCell("F19").getAttr().lineRightUp(BorderStyle.Double, ExcelColor.Black);

			// 細実線（黒）の罫線（左上がり斜線）
			xlsxCreator.getCell("B21").getAttr().lineLeftUp(BorderStyle.Hair, ExcelColor.Black);

			// 中破線（黒）の罫線（右上がり斜線）
			xlsxCreator.getCell("D21").getAttr().lineRightUp(BorderStyle.MediumDashed, ExcelColor.Black);

			// 細一点鎖線（黒）の罫線（左上がり斜線）
			xlsxCreator.getCell("F21").getAttr().lineLeftUp(BorderStyle.DashDot, ExcelColor.Black);

			// 中一点鎖線（黒）の罫線（右上がり斜線）
			xlsxCreator.getCell("B23").getAttr().lineRightUp(BorderStyle.MediumDashDot, ExcelColor.Black);

			// 細二点鎖線（黒）の罫線（左上がり斜線）
			xlsxCreator.getCell("D23").getAttr().lineLeftUp(BorderStyle.DashDotDot, ExcelColor.Black);

			// 中二点鎖線（黒）の罫線（右上がり斜線）
			xlsxCreator.getCell("F23").getAttr().lineRightUp(BorderStyle.MediumDashDotDot, ExcelColor.Black);

			// 中一点斜鎖線（黒）の罫線（左上がり斜線）
			xlsxCreator.getCell("B25").getAttr().lineLeftUp(BorderStyle.SlantDashDot, ExcelColor.Black);

			// 実線（赤）の罫線（左上がり斜線）
			xlsxCreator.getCell("B27").getAttr().lineLeftUp(BorderStyle.Thin, ExcelColor.Red);

			// 太線（緑）の罫線（右上がり斜線）
			xlsxCreator.getCell("D27").getAttr().lineRightUp(BorderStyle.Medium, ExcelColor.Green);

			// 破線（青）の罫線（左上がり斜線）
			xlsxCreator.getCell("F27").getAttr().lineLeftUp(BorderStyle.Dashed, ExcelColor.Blue);

			// 点線（パープル）の罫線（右上がり斜線）
			xlsxCreator.getCell("B29").getAttr().lineRightUp(BorderStyle.Dotted, Color.MAGENTA);

			// 極太線（グレー）の罫線（左上がり斜線）
			xlsxCreator.getCell("D29").getAttr().lineLeftUp(BorderStyle.Thick, Color.GRAY);

			// 二重線（オレンジ）の罫線（右上がり斜線）
			xlsxCreator.getCell("F29").getAttr().lineRightUp(BorderStyle.Double, Color.ORANGE);

			// 実線（黒）の罫線（Box）
			xlsxCreator.getCell("B31").setStr("箱線（実線）");
			xlsxCreator.getCell("B31").getAttr().box(BoxType.Box, BorderStyle.Thin, ExcelColor.Black);

			// 太線（黒）の罫線（上横線）
			xlsxCreator.getCell("D31").setStr("上横線（太線）");
			xlsxCreator.getCell("D31").getAttr().box(BoxType.Over, BorderStyle.Medium, ExcelColor.Black);

			// 破線（黒）の罫線（下横線）
			xlsxCreator.getCell("F31").setStr("下横線（破線）");
			xlsxCreator.getCell("F31").getAttr().box(BoxType.Under, BorderStyle.Dashed, ExcelColor.Black);

			// 点線（黒）の罫線（左縦線）
			xlsxCreator.getCell("B33").setStr("左縦線（点線）");
			xlsxCreator.getCell("B33").getAttr().box(BoxType.Left, BorderStyle.Dotted, ExcelColor.Black);

			// 極太線（黒）の罫線（右縦線）
			xlsxCreator.getCell("D33").setStr("右縦線（極太線）");
			xlsxCreator.getCell("D33").getAttr().box(BoxType.Right, BorderStyle.Thick, ExcelColor.Black);

			// 二重線（赤）の罫線（格子線）
			xlsxCreator.getCell("B35").setStr("格子線（赤二重線）");
			xlsxCreator.getCell("B35:F37").getAttr().box(BoxType.Ltc, BorderStyle.Double, ExcelColor.Red);
		}
		// 塗りつぶし - 背景色
		if (jCheckBoxBackColor.isSelected() == true) {
			// 「塗りつぶし - 背景色」用のシートを作成
			AddSheet("塗りつぶし（背景色）");
			xlsxCreator.setZoom(85);
			xlsxCreator.getCell("A1").getAttr().setFontPoint(14);
			xlsxCreator.getCell("A1").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("A1").setStr("背景色の設定");
			xlsxCreator.getCell("A3").setStr("背景色");

			// 背景色（ExcelColor 列挙体）を設定します（jp.co.adv.excelcreator.enums.ExcelColor）
			xlsxCreator.getCell("B3").getAttr().setBackColor(ExcelColor.Black);		// 黒
			xlsxCreator.getCell("D3").getAttr().setBackColor(ExcelColor.White);		// 白
			xlsxCreator.getCell("F3").getAttr().setBackColor(ExcelColor.Red);		// 赤
			xlsxCreator.getCell("H3").getAttr().setBackColor(ExcelColor.Green);		// 緑
			xlsxCreator.getCell("J3").getAttr().setBackColor(ExcelColor.Blue);		// 青
			xlsxCreator.getCell("L3").getAttr().setBackColor(ExcelColor.Yellow);	// 黄
			xlsxCreator.getCell("N3").getAttr().setBackColor(ExcelColor.Pink);		// ピンク
			xlsxCreator.getCell("B5").getAttr().setBackColor(ExcelColor.Cyan);		// 水
			xlsxCreator.getCell("D5").getAttr().setBackColor(ExcelColor.DarkRed);	// 濃い赤
			xlsxCreator.getCell("F5").getAttr().setBackColor(ExcelColor.DarkGreen);	// 濃い緑
			xlsxCreator.getCell("H5").getAttr().setBackColor(ExcelColor.DrakBlue);	// 濃い青
			xlsxCreator.getCell("J5").getAttr().setBackColor(ExcelColor.DrakYellow);	// 濃い黄
			xlsxCreator.getCell("L5").getAttr().setBackColor(ExcelColor.Purple);	// 紫
			xlsxCreator.getCell("N5").getAttr().setBackColor(ExcelColor.BlueGreen);	// 青緑

			// 背景色（Color 構造体）を設定します（java.awt.Color）
			xlsxCreator.getCell("B7").getAttr().setBackColor(Color.BLACK);		// 黒
			xlsxCreator.getCell("D7").getAttr().setBackColor(Color.BLUE);		// 青
			xlsxCreator.getCell("F7").getAttr().setBackColor(Color.CYAN);		// シアン
			xlsxCreator.getCell("H7").getAttr().setBackColor(Color.DARK_GRAY);		// ダークグレイ
			xlsxCreator.getCell("J7").getAttr().setBackColor(Color.GRAY);		// グレイ
			xlsxCreator.getCell("L7").getAttr().setBackColor(Color.GREEN);		// 緑
			xlsxCreator.getCell("N7").getAttr().setBackColor(Color.LIGHT_GRAY);		// ライトグレイ
			xlsxCreator.getCell("B9").getAttr().setBackColor(Color.MAGENTA);		// マゼンタ
			xlsxCreator.getCell("D9").getAttr().setBackColor(Color.ORANGE);		// オレンジ
			xlsxCreator.getCell("F9").getAttr().setBackColor(Color.PINK);		// ピンク
			xlsxCreator.getCell("H9").getAttr().setBackColor(Color.RED);		// 赤
			xlsxCreator.getCell("J9").getAttr().setBackColor(Color.WHITE);		// 白
			xlsxCreator.getCell("L9").getAttr().setBackColor(Color.YELLOW);		// 黄
		}
		// 塗りつぶし - パターン
		if (jCheckBoxPattern.isSelected() == true) {
			// 「塗りつぶし - パターン」用のシートを作成
			AddSheet("塗りつぶし（パターン）");
			xlsxCreator.setZoom(85);
			xlsxCreator.getCell("A1").getAttr().setFontPoint(14);
			xlsxCreator.getCell("A1").getAttr().setFontStyle(FontStyle.Bold);
			xlsxCreator.getCell("A1").setStr("パターンの設定");
			xlsxCreator.getCell("A").setColWidth(18);
			xlsxCreator.getCell("A3").setStr("パターン");
			xlsxCreator.getCell("A9").setStr("パターン（色）");
			xlsxCreator.getCell("A11").setStr("パターン＋背景色");

			// パターン
			xlsxCreator.getCell("B3").getAttr().setPattern(Pattern.Solid);		// 塗りつぶし
			xlsxCreator.getCell("D3").getAttr().setPattern(Pattern.MediumGray);		// 50％灰色
			xlsxCreator.getCell("F3").getAttr().setPattern(Pattern.DarkGray);		// 75％灰色
			xlsxCreator.getCell("H3").getAttr().setPattern(Pattern.LightGray);		// 25％灰色
			xlsxCreator.getCell("J3").getAttr().setPattern(Pattern.DarkHorizontal);	// 横 縞
			xlsxCreator.getCell("L3").getAttr().setPattern(Pattern.DarkVertical);	// 縦 縞
			xlsxCreator.getCell("B5").getAttr().setPattern(Pattern.DarkDown);		// 右下がり斜線 縞
			xlsxCreator.getCell("D5").getAttr().setPattern(Pattern.DarkUp);		// 左下がり斜線 縞
			xlsxCreator.getCell("F5").getAttr().setPattern(Pattern.DarkGrid);		// 左下がり斜線 格子
			xlsxCreator.getCell("H5").getAttr().setPattern(Pattern.DarkTrellis);	// 極太線 左下がり斜線 格子
			xlsxCreator.getCell("J5").getAttr().setPattern(Pattern.LightHorizontal);	// 実線 横 縞
			xlsxCreator.getCell("L5").getAttr().setPattern(Pattern.LightVertical);	// 実線 縦 縞
			xlsxCreator.getCell("B7").getAttr().setPattern(Pattern.LightDown);		// 実線 右下がり斜線 縞
			xlsxCreator.getCell("D7").getAttr().setPattern(Pattern.LightUp);		// 実線 左下がり斜線 縞
			xlsxCreator.getCell("F7").getAttr().setPattern(Pattern.LightGrid);		// 実線 横 格子
			xlsxCreator.getCell("H7").getAttr().setPattern(Pattern.LightTrellis);	// 実線 左下がり斜線 格子
			xlsxCreator.getCell("J7").getAttr().setPattern(Pattern.Gray125);		// 12.5％灰色
			xlsxCreator.getCell("L7").getAttr().setPattern(Pattern.Gray0625);		// 6.25％灰色

			// 実線 右下がり斜線 縞（赤）
			xlsxCreator.getCell("B9").getAttr().setPattern(Pattern.LightDown);
			xlsxCreator.getCell("B9").getAttr().setForeColor(ExcelColor.Red);

			// 50％灰色（緑）
			xlsxCreator.getCell("D9").getAttr().setPattern(Pattern.MediumGray);
			xlsxCreator.getCell("D9").getAttr().setForeColor(ExcelColor.Green);

			// 75％灰色（青）
			xlsxCreator.getCell("F9").getAttr().setPattern(Pattern.DarkGray);
			xlsxCreator.getCell("F9").getAttr().setForeColor(ExcelColor.Blue);

			// 25％灰色（赤）
			xlsxCreator.getCell("H9").getAttr().setPattern(Pattern.LightGray);
			xlsxCreator.getCell("H9").getAttr().setForeColor(Color.RED);

			// 横 縞（緑）
			xlsxCreator.getCell("J9").getAttr().setPattern(Pattern.DarkHorizontal);
			xlsxCreator.getCell("J9").getAttr().setForeColor(Color.GREEN);

			// 縦 縞（青）
			xlsxCreator.getCell("L9").getAttr().setPattern(Pattern.DarkVertical);
			xlsxCreator.getCell("L9").getAttr().setForeColor(Color.BLUE);

			// 右下がり斜線 縞（白）＋ 背景色（黒）
			xlsxCreator.getCell("B11").getAttr().setPattern(Pattern.DarkDown);
			xlsxCreator.getCell("B11").getAttr().setForeColor(ExcelColor.White);
			xlsxCreator.getCell("B11").getAttr().setBackColor(ExcelColor.Black);

			// 左下がり斜線 縞（黒）＋ 背景色（白）
			xlsxCreator.getCell("D11").getAttr().setPattern(Pattern.DarkUp);
			xlsxCreator.getCell("D11").getAttr().setForeColor(ExcelColor.Black);
			xlsxCreator.getCell("D11").getAttr().setBackColor(ExcelColor.White);

			// 左下がり斜線 格子（赤）＋ 背景色（白）
			xlsxCreator.getCell("F11").getAttr().setPattern(Pattern.DarkGrid);
			xlsxCreator.getCell("F11").getAttr().setForeColor(ExcelColor.Red);
			xlsxCreator.getCell("F11").getAttr().setBackColor(ExcelColor.White);

			// 極太線 左下がり斜線 格子（白）＋ 背景色（黒）
			xlsxCreator.getCell("H11").getAttr().setPattern(Pattern.DarkTrellis);
			xlsxCreator.getCell("H11").getAttr().setForeColor(Color.WHITE);
			xlsxCreator.getCell("H11").getAttr().setBackColor(Color.BLACK);

			// 実線 横 縞（黒）＋ 背景色（白）
			xlsxCreator.getCell("J11").getAttr().setPattern(Pattern.LightHorizontal);
			xlsxCreator.getCell("J11").getAttr().setForeColor(Color.BLACK);
			xlsxCreator.getCell("J11").getAttr().setBackColor(Color.WHITE);

			// 実線 縦 縞（赤）＋ 背景色（白）
			xlsxCreator.getCell("L11").getAttr().setPattern(Pattern.LightVertical);
			xlsxCreator.getCell("L11").getAttr().setForeColor(Color.RED);
			xlsxCreator.getCell("L11").getAttr().setBackColor(Color.WHITE);
		}

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// Excel シートを新規に追加します。シート名が Sheet1 の場合、追加しません。
	private void AddSheet(String sheetName) {
		if (xlsxCreator.getSheetName().equals("Sheet1") != true) {
			xlsxCreator.addSheet(1);
		}
		xlsxCreator.setSheetNo(xlsxCreator.getSheetCount() - 1);
		xlsxCreator.setSheetName(sheetName);
	}
}
