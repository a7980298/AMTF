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

public class HensuuJPanel extends JPanel {

	private String fileName;
	private String outFileName;
	private JTextField jTextFieldKeyword;

	public HensuuJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonTemplateOpen1 = new JButton();
		JButton jButtonHensuu = new JButton();
		JPanel jPanel3 = new JPanel();
		JButton jButtonTemplateOpen2 = new JButton();
		JLabel jLabel1 = new JLabel();
		jTextFieldKeyword = new JTextField();
		JButton jButtonKeyword = new JButton();
		JLabel jLabel2 = new JLabel();
		JLabel jLabel3 = new JLabel();
		JLabel jLabel4 = new JLabel();
		JLabel jLabel5 = new JLabel();

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13));
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("値の設定（基本操作）- 変数名の使用例");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(2);
		jTextArea1.setText("変数名を使用することでテキストボックスへの値の挿入が可能になります。\n同一の変数名が複数のセルに配置されている場合、すべてのセルに値が挿入されます。\nテンプレート Excel 側でレイアウトの変更(行列の追加、削除によるセル移動)があった場合でも、コードを編集することなく目的のセルに対して値の挿入が可能です。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "変数名を使用した値の設定", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
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

		jButtonHensuu.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonHensuu.setText("Excel ファイル作成");
		jButtonHensuu.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonHensuu.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonHensuuActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addComponent(jButtonTemplateOpen1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jButtonHensuu, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 450, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonTemplateOpen1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonHensuu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE))
				);

		jPanel3.setBorder(BorderFactory.createTitledBorder(null, "変数名キーワード文字列の変更", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel3.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel3.setOpaque(false);
		jPanel3.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonTemplateOpen2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonTemplateOpen2.setText("テンプレートを確認");
		jButtonTemplateOpen2.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTemplateOpen2ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel1.setText("変数名のキーワード文字列を変更することが可能です。（既定値 \"**\" アスタリスク 2 つ）");

		jTextFieldKeyword.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextFieldKeyword.setText("--");

		jButtonKeyword.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonKeyword.setText("Excel ファイル作成");
		jButtonKeyword.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonKeyword.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonKeywordActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel2.setText("・ 最大 64 文字");

		jLabel3.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel3.setText("・ Excel で文字として認識可能で、かつ、 半角文字のみ指定可能");

		jLabel4.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel4.setText("・ 「\\」、「'」、「\"」、「,」、「^」、「.」、「[」、「]」は使用不可");

		jLabel5.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel5.setText("キーワード文字列");

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(5, 5, 5)
						.addComponent(jLabel1)
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGap(30, 30, 30)
										.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3)
												.addComponent(jLabel2)
												.addComponent(jLabel4)))
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGap(6, 6, 6)
										.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(jPanel3Layout.createSequentialGroup()
														.addComponent(jButtonTemplateOpen2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(jButtonKeyword, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel3Layout.createSequentialGroup()
														.addComponent(jLabel5)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jTextFieldKeyword, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabel2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel3)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel4)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5)
								.addComponent(jTextFieldKeyword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonTemplateOpen2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonKeyword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE))
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
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 381, Short.MAX_VALUE))
				);
	}

	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpen1ActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templatehensuu.xlsx");
	}
	private void jButtonTemplateOpen2ActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templatehensuu2.xlsx");
	}

	// 変数名を使用した値の設定
	private void jButtonHensuuActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templatehensuu.xlsx";					// テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "varname.xlsx";	// 生成 Excel ファイル

		//【1】===========================================================//
		// オーバーレイオープン
		//================================================================//
		xlsxCreator.openBook(outFileName, fileName);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		xlsxCreator.getCell("**TextBox").setValue("テキストボックス");
		xlsxCreator.getCell("**Name").setValue("同一変数名");
		xlsxCreator.getCell("**Shouhin").setValue("ExcelCreator for Java");
		xlsxCreator.getCell("**Suuryou").setValue(10);
		xlsxCreator.getCell("**Tanka").setValue(40000);
		xlsxCreator.getCell("**Shouhin", 0, 1).setValue("VB-Report 8");
		xlsxCreator.getCell("**Suuryou", 0, 1).setValue(8);
		xlsxCreator.getCell("**Tanka", 0, 1).setValue(85000);
		xlsxCreator.getCell("**Shouhin", 0, 2).setValue("ExcelWebForm");
		xlsxCreator.getCell("**Suuryou", 0, 2).setValue(5);
		xlsxCreator.getCell("**Tanka", 0, 2).setValue(70000);
		xlsxCreator.setFullCalcOnLoad(true);

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}

	// 変数名キーワード文字列の変更
	private void jButtonKeywordActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templatehensuu2.xlsx";				// テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "keyword.xlsx";	// 生成 Excel ファイル

		//【1】===========================================================//
		// オーバーレイオープン
		//================================================================//
		xlsxCreator.setKeyword(jTextFieldKeyword.getText());	// キーワード文字列変更
		xlsxCreator.openBook(outFileName, fileName);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		xlsxCreator.getCell(jTextFieldKeyword.getText() + "Name").setValue("キーワード文字列変更サンプル");

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);
		xlsxCreator.setKeyword("**");	// キーワード文字列(デフォルト)

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}
}
