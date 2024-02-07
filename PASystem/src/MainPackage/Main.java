package MainPackage;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pasdatabase", "root","1234");
			if(conn!=null) {
				System.out.println("Db connected");
			}
		}catch(Exception e) {
			System.out.println("no connected");
		}

	}

}
