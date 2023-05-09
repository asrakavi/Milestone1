package com.example.crudApplication.userManagement.repository;

import com.example.crudApplication.userManagement.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//User repo where all the functionllity are available which are required
@Repository
public interface UserRepository extends CrudRepository<User,String> {

    //We can define some extra function but those function name should be relevent means the name of the
    // function should be same as task we want to be done by that function, like some examples are below->

    //By this function we want to get user by userName, so as we can see the name of the function is the same
    //as we want to get done by function
    Optional<User> findByUserName(String userName);

    Optional<User> findByMobileNumber(String mobileNumber);

    Optional<User> findByEmailId(String emailId);
}
