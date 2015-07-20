package src.main.java.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class atmGUI extends Application{

	private Stage atmStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		atmStage = primaryStage;
		LoginPane login = new LoginPane(atmStage);
		Scene scene = new Scene(login.getLoginPane(), 800, 600);
		atmStage.setScene(scene);
		atmStage.show();
	}

	public static void main(String [] args) {
		launch(args);
	}
	
	public Stage getAtmStage() {
		return atmStage;
	}
}
