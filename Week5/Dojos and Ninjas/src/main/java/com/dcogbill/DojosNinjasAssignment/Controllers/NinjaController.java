package com.dcogbill.DojosNinjasAssignment.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcogbill.DojosNinjasAssignment.Models.Dojo;
import com.dcogbill.DojosNinjasAssignment.Models.Ninja;
import com.dcogbill.DojosNinjasAssignment.Services.DojoService;
import com.dcogbill.DojosNinjasAssignment.Services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos); 
		return "newNinja.jsp";
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		
		if (result.hasErrors()) {
            return "redirect:/ninjas/new";
        } else {
        	this.ninjaService.createNinja(ninja);
        	return "redirect:/dojos";
        }
	}

}
