package com.luminousstore.luminousstore.service.Impl;

import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.entity.User;
import com.luminousstore.luminousstore.mapper.Impl.UserMapperImpl;
import com.luminousstore.luminousstore.repository.UserRepository;
import com.luminousstore.luminousstore.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;



    public UserDTO registerUser(UserDTO userDto){


        // check email is already there
        //
        if (this.userRepository.findByEmail(userDto.getEmail()) == null
                && this.userRepository.findByUsername(userDto.getUsername()) == null){
            User registerer = this.userMapper.userToEntity(userDto);
            this.userRepository.save(registerer);
            return userDto;
        }
        else{
            return null;
        }
    }


    // Add data validations (email and username are not repeated in db)
//    public Optional<UserDTO> registerUser(UserDTO userDto) {
//
//        Optional<UserDTO> userOptional = Optional.of(userDto);
//        if(userOptional.isPresent()) {
//            User checkUser = this.userMapper.userToEntity(userOptional.get());
//
//
//        }
//
//
//    }

//    private boolean emailCheck(String email) {
//        return this.userRepository.findByEmail(email);
//    }
//
//    private boolean usernameCheck(String username) {
//        return this.userRepository.findByUsername(username);
//    }
}
