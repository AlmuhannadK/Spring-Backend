package com.luminousstore.luminousstore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserDTO {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

}
