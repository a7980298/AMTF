package donotedit;

import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainJPanel() {

		final JScrollPane jScrollPane1 = new JScrollPane();
		final JTextArea jTextArea1 = new JTextArea();

		setPreferredSize(new java.awt.Dimension(750, 770));

		String description = null;
		if (SampleWork.isSampleError() == false) {
			description = "このサンプルでは「ExcelCreator for Java」の基本動作をご確認いただけます。\r\n\r\n【ファイル作成】\r\n　　ExcelCreator for Java によるファイル生成方法を説明します。\r\n\r\n【値の設定（基本操作）】\r\n　　セルへの値の設定方法について説明します。\r\n\r\n【Excel 操作・編集】\r\n　　Excel の様々な修飾機能をコード上から設定、編集を行う方法を説明します。\r\n\r\n\r\n\r\n";
			description += "===このサンプルプログラムでは下記ディレクトリへのアクセスを行います。===\r\n";
			description += "　◇入力ファイル \r\n　　" + SampleWork.getInDirectory() + "\r\n";
			description += "　◇ファイル生成先 \r\n　　" + SampleWork.getOutDirectory();
		}
		else {
			description = "※※エラー※※\r\n";
			description += SampleWork.getSampleErrorMessage();
		}

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setRows(5);
		jTextArea1.setText(description);
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setMinimumSize(new java.awt.Dimension(683, 572));
		jTextArea1.setPreferredSize(new java.awt.Dimension(683, 572));
		jTextArea1.setMargin(new Insets(10,  10,  10,  10));
		jScrollPane1.setViewportView(jTextArea1);

		final GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
				);
	}

}
