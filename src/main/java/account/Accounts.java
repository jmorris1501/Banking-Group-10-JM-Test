package account;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import people.Person;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Accounts implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String accountNumber;
	private double balance;
	private int cardNumber;
	private boolean frozenStatus;
	private String dateCreated;
	private int pinCode;
//	@ManyToOne
//	@JoinColumn(name = "idNumber")
//	private Person person;

	@Transient
	private String type;

	public Accounts(String accountNumber, double balance, int cardNumber, boolean frozenStatus, String dateCreated, int pinCode, String type) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.frozenStatus = frozenStatus;
		this.dateCreated = dateCreated;
		this.pinCode = pinCode;
	}

//	public Person getPerson() {
//		return person;
//	}
//
//	public void setPerson(Person person) {
//		this.person = person;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public boolean isFrozenStatus() {
		return frozenStatus;
	}

	public void setFrozenStatus(boolean frozenStatus) {
		this.frozenStatus = frozenStatus;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public boolean authenticate(int pinNo) {
		if (getPinCode() == pinNo) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Accounts accountNumber=" + accountNumber + ", balance=" + balance + ", cardNumber=" + cardNumber + ", frozenStatus=" + frozenStatus
				+ ", dateCreated=" + dateCreated + ", pinCode=" + pinCode + ", type=" + type;
	}

}
