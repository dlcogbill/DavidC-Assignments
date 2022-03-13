package com.dcogbill.BookClub.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dcogbill.BookClub.Models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

	User findByEmail(String email);
}
