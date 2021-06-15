package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import gui.loginDialog.LoginDialog;

import javax.swing.JLayeredPane;
import java.awt.Component;
import javax.swing.Box;

public class MainWindow {

	private JFrame frmIask;
	private LoginDialog loginDlg;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		
	}
	
	public void show()
	{
		this.frmIask.setVisible(true);
	}
	public void hide()
	{
		this.frmIask.setVisible(false);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIask = new JFrame();
		frmIask.setTitle("桌面文档共享与管理系统");
		frmIask.setBounds(100, 100, 630, 485);
		frmIask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIask.getContentPane().setLayout(null);
		
		JPanel userBarPanel = new JPanel();
		userBarPanel.setBounds(0, 0, 610, 40);
		frmIask.getContentPane().add(userBarPanel);
		userBarPanel.setLayout(null);
		
		JButton homePageButton = new JButton("首页");
		homePageButton.setBounds(14, 5, 113, 27);
		userBarPanel.add(homePageButton);
		
		JButton loginButton = new JButton("登录/注册");
		loginButton.setBounds(495, 5, 101, 27);
		userBarPanel.add(loginButton);
		
		loginDlg =new LoginDialog();
		loginDlg.setVisible(false);
		
		class LoginButtonHandleLoginRegister implements MouseListener
		{
			@Override        
			public void mousePressed(MouseEvent e)
			{
				loginDlg.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		}
		
		LoginButtonHandleLoginRegister popUpLoginDialog =new LoginButtonHandleLoginRegister();
		loginButton.addMouseListener(popUpLoginDialog);
	}
}
