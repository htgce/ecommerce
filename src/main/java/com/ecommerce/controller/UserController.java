package com.ecommerce.controller;

import com.ecommerce.model.dto.UserDto;
import com.ecommerce.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(description = "Retrieve users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userList = userService.getUserList();
        if (userList != null && !userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
