package com.dcogbill.DojosNinjasAssignment.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dcogbill.DojosNinjasAssignment.Models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long>{
	
	//returns list of all ninjas
	List<Ninja> findAll();

}
