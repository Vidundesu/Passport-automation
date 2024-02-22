package MainPackage;
import Applicant.*;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Applicant ap = new Applicant();
		
		List<Applicant> applicants = ap.retrieveApplicantData("rosha");
		if (!applicants.isEmpty()) {
		    Applicant firstApplicant = applicants.get(0);
		    System.out.println("First Applicant:");
		    System.out.println("Name: " + firstApplicant.getUserName());
		    System.out.println("Passport Status: " + firstApplicant.getStatus());
		    System.out.println("Appointment Date: " + firstApplicant.getAppointmentDate());
		} else {
		    System.out.println("No applicants found for the given username.");
		}
	}

}
