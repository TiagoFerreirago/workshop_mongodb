package br.com.thfe.workshop_mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.thfe.workshop_mongodb.domain.Post;
import br.com.thfe.workshop_mongodb.service.PostService;

@RestController
@RequestMapping(value= "/posts")
public class PostController {

	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public ResponseEntity<Post>findByIdPost(@PathVariable String id) {
		Post obj= service.findByIdPost(id);
		return ResponseEntity.ok().body(obj);
	}
}