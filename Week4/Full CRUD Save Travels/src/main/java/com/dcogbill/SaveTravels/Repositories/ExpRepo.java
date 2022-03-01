package com.dcogbill.SaveTravels.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dcogbill.SaveTravels.Models.Expense;

@Repository
public interface ExpRepo extends CrudRepository<Expense, Long> {
	
	//returns a list of all Expenses
	List<Expense> findAll();

}
