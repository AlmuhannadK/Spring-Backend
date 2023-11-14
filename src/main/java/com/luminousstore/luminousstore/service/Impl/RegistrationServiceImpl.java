package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.mapper.Impl.UserMapperImpl;
import com.luminousstore.luminousstore.repository.UserRepository;
import com.luminousstore.luminousstore.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;



    public User getRegisteredUserById(Long id) {
        return this.userRepository.findById(id).get();
    }

    public List<User> getRegisteredUsers() {
        return this.userRepository.findAll();
    }

// why not use Optional class?
    public UserDTO registerUser(UserDTO userDto) {
        if ( !usernameAlreadyExists(userDto.getUsername()) && !emailAlreadyExists(userDto.getEmail())) {
            User registerer = this.userMapper.userToEntity(userDto);
            this.userRepository.save(registerer);
            return userDto;
        } else {
            return null;
        }
    }


    public boolean usernameAlreadyExists(String username) {
        return this.userRepository.findByUsername(username) != null;
    }
    public boolean emailAlreadyExists(String email) {
        return this.userRepository.findByEmail(email) != null;
    }
}
