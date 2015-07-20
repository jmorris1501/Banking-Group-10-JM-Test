package gui;

import java.util.ArrayList;
import java.util.List;

import account.AccountType;
import account.Accounts;
import account.CurrentAccount;
import account.SavingsAccount;
import people.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientInfoPane extends Parent {
	
	private Stage tellerStage;
	private GridPane clientGrid, accountGrid, grid;
	private TextField nameF, surnameF, dateF, idF;
	private Label nameL, surnameL, dateL, idL;
	private Label errorL;
	private Parent root;
	private Button saveB, cancelB;
	private Client client;
	private TabPane tabPane;
	private List<Accounts> accounts;
	private ScrollPane scrollPane;
	
	public ClientInfoPane(Stage parent, Client person) {
		tellerStage = parent;
		client = person;
		
		clientGrid = new GridPane();
		clientGrid.setAlignment(Pos.CENTER);
		clientGrid.setHgap(25);
		clientGrid.setVgap(25);
		clientGrid.setPadding(new Insets(15, 15, 15, 15));
		
		accountGrid = new GridPane();
		accountGrid.setAlignment(Pos.CENTER);
		accountGrid.setHgap(25);
		accountGrid.setVgap(25);
		accountGrid.setPadding(new Insets(15, 15, 15, 15));
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(75);
		grid.setVgap(75);
		grid.setPadding(new Insets(15, 15, 15, 15));
		
		nameF = new TextField();
		nameF.setText(client.getName());
		surnameF = new TextField();
		surnameF.setText(client.getSurname());
		dateF = new TextField();
		dateF.setText(client.getDateJoined().toString());
		idF = new TextField();
		idF.setText(client.getIdNumber());
		
		nameL = new Label("Name : ");
		surnameL = new Label("Surname : ");
		dateL = new Label("Date Joined : ");
		idL = new Label("ID Number : ");
		
		errorL = new Label("error");
		
		saveB = new Button("Save");
		cancelB = new Button("Cancel");
		
		cancelB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				ClientTablePane ctp = new ClientTablePane(tellerStage);
				Scene newScene = new Scene(ctp.getClientTablePane(), 1000, 600);
				tellerStage.setScene(newScene);
			}
		});
		
		accounts = client.getAccounts();
		
		tabPane = new TabPane();
		Tab clientInfo = new Tab("Client Info");
		Tab accountInfo = new Tab("Account Info");
		clientInfo.setClosable(false);
		accountInfo.setClosable(false);
		
		for(int i = 0; i < accounts.size(); i ++) {
			if(accounts.get(i).getAccType().equals(AccountType.SAVINGS)) {
				AccountPanel accPan = new AccountPanel((SavingsAccount) accounts.get(i));
				accountGrid.add(accPan.getAccountPanel(), 0, i);
			}
			if(accounts.get(i).getAccType().equals(AccountType.CURRENT)) {
				AccountPanel accPan = new AccountPanel((CurrentAccount) accounts.get(i));
				accountGrid.add(accPan.getAccountPanel(), 0, i);
			}
		}

		scrollPane = new ScrollPane(accountGrid);
		
		clientGrid.add(nameL, 0, 0);
		clientGrid.add(nameF, 1, 0);
		clientGrid.add(surnameL, 0, 1);
		clientGrid.add(surnameF, 1, 1);
		clientGrid.add(dateL, 0, 2);
		clientGrid.add(dateF, 1, 2);
		clientGrid.add(idL, 0, 3);
		clientGrid.add(idF, 1, 3);

		clientGrid.add(errorL, 2, 0, 1, 4);
		
		clientInfo.setContent(clientGrid);
		accountInfo.setContent(scrollPane);
		
		tabPane.getTabs().addAll(clientInfo, accountInfo);
		
		grid.add(tabPane, 0, 0, 8, 7);
		grid.add(saveB, 0, 7);
		grid.add(cancelB, 7, 7);
		
		grid.setId("grid");
		
		grid.getStylesheets().add(atmGUI.class.getResource("teller.css").toExternalForm());
		
		root = grid;
	}
	
	public Parent getClientInfoPane() {
		return root;
	}
}
