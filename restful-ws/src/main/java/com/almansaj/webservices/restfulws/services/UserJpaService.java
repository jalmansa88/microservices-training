package com.almansaj.webservices.restfulws.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almansaj.webservices.restfulws.exceptions.UserNotFoundException;
import com.almansaj.webservices.restfulws.model.User;
import com.almansaj.webservices.restfulws.repository.UserRepository;

@Service
public class UserJpaService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User save(User user){
		return repo.save(user);
	}
	
	public User findById(int id) {
		Optional<User> userOpt = repo.findById(id);
		
		return userOpt.orElseThrow(() -> new UserNotFoundException("id-" + id));
	}
	
	public void deleteByid(int id) {
		repo.deleteById(id);
	}
}
