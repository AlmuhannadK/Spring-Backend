package com.luminousstore.luminousstore.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder

public class UserDTO {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;

}
