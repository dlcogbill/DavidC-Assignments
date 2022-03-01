package com.dcogbill.DojosNinjasAssignment.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcogbill.DojosNinjasAssignment.Models.Ninja;
import com.dcogbill.DojosNinjasAssignment.Repositories.NinjaRepo;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepo ninjaRepo;
	
	// returns all Ninjas
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll(); 
	}
	
	//creates a Ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	//retrieve a Ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
		
	}

}
