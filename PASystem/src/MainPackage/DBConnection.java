package MainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection conn;
	
	public DBConnection() {
		this.connectDB();
	}
	public void connectDB() {
		try {
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pasdatabase", "root","1234");
			if(conn!=null) {
				System.out.println("Db connected");
				
			}
		}catch(SQLException e) {
			System.out.println(e);
//			System.out.println(e);
			
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
