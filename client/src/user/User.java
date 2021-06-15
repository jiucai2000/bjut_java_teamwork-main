/**
 * @author 孙禹铭
 * 
 */
package user;
import lan.ClientConnection;

/**
 * @author 孙禹铭
 *
 */
public class User {
	private String userName;
	private String userPassword;
	private static ClientConnection connection;
	
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	
	public User(String userName, String userPassword) {
		// TODO 自动生成的构造函数存根
		if(connection==null)
			connection=new ClientConnection();
		this.userName=userName;
		this.userPassword=userPassword;
	}
	
	public User() {
		// TODO 自动生成的构造函数存根
		if(connection==null)
			connection=new ClientConnection();
	}
	public void login()
	{
		connection.login(userName, userPassword);
		connection.getResult();
	}
	public int getResult()
	{
		return connection.getResult();
	}

	//public void sendfile{

	//}
}



