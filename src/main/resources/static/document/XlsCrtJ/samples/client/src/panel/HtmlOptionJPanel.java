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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import donotedit.SampleWork;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.html.enums.DocType;

public class HtmlOptionJPanel extends JPanel {

	private String fileName;
	private String outFileName;
	private String outHtmlFileName;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxType;
	private JTextField jTextFieldTitle;
	private JTextArea jTextAreaHeader;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HtmlOptionJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonTemplateOpen = new JButton();
		JButton jButtonHtmlOption = new JButton();

		setBackground(new java.awt.Color(248, 248, 255));

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13)); // NOI18N
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("ファイル作成 - HTML オプション");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jTextArea1.setRows(2);
		jTextArea1.setText("出力 HTML ファイルの各種設定を行います。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "HTML オプション", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
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

		jButtonHtmlOption.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jButtonHtmlOption.setText("HTML ファイル作成");
		jButtonHtmlOption.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonHtmlOption.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonHtmlOptionActionPerformed(evt);
			}
		});

		JLabel jLabel1 = new JLabel("DocType");
		jLabel1.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jComboBoxType = new JComboBox();
		jComboBoxType.setModel(new DefaultComboBoxModel(DocType.values()));
		jComboBoxType.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel("HTML タイトル");
		lblNewLabel_1.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jTextFieldTitle = new JTextField();
		jTextFieldTitle.setText("ExcelCreator for Java");
		jTextFieldTitle.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jTextFieldTitle.setColumns(10);

		JLabel jLabel2 = new JLabel("HTML ヘッダ");
		jLabel2.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jTextAreaHeader = new JTextArea();
		jTextAreaHeader.setRows(10);
		jTextAreaHeader.setColumns(100);
		jTextAreaHeader.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		jTextAreaHeader.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jTextAreaHeader.setText("<meta name=\"author\" content=\"アドバンスソフトウェア株式会社\">\r\n<meta name=\"copyright\" content=\"アドバンスソフトウェア株式会社\">");

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel1)
								.addComponent(jLabel2))
							.addGap(27)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(jPanel1Layout.createSequentialGroup()
									.addComponent(jComboBoxType, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(51)
									.addComponent(lblNewLabel_1)
									.addGap(12)
									.addComponent(jTextFieldTitle, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
								.addComponent(jTextAreaHeader, 0, 514, Short.MAX_VALUE)))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(jButtonHtmlOption, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
					.addGap(117))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(jComboBoxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(jTextFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(jTextAreaHeader, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jButtonHtmlOption, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButtonTemplateOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(70))
		);
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
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(428, Short.MAX_VALUE))
		);
		this.setLayout(layout);

		jPanel1.getAccessibleContext().setAccessibleName("HTML オプション");
	}


	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpenActionPerformed(java.awt.event.ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templateoverlay.xlsx");
	}
	// HTML オプション
	private void jButtonHtmlOptionActionPerformed(java.awt.event.ActionEvent evt) {
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

		// HTML オプション
		xlsxCreator.getHtml().setDocType((DocType) jComboBoxType.getSelectedItem());
		xlsxCreator.getHtml().setTitle(jTextFieldTitle.getText());
		xlsxCreator.getHtml().addHeader(jTextAreaHeader.getText());

		//【3】===========================================================//
		// Excel ファイルクローズ、HTML 出力
		//================================================================//
		xlsxCreator.setFullCalcOnLoad(true);
		xlsxCreator.closeBook(true, "", outHtmlFileName, false);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outHtmlFileName);
	}
}
