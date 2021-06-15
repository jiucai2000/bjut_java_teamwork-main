import java.awt.EventQueue;
import java.io.FileInputStream;

import gui.MainWindow;

/**
 * @author 孙禹铭
 * 
 */

/**
 * @author 孙禹铭
 *
 */
import user.User;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		User client=new User();
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
