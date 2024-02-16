package br.com.thfe.workshop_mongodb.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.thfe.workshop_mongodb.domain.User;
import br.com.thfe.workshop_mongodb.dto.UserDto;
import br.com.thfe.workshop_mongodb.service.UserService;

@RestController
@RequestMapping(value= "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDto>>findAll(){
		List<User>list = service.findAll();
		List<UserDto>dto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dto);
		
	}
	@RequestMapping(value= "/{id}", method= RequestMethod.GET)
	public ResponseEntity<UserDto> findById(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDto(user));
	}
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody UserDto obj){
		User dto = service.fromDto(obj);
		service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value= "/{id}",method= RequestMethod.DELETE)
	public ResponseEntity<Void>delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
