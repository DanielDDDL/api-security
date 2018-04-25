package com.daniel.example.restful_api_security.repositories;

import com.daniel.example.restful_api_security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
