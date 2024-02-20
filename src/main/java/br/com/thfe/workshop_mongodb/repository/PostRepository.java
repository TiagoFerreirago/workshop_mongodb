package br.com.thfe.workshop_mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.thfe.workshop_mongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	
	List<Post>findByTitleIgnoreCase(String text)   ;
		
	
}
