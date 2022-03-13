package com.dcogbill.BookClub.Services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.dcogbill.BookClub.Repositories.UserRepo;
import com.dcogbill.BookClub.Models.LoginUser;
import com.dcogbill.BookClub.Models.User;

@Service
public class UserService {
	
	@Autowired
    private UserRepo userRepo;
	
	//Validate new user, return true if user passes validation, returns false if not
	public Boolean validate(User newUser, Errors errors) {
    	
    	//If password and confirm do not match return false
		if( !newUser.getPassword().equals(newUser.getConfirm() ) ) {
    		
    		errors.rejectValue("password", "Mismatch", "Password does not match");
    		return false;
    		
    	}
    	
    	//If email is already in database, return false
		if( userRepo.findByEmail(newUser.getEmail()) != null ) {
    		
    		errors.rejectValue("email", "Unique", "Email already taken");
    		return false;
    		
    	}
    	
    	return true;
    }
    
    //Save user to database
	public void register(User newUser) {
        
    	//Hash password and add salt
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	
		//Set hashed password to user password
		newUser.setPassword(hashed);
    	
		//Save user and r
		userRepo.save(newUser);
        
    }
    
    //Authenticate user logging in
	public User authenticate(LoginUser newLogin, Errors errors) {
        
    	//Check if user is in database
		User user = userRepo.findByEmail(newLogin.getEmail());    	
    	if( user == null ) {
    		
    		errors.rejectValue("email", "Login", "Incorrect Credentials");
    		return null;
    		
    	}
    	
    	//Check password, return null if they do not match
    	if( !BCrypt.checkpw(newLogin.getPassword(), user.getPassword() ) ) {
    		
    		errors.rejectValue("password", "Login", "Incorrect Credentials");
    		return null;
    	}
    	
    	
    	return user; 
    }
    
	//Get user by email
    public User findByEmail(String email) {
    	return userRepo.findByEmail(email);
    }
    
    //Get user by id
    public User findById(Long id) {
    	return userRepo.findById(id).orElse(null);
    }

}
