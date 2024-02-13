package Applicant;

public class Address {
	private String no;
	private String road;
	private String city;
	
	public Address(String no, String road, String city) {
		this.no=no;
		this.road=road;
		this.city=city;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return ""+no+", "+road+", "+city+".";
	}
}
