package com.luminousstore.luminousstore.repository;

import com.luminousstore.luminousstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
