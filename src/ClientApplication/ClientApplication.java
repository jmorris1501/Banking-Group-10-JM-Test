package ClientApplication;

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

	public void withdraw() {

	}

	public void deposit() {

	}

	public void transfer() {

	}

	public void changePin() {

	}

	public Accounts getAccount() {
		return this.account;
	}

	public ATM getATM() {
		return this.atm;
	}

	class ClientApplicationThread extends Thread {

		public ClientApplicationThread(Socket socket) {
			start();
		}

		@Override
		public void run() {
			ClientApplication ca = null;
			ServerManager sm = null;
			try {
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
				while (true) {
					String selection = (String) ois.readUTF();
					if (selection.equalsIgnoreCase("withdraw")) {
						double amount = (double) ois.readObject();
						if (((ca.getAccount().getBalance()) - 45) > amount && ca.getATM().getBalance() > amount) {
							ca.getAccount().setBalance(ca.getAccount().getBalance() - (amount + 45));
							Transaction transaction = new Transaction();
						}
					}
					if (selection.equalsIgnoreCase("deposit")){
						double amount = (double) ois.readObject();
						ca.getAccount().setBalance(ca.getAccount().getBalance() + amount - 45);
					}
					if (selection.equalsIgnoreCase("transfer")){
						String transferChoice = ois.readUTF();
						if(transferChoice.equalsIgnoreCase("client")){
							String accountNo = ois.readUTF();
							Accounts account = sm.getAcc(accountNo);
							double amount = (double) ois.readObject();
							if(ca.getAccount().getBalance() > (amount + 45)){
								ca.getAccount().setBalance(ca.getAccount().getBalance() - (amount + 45));
								account.setBalance(account.getBalance() + amount);
							}else{
								oos.writeObject(new BankingG10Exception("Failed to transfer, Insufficient Funds"));
							}
						}
						if(transferChoice.equalsIgnoreCase("account")){
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
