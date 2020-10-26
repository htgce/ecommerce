package com.trendyol.ecommerce.service;

import com.trendyol.ecommerce.model.dto.UserDto;
import com.trendyol.ecommerce.model.entity.User;
import com.trendyol.ecommerce.repository.UserRepository;
import com.trendyol.ecommerce.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void given1UserExistsInDbWhenAllUsersAreRequestedThenGet1User() {
        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User());
        when(userRepository.findAll()).thenReturn(userListMock);
        List<UserDto> allUsers = userService.getUserList();
        assertEquals(1, allUsers.size());
    }

}
