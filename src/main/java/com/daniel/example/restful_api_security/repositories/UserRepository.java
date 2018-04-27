package com.daniel.example.restful_api_security.repositories;

import com.daniel.example.restful_api_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
