package br.com.thfe.workshop_mongodb.dto;

import java.io.Serializable;

import br.com.thfe.workshop_mongodb.domain.User;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDto() {
		
	}
	
	public UserDto(User dto) {
		id = dto.getId();
		name = dto.getName();
		email = dto.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
