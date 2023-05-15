package com.example.crudApplication.userManagement.service;

import com.example.crudApplication.userManagement.entity.User;
import com.example.crudApplication.userManagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUSer() {
        User user=geTuser();
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User actual=userService.createUSer(user);
        assertEquals(user,actual);

    }

    @Test
    void getUser() {
        User user = geTuser();
        Mockito.when(userRepository.findById("1")).thenReturn(Optional.ofNullable(user));
        assertEquals(userService.getUser("1"),user);
    }

    @Test
    void updateUser() {
        User user=geTuser();
        Mockito.when(userRepository.findById("1")).thenReturn(Optional.ofNullable(user));
        user.setUserName("Alok");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertEquals(userService.updateUser(user),user);
    }

    @Test
    void deleteUser() {
        User user=geTuser();
        Mockito.when(userRepository.findById("1")).thenReturn(Optional.ofNullable(user));
        Mockito.when(userRepository.existsById(user.getId())).thenReturn(false);
        assertFalse(userRepository.existsById(user.getId()));
    }

    public User geTuser(){
        User mock = new User();
        mock.setId("1");
        mock.setEmailId("rana@gmail.com");
        mock.setAddress1("Delhi");
        mock.setAddress2("Bombay");
        mock.setMobileNumber("124678");
        mock.setFirstName("Raja");
        mock.setLastName("Avi");
        mock.setUserName("Rana");
        return mock;
    }
}