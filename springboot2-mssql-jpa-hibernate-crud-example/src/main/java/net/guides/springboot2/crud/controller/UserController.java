package net.guides.springboot2.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.model.Books;
import net.guides.springboot2.crud.model.User;
import net.guides.springboot2.crud.repository.UserRepository;
import net.guides.springboot2.crud.service.UserServiceImpl;


@RestController
public class UserController {

	 @Autowired
	 private UserServiceImpl userService;
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 
	 
	 @GetMapping("/user/")
	 public List<User> getAllUser(){
	  return userService.getAllUser();
	 }
	 
	 @GetMapping("/user/{userId}")
	 public User getUser(@PathVariable int userId) {
	  return userService.getUserById(userId);
	 }
	 
	 @PostMapping("/user/")
	 public User addUser(@Valid @RequestBody User user)
	 {
		return userRepository.save(user);
		 
	 }
	 
	 @PutMapping("/user/{id}")
	 public  ResponseEntity<String> updateUser(@RequestBody User user){
		 if (user.getId() == null) {
	            addUser(user);
	        }
	        userService.editUser(user);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 @DeleteMapping("/users/{id}")
	   public ResponseEntity<String> deleteUser(@PathVariable Long id){
	        User user = userService.getUserById(id);
	        if (user == null) {
	            return new ResponseEntity<>("userNotFound", HttpStatus.NOT_FOUND);
	        }

	        userService.deleteUserById(id);
	        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	    }
	 }
	 
	
