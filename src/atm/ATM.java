package atm;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;

import location.Location;
import location.Province;

public class ATM
{
	private Mac macAddress;
	private List<Integer> notes;
	private Location address;

	public ATM(Mac macAddress, Location address)
	{
		this.macAddress = macAddress;
		this.address = address;
		notes = new ArrayList<Integer>();

	}

	public void dispenceAmount(int amount)
	{
		this.calculateDispence(amount);
	}

	public void updateNotes()
	{
		notes.add(0, 500);
		notes.add(1, 500);
		notes.add(2, 500);
		notes.add(3, 500);
		notes.add(4, 500);
	}

	public Mac getMacAddress()
	{
		return macAddress;
	}

	public void setMacAddress(Mac macAddress)
	{
		this.macAddress = macAddress;
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

	private void calculateDispence(int amount)
	{
		int theAmount;
		int oneHundred;
		int twoHundred;
		int fifty;
		int twenty;
		int ten;

		if (amount >= 200)
		{

			theAmount = amount / 200;
			theAmount = theAmount * 200;
			twoHundred = notes.get(0) - theAmount;
			notes.remove(0);
			notes.add(0, twoHundred);
			amount = amount - theAmount;

			if (amount >= 100 && amount < 200)
			{
				theAmount = amount / 100;
				theAmount = theAmount * 100;
				oneHundred = notes.get(1) - theAmount;
				notes.remove(1);
				notes.add(1, oneHundred);
				amount = amount - theAmount;

				if (amount >= 50 && amount < 100)
				{
					theAmount = amount / 50;
					theAmount = theAmount * 50;
					fifty = notes.get(2) - theAmount;
					notes.remove(2);
					notes.add(2, fifty);
					amount = amount - theAmount;

					if (amount >= 20 && amount < 50)
					{
						theAmount = amount / 20;
						theAmount = theAmount * 20;
						twenty = notes.get(3) - theAmount;
						notes.remove(3);
						notes.add(3, twenty);
						amount = amount - theAmount;

						if (amount >= 10)
						{
							theAmount = amount / 10;
							theAmount = theAmount * 10;
							ten = notes.get(4) - theAmount;
							notes.remove(4);
							notes.add(4, ten);
							amount = amount - theAmount;
						}
					}
				}

			}

		}
		else if (amount >= 100 && amount < 200)
		{
			theAmount = amount / 100;
			theAmount = theAmount * 100;
			oneHundred = notes.get(1) - theAmount;
			notes.remove(1);
			notes.add(1, oneHundred);
			amount = amount - theAmount;

			if (amount >= 50 && amount < 100)
			{
				theAmount = amount / 50;
				theAmount = theAmount * 50;
				fifty = notes.get(2) - theAmount;
				notes.remove(2);
				notes.add(2, fifty);
				amount = amount - theAmount;

				if (amount >= 20 && amount < 50)
				{
					theAmount = amount / 20;
					theAmount = theAmount * 20;
					twenty = notes.get(3) - theAmount;
					notes.remove(3);
					notes.add(3, twenty);
					amount = amount - theAmount;

					if (amount >= 10)
					{
						theAmount = amount / 10;
						theAmount = theAmount * 10;
						ten = notes.get(4) - theAmount;
						notes.remove(4);
						notes.add(4, ten);
						amount = amount - theAmount;
					}
				}
			}
		}
		else if (amount >= 50 && amount < 100)
		{
			theAmount = amount / 50;
			theAmount = theAmount * 50;
			fifty = notes.get(2) - theAmount;
			notes.remove(2);
			notes.add(2, fifty);
			amount = amount - theAmount;

			if (amount >= 20 && amount < 50)
			{
				theAmount = amount / 20;
				theAmount = theAmount * 20;
				twenty = notes.get(3) - theAmount;
				notes.remove(3);
				notes.add(3, twenty);
				amount = amount - theAmount;

				if (amount >= 10)
				{
					theAmount = amount / 10;
					theAmount = theAmount * 10;
					ten = notes.get(4) - theAmount;
					notes.remove(4);
					notes.add(4, ten);
					amount = amount - theAmount;
				}
			}
		}
		else if (amount >= 20 && amount < 50)
		{
			theAmount = amount / 20;
			theAmount = theAmount * 20;
			twenty = notes.get(3) - theAmount;
			notes.remove(3);
			notes.add(3, twenty);
			amount = amount - theAmount;

			if (amount >= 10)
			{
				theAmount = amount / 10;
				theAmount = theAmount * 10;
				ten = notes.get(4) - theAmount;
				notes.remove(4);
				notes.add(4, ten);
				amount = amount - theAmount;
			}
		}
		else if (amount >= 10 && amount < 20)
		{
			theAmount = amount / 10;
			theAmount = theAmount * 10;
			ten = notes.get(4) - theAmount;
			notes.remove(4);
			notes.add(4, ten);
			amount = amount - theAmount;
		}

		System.out.println("Done");

	}

	public int getBalance()
	{
		int atmBalance;
		atmBalance = notes.get(0) * 200 + notes.get(1) * 100 + notes.get(2)
				* 50 + notes.get(3) * 20 + notes.get(4) * 10;
		return atmBalance;
	}

}
