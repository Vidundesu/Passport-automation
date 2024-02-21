package MainPackage;
import Applicant.*;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		DBConnection db = new DBConnection();
		Encryptor encrypt = new Encryptor("vidun123");
		String pw = "vidun123";
		encrypt.passwordVerification(pw);
		
	}

}
