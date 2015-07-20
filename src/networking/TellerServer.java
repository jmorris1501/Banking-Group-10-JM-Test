package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import people.Employee;
//import atmObject.ATM;
import TellerApplication.TellerApplication;
import networking.*;
import exceptions.BankingG10Exception;

public class TellerServer {

	public ServerSocket socket;
	public Socket clientSocket;
	public Employee employee;

	public TellerServer() {
	/*	try {
	
			socket = new ServerSocket(10001);
			while (true) {
				try {
					System.out.println("Waiting for connection");
					clientSocket = socket.accept();
					TellerServerThread tst = new TellerServerThread(clientSocket);
					System.out.println("Connected to: " + clientSocket.getRemoteSocketAddress());
				} catch (IOException e) {
					System.out.println("Accept failed");
					System.exit(1);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
		}
	}
	class TellerServerThread extends Thread {

		public TellerServerThread(Socket socket) {
			start();
		}
		@Override
		public void run() {
			ServerManager sm = new ServerManager();
			TellerApplication ta = null;
			try {
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
				String employeeID = (String) ois.readUTF();
				if(sm.exists(employeeID)){
					employee = sm.getEmployee(employeeID);
				}else{
					oos.writeObject(new BankingG10Exception("Employee not found"));
				}
				String password = (String) ois.readObject();
				if(employee.authenticate(password)){
					ta.transferInfo(clientSocket, employee);
				}else{
					oos.writeObject(new BankingG10Exception("Invalid Password"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
			oos.close();
			ois.close();
			}
		}
	}
	
	public static void main(String[] args) {
		new TellerServer();
	}
}
*/ 
}}
	