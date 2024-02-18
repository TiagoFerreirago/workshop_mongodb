package br.com.thfe.workshop_mongodb.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.thfe.workshop_mongodb.domain.Post;
import br.com.thfe.workshop_mongodb.domain.User;

public class AuthorDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	
	public AuthorDto() {
		
	}

	public AuthorDto(User post) {
		
		this.id = post.getId();
		this.name = post.getName();
		
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

}