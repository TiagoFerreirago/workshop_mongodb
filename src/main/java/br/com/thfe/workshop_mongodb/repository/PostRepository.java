package br.com.thfe.workshop_mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.thfe.workshop_mongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'title': {$regex: ?0, $options: 'i' } }")
	List<Post>searchTitleQuery(String text);
	
	List<Post>findByTitleIgnoreCase(String text)   ;
		
	
}
