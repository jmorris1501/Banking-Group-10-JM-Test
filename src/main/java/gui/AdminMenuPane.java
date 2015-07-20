package src.main.java.gui;

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

public class AdminMenuPane extends Parent{

	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private Button reload, print, view, atmInfo, exit;
	private final Text actiontarget = new Text();
	private Scene newScene;

	public AdminMenuPane(Stage parent) {
		atmStage = parent;
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(400);
		grid.setVgap(100);
		grid.setPadding(new Insets(10, 10, 10, 10));

		reload = new Button("Reload Notes");
		reload.setMaxSize(300, 100);
		print = new Button("Print");
		print.setMaxSize(300, 100);
		view = new Button("View");
		view.setMaxSize(300, 100);
		atmInfo = new Button("ATM Info");
		atmInfo.setMaxSize(300, 100);
		exit = new Button("Exit");
		exit.setMaxSize(300, 100);

		grid.add(reload, 0, 0);
		grid.add(print, 1, 0);
		grid.add(view, 0, 1);
		grid.add(atmInfo, 1, 1);
		grid.add(exit, 1, 2);
		grid.add(actiontarget, 0, 2);

		actiontarget.setId("actiontarget");
		grid.setId("grid");
//		grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());

		reload.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				actiontarget.setText("reload button pressed");
				ReloadNotesPane rnp = new ReloadNotesPane(atmStage, "450", "450", "450", "450", "450");
				newScene = new Scene(rnp.getReloadNotesPane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		print.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				/**
				actiontarget.setText("print button pressed");
				AccountChoicePane accChPn = new AccountChoicePane(atmStage, "print");
				newScene = new Scene(accChPn.getAccountChoicePane(), 800, 600);
				atmStage.setScene(newScene);
				*/
			}
		});
		view.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				/**
				actiontarget.setText("view button pressed");
				ATMViewPane avp = new ATMViewPane(atmStage, "8e8e8e8e:8e8e8e8e", "12 ad 1992", "1 2 1 3 2");
				newScene = new Scene(avp.getATMViewPane(), 800, 600);
				atmStage.setScene(newScene);
				*/
			}
		});
		atmInfo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				actiontarget.setText("view button pressed");
				ATMViewPane avp = new ATMViewPane(atmStage, "8e8e8e8e:8e8e8e8e", "12 ad 1992", "1 2 1 3 2");
				newScene = new Scene(avp.getATMViewPane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		exit.setOnAction(new EventHandler<ActionEvent>() {
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

	public Parent getAdminMenuPane() {
		return root;
	}
}
