package com.agusftorres.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agusftorres.users.entity.User;
import com.agusftorres.users.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
   @Autowired
   private UserService userService;

   @GetMapping
   public List<User> getAllUsers() {
      return userService.getAllUsers();
   }

   @GetMapping("/{id}")
   public ResponseEntity<User> getUserById(@PathVariable Long id) {
      return userService.getUserById(id)
                           .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                           .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }

   @PostMapping
   public ResponseEntity<User> createUser(@RequestBody User user) {
      User newUser = userService.saveUser(user);
      return new ResponseEntity<>(newUser, HttpStatus.CREATED);
   }

   @PutMapping
   public ResponseEntity<User> updateUser(@RequestBody User user) {
      User updatedUser = userService.updateUser(user);
      return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
   }


   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
      userService.deleteUser(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
