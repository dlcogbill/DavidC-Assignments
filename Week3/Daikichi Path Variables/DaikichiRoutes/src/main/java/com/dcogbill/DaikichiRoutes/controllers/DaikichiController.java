package com.dcogbill.DaikichiRoutes.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	//http GET request to 'http://localhost:8080/daikichi' display 'Welcome!'
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	
	//http GET request to 'http://localhost:8080/daikichi/today' display 'Today you will find luck in all your endeavors!'
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	//GET request to 'http://localhost:8080/daikichi/tomorrow' display 'Tomorrow, an opportunity will arise, so be sure to be open to new ideas!'
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	//http GET request to 'http://localhost:8080/daikichi/travel/kyoto' where url will take any string for city
	//display 'Congratulations! You will soon travel to kyoto!'.
	@RequestMapping("/travel/{city}")
	public String travel(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city;
	}
	
	//http GET request to 'http://localhost:8080/daikichi/lotto/8' where url will take any integer
	//If number even, display 'You will take a grand journey in the near future, but be weary of tempting offers'
	//If odd, display "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends."
	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable("num") Integer num) {
		if ( num % 2 == 0 ) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		} else return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	}
	

}
