package com.daniel.example.restful_api_security.security;

import com.daniel.example.restful_api_security.model.User;
import com.daniel.example.restful_api_security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class UserDetailsServiceImp implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImp (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User fromDatabase = userRepository.findByUsername(username);
        if(fromDatabase == null)
            throw new UsernameNotFoundException("User with username " + username + " was not found.");

        return fromDatabase;
    }
}
