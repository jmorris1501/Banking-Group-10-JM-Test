package people;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import location.Location;
import location.Province;

//@Entity
//@Table
//@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable
{
//	@Id
//	@GeneratedValue
	private int idNumber;
	private String name;
	private String surname;
	private String dateJoined;
//	@OneToOne(mappedBy = "person")
	private Location branch;
	
	
	public Person(int idNumber, String name, String surname, String dateJoined, Location branch)
	{
		
		this.name = name;
		this.surname = surname;
		this.dateJoined = dateJoined;
		this.branch = branch;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getDateJoined()
	{
		return dateJoined;
	}

	public void setDateJoined(String dateJoined)
	{
		this.dateJoined = dateJoined;
	}

	public Location getBranch()
	{
		return branch;
	}

	public void setBranch(Location branch)
	{
		this.branch = branch;
	}
	
	
	
	
}
