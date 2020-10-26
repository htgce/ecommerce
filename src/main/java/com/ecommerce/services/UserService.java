package com.ecommerce.services;

import com.ecommerce.model.dto.UserDto;
import com.ecommerce.model.entity.User;
import com.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDto> getUserList() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public UserDto addUser(UserDto userDto) {
        return new UserDto(userRepository.save(new User(userDto)));
    }
}
