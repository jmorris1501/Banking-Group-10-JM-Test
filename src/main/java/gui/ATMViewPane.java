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

public class ATMViewPane {
	
	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private Button cancel;
	private Label atmMacL, atmLocationL, atmNotesL, currentDateL;
	private Label atmMac, atmLocation, atmNotes, currentDate;
	private final Text actiontarget = new Text();
	private Scene newScene;
	private Date date;
	
	public ATMViewPane(Stage parent, String atmMacAd, String atmLocAd, String atmNoteA) {
		atmStage = parent;
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(200);
		grid.setVgap(50);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		cancel = new Button("Continue");
		cancel.setMaxSize(300, 100);

		date = new Date();
		
		atmMacL = new Label("ATM MAC Address:");
		atmMac = new Label(atmMacAd);
		atmLocationL = new Label("ATM Location:");
		atmLocation = new Label(atmLocAd);
		atmNotesL = new Label("ATM Notes:");
		atmNotes = new Label(atmNoteA);
		currentDateL = new Label("Current Date:");
		currentDate = new Label(date.toString());
		
		grid.add(atmMacL, 0, 0);
		grid.add(atmMac, 1, 0);
		grid.add(atmLocationL, 0, 1);
		grid.add(atmLocation, 1, 1);
		grid.add(atmNotesL, 0, 2);
		grid.add(atmNotes, 1, 2);
		grid.add(currentDateL, 0, 3);
		grid.add(currentDate, 1, 3);
		grid.add(cancel, 1, 4);
		grid.add(actiontarget, 0, 4);
		
		actiontarget.setId("actiontarget");
		grid.setId("grid");
//		grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				AdminMenuPane amp = new AdminMenuPane(atmStage);
				MessagePane mp = new MessagePane(atmStage, "Cancelling...", amp.getAdminMenuPane(), 800, 600);
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
	
	public Parent getATMViewPane() {
		return root;
	}
}
