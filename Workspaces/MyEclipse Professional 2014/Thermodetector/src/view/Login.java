package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import dao.UserDao;
import bean.UserBean;
import utils.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
					Login frame = new Login();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel username = new JLabel("用户名：");
		username.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		username.setBounds(93, 35, 64, 39);
		contentPane.add(username);
		
		JLabel password = new JLabel("密   码：");
		password.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		password.setBounds(93, 84, 64, 39);
		contentPane.add(password);
		
		usernameText = new JTextField();
		usernameText.setBounds(161, 45, 148, 21);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		passwordText = new JTextField();
		passwordText.setColumns(10);
		passwordText.setBounds(161, 94, 148, 21);
		contentPane.add(passwordText);
		
		JButton loginButton = new JButton("登陆");
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String username = usernameText.getText();
				String password = passwordText.getText();
				if (StringUtil.isEmpty(username)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return;
				}
				if (StringUtil.isEmpty(password)) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
				}
				UserBean user = new UserBean(username, password);
				boolean flag = UserDao.login(user);
				if(!flag){
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}else{
					JOptionPane.showMessageDialog(null, "登录成功");
				}
			}
		});
		loginButton.setBounds(93, 145, 93, 23);
		contentPane.add(loginButton);
		
		JButton resetButton = new JButton("重置");
		resetButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clearText();
			}
		});
		resetButton.setBounds(216, 145, 93, 23);
		contentPane.add(resetButton);
		
		JLabel lbladminadmin = new JLabel("提示：账户admin密码admin");
		lbladminadmin.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lbladminadmin.setBounds(93, 178, 216, 39);
		contentPane.add(lbladminadmin);
	}
	
	private void clearText() {//清空文本框, 密码框的输入
		usernameText.setText("");
		passwordText.setText("");
    }
}
