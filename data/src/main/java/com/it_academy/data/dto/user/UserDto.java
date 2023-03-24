package com.it_academy.data.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    private Long id;

    @NotBlank(message = "{errors.user.create.firstname.empty}")
    @Size(min = 3, message = "{errors.user.create.username.short}")
    @Size(max = 20, message = "{errors.user.create.username.long}")
    private String firstName;

    @NotBlank(message = "{errors.user.create.password.empty}")
    @Size(min = 3, message = "{errors.user.create.password.short}")
    @Size(max = 40, message = "{errors.user.create.password.long}")
    private String lastName;

    @Size(max = 40, message = "{errors.user.create.patronymic.long}")
    private String patronymic;

    @NotBlank(message = "{errors.user.create.email.empty}")
    @Size(min = 4, message = "{errors.user.create.email.short}")
    @Size(max = 40, message = "{errors.user.create.email.long}")
    private String email;

    private Role role;

    public enum Role {
        SECURE_API_USER, ADMINISTRATOR, SALE_USER, CUSTOMER_USER
    }
}
