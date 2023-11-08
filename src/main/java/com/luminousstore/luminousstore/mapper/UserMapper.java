package com.luminousstore.luminousstore.mapper;

import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.entity.User;

public interface UserMapper {

    UserDTO userToDto(User user);

    User userToEntity(UserDTO dto);
}
