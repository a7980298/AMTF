package panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import donotedit.SampleWork;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.BorderStyle;
import jp.co.adv.excelcreator.enums.BoxType;
import jp.co.adv.excelcreator.enums.ExcelColor;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.FontStyle;
import jp.co.adv.excelcreator.enums.HorizontalAlignment;

public class CreateJPanel extends JPanel {

	private String outFileName;
	private JRadioButton jRadioButtonSample;
	private JRadioButton jRadioButtonCustom;
	private JComboBox<Object> jComboBoxExcelVersion;
	private JTextField jTextFieldSheetCount;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CreateJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		ButtonGroup buttonGroup1 = new ButtonGroup();
		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		jRadioButtonSample = new JRadioButton();
		jRadioButtonCustom = new JRadioButton();
		JLabel jLabel2 = new JLabel();
		JLabel jLabel3 = new JLabel();
		jTextFieldSheetCount = new JTextField();
		JButton jButtonCreateBook = new JButton();

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13));
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("ファイル作成 - 新規作成");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setRows(2);
		jTextArea1.setText("プログラム上で Excel ファイルを新規に作成します。\nExcelCreator for Java による Excel ファイル作成は、たった 3 段階のコーディングで実現可能です。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "新規作成", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		buttonGroup1.add(jRadioButtonSample);
		jRadioButtonSample.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jRadioButtonSample.setSelected(true);
		jRadioButtonSample.setText("サンプル（明細書デザインで xlsx 形式の Excel ファイルを作成します。）");
		jRadioButtonSample.setOpaque(false);

		buttonGroup1.add(jRadioButtonCustom);
		jRadioButtonCustom.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jRadioButtonCustom.setText("カスタム（下記の設定で Excel ファイルを作成します。）");
		jRadioButtonCustom.setOpaque(false);

		jLabel2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel2.setText("Excel バージョン");

		jLabel3.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel3.setText("Excel シート数");

		jComboBoxExcelVersion = new JComboBox<Object>();
		jComboBoxExcelVersion.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jComboBoxExcelVersion.setModel(new DefaultComboBoxModel(new String[] {"Excel 2007", "Excel 2010", "Excel 2013", "Excel 2013 Strict", "Excel 2016", "Excel 2016 Strict", "Excel 2019", "Excel 2019 Strict"}));

		jTextFieldSheetCount.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextFieldSheetCount.setHorizontalAlignment(JTextField.RIGHT);
		jTextFieldSheetCount.setText("1");

		jButtonCreateBook.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonCreateBook.setText("Excel ファイル作成");
		jButtonCreateBook.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonCreateBook.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCreateBookActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jRadioButtonCustom)
								.addComponent(jRadioButtonSample)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(21, 21, 21)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel2)
												.addComponent(jLabel3))
										.addGap(18, 18, 18)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jComboBoxExcelVersion, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextFieldSheetCount, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
						.addComponent(jButtonCreateBook, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jRadioButtonSample)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jRadioButtonCustom)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(jComboBoxExcelVersion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(jTextFieldSheetCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonCreateBook, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(27, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 536, Short.MAX_VALUE))
				);
	}

	private void jButtonCreateBookActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();

		// サンプル(明細書形式) Excel ファイル作成
		if (jRadioButtonSample.isSelected() == true) {
			outFileName = SampleWork.getOutDirectory() + "createbook(sample).xlsx";
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
		else if (jRadioButtonCustom.isSelected() == true) {

			Integer sheetCount;
			try {
				sheetCount = Integer.parseInt(jTextFieldSheetCount.getText());
			} catch (NumberFormatException ex) {
				sheetCount = 1;
			}
			//【1】===========================================================//
			// Excel ファイル新規作成
			//================================================================//
			outFileName = SampleWork.getOutDirectory() + "createbook(custom).xlsx";  // 生成 Excel ファイル(xlsx)
			ExcelVersion[] versionList = ExcelVersion.values();
			xlsxCreator.createBook(outFileName, sheetCount, versionList[jComboBoxExcelVersion.getSelectedIndex()]);

			//【2】===========================================================//
			// 値の設定
			//================================================================//
			// サンプルレイアウト用処理
			xlsxCreator.getCell("A1").setValue("■ExcelCreator for Java - 新規作成（カスタム）");
			xlsxCreator.getCell("A1").getAttr().setFontColor(new Color(54, 96, 146));
			xlsxCreator.getCell("A").setColWidth(18.0);
			xlsxCreator.getCell("A2").setValue("Excel バージョン");
			xlsxCreator.getCell("B2").setValue(jComboBoxExcelVersion.getSelectedItem().toString());
			xlsxCreator.getCell("A3").setValue("シート数");
			xlsxCreator.getCell("B3").setValue(sheetCount);

			//【3】===========================================================//
			// Excel ファイルクローズ
			//================================================================//
			xlsxCreator.closeBook(true);
		}
		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}
}
