package panel;

import java.awt.Color;

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
import jp.co.adv.excelcreator.enums.ExcelVersion;

public class AttributeRowColJPanel extends JPanel {

	private String fileName;
	private String outFileName;

	public AttributeRowColJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonTemplateOpen1 = new JButton();
		JButton jButtonEditRow = new JButton();
		JLabel jLabel6 = new JLabel();
		JPanel jPanel2 = new JPanel();
		JButton jButtonTemplateOpen2 = new JButton();
		JButton jButtonEditCol = new JButton();
		JLabel jLabel7 = new JLabel();
		JPanel jPanel3 = new JPanel();
		JButton jButtonEditRowCol = new JButton();
		JLabel jLabel8 = new JLabel();

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13));
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("Excel 操作・編集 - 行列操作");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(2);
		jTextArea1.setText("ExcelCreator の機能で行列の各操作を行います。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "行の操作", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonTemplateOpen1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonTemplateOpen1.setText("テンプレートを確認");
		jButtonTemplateOpen1.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTemplateOpen1ActionPerformed(evt);
			}
		});

		jButtonEditRow.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonEditRow.setText("Excel ファイル作成");
		jButtonEditRow.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonEditRow.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditRowActionPerformed(evt);
			}
		});

		jLabel6.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel6.setText("行の挿入、クリア、削除、コピー/貼り付け、コピー/挿入を行います。");

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel6)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jButtonTemplateOpen1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(jButtonEditRow, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
						.addGap(0, 0, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel6)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonTemplateOpen1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonEditRow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(21, Short.MAX_VALUE))
				);

		jPanel2.setBorder(BorderFactory.createTitledBorder(null, "列の操作", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel2.setOpaque(false);
		jPanel2.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonTemplateOpen2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonTemplateOpen2.setText("テンプレートを確認");
		jButtonTemplateOpen2.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTemplateOpen2ActionPerformed(evt);
			}
		});

		jButtonEditCol.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonEditCol.setText("Excel ファイル作成");
		jButtonEditCol.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonEditCol.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditColActionPerformed(evt);
			}
		});

		jLabel7.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel7.setText("列の挿入、クリア、削除、コピー/貼り付け、コピー/挿入を行います。");

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel7)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(jButtonTemplateOpen2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(jButtonEditCol, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
						.addGap(0, 402, Short.MAX_VALUE))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel7)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonTemplateOpen2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonEditCol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(21, Short.MAX_VALUE))
				);

		jPanel3.setBorder(BorderFactory.createTitledBorder(null, "行の高さ、列幅の操作", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel3.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel3.setOpaque(false);
		jPanel3.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonEditRowCol.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonEditRowCol.setText("Excel ファイル作成");
		jButtonEditRowCol.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonEditRowCol.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditRowColActionPerformed(evt);
			}
		});

		jLabel8.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel8.setText("行の高さ、列幅の編集を行います。");

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jButtonEditRowCol, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8))
						.addGap(0, 0, Short.MAX_VALUE))
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel8)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButtonEditRowCol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(21, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 400, Short.MAX_VALUE))
				);
	}

	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpen1ActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templaterow.xlsx");
	}
	private void jButtonTemplateOpen2ActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templatecolumn.xlsx");
	}

	// 行の操作
	private void jButtonEditRowActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templaterow.xlsx";		// テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "editrow.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// 列の操作
	private void jButtonEditColActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templatecolumn.xlsx";	// テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "editcol.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// 行の高さ・列幅の操作
	private void jButtonEditRowColActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "roweheightcolwidth.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}
}
