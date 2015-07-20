package src.main.java.gui;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessagePane extends Parent {

	private Stage mainStage;
	private Parent root;
	private final Parent newParent;
	private int paneW, paneH;
	private GridPane grid;
	private final Text actiontarget = new Text();
	private Label indicator;
	private String message;
	private Scene newScene;

	public MessagePane(Stage stage, String text, Parent parent, int paneWidth, int paneHeight) {
		mainStage = stage;
		message = text;
		newParent = parent;
		paneW = paneWidth;
		paneH = paneHeight;

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(100);
		grid.setVgap(50);
		grid.setPadding(new Insets(10, 10, 10, 10));

		indicator = new Label(message);

		indicator.setAlignment(Pos.CENTER_RIGHT);

		grid.add(indicator, 0, 0, 2, 1);
		grid.add(actiontarget, 0, 1, 2, 1);

		actiontarget.setId("actiontarget");
		indicator.setId("indicator");
		grid.setId("grid");
		// grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());

		root = grid;
		
		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				return null;
			}
		};
		sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			public void handle(WorkerStateEvent event) {
				newScene = new Scene(newParent, paneW, paneH);
				mainStage.setScene(newScene);
			}
		});
		new Thread(sleeper).start();
	}

	public Parent getMessagePane() {
		return root;
	}
}
