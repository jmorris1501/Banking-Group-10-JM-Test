package people;

import java.util.ArrayList;
import java.util.Date;

import location.Location;
import account.Accounts;

public class Client extends Person {

	private ArrayList<Accounts> accounts;

	public Client(String name, String surname, Date dateJoined,
			String idNumber, Location address, Location branch,
			ArrayList<Accounts> accounts) {
		super(name, surname, dateJoined, idNumber, address, branch);
		this.accounts = accounts;
	}

	public ArrayList<Accounts> getAccounts() {
		return accounts;
	}

	public void addAccount(Accounts account) {
		try {
			if (accounts.contains(account)) {
				accounts.remove(account);
			} else {
				accounts.add(account);
			}
		} catch (Exception theException) {
			theException.printStackTrace();
		}
	}

	public void removeAcount(String accountNumber) {
		for (Accounts items : accounts) {
			if (items.getAccountNumber().equals(accountNumber)) {
				try {
					accounts.remove(items);
				} catch (Exception theException) {
					theException.printStackTrace();
				}
			}
		}
	}

}
