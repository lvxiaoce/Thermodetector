package com.kun.view;

import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kun.action.HeightAction;
import com.kun.actionImpl.HeightActionImpl;
import javax.swing.JButton;

public class TestParamList extends JPanel {
	private JTable table;
	private DefaultTableModel dtm;
	private HeightAction hiAction = new HeightActionImpl();

	/**
	 * Create the panel.
	 */
	public TestParamList() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 69, 192, 304);
		add(scrollPane);
		
		dtm = new DefaultTableModel();
		dtm.addColumn("高度");
		dtm.addColumn("操作");
		
		List<String> listHi = hiAction.selectHeightAll();
		
		for(String str:listHi){
			Vector<String> v = new Vector<String>();
			v.add(str);
			v.add("删除");
			dtm.addRow(v);
		}
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("添加新高度");
		btnNewButton.setBounds(125, 30, 93, 23);
		add(btnNewButton);
		
		
	}
}
