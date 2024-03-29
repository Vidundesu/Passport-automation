package Applicant;
import MainPackage.DBConnection;
import MainPackage.Encryptor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
	private String username, status;
	private LocalDate appointmentDate;
	private byte[] passportImage;
	private byte[] birthImage;
	
	DBConnection db = new DBConnection();
	private Connection conn = db.connectDB();
	Connection conn2 = db.connectNicDB();
	public Applicant() {
		
	}
	public Applicant(String username, String status, LocalDate appointmentDate) {
		this.username=username;
		this.status=status;
		this.appointmentDate=appointmentDate;
	}
	public String getUserName() {
        return username;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
    
	public Applicant(String firstName, String middleName, String lastName, String fatherName, String motherName,
					String no,String road, String city, int date, int month, int year, String pob, int birthNumber,String email, 
					String mobileNumber, int NIC, byte[] passportImg, byte[] birthImg) {
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
		this.passportImage=passportImg;
		this.birthImage=birthImg;
	}
	
	public byte[] getPassportImage() {
		return passportImage;
	}
	public void setPassportImage(byte[] passportImage) {
		this.passportImage = passportImage;
	}
	public byte[] getBirthImage() {
		return birthImage;
	}
	public void setBirthImage(byte[] birthImage) {
		this.birthImage = birthImage;
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
			String sql = "INSERT INTO Applicant VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			stmt.setBytes(13, passportImage);
			stmt.setBytes(14, birthImage);
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
	            String statusSql = "INSERT INTO ApplicantStatus Values (?,?)";
	            PreparedStatement statusStmt = conn.prepareStatement(statusSql); 
	            statusStmt.setString(1, "Processing");
	            statusStmt.setLong(2, NIC);
	            int statusRowsInserted = statusStmt.executeUpdate(); // Execute the status SQL query
	            if (statusRowsInserted > 0) {
	                System.out.println("Success");
	            } else {
	                System.out.println("Failed to insert into ApplicantStatus table");
	            }
	        } else {
	            System.out.println("Failed to insert into Applicant table");
	        }
	        return true;
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean applicantLoginCredentials(String username, String password, String passkey) {
		try {
			Encryptor encrypt = new Encryptor();
			String sql = "INSERT INTO ApplicantLogin VALUES (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			String hashedPassword = encrypt.encryptString(password);
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
			
			String sql = "SELECT username, password FROM ApplicantLogin WHERE username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				Encryptor encrypt = new Encryptor();
				String usernameDB = result.getString("username");
				String passwordDB = result.getString("password");
				
				if (encrypt.passwordVerification(password, passwordDB)) {
                    System.out.println("User logged: " + username);
                    return true;
                } else {
                    return false;
                }
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public List<Applicant> retrieveApplicantData(String username) {
		List<Applicant> applicants = new ArrayList<>();
		try {
			
			String sql = "SELECT firstName, passportStatus, appointmentDate " +
		             "FROM applicant ap " +
		             "LEFT JOIN applicantLogin al ON ap.NIC = al.userID " +
		             "LEFT JOIN applicantStatus ast ON ap.NIC = ast.userID " +
		             "LEFT JOIN applicantAppointment apa ON ap.NIC = apa.userID " +
		             "WHERE username = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				String userName = result.getString("firstName");
				String status = result.getString("passportStatus");
				LocalDate appointmentDate = result.getDate("appointmentDate").toLocalDate();
				applicants.add(new Applicant(userName, status, appointmentDate));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return applicants;
	}
	public boolean applicantAppointment(String username, LocalDate apDate) {
	    int id;
	    try {
	       
	        String getUserIdSQL = "SELECT userID FROM ApplicantLogin WHERE username = ?";
	        PreparedStatement stmt = conn.prepareStatement(getUserIdSQL);
	        stmt.setString(1, username);
	        ResultSet result = stmt.executeQuery();
	        if (result.next()) {
	            id = result.getInt("userID");
	        } else {
	            System.out.println("Username not found");
	            return false;
	        }
	        stmt.close();

	        String insertAppointmentSQL = "INSERT INTO ApplicantAppointment VALUES (?, ?)";
	        PreparedStatement insertApStmt = conn.prepareStatement(insertAppointmentSQL);
	        insertApStmt.setDate(1, java.sql.Date.valueOf(apDate));
	        insertApStmt.setInt(2, id);
	        int rows = insertApStmt.executeUpdate();
	        
	        if (rows > 0) {
	            System.out.println("Appointment scheduled");
	            return true;
	        } else {
	            System.out.println("Failed to schedule appointment");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
}
