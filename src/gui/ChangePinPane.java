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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangePinPane extends Parent {

	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private Button cancel, confirm;
	private PasswordField oldPin, newPin, repNewPin;
	private final Text actiontarget = new Text();
	private Label indicator, oldPinCode, newPinCode, repNewPinCode;
	private String message;

	public ChangePinPane(Stage parent) {
		atmStage = parent;

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(100);
		grid.setVgap(50);
		grid.setPadding(new Insets(10, 10, 10, 10));

		oldPinCode = new Label("Old Pin Code:");
		newPinCode = new Label("New Pin Code:");
		repNewPinCode = new Label("Repeat Pin Code:");

		oldPin = new PasswordField();
		oldPin.setFont(new Font("Arial Black", 22));
		oldPin.setMaxWidth(400);
		oldPin.setAlignment(Pos.CENTER_RIGHT);

		newPin = new PasswordField();
		newPin.setFont(new Font("Arial Black", 22));
		newPin.setMaxWidth(400);
		newPin.setAlignment(Pos.CENTER_RIGHT);

		repNewPin = new PasswordField();
		repNewPin.setFont(new Font("Arial Black", 22));
		repNewPin.setMaxWidth(400);
		repNewPin.setAlignment(Pos.CENTER_RIGHT);
		
		confirm = new Button("Confirm");
		confirm.setMaxSize(300, 100);
		cancel = new Button("Cancel");
		cancel.setMaxSize(300, 100);

		indicator = new Label("Please enter:");

		indicator.setAlignment(Pos.CENTER_RIGHT);

		grid.add(indicator, 0, 0, 2, 1);
		grid.add(oldPinCode, 0, 1);
		grid.add(oldPin, 1, 1);
		grid.add(newPinCode, 0, 2);
		grid.add(newPin, 1, 2);
		grid.add(repNewPinCode, 0, 3);
		grid.add(repNewPin, 1, 3);
		grid.add(confirm, 0, 4);
		grid.add(cancel, 1, 4);
		grid.add(actiontarget, 0, 5, 2, 1);

		cancel.setAlignment(Pos.BOTTOM_RIGHT);

		oldPin.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (!"0123456789".contains(ke.getCharacter())) {
					ke.consume();
				} else if (oldPin.getText().length() >= 5) {
					ke.consume();
				}
				else if (ke.getCode() == KeyCode.ENTER) {
					newPin.requestFocus();
				}
			}
		});
		newPin.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (!"0123456789".contains(ke.getCharacter())) {
					ke.consume();
				} else if (newPin.getText().length() >= 5) {
					ke.consume();
				}
				else if (ke.getCode() == KeyCode.ENTER) {
					confirm.requestFocus();
				}
			}
		});
		repNewPin.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (!"0123456789".contains(ke.getCharacter())) {
					ke.consume();
				} else if (repNewPin.getText().length() >= 5) {
					ke.consume();
				}
				else if (ke.getCode() == KeyCode.ENTER) {
					confirm.requestFocus();
				}
			}
		});
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				String oldP = new String(oldPin.getText());
				String newP = new String(newPin.getText());
				String repNewP = new String(repNewPin.getText());
				if(newP.equals(repNewP)) {
					if(!(oldP.equals(newP))) {
						message = "PIN Changed Successfully!";
						MessageChoicePane mcp = new MessageChoicePane(atmStage, message);
						Scene newScene = new Scene(mcp.getMessageChoicePane(), 800, 600);
						atmStage.setScene(newScene);
					} else {
						actiontarget.setText("Your new Pin can't be the same as your old Pin");
					}
				} else {
					actiontarget.setText("Your new PIN doesn't match");
				}
			}
		});
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				message = "Changing PIN Canceled!";
				MessageChoicePane mcp = new MessageChoicePane(atmStage, message);
				Scene newScene = new Scene(mcp.getMessageChoicePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});

		actiontarget.setId("actiontarget");
		indicator.setId("indicator");
		grid.setId("grid");
		// grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());

		root = grid;
	}

	public Parent getChangePinPane() {
		return root;
	}
}
