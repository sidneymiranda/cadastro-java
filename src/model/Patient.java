package model;

public class Patient {
	private String name;
	private String dob;
	private String address;
	private String phone;
		
	
	public Patient() {
	}

	public Patient(String name, String dob, String address, String phone) {
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
