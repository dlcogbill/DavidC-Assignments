package com.dcogbill.BookClub.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dcogbill.BookClub.Models.Book;
import com.dcogbill.BookClub.Services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookServ;
	
	//Show all books
	//Check if user is logged in, retrieve all books, send to view
	@GetMapping("/books")
	public String books(HttpSession session, Model model) {
		
		
		if( session.getAttribute("user") == null ) {
			
			
			return "redirect:/";
		} else {
			
			List<Book> books = bookServ.allBooks();
			model.addAttribute("books", books);
			return "books.jsp";
		}
		
	}
	
	//Show a book
	//Check if user is logged in, retrieve a book, send to view
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable Long id,
			Model model, HttpSession session) {
		
		
		if( session.getAttribute("user") == null ) {
			
			return "redirect:/";
			
		} else {
			
			Book book = bookServ.findBook(id);
			model.addAttribute("book", book);
			model.addAttribute("user", session.getAttribute("user") );
			return "show.jsp";
			
		}
		
		
	}
	
	//New Book Form
	//Check if user is logged in, and render new book form
	@GetMapping("/books/new")
	public String newBookForm(HttpSession session,
			@ModelAttribute("book") Book book,
			Model model) {
		
		
		if ( session.getAttribute("user") == null ) {
			
			return "redirect:/";
			
		} else {
			
			model.addAttribute("user", session.getAttribute("user"));
			return "new.jsp";
			
		}
	}
	
	//New Book route
	//Check if user is logged in, check for errors, create book in db
	@PostMapping("/books/new")
	public String newBook(HttpSession session,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		
		
		if ( session.getAttribute("user") == null ) {

			return "redirect:/";
			
		} else {
			
			if (result.hasErrors()) {
				
				return "new.jsp";
			} else {
				
				bookServ.createBook(book);
				return "redirect:/books";
				
			}
			
			
		}
	}
	
	//Edit Book form
	//Check if user is logged in, and render edit book form
	@GetMapping("/books/{id}/edit")
	public String editBookForm(HttpSession session,
			@PathVariable Long id,
			@ModelAttribute("book") Book book,
			Model model) {
		
		
		if ( session.getAttribute("user") == null ) {
			
			return "redirect:/";
			
		} else {
			
			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("editedBook", bookServ.findBook(id) );
			return "edit.jsp";
			
		}
	}
	
	//Edit Book route
	//Check if user is logged in, check for errors, edit book in db
	@PutMapping("/books/{id}/edit")
	public String editBook(HttpSession session,
			@PathVariable Long id,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model model) {
		
		if ( session.getAttribute("user") == null ) {

			return "redirect:/";
			
		} else {
			
			if (result.hasErrors()) {
				
				model.addAttribute("user", session.getAttribute("user"));
				model.addAttribute("editedBook", bookServ.findBook(id) );
				return "edit.jsp";
			} else {
				
				bookServ.updateBook(book);
				return "redirect:/books/" + id;
				
			}
			
			
		}
	}
	
	

}
