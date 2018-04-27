package com.daniel.example.restful_api_security.controllers;

import com.daniel.example.restful_api_security.model.User;
import com.daniel.example.restful_api_security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class APIController {

    private UserRepository userRepository;

    @Autowired
    public APIController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> listAllUsers () {

        List<User> users = userRepository.findAll(); //TODO implement using sort
        if(users.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser (@PathVariable("id") Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(user -> new ResponseEntity<>(user,HttpStatus.OK));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
