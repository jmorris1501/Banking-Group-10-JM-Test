package atm;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class Notes implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String denomination;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "macAddress")
	private ATM atm;

	public Notes(String denomination, int quantity) {
		this.denomination = denomination;
		this.quantity = quantity;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
