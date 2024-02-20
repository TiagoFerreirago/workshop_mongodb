package br.com.thfe.workshop_mongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private AuthorDto author;
	private Date date; 
	
	
	public CommentDto() {
		
	}


	public CommentDto(AuthorDto author,String id, Date date) {
		
		this.id = id;
		this.author = author;
		this.date = date;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public AuthorDto getAuthor() {
		return author;
	}


	public void setAuthor(AuthorDto author) {
		this.author = author;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
}
