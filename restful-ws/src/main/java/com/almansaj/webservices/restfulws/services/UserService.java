package com.almansaj.webservices.restfulws.services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.almansaj.webservices.restfulws.model.User;

@Service
public class UserService {
	
	private static List<User> users;
	private static int userCount = 3;
	
	static {
		users = new ArrayList<>(Arrays.asList(
					new User(1, "Javi", LocalDate.now()),
					new User(2, "Alberto", LocalDate.now()),
					new User(3, "Troll", LocalDate.now())));
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findById(int id) {
		return users
				.stream()
				.filter(u -> u.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
	public boolean deleteByid(int id) {
		return users.removeIf(user -> user.getId().equals(id));
	}
}
