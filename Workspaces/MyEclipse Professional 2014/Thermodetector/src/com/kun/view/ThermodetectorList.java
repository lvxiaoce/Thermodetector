package com.kun.view;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kun.action.HeightAction;
import com.kun.action.TherInfAction;
import com.kun.action.TimeAction;
import com.kun.actionImpl.HeightActionImpl;
import com.kun.actionImpl.TherInfActionImpl;
import com.kun.actionImpl.TimeActionImpl;
import com.kun.bean.TherInfBean;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class ThermodetectorList extends JPanel {
	private JTable table;
	private JComboBox comboBox = null;
	private JButton btnNewButton = null;
	private JComboBox comboBox_1 = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DefaultTableModel dtm;
	private TherInfAction tAction = new TherInfActionImpl();
	private TimeAction tiAction = new TimeActionImpl();
	private HeightAction hiAction = new HeightActionImpl();
	/**
	 * Create the panel.
	 */
	public ThermodetectorList() {
		this.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 893, 275);
		add(scrollPane);
		
		dtm = new DefaultTableModel();
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
		
		List<TherInfBean> list = tAction.selectTherListAll();
		
		for(TherInfBean tBean:list){
			Vector<String> v = new Vector<String>();
			v.add(tBean.getTime());
			v.add(tBean.getHeight());
			v.add(tBean.getSouth3());
			v.add(tBean.getSouth2());
			v.add(tBean.getSouth1());
			v.add(tBean.getCore());
			v.add(tBean.getNorth1());
			v.add(tBean.getNorth2());
			v.add(tBean.getNorth3());
			v.add(tBean.getEast3());
			v.add(tBean.getEast2());
			v.add(tBean.getEast1());
			v.add(tBean.getWest1());
			v.add(tBean.getWest2());
			v.add(tBean.getWest3());
			dtm.addRow(v);
		}
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("查询：");
		lblNewLabel.setBounds(26, 29, 45, 24);
		add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(177, 31, 123, 21);
		add(comboBox);
		
		btnNewButton = new JButton("查询");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String item1 = (String) comboBox_1.getSelectedItem();
				String item2 = (String) comboBox.getSelectedItem();
				if(("测量时间").equals(item1)){
					dtm.setRowCount(0);
					
					List<TherInfBean> list = tAction.serchTimeTherListAll(item2);
					
					for(TherInfBean tBean:list){
						Vector<String> v = new Vector<String>();
						v.add(tBean.getTime());
						v.add(tBean.getHeight());
						v.add(tBean.getSouth3());
						v.add(tBean.getSouth2());
						v.add(tBean.getSouth1());
						v.add(tBean.getCore());
						v.add(tBean.getNorth1());
						v.add(tBean.getNorth2());
						v.add(tBean.getNorth3());
						v.add(tBean.getEast3());
						v.add(tBean.getEast2());
						v.add(tBean.getEast1());
						v.add(tBean.getWest1());
						v.add(tBean.getWest2());
						v.add(tBean.getWest3());
						dtm.addRow(v);
					}
					table = new JTable(dtm);
				}
				if(("测量高度").equals(item1)){
					dtm.setRowCount(0);
					
					List<TherInfBean> list = tAction.serchHeightTherListAll(item2);
					
					for(TherInfBean tBean:list){
						Vector<String> v = new Vector<String>();
						v.add(tBean.getTime());
						v.add(tBean.getHeight());
						v.add(tBean.getSouth3());
						v.add(tBean.getSouth2());
						v.add(tBean.getSouth1());
						v.add(tBean.getCore());
						v.add(tBean.getNorth1());
						v.add(tBean.getNorth2());
						v.add(tBean.getNorth3());
						v.add(tBean.getEast3());
						v.add(tBean.getEast2());
						v.add(tBean.getEast1());
						v.add(tBean.getWest1());
						v.add(tBean.getWest2());
						v.add(tBean.getWest3());
						dtm.addRow(v);
					}
					table = new JTable(dtm);
				}
				if(("请选择一项").equals(item1)){
					JOptionPane.showMessageDialog(null,"请选择时间或者高度进行查询！");
				}
			}
		});
		btnNewButton.setBounds(310, 30, 61, 23);
		add(btnNewButton);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item1 = (String) comboBox_1.getSelectedItem();
				if(("测量时间").equals(item1)){
					comboBox.removeAllItems();
					List<String> listTi = tiAction.selectTimeAll();
					for(String timeStr:listTi){
						comboBox.addItem(timeStr);
					}
				}
				if(("测量高度").equals(item1)){
					comboBox.removeAllItems();
					List<String> listHi = hiAction.selectHeightAll();
					for(String heightStr:listHi){
						comboBox.addItem(heightStr);
					}
				}
				if(("请选择一项").equals(item1)){
					comboBox.removeAllItems();
				}
			}
		});
		comboBox_1.setBounds(70, 31, 97, 21);
		comboBox_1.addItem("请选择一项");
		comboBox_1.addItem("测量时间");
		comboBox_1.addItem("测量高度");
		add(comboBox_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(60, 365, 45, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(112, 366, 22, 18);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(122, 365, 45, 21);
		add(textField_1);
		
		JLabel label = new JLabel("第");
		label.setBounds(37, 363, 22, 24);
		add(label);
		
		JLabel label_1 = new JLabel("页");
		label_1.setBounds(177, 363, 22, 24);
		add(label_1);
		
		JButton btnNewButton_1 = new JButton("上一页");
		btnNewButton_1.setBounds(207, 364, 93, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("下一页");
		btnNewButton_2.setBounds(316, 364, 93, 23);
		add(btnNewButton_2);
		
		JLabel label_2 = new JLabel("第");
		label_2.setBounds(711, 362, 22, 24);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(728, 365, 45, 21);
		add(textField_2);
		
		JButton button = new JButton("跳转");
		button.setBounds(811, 364, 61, 23);
		add(button);
		
		JLabel label_3 = new JLabel("页");
		label_3.setBounds(779, 363, 22, 24);
		add(label_3);
	}
}
