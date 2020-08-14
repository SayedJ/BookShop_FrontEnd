package net.guides.springboot2.crud.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bruger")
public class User implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
    private Long id;
	
	@Column(name = "firstname")
    private String firstname;
    
	@Column(name = "lastname")
    private String lastName;
    
	@Column(name = "email")    
    private String email;
    
	@Column(name = "password")
    private String password;
    
	@Column(name = "passwordConfirmation")
    private String passwordConfirmation;
    
    public User() {
    	  super();
    	 }

    	 public User(String firstname, String lastName, String email, String password, String passwordConfirmation) {
    	  super();
    	  this.firstname = firstname;
    	  this.lastName = lastName;
    	  this.email =email;
    	  this.password = password;
    	  this.passwordConfirmation = passwordConfirmation;
    	 }

	
    public void setId(Long id) {
			this.id = id;
		}

	public Long getId() {
        return id;
    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

   
    
}
