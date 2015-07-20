package clientapplication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import logs.Transaction;
import atm.ATM;
import networking.ServerManager;
import account.Accounts;
import exceptions.BankingG10Exception;

public class ClientApplication {

	private ATM atm = null;
	private Accounts account = null;
	private Socket clientSocket = null;

	public ClientApplication() {
		ClientApplicationThread cat = new ClientApplicationThread(clientSocket);
	}

	public void transferInfo(Socket clientSocket, ATM atm, Accounts account) {
		this.clientSocket = clientSocket;
		this.account = account;
		this.atm = atm;
	}

	public Accounts getAccount() {
		return this.account;
	}

	public ATM getATM() {
		return this.atm;
	}

	class ClientApplicationThread extends Thread {
		private ServerManager sm;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;

		public ClientApplicationThread(Socket socket) {
			start();
		}

		public void withdraw() {
			try {
				openInputStream();
				double amount = (double) ois.readObject();
				if (((getAccount().getBalance()) - 45) > amount && getATM().getBalance() > amount) {
					getAccount().setBalance(getAccount().getBalance() - (amount + 45));
					Transaction transaction = new Transaction();
				}
				closeInputStream();
			} catch (IOException | ClassNotFoundException e) {

			}
		}

		public void deposit() {
			try {
				openInputStream();
				double amount = (double) ois.readObject();
				getAccount().setBalance(getAccount().getBalance() + amount - 45);
			} catch (IOException | ClassNotFoundException e) {

			}
		}

		public void transferToClient() {
			sm = new ServerManager();
			try {
				openInputStream();
				String accountNo = ois.readUTF();
				Accounts account = sm.getAcc(accountNo);
				double amount = (double) ois.readObject();
				if (getAccount().getBalance() > (amount + 45)) {
					getAccount().setBalance(getAccount().getBalance() - (amount + 45));
					account.setBalance(account.getBalance() + amount);
				} else {
					openOutputSteam();
					oos.writeObject(new BankingG10Exception("Failed to transfer, Insufficient Funds"));
					closeOutputStream();
				}
				closeInputStream();
			} catch (IOException | ClassNotFoundException e) {

			}
		}

		public void transferToAccount() {

		}

		public void changePin() {

		}

		public void openInputStream() throws IOException {
			ois = new ObjectInputStream(clientSocket.getInputStream());
		}

		public void openOutputSteam() throws IOException {
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
		}

		public void closeInputStream() throws IOException {
			ois.close();
		}

		public void closeOutputStream() throws IOException {
			oos.close();
		}

		@Override
		public void run() {
			try {
				while (true) {
					String selection = (String) ois.readUTF();
					if (selection.equalsIgnoreCase("withdraw")) {
						withdraw();
					}
					if (selection.equalsIgnoreCase("deposit")) {
						deposit();
					}
					if (selection.equalsIgnoreCase("transfer")) {
						String transferChoice = ois.readUTF();
						if (transferChoice.equalsIgnoreCase("client")) {
							transferToClient();
						}
						if (transferChoice.equalsIgnoreCase("account")) {
							String accountNo = ois.readUTF();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
