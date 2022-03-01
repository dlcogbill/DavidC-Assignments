package com.dcogbill.SaveTravels.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcogbill.SaveTravels.Models.Expense;
import com.dcogbill.SaveTravels.Services.ExpService;

@Controller
public class Expenses {
	
	@Autowired
	private ExpService expService;
	
	//Show All Expenses and Create expense form
	@RequestMapping("/expenses")
    public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	//Create expense
	@PostMapping("/expenses/new")
	public String newExpense( @Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			expService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	//Show Expense details
	@RequestMapping("/expenses/{id}")
	public String showExpense( @PathVariable Long id, Model model ) {
		
		Expense expense = expService.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	
	
	//Edit Expense page
	@RequestMapping("/expenses/{id}/edit")
	public String editExpense(@PathVariable Long id, Model model) {
		
		Expense expense = expService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";

	}
	
	//Update Expense
	@PutMapping("/expenses/{id}/edit")
	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense,
	BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expService.updateExpense(expense);
			return "redirect:/expenses";
		}
	
	}
	
	//Delete an Expense
	@DeleteMapping("expenses/{id}/delete")
	public String deleteExpense(@PathVariable Long id) {
		expService.deleteExpense(id);
		return "redirect:/expenses";
	}

}
