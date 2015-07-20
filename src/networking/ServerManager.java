package networking;

import java.io.*;
import java.net.*;
import java.util.*;

import account.Accounts;
import dao.HibernateDAO;

public class ServerManager {

	public ServerManager() {

		
	}

	public Accounts getAcc(String accNo) {
		HibernateDAO hdao = null;
		Accounts account = hdao.fetchAccount(accNo);
		return account;
	}
}
