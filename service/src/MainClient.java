import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 孙禹铭
 * 
 */

/**
 * @author 孙禹铭
 *
 */
public class MainClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Socket client;
		
        try {
        	System.out.println("连接到主机：" + "local" + " ，端口号：" + "6426");
			client = new Socket("localhost", 6426);
	        System.out.println("远程主机地址：" + client.getLocalSocketAddress());
	        while(client.isConnected())
	        {
	        	
	        }
	        System.out.println("连接关闭");
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        

		   
		     
	}

}
