package br.com.thfe.workshop_mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thfe.workshop_mongodb.domain.Post;
import br.com.thfe.workshop_mongodb.repository.PostRepository;
import br.com.thfe.workshop_mongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	
	@Autowired
	private PostRepository service;
	
	
	public Post findByIdPost(String id) {
		Optional<Post> post = service.findById(id);
		return post.orElseThrow(() ->  new ObjectNotFoundException("Objeto não encontrado"));		
	}
	
	/*public List<Post>findByTitle(String id){
		return service.findByTitleIgnoreCase(id);
	}*/
	
	public List<Post>findByTitle(String id){
		return service.searchTitleQuery(id);
	}
}