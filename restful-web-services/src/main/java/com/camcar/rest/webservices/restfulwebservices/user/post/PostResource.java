package com.camcar.rest.webservices.restfulwebservices.user.post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.camcar.rest.webservices.restfulwebservices.user.User;
import com.camcar.rest.webservices.restfulwebservices.user.UserNotFoundException;

@RestController
public class PostResource {

	@Autowired
	private PostDaoService service;

	@GetMapping("/users/{id}/posts")
	public List<Post> retrievePostForUser(@PathVariable int id) {
		List<Post> posts = service.findAll(id);
		if (posts == null)
			throw new UserNotFoundException("id : " + id);
		return posts;
	}

	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPost(@RequestBody Post post) {
		Post postSaved = service.save(post);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(postSaved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}/posts/{post_id}")
	public Post retrieveUser(@PathVariable int id, @PathVariable int post_id) {
		Post post = service.findOne(id, post_id);
		if(post == null)
			throw new PostNotFoundException(" post id : "+id);
		return post;
	}
}
