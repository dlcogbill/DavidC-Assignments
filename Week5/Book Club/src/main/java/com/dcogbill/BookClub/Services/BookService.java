package com.dcogbill.BookClub.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcogbill.BookClub.Models.Book;
import com.dcogbill.BookClub.Repositories.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	//Return all books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	//Create a book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	//Get Book from database by Id
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if( optionalBook.isPresent() ) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	//Save an existing book
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	//Delete a book
	public void deleteBook(Long id) {
		
		bookRepo.deleteById(id);
		
	}

}
