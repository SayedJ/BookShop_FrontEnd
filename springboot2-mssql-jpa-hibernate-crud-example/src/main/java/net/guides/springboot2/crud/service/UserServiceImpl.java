package net.guides.springboot2.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.guides.springboot2.crud.config.SecurityConfig;
import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Books;
import net.guides.springboot2.crud.model.User;
import net.guides.springboot2.crud.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class UserServiceImpl implements UserService {
 
 private static List<User> users = new ArrayList<>();
 
 private UserRepository userRepository;
 


 @Override
 public List<User> getAllUser() {
  return userRepository.findAll();
 }

 @Override
 public User getUserById(long id) {
  for(User user : users) {
   if(user.getId() == id) {
    return user;
   }
  }
  return null;
 }

@Override
public User addUser(User user) {
	
	User newUser = new User();
    newUser.setFirstname(user.getFirstname());
    newUser.setPassword(user.getPassword());
    newUser.setPasswordConfirmation(user.getPasswordConfirmation());
    newUser.setLastName(user.getLastName());
    userRepository.save(newUser);
    return newUser;
}

@Override
public void editUser(User user) {
	userRepository.save(user);
    
}

@Override
public void deleteUserById(Long userId) {
	userRepository.deleteById(userId);
	
}




}
