package com.example.crudApplication.userManagement.service;

import com.example.crudApplication.userManagement.entity.User;
import com.example.crudApplication.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;


    public User createUSer(User user) {

        if(userRepo.findByUserName(user.getUserName()).isPresent()){
            throw new IllegalArgumentException("User with same Name already exits");
        }
        if(userRepo.findByMobileNumber(user.getMobileNumber()).isPresent()){
            throw new IllegalArgumentException("User with same MobileNumber already exits");
        }
        if(userRepo.findByEmailId(user.getEmailId()).isPresent()){
            throw new IllegalArgumentException("User with same EmailId already exits");
        }
        return userRepo.save(user);
    }

    public User getUser(String id) {
        return userRepo.findById(id).orElseThrow(()-> new NoSuchElementException("User not found"));
    }


    public User updateUser(User user) {
        if(!userRepo.existsById(user.getId())){
            throw new NoSuchElementException("User not found");
        }
        return userRepo.save(user);
    }

    public void deleteUser(String id) {
        if(!userRepo.existsById(id)){
            throw new NoSuchElementException("User not found");
        }
        userRepo.deleteById(id);
    }
}
