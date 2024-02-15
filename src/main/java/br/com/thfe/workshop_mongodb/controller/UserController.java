package br.com.thfe.workshop_mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thfe.workshop_mongodb.domain.User;
import br.com.thfe.workshop_mongodb.service.UserService;

@RestController
@RequestMapping(value= "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>>findAll(){
		List<User>list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
