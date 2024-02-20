package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import MainPackage.DBConnection;

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
	public boolean adminLogin() {
		try {
			String sql = "SELECT username, password FROM AdminLogin WHERE username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
			 
		}
	}
}
