package src.main.java.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class tellerGUI extends Application{

	private Stage tellerStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		tellerStage = primaryStage;
		TellerLoginPane tLogin = new TellerLoginPane(tellerStage);
		Scene scene = new Scene(tLogin.getTellerLoginPane(), 1000, 600);
		tellerStage.setScene(scene);
		tellerStage.show();
	}

	public static void main(String [] args) {
		launch(args);
	}
	
	public Stage getTellerStage() {
		return tellerStage;
	}
}
