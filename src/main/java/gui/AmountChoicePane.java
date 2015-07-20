package src.main.java.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AmountChoicePane extends Parent{
	
	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private Button cancel, confirm;
	private TextField amount;
	private final Text actiontarget = new Text();
	private String choice;
	private String account;
	private Label indicator, currency;
	private String message;
	
	public AmountChoicePane(Stage parent, String pressed, String accountType) {
		atmStage = parent;
		choice = pressed;
		account = accountType;
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(100);
		grid.setVgap(50);
		grid.setPadding(new Insets(10, 10, 10, 10));

		currency = new Label("R");
		
		amount = new TextField("0.00");
		amount.setFont(new Font("Arial Black", 22));
		amount.setMaxWidth(400);
		amount.setAlignment(Pos.CENTER_RIGHT);
		
		confirm = new Button("Confirm");
		confirm.setMaxSize(300, 100);
		cancel = new Button("Cancel");
		cancel.setMaxSize(300, 100);
		
		if(choice.contains("withdraw")) {
			indicator = new Label("Please enter the amount you \nwish to Withdraw from " + account + " Account:");
		} else if(choice.contains("deposit")) {
			indicator = new Label("Please enter the amount you \nwish to Deposit to " + account + " Account:");
		} else if(choice.contains("transfer")) {
			indicator = new Label("Please enter the amount you \nwish to Transfer to " + account + " Account:");
		} else if(choice.contains("viewBalance")) {
			indicator = new Label("View Balance of:");
		}
		
		indicator.setAlignment(Pos.CENTER_RIGHT);
		
		grid.add(indicator, 0, 0, 3, 1);
		grid.add(currency, 0, 1);
		grid.add(amount, 1, 1, 2, 1);
		grid.add(actiontarget, 0, 2, 2, 1);
		
		cancel.setAlignment(Pos.BOTTOM_RIGHT);
		
		grid.add(confirm, 0, 3);
		grid.add(cancel, 1, 3);		
		
		amount.setOnKeyTyped(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				if (!"0123456789.".contains(ke.getCharacter())) {
					ke.consume();
				} /**else if (amount.getText().length() >= 16) {
					ke.consume();
				} */else if (ke.getCode() == KeyCode.ENTER) {
					amount.requestFocus();
				}
				else if (ke.getCode() == KeyCode.DELETE) {
					ke.consume();
				}
			}
		});
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(choice.contains("withdraw")) {
					message = "R " + amount.getText() + " withdrawn from " + account + " account";
				} else if(choice.contains("deposit")) {
					message = "R " + amount.getText() + " deposited to " + account + " account";
				} else if(choice.contains("transfer")) {
					message = "R " + amount.getText() + " transfered to " + account + " account";
				} else if(choice.contains("viewBalance")) {
					message = "R " + amount.getText() + " withdrawn from " + account + " account";
				}
				LoginPane login = new LoginPane(atmStage);
				MessagePane mp = new MessagePane(atmStage, message, login.getLoginPane(), 800, 600);
				Scene newScene = new Scene(mp.getMessagePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(choice.contains("withdraw")) {
					message = "Withdrawal Canceled!";
				} else if(choice.contains("deposit")) {
					message = "Deposit Canceled!";
				} else if(choice.contains("transfer")) {
					message = "Transfer Canceled!";
				} else if(choice.contains("viewBalance")) {
					message = "Viewing Canceled!";
				}
				MessageChoicePane mcp = new MessageChoicePane(atmStage, message);
				Scene newScene = new Scene(mcp.getMessageChoicePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		
		actiontarget.setId("actiontarget");
		indicator.setId("indicator");
		grid.setId("grid");
//		grid.setGridLinesVisible(true);
		
		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());
		
		root = grid;
	}
	
	public Parent getAmountChoicePane() {
		return root;
	}
}
