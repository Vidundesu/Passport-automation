package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import MainPackage.DBConnection;
import MainPackage.Encryptor;

public class Admin {
	private String username;
	private String pw;
	DBConnection db = new DBConnection();
	private Connection conn;
	public Admin() {
		
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
	public boolean adminLogin(String username, String password) {
		try {
			
			String sql = "SELECT username, password FROM AdminLogin WHERE username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				String hashedPasswordDB = result.getString("password");
				String usernameDB = result.getString("username");
				Encryptor encrypt = new Encryptor();
				if (encrypt.passwordVerification(password, hashedPasswordDB)) {
                    System.out.println("User logged: " + username);
                    return true;
                } else {
                    return false;
                }
			}else
			return false;
		}catch(Exception e) {
			 System.out.println(e);
			 return false;
		}
	}
	public void displayApplicants(JTable table) {
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 model.setRowCount(0);
		    try {
		        String sql = "SELECT * FROM applicant"; 
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        ResultSet rs = stmt.executeQuery();
		        while(rs.next()) {
		        	Object[] rowData = {
		        			rs.getString("NIC"),
		        			rs.getString("firstName"),
		        			rs.getString("lastName"),
		        			rs.getInt("birthNumber"),
		        			rs.getString("email")
		        	};
		        	model.addRow(rowData);
		        }
		        rs.close();
		        stmt.close();
		        conn.close();
		        
		        table.setModel(model);
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
	}
}
 