package src.main.java.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Property;

import java.util.List;

import src.main.java.account.Accounts;

public class HibernateDAO {

	private SessionFactory sessionFactory;

	public HibernateDAO() {
		super();
	}

	public void persistAccount(Accounts account) {
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

	}

	public Accounts fetchAccount(String accNumber) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// Transaction t = session.beginTransaction();

		Accounts account = (Accounts) session.createCriteria(Accounts.class).add(Property.forName("accountNumber").eq(accNumber)).list().get(0);
		session.close();

		return account;

	}

}
