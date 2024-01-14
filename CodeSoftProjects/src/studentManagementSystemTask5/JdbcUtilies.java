package studentManagementSystemTask5;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtilies {

	public static Connection buildConnection() throws Exception {
		String URL = "jdbc:mysql://localhost:3306/codesoft?useSSL=false";
		String UserName = "root";
		String Password = "Ashu@120";
		Connection dbConnection = DriverManager.getConnection(URL,UserName,Password);
		return dbConnection;
	}
}
