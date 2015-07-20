package src.main.java.account;

import java.util.Date;

public abstract class Accounts
{
	private String accountNumber;
	private double balance;
	private String cardNumber;
	private boolean frozenStatus;
	private Date dateCreated;
	private int pinCode;
	private String type;
	private AccountType accType;
	
	public Accounts(String accountNumber, double balance, String cardNumber,
			boolean frozenStatus, Date dateCreated, int pinCode, AccountType type)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.cardNumber = cardNumber;
		this.frozenStatus = frozenStatus;
		this.dateCreated = dateCreated;
		this.pinCode = pinCode;
		this.accType = type;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public String getCardNumber()
	{
		return cardNumber;
	}

	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public boolean isFrozenStatus()
	{
		return frozenStatus;
	}

	public void setFrozenStatus(boolean frozenStatus)
	{
		this.frozenStatus = frozenStatus;
	}

	public Date getDateCreated()
	{
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	public int getPinCode()
	{
		return pinCode;
	}

	public void setPinCode(int pinCode)
	{
		this.pinCode = pinCode;
	}

	public AccountType getAccType() {
		return accType;
	}

	public void setAccType(AccountType accType) {
		this.accType = accType;
	}


	@Override
	public String toString() {
		return "Accounts accountNumber=" + accountNumber + ", balance=" + balance + ", cardNumber=" + cardNumber + ", frozenStatus=" + frozenStatus
				+ ", dateCreated=" + dateCreated + ", pinCode=" + pinCode + ", type=" + type;
	}


	public boolean authenticate(int pinNo) {
		// TODO Auto-generated method stub
		return false;
	}
}
