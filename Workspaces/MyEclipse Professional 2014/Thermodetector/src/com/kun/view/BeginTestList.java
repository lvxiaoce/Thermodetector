package com.kun.view;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.kun.action.TestAction;
import com.kun.action.TherInfAction;
import com.kun.action.TimeAction;
import com.kun.actionImpl.TestActionImpl;
import com.kun.actionImpl.TherInfActionImpl;
import com.kun.actionImpl.TimeActionImpl;
import com.kun.bean.TherInfBean;
import com.kun.utils.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.Color;

public class BeginTestList extends JPanel {
	private JTable table;
	private JTextField collectionTime;
	private DefaultTableModel dtm; 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton beginButton;
	private JButton stopButton;
	private JButton addButton;
	private List<TherInfBean> listAll = new ArrayList<TherInfBean>();
	private String[] timeStr;
	private TestAction tAction = new TestActionImpl();
	private TherInfAction thAction = new TherInfActionImpl();
	private TimeAction tiAction = new TimeActionImpl();
	/**
	 * Create the panel.
	 */
	public BeginTestList() {
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
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		
		beginButton = new JButton("开始采集");
		beginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String cTime = collectionTime.getText();
				if(cTime.isEmpty()){
					JOptionPane.showMessageDialog(null,"请输入采集时间");
					return;
				}
				if(!StringUtil.isMatches(cTime)){
					JOptionPane.showMessageDialog(null,"请输入正确的采集时间");
					return;
				}
				
				beginButton.setVisible(false);
				beginButton.setEnabled(false);
				
				stopButton.setVisible(true);
				stopButton.setEnabled(true);
				
				addButton.setVisible(false);
				addButton.setEnabled(false);
				
				List<TherInfBean> list =  tAction.RandomTestList();
				
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
					listAll.add(tBean);
				}
			}
		});
		beginButton.setBounds(216, 30, 87, 23);
		add(beginButton);
		
		JLabel lblNewLabel = new JLabel("采集时间：每");
		lblNewLabel.setBounds(10, 34, 93, 15);
		add(lblNewLabel);
		
		collectionTime = new JTextField();
		collectionTime.setBounds(86, 32, 42, 21);
		add(collectionTime);
		collectionTime.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("分钟采集一次");
		lblNewLabel_1.setBounds(133, 35, 80, 15);
		add(lblNewLabel_1);
		
		stopButton = new JButton("停止");
		stopButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				beginButton.setVisible(true);
				beginButton.setEnabled(true);
				
				stopButton.setVisible(false);
				stopButton.setEnabled(false);
				
				addButton.setVisible(true);
				addButton.setEnabled(true);
				
			}
		});
		stopButton.setBounds(311, 30, 74, 23);
		add(stopButton);
		stopButton.setVisible(false);
		stopButton.setEnabled(false);
		
		
		addButton = new JButton("导入数据到数据库");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println(listAll);
				boolean addflag = true; 
			
				String time = "";
				
				for (TherInfBean tBean : listAll) {

					if(!time.equals(tBean.getTime())){
						boolean tflag = tiAction.addTime(tBean.getTime());
						if(!tflag){
							JOptionPane.showMessageDialog(null,"导入失败");
							break;
						}
						time = tBean.getTime();
					}
					
					addflag = thAction.addTherInf(tBean);
					if(!addflag){
						JOptionPane.showMessageDialog(null,"导入失败");
						break;
					}
				}
				JOptionPane.showMessageDialog(null,"导入成功");
			}
		});
		addButton.setBounds(760, 30, 143, 23);
		add(addButton);
		addButton.setVisible(false);
		addButton.setEnabled(false);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(58, 365, 45, 21);
		add(textField);
		
		JLabel label = new JLabel("/");
		label.setBounds(110, 366, 22, 18);
		add(label);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 365, 45, 21);
		add(textField_1);
		
		JLabel label_1 = new JLabel("第");
		label_1.setBounds(35, 363, 22, 24);
		add(label_1);
		
		JLabel label_2 = new JLabel("页");
		label_2.setBounds(175, 363, 22, 24);
		add(label_2);
		
		JButton button_1 = new JButton("上一页");
		button_1.setBounds(205, 364, 93, 23);
		add(button_1);
		
		JButton button_2 = new JButton("下一页");
		button_2.setBounds(314, 364, 93, 23);
		add(button_2);
		
		JLabel label_3 = new JLabel("第");
		label_3.setBounds(709, 362, 22, 24);
		add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(726, 365, 45, 21);
		add(textField_2);
		
		JButton button_3 = new JButton("跳转");
		button_3.setBounds(809, 364, 61, 23);
		add(button_3);
		
		JLabel label_4 = new JLabel("页");
		label_4.setBounds(777, 363, 22, 24);
		add(label_4);
		
		JButton btnNewButton = new JButton("清空采集数据");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				listAll = new ArrayList<TherInfBean>();
				
				dtm.setRowCount(0);
				
				beginButton.setVisible(true);
				beginButton.setEnabled(true);
				
				stopButton.setVisible(false);
				stopButton.setEnabled(false);
			}
		});
		btnNewButton.setBounds(614, 30, 127, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("请输入正整数类型参数");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(51, 52, 127, 15);
		add(lblNewLabel_2);
		
		JLabel label_5 = new JLabel("按下停止钮后可导入数据至数据库");
		label_5.setForeground(Color.RED);
		label_5.setBounds(392, 34, 189, 15);
		add(label_5);
	}
}
