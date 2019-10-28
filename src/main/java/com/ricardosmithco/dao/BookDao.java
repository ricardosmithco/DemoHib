package com.ricardosmithco.dao;

import java.util.List;

import com.ricardosmithco.beans.Book;

public interface BookDao {
	
	public Book getBookById(int id);
	
	public List<Book> getAllBooks();
	
	public boolean addBook(Book book);
	
	public boolean updateBook(Book book);
	
	public boolean deleteBook(Book book);

}
