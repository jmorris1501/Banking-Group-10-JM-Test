package src.main.java.atm;

import java.util.ArrayList;

import javax.crypto.Mac;

import src.main.java.location.Location;

public class ATM
{
	private Mac macAddress;
	private Location location;
	private ArrayList<Notes> notes;
	
	public ATM(Mac macAddress, Location location, ArrayList<Notes> notes)
	{
		this.macAddress = macAddress;
		this.location = location;
		this.notes = notes;
	}
	
	public Mac getMacAddress()
	{
		return macAddress;
	}
	
	public void setMacAddress(Mac macAddress)
	{
		this.macAddress = macAddress;
	}
	
	
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ArrayList<Notes> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Notes> notes) {
		this.notes = notes;
	}

	public void removeNotes(String note)
	{
		notes.remove(note);
	}
	
	public boolean atmNotes()
	{
		if (notes.isEmpty())
		{
			return false;
		}
		return true;
	}

	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
