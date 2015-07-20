package people;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import location.Location;
import location.Province;

//@Entity
//@Table
//@PrimaryKeyJoinColumn(name = "idNumber")
public class Admin extends Person implements Serializable {

	private int adminCardNumber;
	private int adminCode;

	public Admin(int idNumber, String name, String surname, String dateJoined, Location branch, int adminCardNumber, int adminCode) {
		super(idNumber, name, surname, dateJoined, branch);
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
