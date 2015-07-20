package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainPane extends Parent {

	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private Button withdraw, deposit, transfer, changePin, viewBalances,
			statements, exit;
	private final Text actiontarget = new Text();
	private Scene newScene;

	public MainPane(Stage parent) {
		atmStage = parent;
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(400);
		grid.setVgap(100);
		grid.setPadding(new Insets(10, 10, 10, 10));

		withdraw = new Button("Withdraw");
		withdraw.setMaxSize(300, 100);
		deposit = new Button("Deposit");
		deposit.setMaxSize(300, 100);
		transfer = new Button("Transfer");
		transfer.setMaxSize(300, 100);
		changePin = new Button("Change PIN");
		changePin.setMaxSize(300, 100);
		viewBalances = new Button("View Balances");
		viewBalances.setMaxSize(300, 100);
		statements = new Button("Statements");
		statements.setMaxSize(300, 100);
		exit = new Button("Exit");
		exit.setMaxSize(300, 100);

		grid.add(withdraw, 0, 0);
		grid.add(deposit, 1, 0);
		grid.add(transfer, 0, 1);
		grid.add(changePin, 1, 1);
		grid.add(viewBalances, 0, 2);
		grid.add(statements, 1, 2);
		grid.add(exit, 1, 3);
		grid.add(actiontarget, 0, 3);

		actiontarget.setId("actiontarget");
		grid.setId("grid");
//		grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());

		withdraw.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				actiontarget.setText("withdraw button pressed");
				AccountChoicePane accChPn = new AccountChoicePane(atmStage, "withdraw");
				newScene = new Scene(accChPn.getAccountChoicePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		deposit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				actiontarget.setText("deposit button pressed");
				AccountChoicePane accChPn = new AccountChoicePane(atmStage, "deposit");
				newScene = new Scene(accChPn.getAccountChoicePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		transfer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				actiontarget.setText("transfer button pressed");
				AccountChoicePane accChPn = new AccountChoicePane(atmStage, "transfer");
				newScene = new Scene(accChPn.getAccountChoicePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		changePin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				actiontarget.setText("changePin button pressed");
				ChangePinPane chngPnPn = new ChangePinPane(atmStage);
				newScene = new Scene(chngPnPn.getChangePinPane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		viewBalances.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				actiontarget.setText("viewBalances button pressed");
				AccountChoicePane accChPn = new AccountChoicePane(atmStage, "viewBalance");
				newScene = new Scene(accChPn.getAccountChoicePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		statements.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				actiontarget.setText("statements button pressed");
				StatementPane sp = new StatementPane(atmStage);
				newScene = new Scene(sp.getStatementPane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				actiontarget.setText("exit button pressed");
				LoginPane login = new LoginPane(atmStage);
				MessagePane mp = new MessagePane(atmStage, "Exiting...", login.getLoginPane(), 800, 600);
				newScene = new Scene(mp.getMessagePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});

		root = grid;
	}

	public Parent getMainPane() {
		return root;
	}
}
