package com.kun.view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;







import com.kun.action.UserAction;
import com.kun.actionImpl.UserActionImpl;
import com.kun.bean.UserBean;
import com.kun.dao.UserDao;
import com.kun.utils.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

/**
 * 注册页面
 * @author 
 *
 */
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField surePassword;
	private UserAction uAction = new UserActionImpl();

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 481, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel usernameField = new JLabel("用  户  名：");
		usernameField.setIcon(new ImageIcon(Register.class.getResource("/res/userName.png")));
		usernameField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		usernameField.setBounds(108, 49, 115, 39);
		contentPane.add(usernameField);
		
		JLabel passwordField = new JLabel("密      码 ：");
		passwordField.setIcon(new ImageIcon(Register.class.getResource("/res/password.png")));
		passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		passwordField.setBounds(108, 98, 115, 39);
		contentPane.add(passwordField);

		JLabel label_2 = new JLabel("确认密码 ：");
		label_2.setIcon(new ImageIcon(Register.class.getResource("/res/password.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(108, 147, 115, 39);
		contentPane.add(label_2);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(207, 59, 130, 21);
		contentPane.add(username);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(207, 108, 130, 21);
		contentPane.add(password);
		
		surePassword = new JPasswordField();
		surePassword.setColumns(10);
		surePassword.setBounds(207, 157, 130, 21);
		contentPane.add(surePassword);
		
		JButton registerButton = new JButton("注册");
		registerButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//获得文本框的值
				String usernameText = username.getText();
				String passwordText = password.getText();
				String surePasswordText = surePassword.getText();
				if (StringUtil.isEmpty(usernameText)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return;
				}
				if (StringUtil.isEmpty(passwordText)) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					return;
				}
				if (StringUtil.isEmpty(surePasswordText)) {
					JOptionPane.showMessageDialog(null, "确认密码不能为空");
					return;
				}
				if(!passwordText.equals(surePasswordText)){
					JOptionPane.showMessageDialog(null, "两次密码不同");
					return;
				}
				
				UserBean user = new UserBean(usernameText,passwordText);
				
				//判断是否注册成功
				boolean flag = uAction.register(user);
				
				if(!flag){
					JOptionPane.showMessageDialog(null, "注册失败");
				}else{
					JOptionPane.showMessageDialog(null, "注册成功");
					//关闭登录窗口
					close();
					
					//初始化主页面
					Main mainFrame = new Main(user);
					
					//设置窗口居中
					mainFrame.setLocationRelativeTo(null);
					
					//设置窗口为可见
					mainFrame.setVisible(true);
				}
			}
		});
		registerButton.setBounds(108, 197, 73, 23);
		contentPane.add(registerButton);
		
		JButton resetButton = new JButton("重置");
		resetButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clearText();
			}
		});
		resetButton.setBounds(187, 197, 73, 23);
		contentPane.add(resetButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		cancelButton.setBounds(264, 197, 73, 23);
		contentPane.add(cancelButton);
	}
	
	//清空输入框的输入
	private void clearText() {
		username.setText("");
		password.setText("");
		surePassword.setText("");
	}
	
	//窗口关闭事件
		private void close(){
			this.dispose();
		}
}
