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

public class LoginPane extends Parent {

	private Stage atmStage;
	private GridPane grid;
	private TextField cardNoField;
	private PasswordField pinField;
	private Text sceneTitle;
	private Label cardNo, pinNo;
	private Parent root;
	private Button submit, admin;

	public LoginPane(Stage parent) {
		atmStage = parent;

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(50);
		grid.setPadding(new Insets(50, 50, 50, 50));

		sceneTitle = new Text("Please Enter:");
		grid.add(sceneTitle, 0, 0, 2, 1);

		cardNo = new Label("Card Number:");
		grid.add(cardNo, 0, 1);

		cardNoField = new TextField();
		cardNoField.setFont(new Font("Arial Black", 22));
		grid.add(cardNoField, 1, 1);

		pinNo = new Label("Pin Code:");
		grid.add(pinNo, 0, 2);

		pinField = new PasswordField();
		pinField.setFont(new Font("Arial Black", 22));
		grid.add(pinField, 1, 2);

		submit = new Button("Submit");
		submit.setMaxSize(300, 100);

		admin = new Button("Admin");
		admin.setMaxSize(300, 100);

		grid.add(admin, 0, 4);
		grid.add(submit, 1, 4);
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		cardNoField.requestFocus();

		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				actiontarget.setText("Submit button pressed");
			}
		});
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				String card = new String(cardNoField.getText());
				String pin = new String(pinField.getText());
				if (card.equals("1111111111111111") && pin.equals("11111")) {
					MainPane main = new MainPane(atmStage);
					MessagePane mp = new MessagePane(atmStage, "Loading...",
							main.getMainPane(), 800, 600);
					Scene newScene = new Scene(mp.getMessagePane(), 800, 600);
					atmStage.setScene(newScene);
				} else if (card.equals("2222222222222222")
						&& pin.equals("22222")) {
					AdminMenuPane amp = new AdminMenuPane(atmStage);
					Scene newScene = new Scene(amp.getAdminMenuPane(), 800, 600);
					atmStage.setScene(newScene);
				}
			}
		});
		admin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				AdminMenuPane amp = new AdminMenuPane(atmStage);
				MessagePane mp = new MessagePane(atmStage, "Loading...", amp
						.getAdminMenuPane(), 800, 600);
				Scene newScene = new Scene(mp.getMessagePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		cardNoField.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (!"0123456789".contains(ke.getCharacter())) {
					ke.consume();
				} else if (cardNoField.getText().length() >= 16) {
					ke.consume();
				} else if (ke.getCode() == KeyCode.ENTER) {
					pinField.requestFocus();
				}
			}
		});
		pinField.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (!"0123456789".contains(ke.getCharacter())) {
					ke.consume();
				} else if (pinField.getText().length() >= 5) {
					ke.consume();
				} else if (ke.getCode() == KeyCode.ENTER) {
					submit.requestFocus();

				}
			}
		});

		sceneTitle.setId("please-text");
		actiontarget.setId("actiontarget");
		grid.setId("grid");

		// grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());

		root = grid;
	}

	public Parent getLoginPane() {
		return root;
	}
}
