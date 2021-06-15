/**
 * @author 孙禹铭
 * 
 */
package lan;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author 孙禹铭
 *
 */
public class Network {
	static public final int port = 11426;

	
	static public void register (EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(LoginInformation.class);
		kryo.register(UserInformation.class);
		kryo.register(LoginResult.class);
		kryo.register(ChatUserNames.class);
		kryo.register(ChatMessage.class);
		kryo.register(FileMessage.class);
		kryo.register(FilesendResult.class);
	}
	
	//连接使用的信息
	static public class LoginInformation
	{
		public String name;
		public String password;
	}

	
	//登录使用的信息
	static public class UserInformation {
		public String name;
	}
	
	static public class LoginResult
	{
		//-1 已登录
		//0  登陆成功
		//1  登录信息用户名非法
		//2  登录信息用户名为空
		//3  登录信息用户名或密码错误
		public int result;
	}

	
	//聊天使用的信息
	static public class ChatUserNames {
		public String[] names;
	}

	static public class ChatMessage {
		public String senderName;
		public String text;
	}
	
	//文件传输使用的信息
	static public class FileMessage{
		public String sendMessage;
	}

	static public class FilesendResult{
		public int result;
	}


	//文件共享使用的信息
	
	//圈子共享使用的信息
}
