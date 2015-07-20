package people;

import java.util.Date;

import location.Location;

public abstract class Person {
	private String name;
	private String surname;
	private Date dateJoined;
	private String idNumber;
	private Location address;
	private Location branch;

	public Person(String name, String surname, Date dateJoined,
			String idNumber, Location address, Location branch) {

		this.name = name;
		this.surname = surname;
		this.dateJoined = dateJoined;
		this.idNumber = idNumber;
		this.address = address;
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getAddress() {
		return address.displayAddress();
	}

	public void setAddress(Location address) {
		this.address = address;
	}

	public String getBranch() {
		return branch.displayBranch();
	}

	public void setBranch(Location branch) {
		this.branch = branch;
	}

}
