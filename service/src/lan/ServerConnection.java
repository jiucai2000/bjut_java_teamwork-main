/**
 * @author 孙禹铭
 * 
 */
package lan;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import lan.Network.ChatMessage;
import lan.Network.LoginInformation;
import lan.Network.LoginResult;
import lan.Network.UserInformation;
import lan.Network.FileMessage;
import lan.Network.FilesendResult;

import database.Login;

/**
 * @author 孙禹铭
 *
 */
public class ServerConnection{
	Server server;

	public ServerConnection () throws IOException {
		server = new Server() {
			protected Connection newConnection () {
				return new UserConnection();
			}
		};

		Network.register(server);

		server.addListener(new Listener() {
			public void received (Connection c, Object object) {
				UserConnection connection = (UserConnection)c;


				
				if (object instanceof LoginInformation) {
					LoginResult loginResult=new LoginResult();
					//已登录
					if (connection.name != null) 
					{
						loginResult.result=-1;
						server.sendToTCP(connection.getID(), loginResult);
						return;
					}
					String name = ((LoginInformation)object).name;
					String password=((LoginInformation)object).password;
					//登录名称不合法
					if (name == null) 
					{
						loginResult.result=1;
						server.sendToTCP(connection.getID(), loginResult);
						return;
					}
					name = name.trim();
					//登录名称为空
					if (name.length() == 0) return;
					//用户名或密码错误
					if(Login.login(name, password)==false)
					{
						loginResult.result=3;
						server.sendToTCP(connection.getID(), loginResult);
						return;
					}
					else 
					{
						connection.name = name;
						loginResult.result=0;
						server.sendToTCP(connection.getID(), loginResult);
						return;
					}
				}


				//zqz测试:文件接收
				if (object instanceof FileMessage)
				{
					System.out.println("是否接收文件？");
					Scanner sc=new Scanner(System.in);
					String choice=sc.nextLine();
					FilesendResult filesendResult=new FilesendResult();

					if (choice.equals("yes"))
					{
						File file=new File("C:/Users/zqz/Desktop/02.txt");//定义存盘的文件路径
						try {
							file.createNewFile();//新建文件
							FileWriter fw=new FileWriter(file,true);
							BufferedWriter bw=new BufferedWriter(fw);
							String data=((FileMessage) object).sendMessage;
							bw.write(data);//将接收的信息写入文件
							bw.close();
							System.out.println("接收成功");
							filesendResult.result=1;//成功
							server.sendToTCP(connection.getID(),filesendResult);
						} catch (IOException e) {
							e.printStackTrace();
						}

					}else {
						System.out.println("已拒绝");
						filesendResult.result=0;//拒绝
					server.sendToTCP(connection.getID(),filesendResult);
					}

				}


			}

			public void disconnected (Connection c) {
				
				//连接断开的操作
				UserConnection connection = (UserConnection)c;
				if (connection.name != null) {
					//连接断开的数据库操作等
					/*
					 * 
					 * 
					 * 
					 * 
					 * */
					System.out.println(connection.name+"断开连接");
				}
			}
		});
		server.bind(Network.port);
		server.start();

	}

	static class UserConnection extends Connection {
		public String name;
	}

	public static void main (String[] args) throws IOException {
		Log.set(Log.LEVEL_DEBUG);
		new ServerConnection();
	}

}
