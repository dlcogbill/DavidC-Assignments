package com.dcogbill.DojosNinjasAssignment.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcogbill.DojosNinjasAssignment.Models.Dojo;
import com.dcogbill.DojosNinjasAssignment.Repositories.DojoRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepo dojoRepo;
	
	// returns all Dojos
	public List<Dojo> allDojos() {
		return dojoRepo.findAll(); 
	}
	
	//creates a Dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	//retrieve a Dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
		
	}

}