package networking;

import java.io.*;
import java.net.*;
import java.util.*;

import account.Accounts;
import account.CurrentAccount;
import dao.HibernateDAO;

public class ServerManager {

	public ServerManager() {
		
	}
	
	public void saveAcc(Accounts account){
		HibernateDAO hdao = null;
		hdao.persistAccount(account);
	}

	public Accounts getAcc(String accNo) {
		HibernateDAO hdao = new HibernateDAO();
		Accounts account = hdao.fetchAccount(accNo);
		System.out.println("Account read");
		return account;
	}
}
