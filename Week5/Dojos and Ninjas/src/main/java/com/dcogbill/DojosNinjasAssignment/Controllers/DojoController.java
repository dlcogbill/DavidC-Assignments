package com.dcogbill.DojosNinjasAssignment.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcogbill.DojosNinjasAssignment.Models.Dojo;
import com.dcogbill.DojosNinjasAssignment.Models.Ninja;
import com.dcogbill.DojosNinjasAssignment.Services.DojoService;


@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
	
	@RequestMapping("/dojos")
	public String index(Model model) {
		
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "dojos.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		
		return "newDojo.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if (result.hasErrors()) {
            return "newDojo.jsp";
        } else {
        	dojoService.createDojo(dojo);
        	return "redirect:/dojos";
        }
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "showDojo.jsp";
	}

}
