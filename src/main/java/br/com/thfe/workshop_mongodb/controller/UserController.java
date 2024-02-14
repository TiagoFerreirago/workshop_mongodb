package br.com.thfe.workshop_mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thfe.workshop_mongodb.domain.User;

@RestController
@RequestMapping(value= "/users")
public class UserController {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>>findAll(){
		User fernando = new User(1L, "Fernando Love","Fernandodogueto@gmail.com" );
		User geovana = new User(2L, "Geovana Silva", "Genova@gmail.com");
		List<User>list = new ArrayList<>();
		list.add(geovana);
		list.add(fernando);
		return ResponseEntity.ok().body(list);
		
	}
}
