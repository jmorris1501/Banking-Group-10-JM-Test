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
public class Employee extends Person implements Serializable {

	private String employeeID;
	private String employeePassword;

	public Employee(int idNumber, String name, String surname, String dateJoined, Location branch, String employeeID, String employeePassword) {
		super(idNumber, name, surname, dateJoined, branch);
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
