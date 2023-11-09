package com.luminousstore.luminousstore.repository;

import com.luminousstore.luminousstore.dto.UserDTO;
import com.luminousstore.luminousstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    UserDTO findByEmail(String email);

    UserDTO findByUsername(String username);

//    boolean findByEmail(String email);
//
//    boolean findByUsername(String username);

}
