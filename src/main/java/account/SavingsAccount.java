package account;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "accountNumber")
public class SavingsAccount extends Accounts implements Serializable{

	private double interestRate;
	private String noticeDate;
	
	public SavingsAccount() {
		this(null, 0, 0, false, null, 0, "Savings", 0, null);
	}

	public SavingsAccount(String accountNumber, double balance, int cardNumber, boolean frozenStatus, String dateCreated, int pinCode, String type,
			double interestRate, String noticeDate) {
		super(accountNumber, balance, cardNumber, frozenStatus, dateCreated, pinCode, type);
		this.interestRate = interestRate;
		this.noticeDate = noticeDate;
		setType("Savings");
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	@Override
	public String toString() {
		return super.toString() + "SavingsAccount [interestRate=" + interestRate + ", noticeDate=" + noticeDate + "]";
	}

}
