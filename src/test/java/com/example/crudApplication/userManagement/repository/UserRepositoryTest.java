package com.example.crudApplication.userManagement.repository;

import com.example.crudApplication.userManagement.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class UserRepositoryTest {

    //@Autowired
    //private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserName() {

        User user=geTuser();

        userRepository.save(user);
        User actual=userRepository.findByUserName("Avanish");
        assertThat(actual.getId()).isEqualTo("1");
    }

    @Test
    void findByMobileNumber() {
        User user=geTuser();

        //entityManager.persist(user);
        userRepository.save(user);
        User actual=userRepository.findByMobileNumber("124678");
        assertThat(actual.getUserName()).isEqualTo("Avanish");
    }

    @Test
    void findByEmailId() {
        User mock = new User();
        mock.setId("1");
        mock.setEmailId("rana@gmail.com");
        mock.setAddress1("Delhi");
        mock.setAddress2("Bombay");
        mock.setMobileNumber("124678");
        mock.setFirstName("Raja");
        mock.setLastName("Avi");
        mock.setUserName("Avanish");

        //entityManager.persist(mock);
        userRepository.save(mock);
        User actual=userRepository.findByEmailId("rana@gmail.com");
        assertThat(actual.getUserName()).isEqualTo("Avanish");

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
        mock.setUserName("Avanish");
        return mock;
    }

}