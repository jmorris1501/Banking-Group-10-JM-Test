package atm;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;

import javax.crypto.Mac;
import javax.persistence.*;

import location.Location;
import location.Province;

@Entity
@Table
public class ATM implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String macAddress;
	@OneToMany(mappedBy = "atm")
	private Set<Notes> notes;
//	@OneToOne(mappedBy = "atm")
//	private Location location;

	public ATM(int streetNumber, String streetName, String buildingName, int buildingNumber, String city, int zipCode, Province province,
			String macAddress, Set<Notes> notes) {
		this.macAddress = macAddress;
		this.notes = notes;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress() {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			macAddress = sb.toString();
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void removeNotes(String note) {
		notes.remove(note);
	}

	public boolean atmNotes() {
		if (notes.isEmpty()) {
			return false;
		}
		return true;
	}

	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
