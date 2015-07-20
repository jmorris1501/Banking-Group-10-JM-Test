package src.main.java.people;

import java.util.Date;

import src.main.java.location.Location;

public class Admin extends Person {
	private int adminCardNumber;
	private int adminCode;

	public Admin(String name, String surname, Date dateJoined, String idNumber,
			Location address, Location branch, int adminCardNumber,
			int adminCode) {
		super(name, surname, dateJoined, idNumber, address, branch);
		this.adminCardNumber = adminCardNumber;
		this.adminCode = adminCode;
	}

	public int getAdminCardNumber() {
		return adminCardNumber;
	}

	public void setAdminCardNumber(int adminCardNumber) {
		this.adminCardNumber = adminCardNumber;
	}

	public int getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(int adminCode) {
		this.adminCode = adminCode;
	}

}
