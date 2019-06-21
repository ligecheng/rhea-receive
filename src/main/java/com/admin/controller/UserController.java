package com.admin.controller;

import com.admin.entity.User;
import com.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userServiceImp")
    public UserService userService;
    @GetMapping("/home")
    public java.util.List<User> List(){
        List<User>list=userService.getAll();

        return list;
    }

}
