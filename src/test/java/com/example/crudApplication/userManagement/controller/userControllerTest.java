package com.example.crudApplication.userManagement.controller;

import com.example.crudApplication.userManagement.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
    void createUser() throws Exception{

        User mockUser=geTuser();

        String inputInJson = mapToJson(mockUser);

        String message = mockUser + " Done";
        String URI = "/User";
        Mockito.when(userService.createUSer(Mockito.any(User.class))).thenReturn(mockUser);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(inputInJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
        assertEquals(inputInJson,outputInJson);

    }


    @Test
    void getUser() throws Exception {

        User mockUser=geTuser();

        String id = mockUser.getId();

        Mockito.when(userService.getUser(Mockito.anyString())).thenReturn(mockUser);
        String URI = "/User/{id}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI,id).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected=this.mapToJson(mockUser);
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = result.getResponse().getContentAsString();

        assertEquals(expected,outputInJson);

//        User mockUser =geTuser();
//
//        String id = mockUser.getId();
//        String URI = "/User/{id}";
//        ResponseEntity<?> mockResponseEntity = new ResponseEntity<>(mockUser,HttpStatus.OK);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI,id).accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputInJson = result.getResponse().getContentAsString();
//
//        assertEquals(HttpStatus.OK.value(),response.getStatus());


    }

    @Test
    void updateUser() throws Exception {

        User mockUser=geTuser();

        String inputInJson = mapToJson(mockUser);
        //String id = mockUser.getId();
        String URI = "/User";

        Mockito.when(userService.updateUser(Mockito.any(User.class))).thenReturn(mockUser);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URI).accept(MediaType.APPLICATION_JSON).content(inputInJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String expectedJson = mapToJson(mockUser);
        String outputInJson = response.getContentAsString();
        assertEquals(expectedJson,outputInJson);
    }

    @Test
    void deleteUser() throws Exception {

//        User mockUser=geTuser();
//        String id = mockUser.getId();

        String id="1";
        String URI = "/User/{id}";
        Mockito.doNothing().when(userService).deleteUser(Mockito.any(String.class));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URI,id);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(object);
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