package com.kun.view;

import java.util.List;
import java.util.Vector;

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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThermodetectorList extends JPanel {
	private JTable table;
	private JComboBox comboBox = null;
	private JButton btnNewButton = null;
	private JComboBox comboBox_1 = null;
	private TherInfAction tAction = new TherInfActionImpl();
	private TimeAction tiAction = new TimeActionImpl();
	private HeightAction hiAction = new HeightActionImpl();
	/**
	 * Create the panel.
	 */
	public ThermodetectorList() {
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
			}
		});
		comboBox_1.setBounds(70, 31, 97, 21);
		comboBox_1.addItem("请选择一项");
		comboBox_1.addItem("测量时间");
		comboBox_1.addItem("测量高度");
		add(comboBox_1);
	}
}
