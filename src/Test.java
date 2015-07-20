import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Date;

import account.Accounts;
import account.CurrentAccount;
import account.SavingsAccount;
import sun.font.EAttribute;



public class Test {
	public Socket socket;
	public ObjectInputStream ois;
	public ObjectOutputStream oos;
	
	public Test() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 10000);
	}
	
	public void openStreams() throws IOException{
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
	}

	public void closeStreams() throws IOException{
		ois.close();
		oos.close();
	}
	
	public Socket getSocket() {
		return socket;
	}

	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	
	public ObjectInputStream getOis() {
		return ois;
	}

	
	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	
	public ObjectOutputStream getOos() {
		return oos;
	}

	
	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		EasyIn fromKBD = new EasyIn();
		Test test = new Test();
		test.openStreams();
		System.out.print("Account Number:");
		String accNo = fromKBD.readString();
		test.getOos().writeObject(accNo);
		System.out.print("Pin number:");
		int pin = fromKBD.readInt();
		test.getOos().writeObject(pin);
		
		Accounts account = (Accounts) test.getOis().readObject();
		System.out.println(account.toString());
	}
}
