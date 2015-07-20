package location;

import java.io.Serializable;

import javax.persistence.*;

import people.Client;
import people.Person;
import atm.ATM;

//@Entity
//@Table
public class Location implements Serializable
{
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int zipCode;
	private int streetNumber;
	private int buildingNumber;
	private String buildingName;
	private String streetName;
	private String city;
	private Province province;
//	@OneToOne
//	@PrimaryKeyJoinColumn
	private ATM atm;
//	@OneToOne
//	@PrimaryKeyJoinColumn
	private Person person;
	
	
	
	public Location() {
		this(0, null, null, 0, null, 0, Province.GAUTENG);
	}
	public Location(int streetNumber,String streetName,String buildingName, int buildingNumber,
			String city,int zipCode,Province province)
	{
		this.zipCode = zipCode;
		this.streetNumber = streetNumber;
		this.buildingNumber = buildingNumber;
		this.buildingName = buildingName;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
	}
	public int getZipCode()
	{
		return zipCode;
	}
	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}
	public int getStreetNumber()
	{
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber)
	{
		this.streetNumber = streetNumber;
	}
	public int getBuildingNumber()
	{
		return buildingNumber;
	}
	public void setBuildingNumber(int buildingNumber)
	{
		this.buildingNumber = buildingNumber;
	}
	public String getStreetName()
	{
		return streetName;
	}
	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public Province getProvince()
	{
		return province;
	}
	public void setProvince(Province province)
	{
		this.province = province;
	}
	public String getBuildingName()
	{
		return buildingName;
	}
	public void setBuildingName(String buildingName)
	{
		this.buildingName = buildingName;
	}
	
	
	
}
