package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	public static Connection getMySQLConnection()
			throws ClassNotFoundException, SQLException {

		// Chú ý: Thay đổi các thông số kết nối cho phù hợp.
		String hostName = "localhost";
	    String dbName = "bsbus";
	    String userName = "duybao";
	    String password = "EriK0812";
		/*String hostName = "192.168.30.183";
		String dbName = "bsbus";
		String userName = "root";
		String password = "AXTmqo71594";*/
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName,
			String userName, String password) throws SQLException,
	ClassNotFoundException {
		// Khai báo class Driver cho DB MySQL
		// Việc này cần thiết với Java 5
		// Java6 trở lên tự động tìm kiếm Driver thích hợp.
		// Nếu bạn dùng Java > 5, thì ko cần dòng này cũng được.
		Class.forName("com.mysql.jdbc.Driver");

		// Cấu trúc URL Connection dành cho MySQL
		// Ví dụ: jdbc:mysql://localhost:3306/simplehr
		String connectionURL = "jdbc:mysql://"+hostName+":3306/"+ dbName;
//		 String connectionURL = "jdbc:mysql://"+hostName+"/"+ dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName,
				password);
		System.out.println("Connect Seccessful");
		return conn;
	}
}
