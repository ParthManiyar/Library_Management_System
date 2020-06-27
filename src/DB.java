import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	static Connection conn=null;
	static String databaseName="project_demo";
	static String url="jdbc:mysql://localhost:3306/"+databaseName;
	static String username= "root";
	static String password= "Phm245183";
	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(url,username,password);
		return conn;
		
	}

}
