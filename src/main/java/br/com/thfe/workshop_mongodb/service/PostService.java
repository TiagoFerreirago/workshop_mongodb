package br.com.thfe.workshop_mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thfe.workshop_mongodb.domain.User;
import br.com.thfe.workshop_mongodb.dto.UserDto;
import br.com.thfe.workshop_mongodb.repository.UserRepository;
import br.com.thfe.workshop_mongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	
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
	
	public User insert(User user) {
		return service.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		service.deleteById(id);
	}
	
	public User update(User user) {
		User newUser= findById(user.getId());
		updatefrom(newUser,user);
		return service.save(newUser);
	}
	
	private void updatefrom(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDto(UserDto obj) {
		User user = new User(obj.getId(), obj.getName(), obj.getEmail());
		return user;
	}
}
