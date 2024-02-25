package MainPackage;
import Applicant.*;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.List;

import Admin.Admin;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Application applicationMain = new Application();
		applicationMain.main(null);
	}

}
