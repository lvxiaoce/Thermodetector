package com.kun.view;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.kun.action.TestAction;
import com.kun.actionImpl.TestActionImpl;
import com.kun.bean.TherInfBean;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BeginTestList extends JPanel {
	private JTable table;
	private JTextField textField;
	private TestAction tAction = new TestActionImpl();
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
		
		JButton btnNewButton = new JButton("开始测试");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<TherInfBean> list =  tAction.RandomTestList();
			}
		});
		btnNewButton.setBounds(145, 30, 87, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("采集时间：");
		lblNewLabel.setBounds(10, 34, 66, 15);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(68, 31, 42, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("分钟");
		lblNewLabel_1.setBounds(115, 34, 32, 15);
		add(lblNewLabel_1);
		
		JButton button = new JButton("停止");
		button.setBounds(240, 30, 74, 23);
		add(button);
		
		JButton btnNewButton_1 = new JButton("加入到数据库中");
		btnNewButton_1.setBounds(776, 30, 127, 23);
		add(btnNewButton_1);
	}
}
