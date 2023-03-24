package com.it_academy.data.dto.user;

import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String email;

    private Role role;

    public enum Role {
        SECURE_API_USER, ADMINISTRATOR, SALE_USER, CUSTOMER_USER
    }
}