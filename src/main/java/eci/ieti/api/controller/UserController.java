package eci.ieti.api.controller;

import eci.ieti.api.model.User;
import eci.ieti.api.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<?> getAllUsers(){
        List<User> all = userService.getAll();
        return new ResponseEntity<>(all, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") String userId){
        User user = userService.getById(userId);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> createUser(@RequestBody User newUser){
        User user = userService.create(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "/users/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") String userId, @RequestBody User user){
        User updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId){
        userService.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
