package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import donotedit.SampleWork;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.ExcelVersion;
import jp.co.adv.excelcreator.enums.HorizontalAlignment;
import jp.co.adv.excelcreator.enums.PdfEncryptionType;
import jp.co.adv.excelcreator.enums.PdfPermit;
import jp.co.adv.excelcreator.enums.VerticalAlignment;

public class PdfOption1JPanel extends JPanel {

	private String outFileName;
	private String outPdfFileName;
	private JTextField jTextFieldOwnerPassword;
	private JTextField jTextFieldUserPassword;
	private JTextField jTextFieldTitle;
	private JTextField jTextFieldSubject;
	private JTextField jTextFieldAuthor;
	private JTextField jTextFieldApplication;
	private JTextField jTextFieldProducer;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxEncryptType;
	private JCheckBox jCheckBoxPrint;
	private JCheckBox jCheckBoxChange;
	private JCheckBox jCheckBoxCopy;
	private JCheckBox jCheckBoxComment;
	private JCheckBox jCheckBoxFormField;
	private JCheckBox jCheckBoxContentAccess;
	private JCheckBox jCheckBoxDocumentAssembly;
	private JCheckBox jCheckBoxPrintHigh;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PdfOption1JPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JPanel jPanel3 = new JPanel();
		JButton jButtonPdf = new JButton();

