package com.daniel.example.restful_api_security.init;

import com.daniel.example.restful_api_security.model.Role;
import com.daniel.example.restful_api_security.model.RoleType;
import com.daniel.example.restful_api_security.model.User;
import com.daniel.example.restful_api_security.repositories.RoleRepository;
import com.daniel.example.restful_api_security.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public InitDataLoader (UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        //roles
        Role adminRole = new Role(RoleType.ROLE_ADMIN);
        Role userRole  = new Role(RoleType.ROLE_USER);
        roleRepository.saveAndFlush(adminRole);
        roleRepository.save(userRole);

        //users
        User admin = new User("admin","password");
        admin.getRoles().add(adminRole);
        admin.getRoles().add(userRole);
        userRepository.saveAndFlush(admin);

        User user = new User("user", "password");
        user.getRoles().add(userRole);
        userRepository.saveAndFlush(user);

    }
}
