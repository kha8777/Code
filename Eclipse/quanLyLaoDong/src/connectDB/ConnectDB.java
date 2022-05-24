package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance() {
		return instance;
	}
	public static Connection getconnection(){
		return con;
	}
	public void Connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=quanlilaodong";
		String user = "sa";
		String pass = "123456";
		
		try {
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("connect succesful");
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("disconnect");
		}
	}
	public void disconnect(){
		if(con!=null)
			try{
				con.close();
			}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Can not disconnect");
		}
	}
	
	
}
