package panel;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;

import donotedit.SampleWork;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.MaxEndPoint;

public class GetPositionJPanel extends JPanel {

	private String fileName;
	private JComboBox<Object> jComboBoxIndex;
	private JTextField jTextFieldResultGetPos1;
	private JTextField jTextFieldResultGetPos2;
	private JRadioButton jRadioButtonEndPoint;

	/**
	 * Create the panel.
	 */
	public GetPositionJPanel() {
		setPreferredSize(new java.awt.Dimension(750, 770));
		setBackground(new java.awt.Color(248, 248, 255));

		ButtonGroup buttonGroup1 = new ButtonGroup();
		JLabel jLabelDescription = new JLabel();
		JScrollPane jScrollPane1 = new JScrollPane();
		JTextArea jTextArea1 = new JTextArea();
		JPanel jPanel1 = new JPanel();
		JButton jButtonGetPosVer = new JButton();
		JLabel jLabel6 = new JLabel();
		JLabel jLabel7 = new JLabel();
		JLabel jLabel8 = new JLabel();
		JLabel jLabel9 = new JLabel();
		JButton jButtonGetPosCellName = new JButton();
		JButton jButtonTemplateOpen1 = new JButton();
		JPanel jPanel5 = new JPanel();
		JButton jButtonGetMaxData = new JButton();
		JLabel jLabel14 = new JLabel();
		JLabel jLabel15 = new JLabel();
		JButton jButtonGetMaxArea = new JButton();
		JButton jButtonTemplateOpen2 = new JButton();
		JRadioButton jRadioButtonMaxPoint = new JRadioButton();

		jLabelDescription.setBackground(new java.awt.Color(240, 240, 255));
		jLabelDescription.setFont(new java.awt.Font("Meiryo UI", 1, 13));
		jLabelDescription.setForeground(new java.awt.Color(22, 41, 116));
		jLabelDescription.setText("Excel 操作・編集 - 座標情報を取得");
		jLabelDescription.setOpaque(true);

		jTextArea1.setEditable(false);
		jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(2);
		jTextArea1.setText("ExcelCreator の機能でシート内の座標情報を取得します。");
		jTextArea1.setAutoscrolls(false);
		jTextArea1.setOpaque(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.setBorder(BorderFactory.createTitledBorder(null, "座標情報の取得（変数名、セル名）", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonGetPosVer.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonGetPosVer.setText("座標取得 (変数名)");
		jButtonGetPosVer.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonGetPosVer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButtonGetPosVerActionPerformed(evt);
			}
		});

		jTextFieldResultGetPos1 = new JTextField();
		jTextFieldResultGetPos1.setEditable(false);
		jTextFieldResultGetPos1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextFieldResultGetPos1.setHorizontalAlignment(JTextField.LEFT);

		jLabel6.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel6.setText("<html>指定した変数名、セル名の座標情報の取得を行います。<br>同一の変数名が複数配置されている場合、第 2 引数に取得したい変数名の番号(A1 セルに近い順 0～)を指定します。");

		jLabel7.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel7.setText("取得結果");

		jComboBoxIndex = new JComboBox<Object>();
		jComboBoxIndex.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jComboBoxIndex.setModel(new DefaultComboBoxModel<Object>(new String[] { "0", "1", "2" }));

		jLabel8.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel8.setText("番目の変数名「**Ver」の座標取得");

		jLabel9.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel9.setText("セル名「NAMAE」の座標取得");

		jButtonGetPosCellName.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonGetPosCellName.setText("座標取得 (セル名)");
		jButtonGetPosCellName.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonGetPosCellName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButtonGetPosCellNameActionPerformed(evt);
			}
		});

		jButtonTemplateOpen1.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonTemplateOpen1.setText("テンプレートを確認");
		jButtonTemplateOpen1.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButtonTemplateOpen1ActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel6)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jLabel7)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(jTextFieldResultGetPos1))
							.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
									.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jComboBoxIndex, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jLabel8))
									.addComponent(jLabel9))
								.addGap(18)
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
									.addComponent(jButtonGetPosCellName, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addComponent(jButtonGetPosVer, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))))
						.addComponent(jButtonTemplateOpen1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel6)
					.addGap(14)
					.addComponent(jButtonTemplateOpen1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jComboBoxIndex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel8)
						.addComponent(jButtonGetPosVer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel9)
						.addComponent(jButtonGetPosCellName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel7)
						.addComponent(jTextFieldResultGetPos1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		jPanel1.setLayout(jPanel1Layout);

		jPanel5.setBorder(BorderFactory.createTitledBorder(null, "データの最終座標の取得", 0, 0, new java.awt.Font("Meiryo UI", 0, 13)));
		jPanel5.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jPanel5.setOpaque(false);
		jPanel5.setPreferredSize(new java.awt.Dimension(443, 159));

		jButtonGetMaxData.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonGetMaxData.setText("getMaxData");
		jButtonGetMaxData.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonGetMaxData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButtonGetMaxDataActionPerformed(evt);
			}
		});

		jTextFieldResultGetPos2 = new JTextField();
		jTextFieldResultGetPos2.setEditable(false);
		jTextFieldResultGetPos2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jTextFieldResultGetPos2.setHorizontalAlignment(JTextField.LEFT);

		jLabel14.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel14.setText("<html>Excel シート上で値、または、書式が設定されているセルの最終座標の取得を行います。<br>getMaxData メソッドは値を、getMaxArea メソッドは書式を対象とします。");

		jLabel15.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jLabel15.setText("取得結果");

		jButtonGetMaxArea.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonGetMaxArea.setText("getMaxArea");
		jButtonGetMaxArea.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonGetMaxArea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButtonGetMaxAreaActionPerformed(evt);
			}
		});

		jButtonTemplateOpen2.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jButtonTemplateOpen2.setText("テンプレートを確認");
		jButtonTemplateOpen2.setPreferredSize(new java.awt.Dimension(130, 30));
		jButtonTemplateOpen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButtonTemplateOpen1ActionPerformed(evt);
			}
		});

		jRadioButtonEndPoint = new JRadioButton();
		buttonGroup1.add(jRadioButtonEndPoint);
		jRadioButtonEndPoint.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jRadioButtonEndPoint.setSelected(true);
		jRadioButtonEndPoint.setText("EndPoint - データのある 1 番右下の座標");
		jRadioButtonEndPoint.setBackground(new java.awt.Color(248, 248, 255));

		buttonGroup1.add(jRadioButtonMaxPoint);
		jRadioButtonMaxPoint.setFont(new java.awt.Font("Meiryo UI", 0, 13));
		jRadioButtonMaxPoint.setText("MaxPoint - 最大行と最大列の交点");
		jRadioButtonMaxPoint.setBackground(new java.awt.Color(248, 248, 255));

		GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel14)
								.addGroup(jPanel5Layout.createSequentialGroup()
										.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
														.addComponent(jLabel15)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jTextFieldResultGetPos2, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
												.addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
														.addComponent(jButtonGetMaxData, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(jButtonGetMaxArea, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(506, Short.MAX_VALUE))
								.addGroup(jPanel5Layout.createSequentialGroup()
										.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(jPanel5Layout.createSequentialGroup()
														.addComponent(jRadioButtonEndPoint)
														.addGap(18, 18, 18)
														.addComponent(jRadioButtonMaxPoint))
												.addComponent(jButtonTemplateOpen2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, Short.MAX_VALUE))))
				);
		jPanel5Layout.setVerticalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(14, 14, 14)
						.addComponent(jButtonTemplateOpen2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(7, 7, 7)
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jRadioButtonEndPoint)
								.addComponent(jRadioButtonMaxPoint))
						.addGap(18, 18, 18)
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonGetMaxArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonGetMaxData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel15)
								.addComponent(jTextFieldResultGetPos2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(25, Short.MAX_VALUE))
				);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
				.addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabelDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 231, Short.MAX_VALUE))
				);
	}
	// テンプレート Excel ファイルオープン
	private void jButtonTemplateOpen1ActionPerformed(ActionEvent evt) {
		SampleWork.fileOpen(SampleWork.getInDirectory() + "templateetc.xlsx");
	}

	// 座標情報の取得（変数名）
	private void jButtonGetPosVerActionPerformed(ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templateetc.xlsx";  // テンプレート Excel ファイル

		//【1】===========================================================//
		// Excel ファイル読み込み専用オープン
		//================================================================//
		xlsxCreator.readBook(fileName);

		//【2】===========================================================//
		// 座標情報の取得（変数名）
		//================================================================//
		Integer index = 0;
		try {
			index = Integer.parseInt((String) jComboBoxIndex.getSelectedItem());
		} catch (NumberFormatException ex) {
		}
		Point pt = xlsxCreator.getVarNamePos("**Var", index);   // 変数名が存在しない場合、{-1,-1}となります。
		//Boolean result = xlsxCreator.varCheck(varName);	// VarCheck メソッドで変数名の有無が確認可能。
		jTextFieldResultGetPos1.setText(String.format("変数名[**Var(%S番目)]の座標は x=[%s] y=[%s] です。", index, pt.x, pt.y));

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);
	}

	// 座標情報の取得（セル名）
	private void jButtonGetPosCellNameActionPerformed(ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templateetc.xlsx";  // テンプレート Excel ファイル

		//【1】===========================================================//
		// Excel ファイル読み込み専用オープン
		//================================================================//
		xlsxCreator.readBook(fileName);

		//【2】===========================================================//
		// 座標情報の取得（セル名）
		//================================================================//
		Point pt = xlsxCreator.getNamePos("NAMAE");   // 変数名が存在しない場合、{-1,-1}となります。
		jTextFieldResultGetPos1.setText(String.format("セル名[NAMAE]の座標は x=[%d] y=[%d] です。", pt.x, pt.y));

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);
	}

	// データの最終座標の取得（セルの値）
	private void jButtonGetMaxDataActionPerformed(ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templateetc.xlsx";  // テンプレート Excel ファイル

		//【1】===========================================================//
		// Excel ファイル読み込み専用オープン
		//================================================================//
		xlsxCreator.readBook(fileName);

		//【2】===========================================================//
		// データの最終座標の取得（セルの値）
		//================================================================//
		Point pt;
		// 最終座標の種別に EndPoint
		if (jRadioButtonEndPoint.isSelected() == true) {
			pt = xlsxCreator.getMaxData(MaxEndPoint.EndPoint);	// 一番下の行の最終データの座標
			//pt = xlsxCreator.getMaxData();			// 省略時は EndPointと同じ
		}
		// 最終座標の種別に MaxPoint
		else {
			pt = xlsxCreator.getMaxData(MaxEndPoint.MaxPoint);	// 列の最終座標と行の最終座標の交点
		}
		jTextFieldResultGetPos2.setText(String.format("セルの最終座標は x=[%d] y=[%d] です。", pt.x, pt.y));

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);
	}

	// データの最終座標の取得（セルの値、書式含む）
	private void jButtonGetMaxAreaActionPerformed(ActionEvent evt) {
		// インスタンス生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		fileName = SampleWork.getInDirectory() + "templateetc.xlsx";  // テンプレート Excel ファイル

		//【1】===========================================================//
		// Excel ファイル読み込み専用オープン
		//================================================================//
		xlsxCreator.readBook(fileName);

		//【2】===========================================================//
		// データの最終座標の取得（セルの値、書式含む）
		//================================================================//
		Point pt;
		// 最終座標の種別に EndPoint
		if (jRadioButtonEndPoint.isSelected() == true) {
			pt = xlsxCreator.getMaxArea(MaxEndPoint.EndPoint);	// 一番下の行の最終データの座標
			//pt = xlsxCreator.getMaxArea();			// 省略時は EndPointと同じ
		} // 最終座標の種別に MaxPoint
		else {
			pt = xlsxCreator.getMaxArea(MaxEndPoint.MaxPoint);	// 列の最終座標と行の最終座標の交点
		}
		jTextFieldResultGetPos2.setText(String.format("セルの最終座標は x=[%d] y=[%d] です。", pt.x, pt.y));

		//【3】===========================================================//
		// Excel ファイルクローズ
		//================================================================//
		xlsxCreator.closeBook(true);
	}
}
