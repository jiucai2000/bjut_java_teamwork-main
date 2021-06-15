/**
 * @author 孙禹铭
 * 
 */
package lan;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import lan.Network.ChatMessage;
import lan.Network.LoginResult;
import lan.Network.UserInformation;




/**
 * @author 孙禹铭
 *
 */
public class ClientConnection {

	private Client client;
	private String name;
	private String password;
	private boolean ifLogin;
	private final String host = "localhost";
	
	public ClientConnection () {
		client = new Client();
		client.start();

		Network.register(client);

		client.addListener(new Listener() {
			public void connected (Connection connection) {
				//连接时的操作
				/*
				UserInformation loginInformation = new UserInformation();
				loginInformation.name = name;
				loginInformation.password=password;
				client.sendTCP(loginInformation);
				*/
			}

			public void received (Connection connection, Object object) {
				if (object instanceof LoginResult) {
					LoginResult loginResult = (LoginResult)object;
					//登陆成功
					switch(loginResult.result)
					{
						case -1:
						{
							System.out.println("已登陆");
							ifLogin=true;
							return;
						}
						case 0:
						{
							ifLogin=true;
							return;
						}
						case 1:
						{
							ifLogin=false;
							System.out.println("登录信息用户名非法");
							return;
						}
						case 2:
						{
							ifLogin=false;
							System.out.println("登录信息用户名为空");
							return;
						}
						case 3:
						{
							ifLogin=false;
							System.out.println("登录信息用户名或密码错误");
							return;
						}
					}

					
				}
			}

			public void disconnected (Connection connection) {
				//断开连接的处理
				System.out.println("连接断开");
				return;
			}
		});

		
		new Thread("Connect") {
			public void run () {
				try {
					client.connect(5000, host, Network.port);
				} catch (IOException ex) {
					ex.printStackTrace();
					System.exit(1);
				}
			}
		}.start();
	}

}
