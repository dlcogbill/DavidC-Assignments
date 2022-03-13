package com.dcogbill.BookClub.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dcogbill.BookClub.Services.UserService;
import com.dcogbill.BookClub.Models.LoginUser;
import com.dcogbill.BookClub.Models.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	//Registration and Login form
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User newUser,
		 @ModelAttribute("newLogin") LoginUser newLogin) {
     return "index.jsp";
	}
	
	//Route for registering new user
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
         BindingResult result,
         HttpSession session,
		 @ModelAttribute("newLogin") LoginUser newLogin) {     
	
		//If there are errors redirect back to form page
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		//If not valid user, redirect
		if( !userServ.validate(newUser, result) ) {
			
			return "index.jsp";
		}
		 
		//create user in db
		userServ.register(newUser);
		
		//add user to session
		session.setAttribute("user", newUser); 
		return "redirect:/books";
	}
	
	//Login user
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
		 BindingResult result,
		 HttpSession session,
		 @ModelAttribute("newUser") User newUser) {
 
		//Authenticate user
		User user = userServ.authenticate(newLogin, result);
		
		//If there are errors redirect back to form page
		if(result.hasErrors()) {
			
			return "index.jsp";
		}
		
		//If user not found redirect back to form page
		if (user == null) {
			System.out.println("User is null");
			return "index.jsp";
		}
		
		//add user to session
		session.setAttribute("user", user);
		return "redirect:/books";		
	}
	
	//Logout user
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		
		session.invalidate();
        return "redirect:/";        
	}

}
