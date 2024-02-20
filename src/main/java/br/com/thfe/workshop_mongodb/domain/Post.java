package br.com.thfe.workshop_mongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.thfe.workshop_mongodb.dto.AuthorDto;
import br.com.thfe.workshop_mongodb.dto.CommentDto;
@Document(value="post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	
	private AuthorDto autor;
	
	private List<CommentDto>comment = new ArrayList<>();
	
	public Post() {
		
	}

	public Post(String id, Date date, String title, String body, AuthorDto autor) {
		
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.autor = autor;
	}

	public List<CommentDto> getComment() {
		return comment;
	}

	public void setComment(List<CommentDto> comment) {
		this.comment = comment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDto getAutor() {
		return autor;
	}

	public void setAutor(AuthorDto autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
}
