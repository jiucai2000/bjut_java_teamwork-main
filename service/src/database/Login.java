package database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class Login {
    public static boolean login(String Username, String UserPassword) {
        boolean isLogin = false;
        Connection connection = new Connection();
        try {
            connection.getData("*", "USER", "USERNAME='" + Username + "'AND USERPASSWORD='" + UserPassword + "'");
            while (connection.resultSet.next()) {
                isLogin = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isLogin;
    }

    public static boolean adminLogin(String Username) {
        boolean isAdmin = false;
        Connection con = new Connection();
        try {
            con.getData("*", "USER", "USERNAME='" + Username + "'AND USERNAME='ADMIN'");
            while (con.resultSet.next()) {
                isAdmin = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isAdmin;
    }
}
