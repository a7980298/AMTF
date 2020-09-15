package panel;

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
import jp.co.adv.excelcreator.enums.ExcelColor;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.HeaderFooterMode;
import jp.co.adv.excelcreator.enums.HeaderFooterType;
import jp.co.adv.excelcreator.enums.PageCenter;
import jp.co.adv.excelcreator.enums.PageOrder;
import jp.co.adv.excelcreator.enums.PageOrientation;
import jp.co.adv.excelcreator.enums.PaperKind;

public class AttributeSheetJPanel extends JPanel {

	private String outFileName;

	public AttributeSheetJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonSheetAttr1 = new JButton();
		JLabel jLabel1 = new JLabel();
		JPanel jPanel2 = new JPanel();
		JButton jButtonSheetAttr2 = new JButton();
		JLabel jLabel2 = new JLabel();
		JPanel jPanel4 = new JPanel();
		JButton jButtonSheetAttr6 = new JButton();
		JLabel jLabel4 = new JLabel();
		JPanel jPanel3 = new JPanel();
		JButton jButtonSheetAttr5 = new JButton();
		JLabel jLabel3 = new JLabel();
		JPanel jPanel6 = new JPanel();
		JButton jButtonSheetAttr8 = new JButton();
		JLabel jLabel6 = new JLabel();
		JPanel jPanel5 = new JPanel();
		JButton jButtonSheetAttr7 = new JButton();
		JLabel jLabel5 = new JLabel();
		JPanel jPanel7 = new JPanel();
		JButton jButtonSheetAttr3 = new JButton();
		JLabel jLabel7 = new JLabel();
		JPanel jPanel8 = new JPanel();
		JButton jButtonSheetAttr4 = new JButton();
		JLabel jLabel8 = new JLabel();

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13));
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("Excel 操作・編集 - シート操作");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setRows(2);
		jTextArea1.setText("ExcelCreator の機能でシートの設定や各操作を行います。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "操作対象シート", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonSheetAttr1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonSheetAttr1.setText("Excel ファイル作成");
		jButtonSheetAttr1.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonSheetAttr1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSheetAttr1ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel1.setText("操作対象シートを切り替えます。");

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addGap(40, 40, 40)
						.addComponent(jButtonSheetAttr1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonSheetAttr1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addContainerGap(18, Short.MAX_VALUE))
				);

		jPanel2.setBorder(BorderFactory.createTitledBorder(null, "ヘッダー/フッター", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel2.setOpaque(false);
		jPanel2.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonSheetAttr2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonSheetAttr2.setText("Excel ファイル作成");
		jButtonSheetAttr2.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonSheetAttr2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSheetAttr2ActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel2.setText("ページヘッダー/フッターを設定します。");

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addGap(6, 6, 6)
						.addComponent(jButtonSheetAttr2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(jButtonSheetAttr2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 0, Short.MAX_VALUE))
				);

		jPanel4.setBorder(BorderFactory.createTitledBorder(null, "シート削除", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel4.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel4.setOpaque(false);
		jPanel4.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonSheetAttr6.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonSheetAttr6.setText("Excel ファイル作成");
		jButtonSheetAttr6.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonSheetAttr6.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSheetAttr6ActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel4.setText("シートを削除します。");

		GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButtonSheetAttr6, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel4Layout.setVerticalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(jButtonSheetAttr6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 18, Short.MAX_VALUE))
				);

		jPanel3.setBorder(BorderFactory.createTitledBorder(null, "シート追加", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel3.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel3.setOpaque(false);
		jPanel3.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonSheetAttr5.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonSheetAttr5.setText("Excel ファイル作成");
		jButtonSheetAttr5.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonSheetAttr5.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSheetAttr5ActionPerformed(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel3.setText("シートを追加します。");

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addGap(40, 40, 40)
						.addComponent(jButtonSheetAttr5, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonSheetAttr5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addContainerGap(18, Short.MAX_VALUE))
				);

		jPanel6.setBorder(BorderFactory.createTitledBorder(null, "アクティブシート", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel6.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel6.setOpaque(false);
		jPanel6.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonSheetAttr8.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonSheetAttr8.setText("Excel ファイル作成");
		jButtonSheetAttr8.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonSheetAttr8.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSheetAttr8ActionPerformed(evt);
			}
		});

		jLabel6.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel6.setText("アクティブシートを設定します。");

		GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(
				jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButtonSheetAttr8, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel6Layout.setVerticalGroup(
				jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6)
								.addComponent(jButtonSheetAttr8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 18, Short.MAX_VALUE))
				);

		jPanel5.setBorder(BorderFactory.createTitledBorder(null, "シートコピー", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel5.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel5.setOpaque(false);
		jPanel5.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonSheetAttr7.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonSheetAttr7.setText("Excel ファイル作成");
		jButtonSheetAttr7.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonSheetAttr7.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSheetAttr7ActionPerformed(evt);
			}
		});

		jLabel5.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel5.setText("シートをコピーします。");

		GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addGap(40, 40, 40)
						.addComponent(jButtonSheetAttr7, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel5Layout.setVerticalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonSheetAttr7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5))
						.addContainerGap(18, Short.MAX_VALUE))
				);

		jPanel7.setBorder(BorderFactory.createTitledBorder(null, "シート名、ページ設定（ページタブ）、グリッド線（枠線）", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel7.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel7.setMaximumSize(new java.awt.Dimension(773, 32767));
		jPanel7.setOpaque(false);
		jPanel7.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonSheetAttr3.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonSheetAttr3.setText("Excel ファイル作成");
		jButtonSheetAttr3.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonSheetAttr3.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSheetAttr3ActionPerformed(evt);
			}
		});

		jLabel7.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel7.setText("シート名、ページ設定（ページタブ）、グリッド線（枠線）を設定します。");

		GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(
				jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addGap(197, 197, 197)
						.addComponent(jButtonSheetAttr3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel7Layout.setVerticalGroup(
				jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
						.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonSheetAttr3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7))
						.addContainerGap(18, Short.MAX_VALUE))
				);

		jPanel8.setBorder(BorderFactory.createTitledBorder(null, "印刷タイトル、ページ方向、印刷範囲", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel8.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel8.setOpaque(false);
		jPanel8.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonSheetAttr4.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonSheetAttr4.setText("Excel ファイル作成");
		jButtonSheetAttr4.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonSheetAttr4.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSheetAttr4ActionPerformed(evt);
			}
		});

		jLabel8.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel8.setText("印刷タイトル、ページ方向、印刷範囲を設定します。");

		GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(
				jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addGap(197, 197, 197)
						.addComponent(jButtonSheetAttr4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		jPanel8Layout.setVerticalGroup(
				jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup()
						.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonSheetAttr4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8))
						.addContainerGap(18, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)))
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
								.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 348, Short.MAX_VALUE))
				);
	}

	// 操作対象シート
	private void jButtonSheetAttr1ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "sheetattr1.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// ヘッダー/フッター
	private void jButtonSheetAttr2ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "sheetattr2.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// シート名、ページ設定（ページタブ）、グリッド線（枠線）
	private void jButtonSheetAttr3ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "sheetattr3.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// 印刷タイトル、ページ方向、印刷範囲
	private void jButtonSheetAttr4ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "sheetattr4.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// シート追加
	private void jButtonSheetAttr5ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "sheetattr5.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// シート削除
	private void jButtonSheetAttr6ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "sheetattr6.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// シートコピー
	private void jButtonSheetAttr7ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "sheetattr7.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// アクティブシート
	private void jButtonSheetAttr8ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "sheetattr8.xlsx";	// 生成 Excel ファイル

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

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}
}
