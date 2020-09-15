package panel;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import donotedit.SampleWork;
import jp.co.adv.excelcreator.creator.XlsxCreator;

public class HtmlJPanel extends JPanel {

	private String fileName;
	private String outFileName;
	private String outHtmlFileName;

	public HtmlJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonTemplateOpen = new JButton();
		JButton jButtonHtml = new JButton();

		setBackground(new java.awt.Color(248, 248, 255));

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13)); // NOI18N
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("ファイル作成 - HTML 出力");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jTextArea1.setRows(2);
		jTextArea1.setText("作成した Excel ファイルを元に HTML ファイルの出力を行います。\ncloseBook メソッドの第 3 引数に HTML ファイルの出力先パス、第 4 引数に生成した Excel ファイルを破棄するか指定します。\n第 2 引数の PDF ファイル出力先パスは省略可能です。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "HTML 出力", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonTemplateOpen.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jButtonTemplateOpen.setText("テンプレートを確認");
		jButtonTemplateOpen.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTemplateOpenActionPerformed(evt);
			}
		});

		jButtonHtml.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jButtonHtml.setText("HTML ファイル作成");
		jButtonHtml.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonHtml.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonHtmlActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jButtonHtml, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 450, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonHtml, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(582, Short.MAX_VALUE))
		);
		this.setLayout(layout);

		jPanel1.getAccessibleContext().setAccessibleName("HTML 出力");
	}


	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpenActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templateoverlay.xlsx");
	}
	// HTML 出力
	private void jButtonHtmlActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templateoverlay.xlsx";	    // テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "overlay.xlsx";  // 生成 Excel ファイル
		outHtmlFileName = SampleWork.getOutDirectory() + "overlay.htm";  // 生成 HTML ファイル

		//【1】===========================================================//
		// オーバーレイオープン
		//================================================================//
		xlsxCreator.openBook(outFileName, fileName);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		xlsxCreator.getCell("B4").setValue("ExcelCreator for Java");
		xlsxCreator.getCell("H4").setValue(10);
		xlsxCreator.getCell("K4").setValue(40000);
		xlsxCreator.getCell("O4").setFunc("=H4*K4", 400000);
		xlsxCreator.getCell("B5").setValue("VB-Report 8");
		xlsxCreator.getCell("H5").setValue(8);
		xlsxCreator.getCell("K5").setValue(85000);
		xlsxCreator.getCell("O5").setFunc("=H5*K5", 680000);
		xlsxCreator.getCell("B6").setValue("ExcelWebForm");
		xlsxCreator.getCell("H6").setValue(5);
		xlsxCreator.getCell("K6").setValue(70000);
		xlsxCreator.getCell("O6").setFunc("=H6*K6", 350000);
		xlsxCreator.getCell("O10").setFunc("=SUM(O4:R8)", 1430000);
		xlsxCreator.getCell("O11").setFunc("=O10*0.08", 114400);
		xlsxCreator.getCell("O12").setFunc("=O10+O11", 1544400);

		//【3】===========================================================//
		// Excel ファイルクローズ、HTML 出力
		//================================================================//
		xlsxCreator.setFullCalcOnLoad(true);
		xlsxCreator.closeBook(true, "", outHtmlFileName, false);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outHtmlFileName);
	}
}
