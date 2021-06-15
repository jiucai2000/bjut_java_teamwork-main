/**
 * @author 孙禹铭
 * 
 */
package lan;

import java.awt.EventQueue;
import java.io.*;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import lan.Network.ChatMessage;
import lan.Network.LoginInformation;
import lan.Network.LoginResult;
import lan.Network.UserInformation;


//zzq测试用
import lan.Network.FilesendResult;
import lan.Network.FileMessage;

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
	//private final String host = "localhost";
	private int result=-2;
	
	public String getName() {
		return name;
	}

	public boolean getIfLogin() {
		return ifLogin;
	}

	public int getResult() {
		return result;
	}

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
				//filesend();
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
							result=-1;
							return;
						}
						case 0:
						{
							result=0;
							System.out.println("登陆成功");
							ifLogin=true;
							return;
						}
						case 1:
						{
							ifLogin=false;
							System.out.println("登录信息用户名非法");
							result=1;
							return;
						}
						case 2:
						{
							ifLogin=false;
							System.out.println("登录信息用户名为空");
							result=2;
							return;
						}
						case 3:
						{
							ifLogin=false;
							System.out.println("登录信息用户名或密码错误");
							result=3;
							return;
						}
					}

				}

				if (object instanceof FilesendResult)
				{
					FilesendResult filesendResult=(FilesendResult)object;
					switch (filesendResult.result)
					{
						case 1:
						{
							System.out.println("对方已接收");
							return;
						}
						case 0:
						{
							System.out.println("对方已拒绝");
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
					//client.connect(5000, host, Network.port);
					client.connect(5000, host, Network.port);
				} catch (IOException ex) {
					ex.printStackTrace();
					System.exit(1);
				}
			}
		}.start();
	}

	public void login(String userName,String password)
	{
		LoginInformation loginInformation=new LoginInformation();
		loginInformation.name=userName;
		loginInformation.password=password;
		client.sendTCP(loginInformation);
	}

	//zqz测试：发送文件
	public void filesend()
	{
		FileMessage fileMessage=new FileMessage();
		File file=new File("C:/Users/zqz/Desktop/01.txt");
		BufferedReader reader;
		String str="";
		String result="";
		try {
			FileInputStream c=new FileInputStream(file);//定义FileInputStream对象
			reader = new BufferedReader(new FileReader(file));//将读取的信息给Bufferedreader缓冲区reader
			try {
				while ((str = reader.readLine()) != null) {
					result+=str+"\n";}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		fileMessage.sendfile=result;

	client.sendTCP(fileMessage);
	}
}
