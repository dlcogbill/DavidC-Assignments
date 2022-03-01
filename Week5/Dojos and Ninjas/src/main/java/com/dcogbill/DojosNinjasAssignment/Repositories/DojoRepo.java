package com.dcogbill.DojosNinjasAssignment.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dcogbill.DojosNinjasAssignment.Models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{
	
	//returns list of all dojos
	List<Dojo> findAll();

}
