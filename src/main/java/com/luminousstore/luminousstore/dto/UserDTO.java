package com.luminousstore.luminousstore.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder

public class UserDTO {

    @NotEmpty
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20 ,message = "Last name must be at least 2 and maximum 20 characters")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @NotEmpty
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]+$")
    private String username;

//    @Email
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private String email;

    @NotEmpty(message = "password must not be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$")
    private String password;

}
