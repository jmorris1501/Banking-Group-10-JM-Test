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

public class MessageChoicePane extends Parent{
	
	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private Button /**mainMenu, */confirm;
	private final Text actiontarget = new Text();
	private Label indicator;
	private String message;

	public MessageChoicePane(Stage parent, String text) {
		atmStage = parent;
		message = text;

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(100);
		grid.setVgap(50);
		grid.setPadding(new Insets(10, 10, 10, 10));

		confirm = new Button("Continue");
		confirm.setMaxSize(300, 100);
		/**
		mainMenu = new Button("Main Menu");
		mainMenu.setMaxSize(300, 100);
		*/
		indicator = new Label(message);

		indicator.setAlignment(Pos.CENTER_RIGHT);

		grid.add(indicator, 0, 0, 2, 1);
		grid.add(confirm, 0, 1, 2, 1);
		/**
		grid.add(mainMenu, 1, 1);
		*/
		grid.add(actiontarget, 0, 2, 2, 1);
		/**
		mainMenu.setAlignment(Pos.BOTTOM_RIGHT);
		*/
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				LoginPane login = new LoginPane(atmStage);
				Scene newScene = new Scene(login.getLoginPane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});/**
		mainMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				MainPane main = new MainPane(atmStage);
				Scene newScene = new Scene(main.getMainPane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		*/
		actiontarget.setId("actiontarget");
		indicator.setId("indicator");
		grid.setId("grid");
		// grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());

		root = grid;
	}

	public Parent getMessageChoicePane() {
		return root;
	}
}