package com.agusftorres.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agusftorres.users.entity.User;
import com.agusftorres.users.exception.UserNotFoundException;
import com.agusftorres.users.repository.UserRepository;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;

   public List<User> getAllUsers() {
      return userRepository.findAll();
   }

   public User saveUser(User user) {
      return userRepository.save(user);
   }

   public Optional<User> getUserById(Long id) {
      return userRepository.findById(id);
   }

   public void deleteUser(Long id) {
      userRepository.deleteById(id);
   }

   public User updateUser(User user) {
      if (userRepository.findById(user.getId()).isEmpty()) {
         throw new UserNotFoundException("User not exist: " + user.getId());
      }
      return userRepository.save(user);
   }
}
