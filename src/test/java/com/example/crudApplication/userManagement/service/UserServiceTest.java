package com.example.crudApplication.userManagement.service;

import com.example.crudApplication.userManagement.entity.User;
import com.example.crudApplication.userManagement.repository.UserRepository;
import jakarta.persistence.MapsId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {


    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

//    @BeforeEach
//    void setUp(){
//        this.userService=new UserService(userRepository);
//    }

    @Test
    public void createUSer() {
        User user=geTuser();
        Mockito.when(userRepository.save(user)).thenReturn(user);
//        User actual=userService.createUSer(user);
//        assertEquals(user,actual);
        assertThat(userService.createUSer(user)).isEqualTo(user);

    }

    @Test
    void getUser() {

        User user = geTuser();
        Mockito.when(userRepository.findById("1")).thenReturn(Optional.ofNullable(user));
        //assertEquals(userService.getUser("1"),user);
        assertThat(userService.getUser("1")).isEqualTo(user);


//        User user = geTuser();
//        userRepository.save(user);
//        userService.getUser("1");
//        verify(userRepository).findById("1");

    }

    @Test
    void updateUser() {
        User user = geTuser();
        user.setUserName("Alok");
        Mockito.when(userRepository.existsById(user.getId())).thenReturn(true);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertThat(userService.updateUser(user)).isEqualTo(user);
    }

    @Test
    void deleteUser() {
        User user=geTuser();
        //Mockito.when(userRepository.findById("1")).thenReturn(Optional.ofNullable(user));
        Mockito.when(userRepository.existsById(user.getId())).thenReturn(true);
        //assertFalse(userRepository.existsById(user.getId()));
        assertThat(userService.deleteUser(user.getId())).isTrue();
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