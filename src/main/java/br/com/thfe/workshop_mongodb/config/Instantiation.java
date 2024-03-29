package br.com.thfe.workshop_mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.thfe.workshop_mongodb.domain.Post;
import br.com.thfe.workshop_mongodb.domain.User;
import br.com.thfe.workshop_mongodb.dto.AuthorDto;
import br.com.thfe.workshop_mongodb.dto.CommentDto;
import br.com.thfe.workshop_mongodb.repository.PostRepository;
import br.com.thfe.workshop_mongodb.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository repository;
	@Autowired
	private PostRepository repositoryP;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		repositoryP.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repository.saveAll(Arrays.asList(maria,alex,bob));
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
		Post post = new Post(null, fmt.parse("21/03/2018"), "Partiu viagem","Vou viajar para São Paulo. Abraços!",new AuthorDto(maria));
		Post post1 = new Post(null, fmt.parse("23/03/2018"), "Bom dia","Acordei feliz hoje!",new AuthorDto(bob));
		
		repositoryP.saveAll(Arrays.asList(post,post1));
		//adicionar referencia
		maria.getPost().add(post);
		bob.getPost().add(post1);
		repository.saveAll(Arrays.asList(maria,bob));
		
		CommentDto comment = new CommentDto(new AuthorDto(alex), "Boa viagem mano!", fmt.parse("21/03/2018"));
		CommentDto comment1 = new CommentDto(new AuthorDto(bob), "Aproveite!", fmt.parse("22/03/2018"));
		CommentDto comment2 = new CommentDto(new AuthorDto(alex), "Tenha um ótimo dia!", fmt.parse("23/03/2018"));
		
		post.getComment().addAll(Arrays.asList(comment, comment1));
		post1.getComment().add(comment2);
		
		repositoryP.saveAll(Arrays.asList(post, post1));
	}
	
	
}
