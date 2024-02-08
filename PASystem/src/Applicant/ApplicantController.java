package Applicant;

import java.sql.Date;

public class ApplicantController {
	private Applicant model;
	private ApplicantView view;
	
	public ApplicantController(Applicant model, ApplicantView view) {
		this.model= model;
		this.view = view;
	}
	public void setApplicantName(String firstName, String lastName){
		model.setFirstName(firstName);
		model.setLastName(lastName);
	}
	public void setApplicantAge(int age) {
		model.setAge(age);
	}
	public void setApplicantDob(Date date) {
		model.setDob(date);
	}
	public void setApplicantPob(String pob) {
		model.setPob(pob);
	}
	public void setApplicantParents(String fatherName, String motherName) {
		model.setFatherName(fatherName);
		model.setMotherName(motherName);
	}
	//getters
	public String getApplicantFirstName() {
		return model.getFirstName();
	}
	public String getApplicantLastName() {
		return model.getLastName();
	}
	public int getApplicantAge() {
		return model.getAge();
	}
	public Date getApplicantDob() {
		return model.getDob();
	}
	public String getApplicantPob() {
		return model.getPob();
	}
	public String getApplicantFather() {
		return model.getFatherName();
	}
	public String getApplicantMother() {
		return model.getMotherName();	}

}
