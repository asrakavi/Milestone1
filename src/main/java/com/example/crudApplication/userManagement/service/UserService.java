package com.example.crudApplication.userManagement.service;

import com.example.crudApplication.userManagement.entity.User;
import com.example.crudApplication.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

//Service class(logics are written in this class)
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    //Creating a user
    public User createUSer(User user) {

        if(userRepo.findByUserName(user.getUserName())!=null){
            throw new IllegalArgumentException("User with same Name already exits");
        }
        if(userRepo.findByMobileNumber(user.getMobileNumber())!=null){
            throw new IllegalArgumentException("User with same MobileNumber already exits");
        }
        if(userRepo.findByEmailId(user.getEmailId())!=null){
            throw new IllegalArgumentException("User with same EmailId already exits");
        }
        //If user don't already exits then create.
        return userRepo.save(user);
    }

    //Reading a user
    public User getUser(String id) {
        return userRepo.findById(id).orElseThrow(()-> new NoSuchElementException("User not found"));

    }

////Updating a user
    public User updateUser(User user) {
        if(!userRepo.existsById(user.getId())){
            throw new NoSuchElementException("User not found");
        }
        //If user already exits then update.
        return userRepo.save(user);
    }

    //Deleting a user
    public boolean deleteUser(String id) {
        if(!userRepo.existsById(id)){
            throw new NoSuchElementException("User not found");
        }
        //If user already exits then delete it.
        userRepo.deleteById(id);
        return true;
    }


}
