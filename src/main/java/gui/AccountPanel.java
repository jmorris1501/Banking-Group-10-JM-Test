package src.main.java.gui;

import src.main.java.account.Accounts;
import src.main.java.account.CurrentAccount;
import src.main.java.account.SavingsAccount;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AccountPanel extends Parent {

	private Button freezeB, unfreezeB, saveB, cancelB;
	private Label accNoL, cardNoL, balanceL, frozenL, dateL;
	private Label caMonthlyChargeL, caWithdrawalChargeL, caDailyLimitL;
	private Label saInterestRateL, saNoticeDateL;
	private TextField accNoF, cardNoF, balanceF, frozenF, dateF;
	private TextField caMonthlyChargeF, caWithdrawalChargeF, caDailyLimitF;
	private TextField saInterestRateF, saNoticeDateF;
	private GridPane grid;
	private Parent root;
	private Accounts account;

	public AccountPanel(CurrentAccount ca) {
		account = ca;

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(5, 5, 5, 5));

		freezeB = new Button("Freeze Account");
		unfreezeB = new Button("Unfreeze Account");
		saveB = new Button("Save Account");
		cancelB = new Button("Cancel");

		accNoL = new Label("Account Number : ");
		cardNoL = new Label("Card Number : ");
		balanceL = new Label("Balance : ");
		frozenL = new Label("Frozen Status : ");
		dateL = new Label("Date : ");

		caMonthlyChargeL = new Label("Monthly Charge : ");
		caWithdrawalChargeL = new Label("Withdrawal Charge : ");
		caDailyLimitL = new Label("Daily Limit : ");

		accNoF = new TextField(account.getAccountNumber());
		cardNoF = new TextField("" + account.getCardNumber());
		balanceF = new TextField("" + account.getBalance());
		frozenF = new TextField("" + account.isFrozenStatus());
		dateF = new TextField("" + account.getDateCreated());

		caMonthlyChargeF = new TextField("" + ((CurrentAccount)account).getMonthlyCharge());
		caWithdrawalChargeF = new TextField("" + ((CurrentAccount)account).getWithdrawelCharge());
		caDailyLimitF = new TextField("" + ((CurrentAccount)account).getDailyLimit());

		grid.add(accNoL, 0, 0);
		grid.add(accNoF, 1, 0);
		grid.add(cardNoL, 2, 0);
		grid.add(cardNoF, 3, 0);
		grid.add(balanceL, 0, 1);
		grid.add(balanceF, 1, 1);
		grid.add(frozenL, 2, 1);
		grid.add(frozenF, 3, 1);
		grid.add(dateL, 0, 2);
		grid.add(dateF, 1, 2);
		grid.add(caMonthlyChargeL, 2, 2);
		grid.add(caMonthlyChargeF, 3, 2);
		grid.add(caWithdrawalChargeL, 0, 3);
		grid.add(caWithdrawalChargeF, 1, 3);
		grid.add(caDailyLimitL, 2, 3);
		grid.add(caDailyLimitF, 3, 3);

		grid.add(freezeB, 4, 0);
		grid.add(unfreezeB, 4, 1);
		grid.add(saveB, 4, 2);
		grid.add(cancelB, 4, 3);
/**
		grid.setId("grid");

		grid.getStylesheets().add(
				atmGUI.class.getResource("teller.css").toExternalForm());
*/
		root = grid;
	}

	public AccountPanel(SavingsAccount sa) {
		account = sa;

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(5, 5, 5, 5));

		freezeB = new Button("Freeze Account");
		unfreezeB = new Button("Unfreeze Account");
		saveB = new Button("Save Account");
		cancelB = new Button("Cancel");

		accNoL = new Label("Account Number : ");
		cardNoL = new Label("Card Number : ");
		balanceL = new Label("Balance : ");
		frozenL = new Label("Frozen Status : ");
		dateL = new Label("Date : ");

		accNoF = new TextField(account.getAccountNumber());
		cardNoF = new TextField("" + account.getCardNumber());
		balanceF = new TextField("" + account.getBalance());
		frozenF = new TextField("" + account.isFrozenStatus());
		dateF = new TextField("" + account.getDateCreated());

		saInterestRateL = new Label("Interest Rate : ");
		saNoticeDateL = new Label("Notice Date : ");

		saInterestRateF = new TextField("" + ((SavingsAccount)account).getInterestRate());
		saNoticeDateF = new TextField("" + ((SavingsAccount)account).getNoticeDate());

		grid.add(accNoL, 0, 0);
		grid.add(accNoF, 1, 0);
		grid.add(cardNoL, 2, 0);
		grid.add(cardNoF, 3, 0);
		grid.add(balanceL, 0, 1);
		grid.add(balanceF, 1, 1);
		grid.add(frozenL, 2, 1);
		grid.add(frozenF, 3, 1);
		grid.add(dateL, 0, 2);
		grid.add(dateF, 1, 2);

		grid.add(saInterestRateL, 2, 2);
		grid.add(saInterestRateF, 3, 2);
		grid.add(saNoticeDateL, 0, 3);
		grid.add(saNoticeDateF, 1, 3);

		grid.add(freezeB, 4, 0);
		grid.add(unfreezeB, 4, 1);
		grid.add(saveB, 4, 2);
		grid.add(cancelB, 4, 3);
/**
		grid.setId("grid");

		grid.getStylesheets().add(
				atmGUI.class.getResource("teller.css").toExternalForm());
*/
		root = grid;
	}

	public Parent getAccountPanel() {
		return root;
	}
}
