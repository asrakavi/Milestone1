package com.example.crudApplication.userManagement.repository;

import com.example.crudApplication.userManagement.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByMobileNumber(String mobileNumber);
    Optional<User> findByEmailId(String emailId);
}
