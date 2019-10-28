package com.ricardosmithco.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ricardosmithco.beans.Book;
import com.ricardosmithco.util.ConnectionUtil;

public class BookDaoImpl implements BookDao{
	
	private SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
	

	public Book getBookById(int id) {
		Book book = null;
		
		try(Session sess = sessionFactory.openSession()){
			
			book = sess.get(Book.class, id);
		}
		return book;
	}
	

	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		
		try(Session session = sessionFactory.openSession()){
			bookList = session.createQuery("from Book").getResultList();
		}
		return bookList;
	}
	

	public boolean addBook(Book book) {
		boolean added = false;
		
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.persist(book);
			transaction.commit();
			added = true;
		}
		return added;
	}

	public boolean updateBook(Book book) {
		boolean updated = false;
		
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(book);
			transaction.commit();
			updated = true;
		}
		return updated;
	}

	public boolean deleteBook(Book book) {
		boolean deleted = false;
		
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.delete(book);
			transaction.commit();
			deleted = true;
		}
		return deleted;
	}
	
	

}
