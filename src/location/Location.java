package location;

public class Location {
	private int zipCode;
	private int streetNumber;
	private int buildingNumber;
	private String buildingName;
	private String streetName;
	private String city;
	private Province province;

	public Location(int streetNumber, String streetName, String buildingName,
			int buildingNumber, String city, int zipCode, Province province) {
		this.zipCode = zipCode;
		this.streetNumber = streetNumber;
		this.buildingNumber = buildingNumber;
		this.buildingName = buildingName;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
	}

	public Location(int streetNumber, String streetName, String city,
			int zipCode, Province province) {
		this.zipCode = zipCode;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String displayBranch() {
		return "zipCode = " + zipCode + "\n streetNumber = "
				+ streetNumber + "\n buildingNumber = " + buildingNumber
				+ "\n buildingName = " + buildingName + "\n streetName = "
				+ streetName + "\n city = " + city + "\n province = " + province;
	}

	public String displayAddress() {
		return "zipCode = " + zipCode + "\n streetNumber = "
				+ streetNumber + "\n streetName = "
				+ streetName + "\n city = " + city + "\n province = " + province;
	}
	
}
