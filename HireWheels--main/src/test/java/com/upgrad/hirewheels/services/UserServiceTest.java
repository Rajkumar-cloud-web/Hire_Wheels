package com.upgrad.hirewheels.services;


import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setFirstName("Test 1");
        user.setLastName("mishra");
        user.setPassword("123456");
        user.setWalletMoney(800);
        user.setEmail("tb@gmail.com");// repeated emailId
        user.setMobileNo(88998l);
       // user.setRole(role1);


        try {
            User savedUser = userService.createUser(user);
            Assertions.assertNotNull(savedUser);
            Assertions.assertTrue(savedUser.getUserId() != 0);
            Assertions.assertEquals("Test 1", savedUser.getFirstName());
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testGetUser(){

        User user = new User();
        user.setFirstName("Test 2");
        user.setLastName("Test@");
        user.setEmail("test@gmail.com");
        user.setPassword("test");
        user.setMobileNo(999l);
        try {
            userService.createUser(user);
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }


        try {
            User savedUser = userService.getUser("test@gmail.com","test");
            Assertions.assertNotNull(savedUser);
            Assertions.assertTrue(savedUser.getUserId() != 0);
            Assertions.assertEquals("Test 2", savedUser.getFirstName());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }





    }


}
