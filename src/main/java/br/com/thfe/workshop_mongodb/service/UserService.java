package br.com.thfe.workshop_mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thfe.workshop_mongodb.domain.User;
import br.com.thfe.workshop_mongodb.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository service;
	
	public List<User> findAll(){
		List<User>list = service.findAll();
		return list;
	}
}
