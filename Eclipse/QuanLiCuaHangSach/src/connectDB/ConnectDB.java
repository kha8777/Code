package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection connection;
	private static 	ConnectDB instance;
	
	public ConnectDB() {
		String url ="jdbc:sqlserver://localhost:1433;databaseName=Sach";
		try {
			connection = DriverManager.getConnection(url,"sa","08062002");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static ConnectDB getInstance() {
		if (instance==null) {
			instance = new ConnectDB();
		}
		return instance;
	}
	 public static Connection getConnection() {
		try {
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	 public void disconnect() {
		if (connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void connect() {
		// TODO Auto-generated method stub
		
	}
}
