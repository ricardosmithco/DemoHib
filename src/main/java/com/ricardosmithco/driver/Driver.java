package com.ricardosmithco.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ricardosmithco.beans.Book;
import com.ricardosmithco.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println(session.getStatistics());
		Transaction transaction = session.beginTransaction();
		
		session.save(new Book("A House for Mr. Biswas", "Fiction", "VS", "Naipaul"));
		
		transaction.commit();
		session.close();
	}

}
