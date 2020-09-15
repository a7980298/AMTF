package panel;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import donotedit.SampleWork;
import jp.co.adv.excelcreator.creator.XlsxCreator;

public class OverlayJPanel extends JPanel {

	private String fileName;
	private String outFileName;
	private JTextField jTextFieldInputValue;

	public OverlayJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonTemplateOpen = new JButton();
		JButton jButtonOverlay = new JButton();
		JPanel jPanel3 = new JPanel();
		JButton jButtonOverwrite = new JButton();
		JLabel jLabel1 = new JLabel();
		jTextFieldInputValue = new JTextField();

		setBackground(new java.awt.Color(248, 248, 255));

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13)); // NOI18N
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("ファイル作成 - オーバーレイ/上書きオープン");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jTextArea1.setRows(2);
		jTextArea1.setText("オーバーレイオープン機能は、既存の Excel ファイルを元にデータの設定を行い、別名で Excel ファイルを作成します。\nopenBook メソッドの第 1 引数に出力先のファイルパス、第 2 引数にテンプレートのファイルパスを指定します。\nopenBook メソッドの第 1 引数にテンプレートのファイルパス、第 2 引数を省略(\"\")した場合は上書きオープンになります。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "オーバーレイオープン", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
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

		jButtonOverlay.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jButtonOverlay.setText("Excel ファイル作成");
		jButtonOverlay.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonOverlay.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonOverlayActionPerformed(evt);
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
						.addComponent(jButtonOverlay, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 450, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonOverlay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE))
				);

		jPanel3.setBorder(BorderFactory.createTitledBorder(null, "上書きオープン", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
		jPanel3.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jPanel3.setOpaque(false);
		jPanel3.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonOverwrite.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jButtonOverwrite.setText("Excel ファイル作成");
		jButtonOverwrite.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonOverwrite.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonOverwriteActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jLabel1.setText("下記に入力したテキストを B3 セルに設定します。");

		jTextFieldInputValue.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jTextFieldInputValue.setText("サンプル文字列");

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1)
								.addComponent(jButtonOverwrite, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextFieldInputValue, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 0, Short.MAX_VALUE))
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTextFieldInputValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButtonOverwrite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE))
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
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 473, Short.MAX_VALUE))
				);

		jPanel1.getAccessibleContext().setAccessibleName("オーバーレイオープン");
	}


	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpenActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templateoverlay.xlsx");
	}
	// オーバーレイオープン
	private void jButtonOverlayActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templateoverlay.xlsx";	    // テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "overlay.xlsx";  // 生成 Excel ファイル

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
		xlsxCreator.getCell("O4").setFunc("=H4*K4", null);
		xlsxCreator.getCell("B5").setValue("VB-Report 8");
		xlsxCreator.getCell("H5").setValue(8);
		xlsxCreator.getCell("K5").setValue(85000);
		xlsxCreator.getCell("O5").setFunc("=H5*K5", null);
		xlsxCreator.getCell("B6").setValue("ExcelWebForm");
		xlsxCreator.getCell("H6").setValue(5);
		xlsxCreator.getCell("K6").setValue(70000);
		xlsxCreator.getCell("O6").setFunc("=H6*K6", null);
		xlsxCreator.getCell("O10").setFunc("=SUM(O4:R8)", null);
		xlsxCreator.getCell("O11").setFunc("=O10*0.08", null);
		xlsxCreator.getCell("O12").setFunc("=O10+O11", null);

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	private void jButtonOverwriteActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "overwrite.xlsx";    // 上書き対象 Excel ファイル

		//【1】===========================================================//
		// 上書きオープン
		//================================================================//
		xlsxCreator.openBook(fileName, "");

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		xlsxCreator.getCell("B3").setValue(jTextFieldInputValue.getText());

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(fileName);
	}
}
