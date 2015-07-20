package src.main.java.account;

import java.util.Date;

public class CurrentAccount extends Accounts
{
	private double monthlyCharge;
	private double withdrawelCharge;
	private double dailyLimit;
		
	public CurrentAccount(String accountNumber, double balance, String cardNumber,
			boolean frozenStatus, Date dateCreated, int pinCode, AccountType accType,
			double monthlyCharge, double withdrawelCharge, double dailyLimit)
	{
		super(accountNumber, balance, cardNumber, frozenStatus, dateCreated,
				pinCode, accType);
		this.monthlyCharge = monthlyCharge;
		this.withdrawelCharge = withdrawelCharge;
		this.dailyLimit = dailyLimit;
	}

	public double getMonthlyCharge()
	{
		return monthlyCharge;
	}

	public void setMonthlyCharge(double monthlyCharge)
	{
		this.monthlyCharge = monthlyCharge;
	}

	public double getWithdrawelCharge()
	{
		return withdrawelCharge;
	}

	public void setWithdrawelCharge(double withdrawelCharge)
	{
		this.withdrawelCharge = withdrawelCharge;
	}

	public double getDailyLimit()
	{
		return dailyLimit;
	}

	public void setDailyLimit(double dailyLimit)
	{
		this.dailyLimit = dailyLimit;
	}

	@Override
	public String toString() {
		return super.toString() + "CurrentAccount mounthlyCharge=" + monthlyCharge + ", withdrawelCharge=" + withdrawelCharge + ", dailyLimit=" + dailyLimit;
	}
}
