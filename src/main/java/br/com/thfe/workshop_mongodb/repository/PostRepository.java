package br.com.thfe.workshop_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.thfe.workshop_mongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
