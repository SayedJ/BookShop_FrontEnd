package net.guides.springboot2.crud.service;

import java.util.List;

import net.guides.springboot2.crud.model.User;

public interface UserService {
 
 public List<User> getAllUser();
 
 public User getUserById(long id);
 
 public User addUser(User user);

public void editUser(User user);

public void deleteUserById(Long userId);
}


