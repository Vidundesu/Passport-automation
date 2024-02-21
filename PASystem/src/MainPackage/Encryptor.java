package MainPackage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
	private String password;
	private String hashedPassword;
	
	public Encryptor(String password) throws NoSuchAlgorithmException {
		this.password=password;
		encryptString();
	}
	public String encryptString() throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(password.getBytes());
		BigInteger bigint = new BigInteger(1, messageDigest);
		hashedPassword = bigint.toString(16);
		return hashedPassword;
	}
	public boolean passwordVerification(String password) {
		
		try {
			if(encryptString().equals(hashedPassword)) {
				System.out.println(hashedPassword);
				return true;
			}else {
				System.out.println("no");
				return false;
			}
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
