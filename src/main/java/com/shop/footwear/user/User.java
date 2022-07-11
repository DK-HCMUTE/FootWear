package com.shop.footwear.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
	@Column(name = "enable", nullable = false)
	private boolean enable;
	

	@Column(name = "email", nullable = false, length = 70)
	private String email;
	
	@Column(name = "password", nullable = false, length = 70)
	private String password;
	
	
	
	public User(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@ManyToMany
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String firstName, String lastName, boolean enable) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.enable = enable;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", enable=" + enable
				+ ", email=" + email + ", roles=" + roles + "]";
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	public User(String email, String firstName, String lastName, boolean enable, Set<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.enable = enable;
		this.email = email;
		this.roles = roles;
	}

	public User(Long id, String firstName, String lastName, boolean enable, String email, String password,
			Set<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enable = enable;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	
	

	
}
