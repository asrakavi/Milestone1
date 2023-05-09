package com.example.crudApplication.userManagement.controller;

import com.example.crudApplication.userManagement.entity.User;
import com.example.crudApplication.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {

    @Autowired
    private UserService userService;

    //To create User
    @RequestMapping(method = RequestMethod.POST,value="/User")
    public User createUser(@RequestBody User user){
        return userService.createUSer(user);
    }

    //To read/get a User
    @RequestMapping(method = RequestMethod.GET,value="/User/{id}")
    public User GetUser(@PathVariable String id){
        return userService.getUser(id);
    }

    //To update a User
    @RequestMapping(method = RequestMethod.PUT,value="/User")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    //To delete a User
    @RequestMapping(method = RequestMethod.DELETE,value="/User/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }


}
