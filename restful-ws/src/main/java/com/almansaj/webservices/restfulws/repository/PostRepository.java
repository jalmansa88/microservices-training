package com.almansaj.webservices.restfulws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almansaj.webservices.restfulws.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
}
