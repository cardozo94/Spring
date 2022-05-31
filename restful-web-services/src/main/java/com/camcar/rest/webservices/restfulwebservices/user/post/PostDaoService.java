package com.camcar.rest.webservices.restfulwebservices.user.post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.camcar.rest.webservices.restfulwebservices.user.UserDaoService;

@Component
public class PostDaoService {

	private static List<Post> posts = new ArrayList<>();
	private static int postCount = 3;

	static {
		UserDaoService userService = new UserDaoService();
		posts.add(new Post(1, userService.findOne(1), "Adam post"));
		posts.add(new Post(2, userService.findOne(2), "Eve post"));
		posts.add(new Post(3, userService.findOne(3), "Jack post"));
	}

	public List<Post> findAll(int userId) {
		return posts.stream().filter(post -> post.getUser().getId() == userId).collect(Collectors.toList());
	}

	public Post save(Post post) {
		if (post.getId() == null) {
			post.setId(++postCount);
		}
		posts.add(post);
		return post;
	}

	public Post findOne(int id, int postId) {
		for (Post post : posts) {
			if (post.getUser().getId() == id) {
				if (post.getId() == postId) {
					return post;
				}
			}
		}
		return null;
	}
}
