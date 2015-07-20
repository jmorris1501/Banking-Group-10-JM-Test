package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatementPane {
	
	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private Label transactions, statements;
	private Button week1, week2, week4, month1, month2, month3, cancel;
	private final Text actiontarget = new Text();
	private Scene newScene;
	
	public StatementPane(Stage parent) {
		atmStage = parent;
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(200);
		grid.setVgap(50);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		transactions = new Label("Transactions");
		statements = new Label("Statements");
		
		week1 = new Button("1 Week");
		week1.setMaxSize(300, 100);
		week2 = new Button("2 Weeks");
		week2.setMaxSize(300, 100);
		week4 = new Button("4 Weeks");
		week4.setMaxSize(300, 100);
		month1 = new Button("1 Month");
		month1.setMaxSize(300, 100);
		month2 = new Button("2 Months");
		month2.setMaxSize(300, 100);
		month3 = new Button("4 Months");
		month3.setMaxSize(300, 100);
		cancel = new Button("Continue");
		cancel.setMaxSize(300, 100);

		grid.add(transactions, 0, 0);
		grid.add(statements, 1, 0);
		grid.add(week1, 0, 1);
		grid.add(week2, 0, 2);
		grid.add(week4, 0, 3);
		grid.add(month1, 1, 1);
		grid.add(month2, 1, 2);
		grid.add(month3, 1, 3);
		grid.add(cancel, 1, 4);
		grid.add(actiontarget, 0, 4);
		
		actiontarget.setId("actiontarget");
		grid.setId("grid");
//		grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				LoginPane login = new LoginPane(atmStage);
				MessagePane mp = new MessagePane(atmStage, "Cancelling...", login.getLoginPane(), 800, 600);
				newScene = new Scene(mp.getMessagePane(), 800, 600);
				atmStage.setScene(newScene);
				/**
				actiontarget.setText("exit button pressed");
				LoginPane login = new LoginPane(atmStage);
				newScene = new Scene(login.getLoginPane(), 800, 600);
				atmStage.setScene(newScene);
				*/
			}
		});

		root = grid;
	}
	
	public Parent getStatementPane() {
		return root;
	}
}
