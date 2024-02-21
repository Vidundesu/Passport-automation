package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import MainPackage.DBConnection;
import MainPackage.Encryptor;

public class Admin {
	private String username;
	private String pw;
	DBConnection db = new DBConnection();
	private Connection conn;
	public Admin(String username , String pw) {
		this.username=username;
		this.pw=pw;
		conn = db.connectDB();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean adminLogin(String password) {
		try {
			
			String sql = "SELECT password FROM AdminLogin WHERE username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, sql);
			ResultSet result = stmt.executeQuery();
			String hashedPassword = result.getString("password");
			if(result.next()) {
				Encryptor encryptor = new Encryptor(password);
				
				if(encryptor.passwordVerification(hashedPassword)) {
					return true;
				}else {
					return false;
				}
			}else
			return false;
		}catch(Exception e) {
			 System.out.println(e);
			 return false;
		}
	}
}
