package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TellerLoginPane {
	
	private Stage tellerStage;
	private GridPane grid;
	private TextField usernameField;
	private PasswordField passwordField;
	private Text sceneTitle;
	private Label usernameL, passwordL;
	private Parent root;
	private Button submit;
	
	public TellerLoginPane(Stage parent) {
		tellerStage = parent;

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(50);
		grid.setPadding(new Insets(50, 50, 50, 50));

		sceneTitle = new Text("Please Enter:");
		grid.add(sceneTitle, 0, 0, 2, 1);

		usernameL = new Label("Username:");
		grid.add(usernameL, 0, 1);

		usernameField = new TextField();
		usernameField.setFont(new Font("Arial Black", 22));
		grid.add(usernameField, 1, 1);

		passwordL = new Label("Password:");
		grid.add(passwordL, 0, 2);

		passwordField = new PasswordField();
		passwordField.setFont(new Font("Arial Black", 22));
		grid.add(passwordField, 1, 2);

		submit = new Button("Submit");
		submit.setMaxSize(300, 100);
		
		grid.add(submit, 1, 4);
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		usernameField.requestFocus();

		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				String username = new String(usernameField.getText());
				String password = new String(passwordField.getText());
				if(username.equals("teller") && password.equals("teller")) {
					ClientTablePane ctp = new ClientTablePane(tellerStage);
					MessagePane mp = new MessagePane(tellerStage, "Loading...", ctp.getClientTablePane(), 1000, 600);
					Scene newScene = new Scene(mp.getMessagePane(), 1000, 600);
					tellerStage.setScene(newScene);
				} 
			}
		});
		passwordField.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ENTER) {
					submit.fire();
				}
			}
		});
		
		sceneTitle.setId("please-text");
		actiontarget.setId("actiontarget");
		grid.setId("grid");

//		grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("teller.css").toExternalForm());

		root = grid;
	}

	public Parent getTellerLoginPane() {
		return root;
	}
}
