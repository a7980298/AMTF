package panel;

import java.awt.Color;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

import donotedit.SampleWork;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.CellClearMode;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.HorizontalAlignment;

public class EditCellJPanel extends JPanel {

	private String fileName;
	private String outFileName;

	public EditCellJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonEditCell1 = new JButton();
		JLabel jLabel1 = new JLabel();
		JPanel jPanel2 = new JPanel();
		JButton jButtonEditCell2 = new JButton();
		JLabel jLabel2 = new JLabel();
		JPanel jPanel7 = new JPanel();
		JButton jButtonEditCell3 = new JButton();
		JLabel jLabel7 = new JLabel();
		JPanel jPanel9 = new JPanel();
		JButton jButtonEditCell4 = new JButton();
		JLabel jLabel9 = new JLabel();
		JButton jButtonTemplateOpen = new JButton();
		JPanel jPanel10 = new JPanel();
		JButton jButtonEditCell5 = new JButton();
		JLabel jLabel10 = new JLabel();

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13));
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("Excel 操作・編集 - セル操作");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setRows(2);
		jTextArea1.setText("ExcelCreator の機能でセルに対する操作を行います。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "セル範囲、オフセット指定", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonEditCell1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonEditCell1.setText("Excel ファイル作成");
		jButtonEditCell1.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonEditCell1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditCell1ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel1.setText("セルの範囲指定、セル位置のオフセット指定を行います。");

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jButtonEditCell1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGap(44, 44, 44))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButtonEditCell1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		jPanel2.setBorder(BorderFactory.createTitledBorder(null, "値の設定、取得", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel2.setOpaque(false);
		jPanel2.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonEditCell2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonEditCell2.setText("Excel ファイル作成");
		jButtonEditCell2.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonEditCell2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditCell2ActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel2.setText("さまざまなデータ型による値の設定、取得を行います。");

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jButtonEditCell2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGap(44, 44, 44))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel2)
						.addGap(10, 10, 10)
						.addComponent(jButtonEditCell2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		jPanel7.setBorder(BorderFactory.createTitledBorder(null, "日付の設定、取得", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel7.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel7.setMaximumSize(new java.awt.Dimension(773, 32767));
		jPanel7.setOpaque(false);
		jPanel7.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonEditCell3.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonEditCell3.setText("Excel ファイル作成");
		jButtonEditCell3.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonEditCell3.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditCell3ActionPerformed(evt);
			}
		});

		jLabel7.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel7.setText("Excel の日付は Double 型のシリアル値で管理されているため、開発言語のデータ変換関数を用いて日付の設定、取得を行います。");

		GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(
				jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jButtonEditCell3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38))
				);
		jPanel7Layout.setVerticalGroup(
				jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel7)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButtonEditCell3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE))
				);

		jPanel9.setBorder(BorderFactory.createTitledBorder(null, "セルの操作", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel9.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel9.setOpaque(false);
		jPanel9.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonEditCell4.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonEditCell4.setText("Excel ファイル作成");
		jButtonEditCell4.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonEditCell4.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditCell4ActionPerformed(evt);
			}
		});

		jLabel9.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel9.setText("セルのコピー・貼り付け、クリアを行います。");

		jButtonTemplateOpen.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonTemplateOpen.setText("テンプレートを確認");
		jButtonTemplateOpen.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTemplateOpenActionPerformed(evt);
			}
		});

		GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout.setHorizontalGroup(
				jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel9Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel9Layout.createSequentialGroup()
										.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButtonEditCell4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGap(82, 82, 82))
				);
		jPanel9Layout.setVerticalGroup(
				jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel9Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel9)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonEditCell4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);

		jPanel10.setBorder(BorderFactory.createTitledBorder(null, "改ページの挿入", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel10.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel10.setOpaque(false);
		jPanel10.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonEditCell5.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonEditCell5.setText("Excel ファイル作成");
		jButtonEditCell5.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonEditCell5.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditCell5ActionPerformed(evt);
			}
		});

		jLabel10.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel10.setText("セルや行列を指定して改ページの挿入を行います。");

		GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout.setHorizontalGroup(
				jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel10Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jButtonEditCell5, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGap(44, 44, 44))
				);
		jPanel10Layout.setVerticalGroup(
				jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel10Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel10)
						.addGap(10, 10, 10)
						.addComponent(jButtonEditCell5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1)
				.addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)))
						.addGap(0, 0, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 400, Short.MAX_VALUE))
				);
	}

	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpenActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templateeditcell.xlsx");
	}

	// セル範囲、オフセット指定
	private void jButtonEditCell1ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "editcell1.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// 値の設定、取得
	private void jButtonEditCell2ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "editcell2.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// 日付の設定、取得
	private void jButtonEditCell3ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "editcell3.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// セルの操作
	private void jButtonEditCell4ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templateeditcell.xlsx";	// テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "editcell4.xlsx";	// 生成 Excel ファイル

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
		xlsxCreator.getCell("B2:D9").copy();					// セル範囲をコピー(Pos も使用可能)
		xlsxCreator.getCell("B11").paste();						// 先頭セルを指定して貼り付け(Pos も使用可能)
		//xlsxCreator.getCell("B2:D9").copy("B11");				// Paste メソッド省略(上記と同じ)
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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// 改ページの挿入
	private void jButtonEditCell5ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "editcell5.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}
}
