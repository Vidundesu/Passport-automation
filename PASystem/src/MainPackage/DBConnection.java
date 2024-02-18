package MainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection conn;
	private String username;
	private String password;
	
	public DBConnection() {
		this.username="root";
		this.password="1234";
	}
	public Connection connectDB() {
		try {
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pasdatabase", username,password);
			if(conn!=null) {
				System.out.println("Db connected");
			}
			return conn;
		}catch(SQLException e) {
			System.out.println(e);
			return conn;
		}
		
	}
	public Connection connectNicDB() {
		try {
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/NationalDB", username,password);
			if(conn!=null) {
				System.out.println("Db connected");
			}
			return conn;
		}catch(SQLException e) {
			System.out.println(e);
			return conn;
		}
		
	}
    public void closeConnection(){
        try{
            if(conn!=null){
                conn.close();
            }
        }catch(Exception e){
            System.out.println("fail");
        }
        
    }
	

}
