package net.slipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id @GeneratedValue
	private long id;
	
	@Column(length = 15, nullable = false, unique = true)
	private String userId;
	
	private String password;
	
	private String name;
	
	private String email;
	
	public User() {
	}
	
	public User(String userId, String password, String name, String email) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	public void update(User user) {
		if(matchPassword(user.password)) {
			this.name = user.name;
			this.email = user.email;
		}
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + "]";
	}

	public boolean matchId(long id) {
		return this.id == id;
	}

}
