package com.ecommerce.controller;

import com.ecommerce.model.dto.UserDto;
import com.ecommerce.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void givenNoUserExistsInDbWhenAllUsersAreRequestedThenGetNoContent() {
        when(userService.getUserList()).thenReturn(Arrays.asList());
        ResponseEntity<List<UserDto>> actual = userController.getAllUsers();
        assertEquals(null, actual.getBody());
        assertEquals(HttpStatus.NO_CONTENT, actual.getStatusCode());
    }

    @Test
    public void given1UserExistsInDbWhenAllUsersAreRequestedThenGet1User() {
        List<UserDto> userDtoListMock = new ArrayList<>();
        userDtoListMock.add(new UserDto());
        when(userService.getUserList()).thenReturn(userDtoListMock);
        ResponseEntity<List<UserDto>> actual = userController.getAllUsers();
        assertEquals(1, actual.getBody().size());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}
