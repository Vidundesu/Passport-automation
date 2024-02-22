package MainPackage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
	private String password;
	private String hashedPassword;
	
	public String encryptString(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(password.getBytes());
		BigInteger bigint = new BigInteger(1, messageDigest);
		hashedPassword = bigint.toString(16);
		return hashedPassword;
	}
	public void setHashed(String hashedpw) {
		this.hashedPassword=hashedpw;
	}
	public boolean passwordVerification(String password, String hashedPassword) {
        try {
            return encryptString(password).equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); 
            return false;
        }
    }
}
