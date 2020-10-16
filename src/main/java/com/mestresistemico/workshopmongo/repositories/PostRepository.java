package com.mestresistemico.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mestresistemico.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends /* Exclusivo Mongo */ MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
