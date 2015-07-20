package dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Property;

import people.Person;

import java.util.List;

import javax.crypto.Mac;

import account.*;
import atm.ATM;

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
			System.out.println("Account saved");
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

	}
	
	public void persistPerson(Person person){
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
			System.out.println("Person saved");
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
	public void persistATM(ATM atm){
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			session.save(atm);
			session.getTransaction().commit();
			System.out.println("Person saved");
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
		
		Accounts account = null;
		// Transaction t = session.beginTransaction();
		account = (Accounts) session.createCriteria(Accounts.class).add(Property.forName("accountNumber").eq(accNumber)).list().get(0);
		
		session.close();

		return account;

	}
	
	public Person fetchPerson(int idNumber){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		Person person = null;
		// Transaction t = session.beginTransaction();
		person = (Person) session.createCriteria(Person.class).add(Property.forName("idNumber").eq(idNumber)).list().get(0);
		
		session.close();

		return person;
		
	}
	
	public ATM fetchATM(Mac macAddress){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		ATM atm = null;
		// Transaction t = session.beginTransaction();
		atm = (ATM) session.createCriteria(ATM.class).add(Property.forName("macAddress").eq(macAddress)).list().get(0);
		
		session.close();

		return atm;
		
	}
}
