package com.in28minutes.rest.webservices.restfulwebservices.user;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "All details about the user") 	//Part of SWAGGER Documentation about user class in http://localhost:8080/v2/api-docs
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@ApiModelProperty(notes = "Name should have at least 2 characters") //Part of SWAGGER Documentation about user class in http://localhost:8080/v2/api-docs
	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;

	@ApiModelProperty(notes = "Birth Date should be in the past") //Part of SWAGGER Documentation about user class in http://localhost:8080/v2/api-docs
	@Past
	private Date birthDate;

	//MAKE SURE to mention variable mentioned against User in Post class. Here it's user
	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	public User() {
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	//MAKE SURE Not to include posts in toString() override method to avoid recursion
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", birthDate=" + birthDate +
				'}';
	}
}
