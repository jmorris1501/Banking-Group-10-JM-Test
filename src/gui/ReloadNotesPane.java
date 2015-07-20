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

public class ReloadNotesPane extends Parent {

	private Label indicator, r10L, r20L, r50L, r100L, r200L, r10A, r20A, r50A, r100A, r200A;
	private Button reload, exit, cancel;
	private Stage atmStage;
	private Parent root;
	private GridPane grid;
	private final Text actiontarget = new Text();
	private Scene newScene;

	public ReloadNotesPane(Stage parent, String rem10, String rem20, String rem50, String rem100, String rem200) {
		atmStage = parent;
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(50);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		reload = new Button("Reload");
		reload.setMaxSize(300, 100);
		exit = new Button("Exit");
		exit.setMaxSize(300, 100);
		cancel = new Button("Continue");
		cancel.setMaxSize(300, 100);
		
		r10L = new Label(rem10 + " / 500");
		r20L = new Label(rem20 + " / 500");
		r50L = new Label(rem50 + " / 500");
		r100L = new Label(rem100 + " / 500");
		r200L = new Label(rem200 + " / 500");
		r10A = new Label("R10's");
		r10A.setMaxSize(300, 100);
		r20A = new Label("R20's");
		r20A.setMaxSize(300, 100);
		r50A = new Label("R50's");
		r50A.setMaxSize(300, 100);
		r100A = new Label("R100's");
		r100A.setMaxSize(300, 100);
		r200A = new Label("R200's");
		r200A.setMaxSize(300, 100);
		indicator = new Label("Remaining Notes:");
		
		grid.add(indicator, 0, 0, 5, 1);
		grid.add(r10A, 0, 1);
		grid.add(r20A, 1, 1);
		grid.add(r50A, 2, 1);
		grid.add(r100A, 3, 1);
		grid.add(r200A, 4, 1);
		grid.add(r10L, 0, 2);
		grid.add(r20L, 1, 2);
		grid.add(r50L, 2, 2);
		grid.add(r100L, 3, 2);
		grid.add(r200L, 4, 2);
		grid.add(reload, 0, 3);
		grid.add(actiontarget, 1, 3);
		grid.add(cancel, 3, 3);
		grid.add(exit, 4, 3);
		
		actiontarget.setId("actiontarget");
		grid.setId("grid");
//		grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("atmStyle.css").toExternalForm());
		
		reload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				r10L.setText("500 / 500");
				r20L.setText("500 / 500");
				r50L.setText("500 / 500");
				r100L.setText("500 / 500");
				r200L.setText("500 / 500");
			}
		});		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				AdminMenuPane amp = new AdminMenuPane(atmStage);
				MessagePane mp = new MessagePane(atmStage, "Loading...", amp.getAdminMenuPane(), 800, 600);
				newScene = new Scene(mp.getMessagePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				LoginPane login = new LoginPane(atmStage);
				MessagePane mp = new MessagePane(atmStage, "Exiting...", login.getLoginPane(), 800, 600);
				newScene = new Scene(mp.getMessagePane(), 800, 600);
				atmStage.setScene(newScene);
			}
		});
		
		root = grid;
	}
	
	public Parent getReloadNotesPane() {
		return root;
	}
}
