package com.ebookstoreProject.ebookstore.controller;

import com.ebookstoreProject.ebookstore.entity.UserEntity;
import com.ebookstoreProject.ebookstore.model.User;
import com.ebookstoreProject.ebookstore.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/")

@CrossOrigin("http://localhost:3000/")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {this.userService=userService;}
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/users/{Id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer Id){
        User user=null;
        user=userService.getUserById(Id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/users/{Id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer Id,@RequestBody User user){
        user=userService.updateUser(Id,user);
        return ResponseEntity.ok(user);
    }
}
