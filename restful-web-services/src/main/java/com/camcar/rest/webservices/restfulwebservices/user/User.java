package com.camcar.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.camcar.rest.webservices.restfulwebservices.user.post.Post;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;
	@Past
	private Date bithDate;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	protected User() {
		
	}
	
	public User(Integer id, String name, Date bithDate) {
		super();
		Id = id;
		this.name = name;
		this.bithDate = bithDate;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBithDate() {
		return bithDate;
	}
	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", bithDate=" + bithDate + "]";
	}
}
