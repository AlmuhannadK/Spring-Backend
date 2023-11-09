package com.luminousstore.luminousstore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder

public class UserDTO {

    @NonNull
    @Size(min = 2, max = 20)
    private String firstName;

    @NonNull
    @Size(min = 2, max = 20)
    private String lastName;

    @NonNull
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{4,}$")
    private String username;

    @NonNull
    @Email
    private String email;  //    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,4}")


    @NonNull
    private String password;

}
