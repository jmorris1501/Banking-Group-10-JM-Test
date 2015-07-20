package src.main.java.account;

import java.util.Date;

public class SavingsAccount extends Accounts {

	private double interestRate;
	private Date noticeDate;
//<<<<<<< Upstream, based on origin/networking_and_databasing
	public SavingsAccount(String accountNumber, double balance, String cardNumber,
			boolean frozenStatus, Date dateCreated, int pinCode, AccountType accType,
			double interestRate, Date noticeDate)
	{
		super(accountNumber, balance, cardNumber, frozenStatus, dateCreated,
				pinCode, accType);
//>>>>>>> 749ed16 account panel nearly working
		this.interestRate = interestRate;
		this.noticeDate = noticeDate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	@Override
	public String toString() {
		return super.toString() + "SavingsAccount [interestRate=" + interestRate + ", noticeDate=" + noticeDate + "]";
	}

}
