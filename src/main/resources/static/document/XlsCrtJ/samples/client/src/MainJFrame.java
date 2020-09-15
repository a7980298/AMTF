import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import donotedit.MainJPanel;
import donotedit.SampleWork;
import panel.AttributeCellJPanel;
import panel.AttributeRowColJPanel;
import panel.AttributeSheetJPanel;
import panel.CalculateJPanel;
import panel.CellPosJPanel;
import panel.CreateJPanel;
import panel.DrawingJPanel;
import panel.EditCellJPanel;
import panel.GetPositionJPanel;
import panel.HensuuJPanel;
import panel.HtmlJPanel;
import panel.HtmlOptionJPanel;
import panel.OverlayJPanel;
import panel.PdfJPanel;
import panel.PdfOption1JPanel;
import panel.PdfOption2JPanel;

public class MainJFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		setMinimumSize(new Dimension(1000, 900));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JSplitPane jSplitPane1 = new JSplitPane();
		jSplitPane1.setMinimumSize(new Dimension(1000, 900));
		jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(jSplitPane1, BorderLayout.CENTER);

		JLabel jLabel1 = new JLabel();
		jLabel1.setIcon(new ImageIcon(MainJFrame.class.getResource("/donotedit/images/ecjava_sampleheader.png")));
		jLabel1.setVerticalTextPosition(SwingConstants.TOP);
		jLabel1.setVerticalAlignment(SwingConstants.TOP);
		jLabel1.setPreferredSize(new Dimension(36, 96));
		jLabel1.setOpaque(true);
		jLabel1.setMinimumSize(new Dimension(36, 96));
		jLabel1.setMaximumSize(new Dimension(36, 96));
		jLabel1.setBackground(Color.WHITE);
		jSplitPane1.setLeftComponent(jLabel1);

		final JSplitPane jSplitPane2 = new JSplitPane();
		jSplitPane1.setRightComponent(jSplitPane2);
		jSplitPane2.setDividerLocation(230);
		jSplitPane2.setPreferredSize(new Dimension(683, 572));

		JScrollPane jScrollPane1 = new JScrollPane();
		jSplitPane2.setLeftComponent(jScrollPane1);

		final MainJPanel mainJPanel = new MainJPanel();
		jSplitPane2.setRightComponent(mainJPanel);

		final JTree jTreeSideMenu = new JTree();
		jTreeSideMenu.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)jTreeSideMenu.getLastSelectedPathComponent();
				if (node != null) {
					switch (node.toString()) {
					case "はじめにお読みください":
						jSplitPane2.setRightComponent(mainJPanel);
						break;
					case "新規作成":
						CreateJPanel createJPanel = new CreateJPanel();
						jSplitPane2.setRightComponent(createJPanel);
						break;
					case "オーバーレイ/上書きオープン":
						OverlayJPanel overlayJPanel = new OverlayJPanel();
						jSplitPane2.setRightComponent(overlayJPanel);
						break;
					case "PDF 出力":
						PdfJPanel pdfJPanel = new PdfJPanel();
						jSplitPane2.setRightComponent(pdfJPanel);
						break;
					case "PDF オプション 1":
						PdfOption1JPanel pdfOption1JPanel = new PdfOption1JPanel();
						jSplitPane2.setRightComponent(pdfOption1JPanel);
						break;
					case "PDF オプション 2":
						PdfOption2JPanel pdfOption2JPanel = new PdfOption2JPanel();
						jSplitPane2.setRightComponent(pdfOption2JPanel);
						break;
					case "HTML 出力":
						HtmlJPanel htmlJPanel = new HtmlJPanel();
						jSplitPane2.setRightComponent(htmlJPanel);
						break;
					case "HTML オプション":
						HtmlOptionJPanel htmlOptionJPanel = new HtmlOptionJPanel();
						jSplitPane2.setRightComponent(htmlOptionJPanel);
						break;
					case "セルの指定方法":
						CellPosJPanel cellPosJPanel = new CellPosJPanel();
						jSplitPane2.setRightComponent(cellPosJPanel);
						break;
					case "変数名の使用例":
						HensuuJPanel hensuuJPanel = new HensuuJPanel();
						jSplitPane2.setRightComponent(hensuuJPanel);
						break;
					case "シート操作":
						AttributeSheetJPanel attributeSheetJPanel = new AttributeSheetJPanel();
						jSplitPane2.setRightComponent(attributeSheetJPanel);
						break;
					case "行列操作":
						AttributeRowColJPanel attributeRowColJPanel = new AttributeRowColJPanel();
						jSplitPane2.setRightComponent(attributeRowColJPanel);
						break;
					case "セル操作":
						EditCellJPanel editCellJPanel = new EditCellJPanel();
						jSplitPane2.setRightComponent(editCellJPanel);
						break;
					case "セルの書式設定":
						AttributeCellJPanel attributeCellJPanel = new AttributeCellJPanel();
						jSplitPane2.setRightComponent(attributeCellJPanel);
						break;
					case "Excel 計算式":
						CalculateJPanel calculateJPanel = new CalculateJPanel();
						jSplitPane2.setRightComponent(calculateJPanel);
						break;
					case "図、シェイプの設定":
						DrawingJPanel drawingJPanel = new DrawingJPanel();
						jSplitPane2.setRightComponent(drawingJPanel);
						break;
					case "座標情報の取得":
						GetPositionJPanel getPositionJPanel = new GetPositionJPanel();
						jSplitPane2.setRightComponent(getPositionJPanel);
						break;
					}
				}
			}
		});
		jScrollPane1.setViewportView(jTreeSideMenu);
		jTreeSideMenu.setFont(new Font("Meiryo UI", 0, 13));
		DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("はじめにお読みください");
		if (SampleWork.isSampleError() == false) {
			DefaultMutableTreeNode treeNode2 = new DefaultMutableTreeNode("ファイル作成");
			DefaultMutableTreeNode treeNode3 = new DefaultMutableTreeNode("新規作成");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("オーバーレイ/上書きオープン");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("PDF 出力");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("PDF オプション 1");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("PDF オプション 2");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("HTML 出力");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("HTML オプション");
			treeNode2.add(treeNode3);
			treeNode1.add(treeNode2);
			treeNode2 = new DefaultMutableTreeNode("値の設定 (基本操作)");
			treeNode3 = new DefaultMutableTreeNode("セルの指定方法");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("変数名の使用例");
			treeNode2.add(treeNode3);
			treeNode1.add(treeNode2);
			treeNode2 = new DefaultMutableTreeNode("Excel 操作・編集");
			treeNode3 = new DefaultMutableTreeNode("シート操作");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("行列操作");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("セル操作");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("セルの書式設定");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("Excel 計算式");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("図、シェイプの設定");
			treeNode2.add(treeNode3);
			treeNode3 = new DefaultMutableTreeNode("座標情報の取得");
			treeNode2.add(treeNode3);
			treeNode1.add(treeNode2);
		}
		jTreeSideMenu.setModel(new DefaultTreeModel(treeNode1));
		jTreeSideMenu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		jTreeSideMenu.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
	}
}
