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

public class AccountChoicePane extends Parent {

	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private Button current, savings, cancel;
	private final Text actiontarget = new Text();
	private String choice;
	private Label indicator;

	public AccountChoicePane(Stage parent, String pressed) {
		atmStage = parent;
		choice = pressed;

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(350);
		grid.setVgap(100);
		grid.setPadding(new Insets(10, 10, 10, 10));

		current = new Button("Current Account");
		current.setMaxSize(300, 100);
		savings = new Button("Savings Account");
		savings.setMaxSize(300, 100);
		cancel = new Button("Cancel");
		cancel.setMaxSize(300, 100);

		if (choice.contains("withdraw")) {
			indicator = new Label("Withdraw from:");
		} else if (choice.contains("deposit")) {
			indicator = new Label("Deposit to:");
		} else if (choice.contains("transfer")) {
			indicator = new Label("Transfer to:");
		} else if (choice.contains("viewBalance")) {
			indicator = new Label("View Balance of:");
		}

		indicator.setAlignment(Pos.TOP_CENTER);

		grid.add(indicator, 0, 0, 2, 1);
		grid.add(current, 0, 1);
		grid.add(savings, 1, 1);
		grid.add(actiontarget, 0, 2, 2, 1);

		cancel.setAlignment(Pos.BOTTOM_RIGHT);

		grid.add(cancel, 1, 3);

		current.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				if (choice.contains("withdraw") || choice.contains("deposit")
						|| choice.contains("transfer")) {
					AmountChoicePane acp = new AmountChoicePane(atmStage,
							choice, "Current");
					Scene newScene = new Scene(acp.getAmountChoicePane(), 800,
							600);
					atmStage.setScene(newScene);
				} else if (choice.contains("viewBalance")) {
					ViewPane vp = new ViewPane(atmStage, "Justin", "0123456789012345", "Current", "150000.00");
					Scene newScene = new Scene(vp.getViewPane(), 800,
							600);
					atmStage.setScene(newScene);
				}
			}
		});
		savings.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				if (choice.contains("withdraw") || choice.contains("deposit")
						|| choice.contains("transfer")) {
					AmountChoicePane acp = new AmountChoicePane(atmStage,
							choice, "Savings");
					Scene newScene = new Scene(acp.getAmountChoicePane(), 800,
							600);
					atmStage.setScene(newScene);
				} else if (choice.contains("viewBalance")) {
					ViewPane vp = new ViewPane(atmStage, "Justin", "0123456789012345", "Savings", "150000.00");
					Scene newScene = new Scene(vp.getViewPane(), 800,
							600);
					atmStage.setScene(newScene);
				}
			}
		});
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				MainPane main = new MainPane(atmStage);
				Scene newScene = new Scene(main.getMainPane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});

		actiontarget.setId("actiontarget");
		grid.setId("grid");
		// grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());

		root = grid;
	}

	public Parent getAccountChoicePane() {
		return root;
	}
}
