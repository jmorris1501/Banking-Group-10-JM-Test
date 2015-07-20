package src.main.java.networking;

import java.io.*;
import java.net.*;
import java.util.*;

import src.main.java.account.Accounts;
import src.main.java.dao.HibernateDAO;

public class ServerManager {

	public ServerManager() {

		
	}

	public Accounts getAcc(String accNo) {
		HibernateDAO hdao = null;
		Accounts account = hdao.fetchAccount(accNo);
		return account;
	}
}
