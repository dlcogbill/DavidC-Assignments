package com.dcogbill.SaveTravels.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcogbill.SaveTravels.Models.Expense;
import com.dcogbill.SaveTravels.Repositories.ExpRepo;

@Service
public class ExpService {
	
	@Autowired
	private ExpRepo expRepo;
	
	//returns all Expenses
	public List<Expense> allExpenses() {
		return expRepo.findAll();
	}
	
	//Create an Expense
	public Expense createExpense(Expense expense) {
		return expRepo.save(expense);
	}
	
	//Retrieve an Expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expRepo.findById(id);
		if( optionalExpense.isPresent() ) {
				return optionalExpense.get();
			} else {
				return null;
			}
	}
		
	//Save an existing Expense
	public Expense updateExpense(Expense expense) {
		return expRepo.save(expense);
	}
		
	//Delete an Expense
	public void deleteExpense(Long id) {
			
		expRepo.deleteById(id);
			
	}

}
