package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.mapper.Impl.UserMapperImpl;
import com.luminousstore.luminousstore.repository.UserRepository;
import com.luminousstore.luminousstore.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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

    public ResponseEntity registerUser(UserDTO userDto) {
        if ( !usernameAlreadyExists(userDto.getUsername()) && !emailAlreadyExists(userDto.getEmail())) {
            User registerer = this.userMapper.userToEntity(userDto);
            this.userRepository.save(registerer);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);

        } else {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }


    public boolean usernameAlreadyExists(String username) {
        return this.userRepository.findByUsername(username) != null;
    }
    public boolean emailAlreadyExists(String email) {
        return this.userRepository.findByEmail(email) != null;
    }
}
