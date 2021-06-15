package gui.loginDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class LoginDialog extends JDialog {
	private JTextField userNameField;
	private JPasswordField userPasswordField;
	public boolean dialogResult;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}





		/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		dialogResult=false;
		setTitle("登录/注册");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JButton loginButton = new JButton("登录");
			loginButton.setBounds(23, 198, 113, 27);
			getContentPane().add(loginButton);
		}
		{
			JButton registerButton = new JButton("注册");
			registerButton.setBounds(159, 198, 113, 27);
			getContentPane().add(registerButton);
		}
		{
			JButton backButton = new JButton("返回");
			backButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
				}
			});
			backButton.setBounds(295, 198, 113, 27);
			getContentPane().add(backButton);
		}
		
		userNameField = new JTextField();
		userNameField.setBounds(227, 67, 86, 24);
		getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		userPasswordField = new JPasswordField();
		userPasswordField.setBounds(227, 104, 86, 24);
		getContentPane().add(userPasswordField);
		
		JLabel userNameLabel = new JLabel("用户名:");
		userNameLabel.setBounds(124, 70, 72, 18);
		getContentPane().add(userNameLabel);
		
		JLabel userPasswordLabel = new JLabel("密码:");
		userPasswordLabel.setBounds(124, 107, 72, 18);
		getContentPane().add(userPasswordLabel);
	}
}
