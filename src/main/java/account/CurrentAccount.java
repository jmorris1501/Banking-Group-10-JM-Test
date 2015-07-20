package account;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "accountNumber")
public class CurrentAccount extends Accounts implements Serializable
{
	
	private double monthlyCharge;
	private double withdrawlCharge;
	private double dailyLimit;
	
	public CurrentAccount() {
		this(null, 0, 0, false, null, 0, "Current", 0, 0, 0);
	}

	public CurrentAccount(String accountNumber, double balance, int cardNumber,
			boolean frozenStatus, String dateCreated, int pinCode, String type,
			double monthlyCharge, double withdrawlCharge, double dailyLimit)
	{
		super(accountNumber, balance, cardNumber, frozenStatus, dateCreated,
				pinCode, type);
		this.monthlyCharge = monthlyCharge;
		this.withdrawlCharge = withdrawlCharge;
		this.dailyLimit = dailyLimit;
		setType("Current");
	}

	public double getMonthlyCharge()
	{
		return monthlyCharge;
	}

	public void setMonthlyCharge(double mounthlyCharge)
	{
		this.monthlyCharge = mounthlyCharge;
	}

	public double getWithdrawlCharge()
	{
		return withdrawlCharge;
	}

	public void setWithdrawlCharge(double withdrawlCharge)
	{
		this.withdrawlCharge = withdrawlCharge;
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
		return super.toString() + "CurrentAccount monthlyCharge=" + monthlyCharge + ", withdrawlCharge=" + withdrawlCharge + ", dailyLimit=" + dailyLimit;
	}
}
