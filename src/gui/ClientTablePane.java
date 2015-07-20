package gui;

import java.util.ArrayList;
import java.util.Date;

import account.AccountType;
import account.Accounts;
import account.CurrentAccount;
import account.SavingsAccount;
import people.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import location.Location;
import location.Province;

public class ClientTablePane extends Parent {

	private Parent root;
	private Stage tellerStage;
	private GridPane grid, controls;
	private Label searchLabel;
	private TextField searchField;
	private Button searchB, addClient, remClient, exit, edit;

	private TableView<Client> table = new TableView<Client>();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ClientTablePane(Stage parent) {
		tellerStage = parent;

		Date date = new Date();
		Location address = new Location(6, "Barclay Street", "Benoni", 1501,
				Province.GAUTENG);
		Location branch = new Location(6, "Barclay Street", "Benoni", 1501,
				Province.GAUTENG);

		ArrayList<Accounts> accounts = new ArrayList<Accounts>();
		accounts.add(new SavingsAccount("0000000000000001", 150000.00,
				"00010001", false, date, 12345, AccountType.SAVINGS, 0.75, date));
		accounts.add(new SavingsAccount("0000000000000002", 150000.00,
				"00010002", false, date, 12345, AccountType.SAVINGS, 0.75, date));
		accounts.add(new CurrentAccount("00000000000000003", 500000.00, 
				"00010003", false, date, 12345, AccountType.CURRENT, 100.00, 10.00, 1000.00));
		accounts.add(new CurrentAccount("0000000000000001", 500000.00,
				"00010004", false, date, 12345, AccountType.CURRENT, 100.00, 10.00, 1000.00));

		Client client1 = new Client("Jacob", "Smith", date, "9408195055088",
				address, branch, accounts);
		Client client2 = new Client("Justin", "Morris", date, "9408190555088",
				address, branch, accounts);
		Client client3 = new Client("James", "Morris", date, "9408195055088",
				address, branch, accounts);
		Client client4 = new Client("Stephen", "Morris", date, "9408190555088",
				address, branch, accounts);
		final ObservableList<Client> data = FXCollections
				.observableArrayList(client1, client2, client3, client4);

		grid = new GridPane();
		// grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(5, 5, 5, 5));

		searchLabel = new Label("Search:");
		searchField = new TextField();
		searchB = new Button("Search");

		addClient = new Button("Add Client");
		remClient = new Button("Remove Client");
		exit = new Button("Exit");

		edit = new Button("Edit");

		table.setEditable(false);

		grid.add(searchLabel, 0, 0);
		grid.add(searchField, 1, 0);
		grid.add(searchB, 2, 0);

		TableColumn nameCol = new TableColumn("First Name");
		nameCol.setMinWidth(100);
		nameCol.setCellValueFactory(new PropertyValueFactory<Client, String>(
				"name"));

		TableColumn surnameCol = new TableColumn("Surname");
		surnameCol.setMinWidth(100);
		surnameCol
				.setCellValueFactory(new PropertyValueFactory<Client, String>(
						"surname"));

		TableColumn dateCol = new TableColumn("Date");
		dateCol.setMinWidth(150);
		dateCol.setCellValueFactory(new PropertyValueFactory<Client, Date>(
				"dateJoined"));

		TableColumn idCol = new TableColumn("ID");
		idCol.setMinWidth(100);
		idCol.setCellValueFactory(new PropertyValueFactory<Client, String>(
				"idNumber"));

		TableColumn addressCol = new TableColumn("Address");
		addressCol.setMinWidth(200);
		addressCol
				.setCellValueFactory(new PropertyValueFactory<Client, Location>(
						"address"));

		TableColumn branchCol = new TableColumn("Branch");
		branchCol.setMinWidth(200);
		branchCol
				.setCellValueFactory(new PropertyValueFactory<Client, Location>(
						"branch"));

		TableColumn accountsCol = new TableColumn("Accounts");
		accountsCol.setMinWidth(140);
		accountsCol
				.setCellValueFactory(new PropertyValueFactory<Client, String>(
						"accounts"));

		table.setItems(data);
		table.getColumns().addAll(nameCol, surnameCol, dateCol, idCol,
				addressCol, branchCol, accountsCol);

		controls = new GridPane();
		controls.setHgap(100);
		controls.setPadding(new Insets(5, 5, 5, 5));

		controls.add(addClient, 0, 0);
		controls.add(remClient, 1, 0);
		controls.add(edit, 2, 0);
		controls.add(exit, 3, 0);

		grid.add(table, 0, 1, 8, 1);
		grid.add(controls, 0, 2, 8, 1);

		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				TellerLoginPane tlp = new TellerLoginPane(tellerStage);
				MessagePane mp = new MessagePane(tellerStage, "Exiting...", tlp
						.getTellerLoginPane(), 1000, 600);
				Scene newScene = new Scene(mp.getMessagePane(), 1000, 600);
				tellerStage.setScene(newScene);
			}
		});
		edit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				for (int i = 0; i < data.size(); i++) {
					if (table.getSelectionModel().isSelected(i)) {
						ClientInfoPane cip = new ClientInfoPane(tellerStage,
								data.get(i));
						Scene newScene = new Scene(cip.getClientInfoPane(),
								1000, 600);
						tellerStage.setScene(newScene);
					}
				}
			}
		});
		searchB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				String searchTerm = searchField.getText().toUpperCase();
				ArrayList<Client> results = new ArrayList<Client>();
				for (int i = 0; i < data.size(); i++) {
					if (data.get(i).getName().toUpperCase()
							.contains(searchTerm)
							|| data.get(i).getSurname().toUpperCase()
									.contains(searchTerm)
							|| data.get(i).getIdNumber().toUpperCase()
									.contains(searchTerm)
							|| data.get(i).getAddress().toUpperCase()
									.contains(searchTerm)
							|| data.get(i).getBranch().toUpperCase()
									.contains(searchTerm)) {
						results.add(data.get(i));
					}
				}
				ObservableList<Client> searchResults = FXCollections
						.observableArrayList();
				for (int i = 0; i < results.size(); i++) {
					searchResults.add(results.get(i));
				}
				table.setItems(searchResults);
			}
		});
		searchField.setOnKeyTyped(new EventHandler<Event>() {
			@Override
			public void handle(Event e) {
				searchB.fire();
			}
		});

		grid.setId("grid");

		// grid.setGridLinesVisible(true);

		grid.getStylesheets().add(
				atmGUI.class.getResource("teller.css").toExternalForm());

		root = grid;
	}

	public Parent getClientTablePane() {
		return root;
	}
}
