package MainPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private Connection conn=null;
	
	public DBConnection() {
		this.connectDB();
	}
	public boolean connectDB() {
		try {
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pasdatabase", "root","1234");
			if(conn!=null) {
				System.out.println("Db connected");
				return true;
			}
		}catch(Exception e) {
			System.out.println("no connected");
			return false;
		}
		return false;
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
