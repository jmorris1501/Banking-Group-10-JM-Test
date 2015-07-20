package src.main.java.people;

import java.util.Date;

import src.main.java.location.Location;

public class Employee extends Person {
	private String employeeID;
	private String employeePassword;

	public Employee(String name, String surname, Date dateJoined,
			String idNumber, Location address, Location branch,
			String employeeID, String employeePassword) {
		super(name, surname, dateJoined, idNumber, address, branch);
		this.employeeID = employeeID;
		this.employeePassword = employeePassword;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

}
