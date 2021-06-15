/**
 * @author 孙禹铭
 * 
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * @author 孙禹铭
 *
 */
public class Connection {
	
	private static java.sql.Connection connect = null;
	private static PreparedStatement preState = null;
	public static ResultSet resultSet = null;

    
    public Connection()
    {
    	if(connect==null)
    	{
    		try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    		try {
				connect = DriverManager.getConnection("jdbc:ucanaccess://src/database/moyu.mdb");
				System.out.println(connect);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    	}
    }
    
    public void getData(String selection,String target)
    {
    	try {
    		preState = connect.prepareStatement("select  "+selection+" from "+target);
			resultSet=preState.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
    
    public void getData(String selection,String target,String where)
    {
    	try {
    		preState = connect.prepareStatement("select  "+selection+" from "+target+" where "+where);
			resultSet=preState.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }


    public void closePreState()
	{
		try {
			preState.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
