package src.main.java.gui;

import java.util.Date;

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

public class ViewPane extends Parent{
	
	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private Button cancel;
	private Label nameSurnameL, accNoL, accTypeL, accBalanceL, currentDateL;
	private Label nameSurname, accNo, accType, accBalance, currentDate;
	private final Text actiontarget = new Text();
	private Scene newScene;
	private Date date;
	
	public ViewPane(Stage parent, String fullName, String accNum, String accountType, String accountBal) {
		atmStage = parent;
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(200);
		grid.setVgap(50);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		cancel = new Button("Continue");
		cancel.setMaxSize(300, 100);

		date = new Date();
		
		nameSurnameL = new Label("Account holder:");
		nameSurname = new Label(fullName);
		accNoL = new Label("Account Number:");
		accNo = new Label(accNum);
		accTypeL = new Label("Account Type:");
		accType = new Label(accountType);
		accBalanceL = new Label("Account Balance R:");
		accBalance = new Label(accountBal);
		currentDateL = new Label("Current Date:");
		currentDate = new Label(date.toString());
		
		grid.add(nameSurnameL, 0, 0);
		grid.add(nameSurname, 1, 0);
		grid.add(accNoL, 0, 1);
		grid.add(accNo, 1, 1);
		grid.add(accTypeL, 0, 2);
		grid.add(accType, 1, 2);
		grid.add(accBalanceL, 0, 3);
		grid.add(accBalance, 1, 3);
		grid.add(currentDateL, 0, 4);
		grid.add(currentDate, 1, 4);
		grid.add(cancel, 1, 5);
		grid.add(actiontarget, 0, 5);
		
		actiontarget.setId("actiontarget");
		grid.setId("grid");
//		grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
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
	
	public Parent getViewPane() {
		return root;
	}
}
