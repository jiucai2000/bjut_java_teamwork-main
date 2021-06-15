import java.awt.EventQueue;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import database.Connection;
import database.Login;
import gui.MainWindow;
import lan.ClientConnection;

/**
 * 	@detail	主函数
 *
 */

public class Main {

	private MainWindow applicationMainWindow;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow applicationMainWindow=new MainWindow();
					applicationMainWindow.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});   
	}
}
