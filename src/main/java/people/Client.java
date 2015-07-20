package people;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import location.Location;
import location.Province;
import account.Accounts;

//@Entity
//@Table
//@PrimaryKeyJoinColumn(name = "idNumber")
public class Client extends Person implements Serializable {

//	@OneToMany(mappedBy = "person")
	private Set<Accounts> accounts;

	public Client(int idNumber, String name, String surname, String dateJoined, Location branch, Set<Accounts> accounts, Location address) {
		super(idNumber, name, surname, dateJoined, branch);
		this.accounts = accounts;
	}

	public Set<Accounts> getAccounts() {
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
