package com.kun.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;





import com.kun.bean.UserBean;
import com.kun.dao.UserDao;
import com.kun.utils.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
/**
 * 登录页面
 * @author 
 *
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//美化界面
		try
	    {
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("ヾ(◍°∇°◍)ﾉﾞ    温度测量系统启动成功      ヾ(◍°∇°◍)ﾉﾞ");
					
					//初始化frame对象
					Login frame = new Login();
					
					//设置窗口居中
					frame.setLocationRelativeTo(null);
					
					//frame设为可见
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
	public Login() {
		setTitle("登陆");
		
		//DO_NOTHING_ON_CLOSE  不执行任何操作。
		//HIDE_ON_CLOSE  只隐藏界面。
		//DISPOSE_ON_CLOSE  隐藏并释放窗体
		//EXIT_ON_CLOSE,直接关闭应用程序
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel username = new JLabel("用户名：");
		username.setIcon(new ImageIcon(Login.class.getResource("/res/userName.png")));
		username.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		username.setBounds(93, 35, 84, 39);
		contentPane.add(username);
		
		JLabel password = new JLabel("密   码：");
		password.setIcon(new ImageIcon(Login.class.getResource("/res/password.png")));
		password.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		password.setBounds(93, 84, 84, 39);
		contentPane.add(password);
		
		usernameText = new JTextField();
		usernameText.setBounds(174, 45, 135, 21);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.setColumns(10);
		passwordText.setBounds(174, 94, 135, 21);
		contentPane.add(passwordText);
		
		JButton loginButton = new JButton("登陆");
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				//取输入的文本值
				String username = usernameText.getText();
				String password = passwordText.getText();
				
				//判断用户名和密码是否为空
				if (StringUtil.isEmpty(username)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return;
				}
				if (StringUtil.isEmpty(password)) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
				}
				//建立User对象
				UserBean user = new UserBean(username, password);
				
				//调用数据库方法判断User是否存在
				boolean flag = UserDao.login(user);
				
				if(!flag){
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}else{
					JOptionPane.showMessageDialog(null, "登录成功");
					
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
		loginButton.setBounds(93, 145, 71, 23);
		contentPane.add(loginButton);
		
		JButton resetButton = new JButton("重置");
		resetButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				//调用清空文本框方法
				clearText();
			}
		});
		resetButton.setBounds(245, 145, 64, 23);
		contentPane.add(resetButton);
		
		JLabel msg = new JLabel("提示：账号admin密码admin");
		msg.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		msg.setBounds(93, 178, 216, 39);
		contentPane.add(msg);
		
		JButton registerButton = new JButton("注册");
		registerButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//初始化主页面
				Register registerFrame = new Register();
				
				//设置窗口居中
				registerFrame.setLocationRelativeTo(null);
				
				//设置窗口为可见
				registerFrame.setVisible(true);
			}
		});
		registerButton.setBounds(169, 145, 71, 23);
		contentPane.add(registerButton);
	}
	
	//清空账号框, 密码框的输入
	private void clearText() {
		usernameText.setText("");
		passwordText.setText("");
    }
	
	//窗口关闭事件
	private void close(){
		this.dispose();
	}
}
