package com.almansaj.webservices.restfulws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almansaj.webservices.restfulws.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
