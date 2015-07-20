package TellerApplication;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import logs.Transaction;
import networking.ServerManager;
import account.Accounts;
import exceptions.BankingG10Exception;
import people.Employee;

public class TellerApplication {
	private Socket clientSocket = null;
	private Employee employee = null;
	private Accounts account = null;
	
	public TellerApplication()
	{
		TellerApplicationThread tat = new TellerApplicationThread(clientSocket);
	}

	public void transferInfo(Socket clientSocket, Employee employee) {
	this.employee = employee;
	this.clientSocket = clientSocket;
		
	}
	
	class TellerApplicationThread extends Thread {

		public TellerApplicationThread(Socket socket) {
			start();
		}

		@Override
		public void run() {
		/*	TellerApplication ta = null;
			ServerManager sm = null;
			try {
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
				while (true) 
				{
					String selection = (String) ois.readUTF();
					if (selection.equalsIgnoreCase("freeze account"))
					{
					String accountNo = ois.readUTF();
					Accounts account = sm.getAcc(accountNo);
					if(ta.getAccount().isFrozen() == false)
					{
						ta.getAccount().setFrozenStatus(true);
					}
					
					}
					if(selection.equalsIgnoreCase("unfreeze account"))
					{
						String accountNo = ois.readUTF();
						Account account = sm.getAcc(accountNo);
						if(ta.getAccount().() == true)
						{
							ta.getAccount().(false);
						}
					}
					if(selection.equalsIgnoreCase("create account")){
						
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}

	public Account getAccount() {
		return this.account;
	}
}
*/ 
		}}}