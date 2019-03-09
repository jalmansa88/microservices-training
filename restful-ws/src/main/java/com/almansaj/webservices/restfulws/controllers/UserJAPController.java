package com.almansaj.webservices.restfulws.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.almansaj.webservices.restfulws.model.Post;
import com.almansaj.webservices.restfulws.model.User;
import com.almansaj.webservices.restfulws.repository.PostRepository;
import com.almansaj.webservices.restfulws.services.UserJpaService;

@RestController
@RequestMapping("/jpa")
public class UserJAPController {

	@Autowired
	private UserJpaService userService;
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public Resource<User> rerieveUser(@PathVariable int id) {
		User userFound = userService.findById(id);
		
		Resource<User> resource = new Resource<>(userFound);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("users"));
		return resource;
	}
	
	@GetMapping(path = "/users/{id}/posts")
	public List<Post> getAllUserPosts(@PathVariable int id) {
		return userService.findById(id).getPosts();
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User createdUser = userService.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<User> createUserPost(@PathVariable int id, @RequestBody Post post) {
		User user = userService.findById(id);
		
		post.setUser(user);
		postRepo.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void removeUser(@PathVariable int id) {
		userService.deleteByid(id);
	}
	
}
