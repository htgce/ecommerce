package com.trendyol.ecommerce.model.entity;

import com.sun.istack.NotNull;
import com.trendyol.ecommerce.model.dto.UserDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends ECommerceObject {
    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private String password;

    public User(UserDto userDto) {
        setId(userDto.getId());
        setFirstName(userDto.getFirstName());
        setLastName(userDto.getLastName());
    }
}
