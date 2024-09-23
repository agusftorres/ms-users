package com.agusftorres.users.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.agusftorres.users.entity.User;
import com.agusftorres.users.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

   @InjectMocks
   private UserService userService;

   @Mock
   private UserRepository userRepository;

   @Test
   public void testGetAllUsuarios() {

      List<User> users = Arrays.asList(new User(1L, "John Doe", "john.doe@example.com"));
      when(userRepository.findAll()).thenReturn(users);

      List<User> result = userService.getAllUsers();
      assertEquals(1, result.size());
   }

}