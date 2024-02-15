package Applicant;

import java.sql.Date;

public class Applicant {
	private String firstName;
	private String lastName;
	private int age;
	private Date dob;
	private String pob;
	private String gender;
	
	private String fatherName;
	private String motherName;
	private Address address;

	
	
	public Applicant(String firstName, String lastName, int age, Date dob, String pob, String fatherName,String motherName, String no, String road, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
		this.pob = pob;
		this.fatherName = fatherName;
		this.motherName = motherName;
//		this.address.no=no;
//		this.address.road=road;
//		this.address.city=city;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