		setBackground(new java.awt.Color(248, 248, 255));

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13)); // NOI18N
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("ファイル作成 - PDF オプション 1");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jTextArea1.setRows(2);
		jTextArea1.setText("出力 PDF ファイルの暗号化、文書のプロパティの設定を行います。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "PDF ファイルの暗号化", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jPanel2.setBorder(BorderFactory.createTitledBorder(null, "PDF 文書のプロパティ", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
		jPanel2.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jPanel2.setOpaque(false);
		jPanel2.setPreferredSize(new java.awt.Dimension(443, 159));

		jPanel3.setBorder(BorderFactory.createTitledBorder(null, "ユーザーパスワードの権限", 0, 0, new java.awt.Font("Meiryo UI", 0, 13))); // NOI18N
		jPanel3.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jPanel3.setOpaque(false);
		jPanel3.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonPdf.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
		jButtonPdf.setText("PDF ファイル作成");
		jButtonPdf.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonPdf.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonPdfActionPerformed(evt);
			}
		});

		JLabel jLabel1 = new JLabel("<html>PDF ファイルにパスワードの設定を行ないます。<br>\r\n暗号化強度が(NoPassword)以外でも、オーナーとユーザーパスワードが未設定であればパスワードなしで生成されます。</html>");
		jLabel1.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		JLabel jLabel2 = new JLabel("暗号化強度");
		jLabel2.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		JLabel jLabel3 = new JLabel("オーナーパスワード");
		jLabel3.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		JLabel jLabel4 = new JLabel("ユーザーパスワード");
		jLabel4.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jComboBoxEncryptType = new JComboBox();
		jComboBoxEncryptType.setModel(new DefaultComboBoxModel(PdfEncryptionType.values()));
		jComboBoxEncryptType.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jTextFieldOwnerPassword = new JTextField();
		jTextFieldOwnerPassword.setText("Owner.1");
		jTextFieldOwnerPassword.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jTextFieldOwnerPassword.setColumns(10);

		jTextFieldUserPassword = new JTextField();
		jTextFieldUserPassword.setText("User.1");
		jTextFieldUserPassword.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jTextFieldUserPassword.setColumns(10);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel2)
								.addComponent(jLabel3)
								.addComponent(jLabel4))
							.addGap(28)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jTextFieldUserPassword)
								.addComponent(jTextFieldOwnerPassword)
								.addComponent(jComboBoxEncryptType, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(23, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jButtonPdf, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(586, Short.MAX_VALUE))))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGap(28)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(jComboBoxEncryptType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(jTextFieldOwnerPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(jTextFieldUserPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(jButtonPdf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		jCheckBoxPrint = new JCheckBox("Print");
		jCheckBoxPrint.setSelected(true);
		jCheckBoxPrint.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jCheckBoxPrint.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxChange = new JCheckBox("Change");
		jCheckBoxChange.setSelected(true);
		jCheckBoxChange.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jCheckBoxChange.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxCopy = new JCheckBox("Copy");
		jCheckBoxCopy.setSelected(true);
		jCheckBoxCopy.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jCheckBoxCopy.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxComment = new JCheckBox("Comment");
		jCheckBoxComment.setSelected(true);
		jCheckBoxComment.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jCheckBoxComment.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxFormField = new JCheckBox("FormField");
		jCheckBoxFormField.setSelected(true);
		jCheckBoxFormField.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jCheckBoxFormField.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxContentAccess = new JCheckBox("ContentAccess");
		jCheckBoxContentAccess.setSelected(true);
		jCheckBoxContentAccess.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jCheckBoxContentAccess.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxDocumentAssembly = new JCheckBox("DocumentAssembly");
		jCheckBoxDocumentAssembly.setSelected(true);
		jCheckBoxDocumentAssembly.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jCheckBoxDocumentAssembly.setBackground(new java.awt.Color(248, 248, 255));

		jCheckBoxPrintHigh = new JCheckBox("PrintHigh");
		jCheckBoxPrintHigh.setSelected(true);
		jCheckBoxPrintHigh.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jCheckBoxPrintHigh.setBackground(new java.awt.Color(248, 248, 255));
		GroupLayout gl_jPanel3 = new GroupLayout(jPanel3);
		gl_jPanel3.setHorizontalGroup(
			gl_jPanel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel3.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel3.createSequentialGroup()
							.addComponent(jCheckBoxPrint, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(jCheckBoxChange, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel3.createSequentialGroup()
							.addComponent(jCheckBoxCopy, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(jCheckBoxComment, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel3.createSequentialGroup()
							.addComponent(jCheckBoxFormField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(jCheckBoxContentAccess, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel3.createSequentialGroup()
							.addComponent(jCheckBoxDocumentAssembly, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(jCheckBoxPrintHigh, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))))
		);
		gl_jPanel3.setVerticalGroup(
			gl_jPanel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel3.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING)
						.addComponent(jCheckBoxPrint, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(jCheckBoxChange, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING)
						.addComponent(jCheckBoxCopy, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(jCheckBoxComment, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING)
						.addComponent(jCheckBoxFormField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(jCheckBoxContentAccess, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING)
						.addComponent(jCheckBoxDocumentAssembly, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(jCheckBoxPrintHigh, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
		);
		jPanel3.setLayout(gl_jPanel3);
		jPanel1.setLayout(jPanel1Layout);


		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(158, Short.MAX_VALUE))
		);

		JButton jButtonPdf2 = new JButton();
		jButtonPdf2.setText("PDF ファイル作成");
		jButtonPdf2.setPreferredSize(new Dimension(130, 30));
		jButtonPdf2.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jButtonPdf2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonPdf2ActionPerformed(evt);
			}
		});

		JLabel jLabel5 = new JLabel("タイトル");
		jLabel5.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jTextFieldTitle = new JTextField();
		jTextFieldTitle.setText("PDF Title");
		jTextFieldTitle.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jTextFieldTitle.setColumns(10);

		JLabel jLabel6 = new JLabel("サブタイトル");
		jLabel6.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jTextFieldSubject = new JTextField();
		jTextFieldSubject.setText("PDF SubTitle");
		jTextFieldSubject.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jTextFieldSubject.setColumns(10);

		JLabel jLabel7 = new JLabel("作成者");
		jLabel7.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jTextFieldAuthor = new JTextField();
		jTextFieldAuthor.setText("PDF Author");
		jTextFieldAuthor.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jTextFieldAuthor.setColumns(10);

		JLabel jLabel8 = new JLabel("アプリケーション");
		jLabel8.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jTextFieldApplication = new JTextField();
		jTextFieldApplication.setText("ExcelCreator For Java Sample Application");
		jTextFieldApplication.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jTextFieldApplication.setColumns(10);

		JLabel jLabel9 = new JLabel("PDF 変換");
		jLabel9.setFont(new Font("Meiryo UI", Font.PLAIN, 13));

		jTextFieldProducer = new JTextField();
		jTextFieldProducer.setText("PDF Producer");
		jTextFieldProducer.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		jTextFieldProducer.setColumns(10);
		GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
		gl_jPanel2.setHorizontalGroup(
			gl_jPanel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel2.createSequentialGroup()
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel6)
								.addComponent(jLabel5)
								.addComponent(jLabel7)
								.addComponent(jLabel8)
								.addComponent(jLabel9))
							.addGap(56)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
								.addComponent(jTextFieldProducer, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
								.addComponent(jTextFieldApplication, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
								.addComponent(jTextFieldSubject, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
								.addComponent(jTextFieldAuthor, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
								.addComponent(jTextFieldTitle, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
							.addGap(216))
						.addGroup(gl_jPanel2.createSequentialGroup()
							.addComponent(jButtonPdf2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(586, Short.MAX_VALUE))))
		);
		gl_jPanel2.setVerticalGroup(
			gl_jPanel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextFieldSubject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel6))
					.addGap(7)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextFieldAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextFieldApplication, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel8))
					.addGap(7)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextFieldProducer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel9))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(jButtonPdf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		jPanel2.setLayout(gl_jPanel2);
		this.setLayout(layout);

		jPanel1.getAccessibleContext().setAccessibleName("PDF オプション 1");
	}
	// PDF ファイルの暗号化
	private void jButtonPdfActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "PDF暗号化.xlsx";  // 生成 Excel ファイル
		outPdfFileName = SampleWork.getOutDirectory() + "PDF暗号化.pdf";  // 生成 PDF ファイル

		//【1】===========================================================//
		// Excel ファイル新規作成
		//================================================================//
		xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2013);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		xlsxCreator.getCell("A1").setValue("PDF ファイルの「文書のプロパティ」で権限をご確認ください。");
		xlsxCreator.getCell("A1").setRowHeight(20);
		xlsxCreator.getCell("A1").getAttr().setFontName("Meiryo");
		xlsxCreator.getCell("A1").getAttr().setFontColor(Color.RED);
		xlsxCreator.getCell("A1").getAttr().setFontPoint(16);
		xlsxCreator.getCell("A:B").setColWidth(28);
		xlsxCreator.getCell("6").setRowHeight(150);
		xlsxCreator.getCell("A3:A6").getAttr().setHorizontalAlignment(HorizontalAlignment.Right);
		xlsxCreator.getCell("A6:B6").getAttr().setVerticalAlignment(VerticalAlignment.Top);
		xlsxCreator.getCell("A3").setValue("暗号化強度：");
		xlsxCreator.getCell("A4").setValue("オーナーパスワード：");
		xlsxCreator.getCell("A5").setValue("ユーザーパスワード：");
		xlsxCreator.getCell("A6").setValue("ユーザーパスワードの権限：");

		// PDF の暗号化強度を設定します。
		// ※デフォルト：Acrobat6_RC4_128
		switch (jComboBoxEncryptType.getSelectedIndex()) {
		// PDFEncryptionType.NoPassword
		case 0:
			xlsxCreator.getPdf().setEncryptionType(PdfEncryptionType.NoPassword);
			xlsxCreator.getCell("B3").setValue("PdfEncryptionType.NoPassword");
			break;
		// PDFEncryptionType.Acrobat3_RC4_40
		case 1:
			xlsxCreator.getPdf().setEncryptionType(PdfEncryptionType.Acrobat3_RC4_40);
			xlsxCreator.getCell("B3").setValue("PdfEncryptionType.Acrobat3_RC4_40");
			break;
		// PDFEncryptionType.Acrobat5_RC4_128
		case 2:
			xlsxCreator.getPdf().setEncryptionType(PdfEncryptionType.Acrobat5_RC4_128);
			xlsxCreator.getCell("B3").setValue("PdfEncryptionType.Acrobat5_RC4_128");
			break;
		// PDFEncryptionType.Acrobat6_RC4_128(デフォルト)
		case 3:
			xlsxCreator.getPdf().setEncryptionType(PdfEncryptionType.Acrobat6_RC4_128);
			xlsxCreator.getCell("B3").setValue("PdfEncryptionType.Acrobat6_RC4_128");
			break;
		}

		// PDF のオーナーパスワードを設定します。
		// ユーザーパスワードは省略可能ですが、両方を設定しない場合、
		// パスワードなしのファイルが生成されます。
		xlsxCreator.getPdf().setOwnerPassword(jTextFieldOwnerPassword.getText());
		xlsxCreator.getPdf().setUserPassword(jTextFieldUserPassword.getText());
		if (jTextFieldOwnerPassword.getText().equals("") && jTextFieldUserPassword.getText().equals(""))
			xlsxCreator.getCell("B3").setValue("PdfEncryptionType.NoPassword");
		xlsxCreator.getCell("B4").setValue(jTextFieldOwnerPassword.getText());
		xlsxCreator.getCell("B5").setValue(jTextFieldUserPassword.getText());

		// ユーザーパスワードで PDF ファイルを閲覧する際の権限を設定します。
		// 必要な権限を論理和で連結して、Permitに設定します。
		String strPermit = "";
		int permit = 0;
		if (jCheckBoxPrint.isSelected() == true) {             // Print
			permit = permit | PdfPermit.Print.getValue();
			strPermit += "Print" + "\r\n";
		}
		if (jCheckBoxChange.isSelected() == true) {            // Change
			permit = permit | PdfPermit.Change.getValue();
			strPermit += "Change" + "\r\n";
		}
		if (jCheckBoxCopy.isSelected() == true) {              // Copy
			permit = permit | PdfPermit.Copy.getValue();
			strPermit += "Copy" + "\r\n";
		}
		if (jCheckBoxComment.isSelected() == true) {           // Comment
			permit = permit | PdfPermit.Comment.getValue();
			strPermit += "Comment" + "\r\n";
		}
		if (jCheckBoxFormField.isSelected() == true) {         // FormField
			permit = permit | PdfPermit.FormField.getValue();
			strPermit += "FormField" + "\r\n";
		}
		if (jCheckBoxContentAccess.isSelected() == true) {     // ContentAccess
			permit = permit | PdfPermit.ContentAccess.getValue();
			strPermit += "ContentAccess" + "\r\n";
		}
		if (jCheckBoxDocumentAssembly.isSelected() == true) {  // DocumentAssembly
			permit = permit | PdfPermit.DocumentAssembly.getValue();
			strPermit += "DocumentAssembly" + "\r\n";
		}
		if (jCheckBoxPrintHigh.isSelected() == true) {         // PrintHigh
			permit = permit | PdfPermit.PrintHigh.getValue();
			strPermit += "PrintHigh";
		}
		xlsxCreator.getPdf().setPermit(permit);
		xlsxCreator.getCell("B6").setValue(strPermit);
		permit = xlsxCreator.getPdf().getPermit();

		//【3】===========================================================//
		// Excel ファイルクローズ、PDF 出力
		//================================================================//
		xlsxCreator.closeBook(true, outPdfFileName, false);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outPdfFileName);
	}
	// PDF 文書のプロパティ
	private void jButtonPdf2ActionPerformed(java.awt.event.ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		outFileName = SampleWork.getOutDirectory() + "PDF文書プロパティ.xlsx";  // 生成 Excel ファイル
		outPdfFileName = SampleWork.getOutDirectory() + "PDF文書プロパティ.pdf";  // 生成 PDF ファイル

		//【1】===========================================================//
		// Excel ファイル新規作成
		//================================================================//
		xlsxCreator.createBook(outFileName, 1, ExcelVersion.ver2013);

		//【2】===========================================================//
		// 値の設定
		//================================================================//
		xlsxCreator.getCell("A1").setValue("PDF ファイルのプロパティをご確認ください。");
		xlsxCreator.getCell("A1").setRowHeight(20);
		xlsxCreator.getCell("A1").getAttr().setFontName("Meiryo");
		xlsxCreator.getCell("A1").getAttr().setFontColor(Color.RED);
		xlsxCreator.getCell("A1").getAttr().setFontPoint(16);
		xlsxCreator.getCell("A").setColWidth(20);
		xlsxCreator.getCell("A3:A7").getAttr().setHorizontalAlignment(HorizontalAlignment.Right);
		xlsxCreator.getCell("A3").setValue("タイトル：");
		xlsxCreator.getCell("A4").setValue("サブタイトル：");
		xlsxCreator.getCell("A5").setValue("作成者：");
		xlsxCreator.getCell("A6").setValue("アプリケーション：");
		xlsxCreator.getCell("A7").setValue("PDF 変換：");
		xlsxCreator.getCell("B3").setValue(jTextFieldTitle.getText());
		xlsxCreator.getCell("B4").setValue(jTextFieldSubject.getText());
		xlsxCreator.getCell("B5").setValue(jTextFieldAuthor.getText());
		xlsxCreator.getCell("B6").setValue(jTextFieldApplication.getText());
		xlsxCreator.getCell("B7").setValue(jTextFieldProducer.getText());

		// PDF 文書のプロパティを設定します。
		// タイトル
		xlsxCreator.getPdf().setTitle(jTextFieldTitle.getText());
		// 作成者
		xlsxCreator.getPdf().setAuthor(jTextFieldAuthor.getText());
		// サブタイトル
		xlsxCreator.getPdf().setSubject(jTextFieldSubject.getText());
		// アプリケーション
		xlsxCreator.getPdf().setApplication(jTextFieldApplication.getText());
		// PDF 変換
		xlsxCreator.getPdf().setProducer(jTextFieldProducer.getText());

		//【3】===========================================================//
		// Excel ファイルクローズ、PDF 出力
		//================================================================//
		xlsxCreator.closeBook(true, outPdfFileName, false);

		// サンプル用処理(生成ファイルオープン)
		SampleWork.fileOpen(outPdfFileName);
	}
}
