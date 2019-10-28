package com.ricardosmithco.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	
	private ConnectionUtil(){
		super();
	}
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) { // if no sessionFactory has been created, make one
			
			Configuration configuration = new Configuration();
			
			configuration.setProperty("hibernate.connection.username", System.getenv("DEMO_DB_USERNAME"));
			configuration.setProperty("hibernate.connection.password", System.getenv("DEMO_DB_PASSWORD"));
			configuration.setProperty("hibernate.connection.url", System.getenv("DEMO_DB_URL"));
			
			configuration.configure(); // by default, looks for a hibernate.cfg.xml in src/main/resources
			
			sessionFactory = configuration.buildSessionFactory();
		}
		
		return sessionFactory;
	}

}
