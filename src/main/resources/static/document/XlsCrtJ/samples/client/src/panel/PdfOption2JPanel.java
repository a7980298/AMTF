package panel;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import donotedit.SampleWork;
import jp.co.adv.excelcreator.creator.XlsxCreator;

public class PdfOption2JPanel extends JPanel {

	private String fileName;
	private String outFileName;
	private String outPdfFileName;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxEmbedFonts;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxEUDCFiles;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PdfOption2JPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JPanel jPanel3 = new JPanel();
		JButton jButtonTemplateOpen = new JButton();
		JButton jButtonPdf = new JButton();
		jComboBoxEmbedFonts = new JComboBox();
		jComboBoxEUDCFiles = new JComboBox();

		setBackground(new java.awt.Color(248, 248, 255));

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13)); // NOI18N
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("ファイル作成 - PDF オプション 2");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jTextArea1.setRows(2);
		jTextArea1.setText("出力 PDF ファイルにフォントの埋め込みを行います。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "フォント・外字の埋め込み", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jPanel2.setBorder(BorderFactory.createTitledBorder(null, "フォントの埋め込み", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
		jPanel2.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jPanel2.setOpaque(false);
		jPanel2.setPreferredSize(new java.awt.Dimension(443, 159));

		jPanel3.setBorder(BorderFactory.createTitledBorder(null, "外字の埋め込み", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
		jPanel3.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jPanel3.setOpaque(false);
		jPanel3.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonTemplateOpen.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jButtonTemplateOpen.setText("テンプレートを確認");
		jButtonTemplateOpen.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTemplateOpenActionPerformed(evt);
			}
		});

		jButtonPdf.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jButtonPdf.setText("PDF ファイル作成");
		jButtonPdf.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonPdf.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonPdfActionPerformed(evt);
			}
		});

		JLabel jLabel2 = new JLabel("<html>外字の扱いについて、既定では OS に登録された外字が埋め込まれます。任意の外字ファイルが指定できる事で、環境に依存しない外字登録が実現します。</html>");
		jLabel2.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jComboBoxEUDCFiles.setModel(new DefaultComboBoxModel(new String[] {"埋め込まない", "フォント名を指定", "すべてのフォント"}));
		jComboBoxEUDCFiles.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		GroupLayout gl_jPanel3 = new GroupLayout(jPanel3);
		gl_jPanel3.setHorizontalGroup(
			gl_jPanel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanel3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
						.addComponent(jComboBoxEUDCFiles, 0, 315, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_jPanel3.setVerticalGroup(
			gl_jPanel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanel3.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jLabel2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jComboBoxEUDCFiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		jPanel3.setLayout(gl_jPanel3);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jButtonPdf, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonPdf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(23))
		);

		JLabel jLabel1 = new JLabel("<html>PDF ファイルにフォントを埋め込む事で、特定のフォントがない環境での PDF ファイル閲覧に対応します。</html>");
		jLabel1.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jComboBoxEmbedFonts.setModel(new DefaultComboBoxModel(new String[] {"埋め込まない", "特定のフォントを指定", "すべてのフォント"}));
		jComboBoxEmbedFonts.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
		gl_jPanel2.setHorizontalGroup(
			gl_jPanel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(jComboBoxEmbedFonts, 0, 313, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_jPanel2.setVerticalGroup(
			gl_jPanel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel2.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel1)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(jComboBoxEmbedFonts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		jPanel2.setLayout(gl_jPanel2);
		jPanel1.setLayout(jPanel1Layout);

		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(422, Short.MAX_VALUE))
		);
		this.setLayout(layout);

		jPanel1.getAccessibleContext().setAccessibleName("PDF オプション 2");
	}


	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpenActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templateoverlay.xlsx");
	}
	// フォント・外字の埋め込み
	private void jButtonPdfActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templatepdf.xlsx"; // テンプレート Excel ファイル
		outFileName = SampleWork.getOutDirectory() + "overlay.xlsx"; // 生成 Excel ファイル
		outPdfFileName = SampleWork.getOutDirectory() + "overlay.pdf"; // 生成 PDF ファイル

		//【1】===========================================================//
		// オーバーレイオープン
		//================================================================//
		xlsxCreator.openBook(outFileName, fileName);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		// サンプル説明用の処理
		switch (jComboBoxEUDCFiles.getSelectedIndex()) {
		case 0:
			xlsxCreator.getCell("E8:E10").setValue("設定なし(OSの外字)");
			break;
		case 1:
			xlsxCreator.getCell("E8").setValue("gaiji1.tte");
			xlsxCreator.getCell("E9").setValue("設定なし(OSの外字)");
			xlsxCreator.getCell("E10").setValue("gaiji2.tte");
			break;
		case 2:
			xlsxCreator.getCell("E8:E10").setValue("gaiji1.tte");
			break;
		}

		//================================================================//
		// PDF ファイル出力の詳細機能は、closeBook 前に設定します。
		// Pdf.EmbedFonts でフォントの埋め込みに対応します。
		// 文字列型の配列に埋め込みたいフォント名の列挙を指定する方法と、
		// "*"で使用されたすべてのフォントを埋め込む方法があります。
		//================================================================//
		switch (jComboBoxEmbedFonts.getSelectedIndex()) {
		// 埋め込まない(デフォルト)
		case 0:
			xlsxCreator.getPdf().setEmbedFonts(null);
			break;
		// 埋め込むフォント名を指定(ＭＳ Ｐゴシックと メイリオ)
		case 1:
			xlsxCreator.getPdf().setEmbedFonts(new String[] { "ＭＳ Ｐゴシック", "メイリオ" });
			break;
		// 使用されたすべてのフォントを埋め込む
		case 2:
			xlsxCreator.getPdf().setEmbedFonts(new String[] { "*" });
			break;
		}

		//================================================================//
		// Pdf.EUDCFiles で PDF ファイルで使用する外字ファイルの埋込みを行い
		// ます。
		// 指定方法は、第 1 要素に[対象のフォント名]、第 2 要素に[外字ファイ
		// ルパス]の string 配列をリストで格納したものを使用します。
		// 外字の指定がないフォントでは、システムの外字設定が使用されます。
		// また、すべてのフォントに同一の外字を使用する場合、フォント名を
		// "SystemDefaultEUDCFont"に設定します。
		//================================================================//
		String gaiji1 = SampleWork.getInDirectory() + "gaiji1.tte";
		String gaiji2 = SampleWork.getInDirectory() + "gaiji2.tte";
		switch (jComboBoxEUDCFiles.getSelectedIndex()) {
		// 埋め込まない(デフォルト)
		case 0:
			xlsxCreator.getPdf().setEudcFiles(null);
			break;
		// 埋め込むフォント名を指定(ＭＳ Ｐゴシックで gaiji1.tte 、メイリオで gaiji2.tte)
		case 1:
			xlsxCreator.getPdf().setEudcFiles(new String[][] {
				new String[] { "ＭＳ Ｐゴシック", gaiji1 },
				new String[] { "メイリオ", gaiji2 } });
			break;
		// 使用されたすべてのフォントの外字でgaiji1を使用。
		case 2:
			// "SystemDefaultEUDCFont" の外字と個別のフォントの外字を設定した場合、個別のフォントの設定が優先されます。
			xlsxCreator.getPdf().setEudcFiles(new String[][] { new String[] { "SystemDefaultEUDCFont", gaiji1 } });
			break;
		}

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true, outPdfFileName, false);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outPdfFileName);
	}
}
