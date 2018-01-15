package com.kun.view;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BeginTestList extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public BeginTestList() {
		this.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 893, 412);
		add(scrollPane);
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("采集时间");
		dtm.addColumn("高度");
		dtm.addColumn("南3");
		dtm.addColumn("南2");
		dtm.addColumn("南1");
		dtm.addColumn("中心");
		dtm.addColumn("北1");
		dtm.addColumn("北2");
		dtm.addColumn("北3");
		dtm.addColumn("东3");
		dtm.addColumn("东2");
		dtm.addColumn("东1");
		dtm.addColumn("西1");
		dtm.addColumn("西2");
		dtm.addColumn("西3");
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
	}
}
