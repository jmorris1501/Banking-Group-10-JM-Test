package src.main.java.atm;

public class Notes
{
	private String denomination;
	private int quantity;
	
	public Notes(String denomination, int quantity)
	{
		this.denomination = denomination;
		this.quantity = quantity;
	}

	public String getDenomination()
	{
		return denomination;
	}

	public void setDenomination(String denomination)
	{
		this.denomination = denomination;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	
	
}
