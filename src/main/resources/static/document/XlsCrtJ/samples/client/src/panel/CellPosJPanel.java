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

public class CellPosJPanel extends JPanel {

	private String fileName;
	private String outFileName;

	public CellPosJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonTemplateOpen = new JButton();
		JButton jButtonCellPos = new JButton();

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13));
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("値の設定（基本操作）- セルの指定方法");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setRows(2);
		jTextArea1.setText("値を差し込むセルの指定は、\"A1 参照形式\"、\"座標形式\"、\"セルの名前\"、\"変数名\" の 4 つの指定方法を使用することができます。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "セルの指定方法", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonTemplateOpen.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonTemplateOpen.setText("テンプレートを確認");
		jButtonTemplateOpen.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTemplateOpenActionPerformed(evt);
			}
		});

		jButtonCellPos.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonCellPos.setText("Excel ファイル作成");
		jButtonCellPos.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonCellPos.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCellPosActionPerformed(evt);
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
						.addComponent(jButtonCellPos, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 450, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonCellPos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE))
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
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 628, Short.MAX_VALUE))
				);
	}

	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpenActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templatecellpos.xlsx");
	}

	// セルの指定方法
	private void jButtonCellPosActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templatecellpos.xlsx";	    // テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "cellpos.xlsx";  // 生成 Excel ファイル

		//【1】===========================================================//
		// オーバーレイオープン
		//================================================================//
		xlsxCreator.openBook(outFileName, fileName);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		// A1 参照形式
		// セル位置を "A1" のように直接文字列で指定できます。
		xlsxCreator.getCell("A1").setValue("A1参照形式");

		// 座標形式
		// セル位置を(0, 0)のように座標形式で指定できます。
		xlsxCreator.getPos(0, 1).setValue("座標形式");

		// 変数名
		// セルに設定した特定のキーワード文字列 (デフォルトで"**") から始まる
		// 文字列(例:“**金額”)で指定できます。テンプレートで変数名の位置を
		// 変更すれば、プログラムを変更せずにデータの設定位置を変えることがで
		// き、さらに複数のセルに同じデータを設定したい場合などに便利な機能です。
		xlsxCreator.getCell("**Name").setValue("変数名");

		// セルの名前
		// Excel の名前ボックスに入力したセルの名前で指定できます。テンプレー
		// トで名前の位置を変更すれば、プログラムを変更せずにデータの設定位置
		// を変えることができます。
		xlsxCreator.getCell("セル名").setValue("セル名");

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outFileName);
	}
}
