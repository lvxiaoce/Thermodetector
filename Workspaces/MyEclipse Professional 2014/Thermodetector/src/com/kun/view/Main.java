package com.kun.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import com.kun.bean.UserBean;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 主页面
 * @author 
 *
 */
public class Main extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	/**
	 * Create the frame.
	 */
	public Main(UserBean user) {
		setTitle("温度测量系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统管理");
		mnNewMenu.setIcon(new ImageIcon(Main.class.getResource("/res/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("温度测试");
		mnNewMenu_1.setIcon(new ImageIcon(Main.class.getResource("/res/thermometer.png")));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("主程序");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThermodetectorList tListPanel = new ThermodetectorList();
				desktopPane.add(tListPanel);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(Main.class.getResource("/res/about.png")));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("人员管理");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Main.class.getResource("/res/userName.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("退出");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Main.class.getResource("/res/exit.png")));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 36, 476, 268);
		contentPane.add(desktopPane);
	}
}
