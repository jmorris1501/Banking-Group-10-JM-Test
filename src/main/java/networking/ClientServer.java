package networking;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import clientapplication.ClientApplication;
import dao.HibernateDAO;
import atm.ATM;
import networking.*;
import account.Accounts;
import account.CurrentAccount;
import exceptions.BankingG10Exception;

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
				String accNo = ois.readUTF();
				System.out.println("Acc Number recieved");
				if (sm.getAcc(accNo) != null) {
					account = sm.getAcc(accNo);
					System.out.println("Account Found");
				} else {
					oos.writeObject(new BankingG10Exception("No account found"));
				}
				int pinNo = (int) ois.readObject();
				System.out.println("Pin number recieved");
				if (account.authenticate(pinNo)) {
//					ca = new ClientApplication();
//					ca.transferInfo(clientSocket, atm, account);
					oos.writeObject(account);
					System.out.println("Object written back");
					oos.flush();
					oos.close();
					ois.close();
				} else {
					oos.writeObject(new BankingG10Exception("Invalid Pin Number"));
					oos.close();
					ois.close();
				}
				System.out.println("Object sent or not sent");
			} catch (EOFException e) {
				System.out.println("End of file recieved");
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ClientServer();
	}
}
