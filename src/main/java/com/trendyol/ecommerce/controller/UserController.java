package com.trendyol.ecommerce.controller;

import com.trendyol.ecommerce.model.dto.UserDto;
import com.trendyol.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<UserDto> getAllUser() {
        return userService.getUserList();
    }
}
