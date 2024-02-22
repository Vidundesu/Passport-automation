package Applicant;
import MainPackage.DBConnection;
import MainPackage.Encryptor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JOptionPane;

public class Applicant {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private String motherName;
	private Address address;
	private String birthDate;
	private String pob;
	private int birthNumber;
	private String email;
	private String mobileNumber;
	private int NIC;
	
	DBConnection db = new DBConnection();
	private Connection conn = db.connectDB();
	Connection conn2 = db.connectNicDB();
	public Applicant() {
		conn = db.connectDB();
		conn = db.connectNicDB();
	}
	public Applicant(String firstName, String middleName, String lastName, String fatherName, String motherName,
					String no,String road, String city, int date, int month, int year, String pob, int birthNumber,String email, 
					String mobileNumber, int NIC) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = new Address(no, road, city);
		this.birthDate=String.format("%04d-%02d-%02d", year, month, date);
		this.pob = pob;
		this.birthNumber = birthNumber;
		this.email=email;
		this.mobileNumber = mobileNumber;
		this.NIC=NIC;
		
	}
	
	public int getNIC() {
		return NIC;
	}

	public void setNIC(int nIC) {
		NIC = nIC;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address.toString();
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setBirthDate(int date, int month, int year) {
		this.birthDate=String.format("%04d-%02d-%02d", year, month, date);
	}
	public String getBirthDate() {
		return birthDate;
	}
	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public int getBirthNumber() {
		return birthNumber;
	}

	public void setBirthNumber(int birthNumber) {
		this.birthNumber = birthNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	

	public boolean applicantNicVerification() {
	    try {
	        String sql = "SELECT NIC, lastName FROM NationalTable WHERE NIC=?";
	        PreparedStatement stmt = conn2.prepareStatement(sql);
	        stmt.setLong(1, NIC);
	        ResultSet result = stmt.executeQuery();
	        
	        if (result.next()) {
	            int nicT = result.getInt("NIC");
	            String lastNameT = result.getString("lastName");
	            
	            if (nicT == NIC && lastNameT.equals(lastName)) {
	            	applicantVerification();
	                System.out.println("Verification successful");
	                return true;
	            } else {
	                System.out.println("Mismatch");
	                return false;
	            }
	        } else {
	            System.out.println("Applicant not found");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println(e);
	        return false;
	    }
	}

	public boolean applicantVerification() {
		try {
			String sql = "SELECT NIC FROM Applicant WHERE NIC=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, NIC);
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				JOptionPane.showMessageDialog(null, "You're already registered in the System");
				stmt.close();
				conn.close();
			}else {
				applicantRegister();
			}
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean applicantRegister() {
	
		try {
			String sql = "INSERT INTO Applicant VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, firstName);
			stmt.setString(2, middleName);
			stmt.setString(3, lastName);
			stmt.setString(4, birthDate);
			stmt.setString(5, pob);
			stmt.setInt(6,birthNumber);
			stmt.setString(7, email);
			stmt.setString(8,mobileNumber);
			stmt.setString(9,getAddress());
			stmt.setString(10, fatherName);
			stmt.setString(11, motherName);
			stmt.setLong(12, NIC);
			int rowsInserted = stmt.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("success");
			}else {
				System.out.println("fail");
			}
			return true;
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean applicantLoginCredentials(String username, String password, String passkey) {
		try {
			Encryptor encrypt = new Encryptor(password);
			String sql = "INSERT INTO ApplicantLogin VALUES (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			String hashedPassword = encrypt.encryptString();
			stmt.setString(1, username);
			stmt.setString(2, hashedPassword);
			stmt.setString(3, passkey);
			stmt.setLong(4, NIC);
			
			int rowsInserted = stmt.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("ok pass");
				conn.close();
				conn2.close();
				return true;
			}else {
				return false;
			}
					
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean applicantLogin(String username, String password) {
		try {
			Encryptor encrypt = new Encryptor(password);
			String sql = "SELECT password FROM ApplicantLogin WHERE username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				
			}
		}catch(Exception e) {
			
		}
	}
	
	
	
}
