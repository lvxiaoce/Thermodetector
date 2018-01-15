package com.kun.view;

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







import com.kun.action.UserAction;
import com.kun.actionImpl.UserActionImpl;
import com.kun.bean.UserBean;
import com.kun.dao.UserDao;
import com.kun.utils.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
/**
 * 鐧诲綍椤甸潰
 * @author 
 *
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField passwordText;
	private UserAction uAction = new UserActionImpl();

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
					
					frame.setLocationRelativeTo(null);
					
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
		setTitle("温度系统");
		
		//DO_NOTHING_ON_CLOSE  
		//HIDE_ON_CLOSE  
		//DISPOSE_ON_CLOSE  
		//EXIT_ON_CLOSE
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel username = new JLabel("用户名：");
		username.setIcon(new ImageIcon(Login.class.getResource("/res/userName.png")));
		username.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 16));
		username.setBounds(93, 35, 84, 39);
		contentPane.add(username);
		
		JLabel password = new JLabel("密    码：");
		password.setIcon(new ImageIcon(Login.class.getResource("/res/password.png")));
		password.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 16));
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
		
		JButton loginButton = new JButton("登录");
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				//鍙栬緭鍏ョ殑鏂囨湰鍊�
				String username = usernameText.getText();
				String password = passwordText.getText();
				
				if (StringUtil.isEmpty(username)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空!");
					return;
				}
				if (StringUtil.isEmpty(password)) {
					JOptionPane.showMessageDialog(null, "密码不能为空!");
				}
				UserBean user = new UserBean(username, password);
				
				boolean flag = uAction.login(user);
				
				if(!flag){
					JOptionPane.showMessageDialog(null, "账号或密码错误!");
				}else{
					JOptionPane.showMessageDialog(null, "登录成功!");
					
					close();
					
					Main mainFrame = new Main(user);
					
					mainFrame.setLocationRelativeTo(null);
					
					mainFrame.setVisible(true);
				}
			}
		});
		loginButton.setBounds(93, 145, 71, 23);
		contentPane.add(loginButton);
		
		JButton resetButton = new JButton("退出");
		resetButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				clearText();
			}
		});
		resetButton.setBounds(245, 145, 64, 23);
		contentPane.add(resetButton);
		
		JButton registerButton = new JButton("注册");
		registerButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Register registerFrame = new Register();
				
				registerFrame.setLocationRelativeTo(null);
				
				registerFrame.setVisible(true);
			}
		});
		registerButton.setBounds(169, 145, 71, 23);
		contentPane.add(registerButton);
	}
	
	private void clearText() {
		usernameText.setText("");
		passwordText.setText("");
    }
	
	private void close(){
		this.dispose();
	}
}
