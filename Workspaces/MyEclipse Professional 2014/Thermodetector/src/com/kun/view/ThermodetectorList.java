package com.kun.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.kun.action.HeightAction;
import com.kun.action.TherInfAction;
import com.kun.action.TimeAction;
import com.kun.actionImpl.HeightActionImpl;
import com.kun.actionImpl.TherInfActionImpl;
import com.kun.actionImpl.TimeActionImpl;
import com.kun.bean.TherInfBean;
import com.kun.utils.PageUtils;
import com.kun.utils.StringUtil;

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
	private JTextField nowNumberPagesFieldField;
	private JTextField allNumberPagesField;
	private JTextField pageField;
	private DefaultTableModel dtm;
	private TherInfAction tAction = new TherInfActionImpl();
	private TimeAction tiAction = new TimeActionImpl();
	private HeightAction hiAction = new HeightActionImpl();
	private List<TherInfBean> list = tAction.selectTherListAll();
	private Integer totalPage;//总页数
	private Integer nowPages = 1;//当前页数
	private Integer eachData = 8;//每页显示的数据条数
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
		//获得总页数
		totalPage = PageUtils.getAllNumberPages(list.size(), eachData);
		//获得当前页数据
		List<TherInfBean> getPageList = PageUtils.getEachPageList(list,nowPages,eachData,totalPage);
		
		for(TherInfBean tBean:getPageList){
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
//		JTableHeader header = table.getTableHeader();
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
					
					list = tAction.serchTimeTherListAll(item2);
					
					nowPages = 1;
					
					nowNumberPagesFieldField.setText(nowPages+"");
					
					totalPage = PageUtils.getAllNumberPages(list.size(), eachData);
					
					allNumberPagesField.setText(totalPage+"");//设置总页数
					
					List<TherInfBean> getPageList = PageUtils.getEachPageList(list,nowPages,eachData,totalPage);
					
					for(TherInfBean tBean:getPageList){
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
					
					list = tAction.serchHeightTherListAll(item2);
					
					nowPages = 1;
					
					nowNumberPagesFieldField.setText(nowPages+"");
					
					totalPage = PageUtils.getAllNumberPages(list.size(), eachData);
					
					allNumberPagesField.setText(totalPage+"");//设置总页数
					
					List<TherInfBean> getPageList = PageUtils.getEachPageList(list,nowPages,eachData,totalPage);
					
					for(TherInfBean tBean:getPageList){
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
					dtm.setRowCount(0);
					
					list = tAction.selectTherListAll();
					
					nowNumberPagesFieldField.setText(1+"");
					
					totalPage = PageUtils.getAllNumberPages(list.size(), eachData);
					
					allNumberPagesField.setText(totalPage+"");//设置总页数
					
					List<TherInfBean> getPageList = PageUtils.getEachPageList(list,nowPages,eachData,totalPage);
					
					for(TherInfBean tBean:getPageList){
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
		
		nowNumberPagesFieldField = new JTextField();
		nowNumberPagesFieldField.setEnabled(false);
		nowNumberPagesFieldField.setBounds(60, 365, 45, 21);
		nowNumberPagesFieldField.setText(nowPages+"");//设置当前页数
		add(nowNumberPagesFieldField);
		nowNumberPagesFieldField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(112, 366, 22, 18);
		add(lblNewLabel_1);
		
		allNumberPagesField = new JTextField();
		allNumberPagesField.setEnabled(false);
		allNumberPagesField.setColumns(10);
		allNumberPagesField.setBounds(122, 365, 45, 21);
		allNumberPagesField.setText(totalPage+"");//设置总页数
		add(allNumberPagesField);
		
		JLabel label = new JLabel("第");
		label.setBounds(37, 363, 22, 24);
		add(label);
		
		JLabel label_1 = new JLabel("页");
		label_1.setBounds(177, 363, 22, 24);
		add(label_1);
		
		JButton btnNewButton_1 = new JButton("上一页");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nowPages == 1){
					JOptionPane.showMessageDialog(null, "已经是第一页了!");
					return;
				}
				//清空列表数据
				dtm.setRowCount(0);
				//当前页数加一
				nowPages -= 1;
				//设置当前页数
				nowNumberPagesFieldField.setText(nowPages+"");
				//获得当前页数据
				List<TherInfBean> getPageList = PageUtils.getEachPageList(list,nowPages,eachData,totalPage);
				
				for(TherInfBean tBean:getPageList){
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
		});
		btnNewButton_1.setBounds(207, 364, 93, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("下一页");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nowPages == totalPage){
					JOptionPane.showMessageDialog(null, "已经是最后一页了!");
					return;
				}
				if(list.isEmpty()){
					JOptionPane.showMessageDialog(null, "没有数据!");
					return;
				}
				//清空列表数据
				dtm.setRowCount(0);
				//当前页数加一
				nowPages += 1;
				//设置当前页数
				nowNumberPagesFieldField.setText(nowPages+"");
				//获得当前页数据
				List<TherInfBean> getPageList = PageUtils.getEachPageList(list,nowPages,eachData,totalPage);
				
				for(TherInfBean tBean:getPageList){
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
		});
		btnNewButton_2.setBounds(316, 364, 93, 23);
		add(btnNewButton_2);
		
		JLabel label_2 = new JLabel("第");
		label_2.setBounds(711, 362, 22, 24);
		add(label_2);
		
		pageField = new JTextField();
		pageField.setColumns(10);
		pageField.setBounds(728, 365, 45, 21);
		add(pageField);
		
		JButton button = new JButton("跳转");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String page = pageField.getText();
				if(list.isEmpty()){
					JOptionPane.showMessageDialog(null, "没有数据!");
					return;
				}
				if(page.isEmpty()){
					JOptionPane.showMessageDialog(null, "请输入想要跳转的页数!");
					return;
				}
				if(!StringUtil.isMatches(page)||Integer.parseInt(page)<1||Integer.parseInt(page)>totalPage){
					JOptionPane.showMessageDialog(null,"请输入正确的页数！页数必须为正整数且不能小于1和大于最大页数！");
					return;
				}
				//清空列表数据
				dtm.setRowCount(0);
				//获得当前页数
				nowPages = Integer.parseInt(page);
				//设置当前页数
				nowNumberPagesFieldField.setText(nowPages+"");
				//获得当前页数据
				List<TherInfBean> getPageList = PageUtils.getEachPageList(list,nowPages,eachData,totalPage);
				
				for(TherInfBean tBean:getPageList){
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
		});
		button.setBounds(811, 364, 61, 23);
		add(button);
		
		JLabel label_3 = new JLabel("页");
		label_3.setBounds(779, 363, 22, 24);
		add(label_3);
	}
	
}
