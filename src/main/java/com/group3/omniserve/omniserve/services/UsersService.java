package com.group3.omniserve.omniserve.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group3.omniserve.omniserve.models.User;
import com.group3.omniserve.omniserve.repositories.UserRepository;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

   

    // getAllUsers returns all users in the omniserve db
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = new ArrayList<>();
            userRepository.findAll().forEach(users::add);

            if (users.isEmpty()) {
                return new ResponseEntity<List<User>>(users, null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<User>>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // get user by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // addUser adds a users to the db
    public ResponseEntity<User> createUser(User user) {
        try {
            userRepository.save(user);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // updateUser updates the user in the db
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,User user) {
        Optional<User> userOpt =  userRepository.findById(id);

        if (userOpt.isPresent()) {
            User u = userOpt.get();
            u.setFirstName(u.getFirstName());
            u.setLastName(u.getLastName());
            u.setEmail(u.getEmail());
            u.setUpdateTimestamp(u.getUpdateTimestamp());

            return new ResponseEntity<User>(userRepository.save(u), null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // deleteUser removes a specified user from the db
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        try {
          userRepository.deleteById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }
}
