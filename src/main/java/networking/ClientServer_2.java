package src.main.java.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//import src.main.java.clientapplication.ClientApplication;
import src.main.java.dao.HibernateDAO;
import src.main.java.atm.ATM;
import src.main.java.networking.*;
import src.main.java.account.Accounts;
import src.main.java.account.CurrentAccount;
import src.main.java.exceptions.BankingG10Exception;

public class ClientServer {

	public ServerSocket socket;
	public Socket clientSocket;

	public ClientServer() {
		try {
			// This connects you to the listening port
			socket = new ServerSocket(10000);
			while (true) {
				try {
					System.out.println("Waiting for connection");
					clientSocket = socket.accept();
					ClientServerThread cst = new ClientServerThread(clientSocket);
					System.out.println("Connected to: " + clientSocket.getRemoteSocketAddress());
				} catch (IOException e) {
					System.out.println("Accept failed");
					System.exit(1);
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

		}
	}

	class ClientServerThread extends Thread {

		public ClientServerThread(Socket socket) {
			start();
		}

		@Override
		public void run() {
			ServerManager sm = new ServerManager();
			Accounts account = null;
			ATM atm = null;
			ClientApplication ca = null;
			HibernateDAO hDAO = new HibernateDAO();
			try {
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
				Accounts accountToCreate = new CurrentAccount("1991", 500, 123456789, false, null, 1234, "Savings", 12.4, 10.5, 2000);
				hDAO.persistAccount(accountToCreate);
				String accNo = (String) ois.readUTF();
				if(sm.getAcc(accNo) != null){
					account = sm.getAcc(accNo);
				}else{
					oos.writeObject(new BankingG10Exception("No account found"));
				}
				int pinNo = (int) ois.readObject();
				if(account.authenticate(pinNo)){
//					ca.transferInfo(clientSocket, atm, account);
					oos.writeObject(account);
					oos.flush();
					oos.close();
					ois.close();
				}else{
					oos.writeObject(new BankingG10Exception("Invalid Pin Number"));
					oos.close();
					ois.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
//				oos.close();
//				ois.close();
			}
		}
	}
	
	public static void main(String[] args) {
		new ClientServer();
	}
}
