package panel;

import java.awt.Color;

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
import jp.co.adv.excelcreator.enums.ExcelVersion;

public class CalculateJPanel extends JPanel {

	private String fileName;
	private String outFileName;
	private JCheckBox jCheckBoxFullCalcOnLoad;

	public CalculateJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JLabel jLabel6 = new JLabel();
		jCheckBoxFullCalcOnLoad = new JCheckBox();
		JButton jButtonCaluclate1 = new JButton();
		JPanel jPanel3 = new JPanel();
		JLabel jLabel8 = new JLabel();
		JButton jButtonTemplateOpen = new JButton();
		JButton jButtonCalculate2 = new JButton();

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13));
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("Excel 操作・編集 - Excel 計算式");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(2);
		jTextArea1.setText("ExcelCreator の機能で Excel 計算式関連の設定を行います。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "計算式の設定", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jLabel6.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel6.setText("<html>setFunc メソッドで新規に計算式を設定します。<br>サンプルの処理では計算結果(100)を指定しているため、生成 Excel ファイルを環境の Excel で開いた際には指定した値が結果として表示されます。setFunc メソッドでは任意の計算結果を指定することが可能ですが、Excel 側の機能で計算式の再計算を行う場合、<br>setFullCalcOnLoad メソッドを使用して再計算実行フラグを設定します。");

		jCheckBoxFullCalcOnLoad.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jCheckBoxFullCalcOnLoad.setText("setFullCalcOnLoad");
		jCheckBoxFullCalcOnLoad.setBackground(new java.awt.Color(248, 248, 255));

		jButtonCaluclate1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonCaluclate1.setText("Excel ファイル作成");
		jButtonCaluclate1.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonCaluclate1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCaluclate1ActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jButtonCaluclate1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))))
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jCheckBoxFullCalcOnLoad)
						.addGap(0, 0, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jCheckBoxFullCalcOnLoad)
						.addGap(16, 16, 16)
						.addComponent(jButtonCaluclate1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE))
				);

		jPanel3.setBorder(BorderFactory.createTitledBorder(null, "計算式セルのコピー・移動", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel3.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel3.setOpaque(false);
		jPanel3.setPreferredSize(new java.awt.Dimension(443, 159));

		jLabel8.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel8.setText("計算式が設定されたセルのコピー・移動を行った場合、参照セルの座標は自動調整が行われます。");

		jButtonTemplateOpen.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonTemplateOpen.setText("テンプレートを確認");
		jButtonTemplateOpen.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTemplateOpenActionPerformed(evt);
			}
		});

		jButtonCalculate2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonCalculate2.setText("Excel ファイル作成");
		jButtonCalculate2.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonCalculate2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCalculate2ActionPerformed(evt);
			}
		});

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(jButtonCalculate2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel8))
						.addGap(0, 0, Short.MAX_VALUE))
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel8)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonCalculate2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(25, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 409, Short.MAX_VALUE))
				);
	}

	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpenActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templatecalculate.xlsx");
	}

	// 計算式の設定
	private void jButtonCaluclate1ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "calculate1.xlsx";	// 生成 Excel ファイル

		//【1】===========================================================//
		// Excel ファイル新規作成
		//================================================================//
		xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2016);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		// サンプル用データの設定
		for (int i = 1; i <= 10; i++) {
			xlsxCreator.getCell("A1", 0, i - 1).setValue(i);
		}
		// 第 1 引数に計算式文字列、第 2 引数に計算結果を指定(省略可)
		xlsxCreator.getCell("A10").getAttr().lineBottom(BorderStyle.Double, Color.BLACK);
		xlsxCreator.getCell("A11").setFunc("=SUM(A1:A10)", 100);
		// Excel ファイルオープン時の再計算実行有無
		if (jCheckBoxFullCalcOnLoad.isSelected() == true) {
			xlsxCreator.getCell("B11").setValue("← Excel 側の機能で再計算された結果");
			xlsxCreator.setFullCalcOnLoad(true);
		} else {
			xlsxCreator.getCell("B11").setValue("← setFunc メソッドで指定した計算結果");
		}
		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// 計算式セルのコピー・移動
	private void jButtonCalculate2ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templatecalculate.xlsx";    // テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "calculate2.xlsx";    // 生成 Excel ファイル

		//【1】===========================================================//
		// オーバーレイオープン
		//================================================================//
		xlsxCreator.openBook(outFileName, fileName);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		// サンプル用データの設定
		xlsxCreator.getCell("6").setRowHeight(0);
		xlsxCreator.getCell("C8").setValue("↑計算式のセル範囲が挿入した行数分拡張されます。\n　C5:C6→C5:C15");
		xlsxCreator.getCell("E8").setValue("↑テンプレートに設定された計算式もセルの移動に対応します。\n　C7:D7→C16:D16");
		xlsxCreator.getCell("F8").setValue("↑Func メソッドで設定した計算式もセル範囲の移動・拡張に対応します。\n　C7:D7→C16:D16");

		// 計算式の設定
		xlsxCreator.getCell("**func").setFunc("SUM(C5:D5)", null);		// 一覧(行コピーでセル範囲が調整)
		xlsxCreator.getCell("**funcsum").setFunc("SUM(C7:D7)", null);	// 合計(セル位置の移動でセル範囲が調整)

		// 一行目の明細を 9 行分挿入(※列コピー、セルコピー、削除処理にも対応)
		for (int index = 0; index < 9; index++) {
			xlsxCreator.rowCopy(4);
			xlsxCreator.rowInsertCopied(5 + index);
		}
		xlsxCreator.getCell("G6").setValue("←コピー先で計算式が再調整(C5:D5→C6:D6)");
		xlsxCreator.getCell("G6").getAttr().setFontColor(new Color(92, 84, 36));

		xlsxCreator.setFullCalcOnLoad(true);

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}
}
