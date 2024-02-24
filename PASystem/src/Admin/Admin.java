package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
		        table.setModel(model);
		        stmt.close();
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
	}
	public void displayStatus(JTable table) {
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 model.setRowCount(0);
		    try {
		        String sql = "SELECT firstName,lastName, userID, passportStatus FROM Applicant ap JOIN ApplicantStatus aps ON aps.userID = ap.NIC"; 
		        PreparedStatement stmt = conn.prepareStatement(sql);
		       
		        ResultSet rs = stmt.executeQuery();
		        while(rs.next()) {
		        	Object[] rowData = {
		        			rs.getInt("userID"),
		        			rs.getString("firstName"),
		        			rs.getString("lastName"),
		        			rs.getString("passportStatus")
		        	};
		        	model.addRow(rowData);
		        }
		        table.setModel(model);
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
	}
	public Map<String, byte[]> getDocs(int nic) {
	    Map<String, byte[]> imageDataMap = new HashMap<>();
	    try {
	        String sql = "SELECT passportImage, birthImage FROM applicant WHERE NIC = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, nic);
	        ResultSet result = stmt.executeQuery();

	        if (result.next()) {
	            byte[] passportImage = result.getBytes("passportImage");
	            byte[] birthImage = result.getBytes("birthImage");
	            imageDataMap.put("passportImage", passportImage);
	            imageDataMap.put("birthImage", birthImage);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return imageDataMap;
	}


}
 