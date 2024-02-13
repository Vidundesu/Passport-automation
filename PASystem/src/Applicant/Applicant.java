package Applicant;

import java.sql.Date;

public class Applicant {
	private String firstName;
	private String lastName;
	private int age;
	private String dob;
	private String pob;
	//private RadioButton gender;
	private String fatherName;
	private String motherName;
	private Address address;
	
	public Applicant() {
		this.firstName ="vidun";
		this.lastName="Nethdina";
		this.age=19;
		this.dob="2004-06-12";
		this.address= new Address("53", "piliyandala","piliyandala");
	}
	
	public void setAddress(String no, String road, String city) {
		this.address = new Address(no,road,city);
	}
	public String getAddress() {
		return address.toString();
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public Date getDob() {
//		return dob;
//	}
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
	public String getPob() {
		return pob;
	}
	public void setPob(String pob) {
		this.pob = pob;
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
	
	
}
