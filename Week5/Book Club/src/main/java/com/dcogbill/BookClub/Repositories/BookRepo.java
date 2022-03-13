package com.dcogbill.BookClub.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dcogbill.BookClub.Models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
	
	List<Book> findAll();

}
