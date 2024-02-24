package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import MainPackage.DBConnection;
import MainPackage.Encryptor;
import java.util.random.*;

public class Admin {
	private String username;
	private String pw;
	private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new Random();
    
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
	public boolean updateApplicantStatus(String status, int nic) {
		try {
			String sql = "UPDATE ApplicantStatus SET passportStatus = ? WHERE userID = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.setInt(2, nic);
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected>0) {
				if(status.equals("Passed")) {
					String sql2 = "INSERT INTO passportHolders VALUES(?,?)";
					PreparedStatement pstmt = conn.prepareStatement(sql2);
					pstmt.setInt(1,nic);
					pstmt.setString(2, generatePassportNumber(10));
					int rowsAffect = pstmt.executeUpdate();
					return true;
				}
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
    public static String generatePassportNumber(int length) {
        StringBuilder sb = new StringBuilder(length);
        // First character is always a letter
        sb.append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())));
        // Remaining characters can be letters or digits
        for (int i = 1; i < length; i++) {
            if (i % 2 == 0) {
                // Even positions can be letters
                sb.append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())));
            } else {
                // Odd positions are digits
                sb.append(RANDOM.nextInt(10));
            }
        }
        return sb.toString();
    }
    public List<ReportGenerate> reportGeneration() {
        List<ReportGenerate> reports = new ArrayList<>();
        int applicantCount = 0;
        int passportCount = 0;
        int rejectedCount = 0;
        try {
            String sql1 = "SELECT COUNT(*) FROM applicant";
            String sql2 = "SELECT COUNT(*) FROM passportHolders";
            String sql3 = "SELECT COUNT(*) FROM ApplicantStatus WHERE passportStatus = 'Rejected'";

            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                applicantCount = rs1.getInt(1);
                System.out.println("Applicant Count: " + applicantCount);
            }

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            ResultSet rs2 = stmt2.executeQuery();
            if (rs2.next()) {
                passportCount = rs2.getInt(1);
                System.out.println("Passport Count: " + passportCount);
            }

            PreparedStatement stmt3 = conn.prepareStatement(sql3);
            ResultSet rs3 = stmt3.executeQuery();
            if (rs3.next()) {
                rejectedCount = rs3.getInt(1);
                System.out.println("Rejected Count: " + rejectedCount);
            }

            reports.add(new ReportGenerate(applicantCount, passportCount, rejectedCount));

            rs1.close();
            stmt1.close();
            rs2.close();
            stmt2.close();
            rs3.close();
            stmt3.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }
	//inner class for object data(report data) initialization
	protected static class ReportGenerate{
		private int applicantCount;
		private int passportCount;
		private int rejectedCount;
		
		public ReportGenerate(int applicantCount, int passportCount, int rejectedCount) {
			this.setApplicantCount(applicantCount);
			this.setPassportCount(passportCount);
			this.setRejectedCount(rejectedCount);
		}

		public int getRejectedCount() {
			return rejectedCount;
		}

		public void setRejectedCount(int rejectedCount) {
			this.rejectedCount = rejectedCount;
		}

		public int getPassportCount() {
			return passportCount;
		}

		public void setPassportCount(int passportCount) {
			this.passportCount = passportCount;
		}

		public int getApplicantCount() {
			return applicantCount;
		}

		public void setApplicantCount(int applicantCount) {
			this.applicantCount = applicantCount;
		}
	}
}
 