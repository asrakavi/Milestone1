package com.example.crudApplication.userManagement.controller;

import com.example.crudApplication.userManagement.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.crudApplication.userManagement.entity.User;


import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class userControllerTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private UserService userService;



    @Test
    void createUser() {
    }

    @Test
    void getUser() throws Exception {
        User mockUser = new User();
        mockUser.setId("abc");
        mockUser.setEmailId("abc@gmail.com");
        mockUser.setAddress1("abc,sdk,dsk");
        mockUser.setAddress2("abc,xcjgd,sdh");
        mockUser.setMobileNumber("124678");
        mockUser.setFirstName("abcdvr");
        mockUser.setLastName("dsdsfd");
        mockUser.setUserName("asr");

        String id = "abc";
        String URI = "/User/{id}";
        ResponseEntity<?> mockResponseEntity = new ResponseEntity<>(mockUser,HttpStatus.OK);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI,id).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = result.getResponse().getContentAsString();

        assertEquals(HttpStatus.OK.value(),response.getStatus());




    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}