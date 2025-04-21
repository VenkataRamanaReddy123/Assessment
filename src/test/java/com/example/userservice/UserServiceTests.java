package com.example.userservice;

import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterValidUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setAge(25);
        user.setCountry("France");

        User saved = userService.registerUser(user);
        Assertions.assertNotNull(saved.getId());
    }

    @Test
    public void testRegisterInvalidAge() {
        User user = new User();
        user.setName("Jane Doe");
        user.setEmail("jane@example.com");
        user.setAge(17);
        user.setCountry("France");

        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
    }

    @Test
    public void testRegisterInvalidCountry() {
        User user = new User();
        user.setName("Tom");
        user.setEmail("tom@example.com");
        user.setAge(25);
        user.setCountry("Germany");

        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
    }
}
