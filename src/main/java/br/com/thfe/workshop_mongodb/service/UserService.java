package br.com.thfe.workshop_mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thfe.workshop_mongodb.domain.User;
import br.com.thfe.workshop_mongodb.repository.UserRepository;
import br.com.thfe.workshop_mongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	
	@Autowired
	private UserRepository service;
	
	public List<User> findAll(){
		List<User>list = service.findAll();
		return list;
	}
	
	public User findById(String id) {
		Optional<User>user= service.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
}
