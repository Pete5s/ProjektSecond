package com.example.Genesis.Project.controller;

import com.example.Genesis.Project.model.User;
import com.example.Genesis.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User addUser
    (@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }

    @GetMapping("/user/uuid/{uuid}")
    public String getUserByUuid(@PathVariable String uuid) {
        return userService.getUserByUuid(uuid);
    }
    @GetMapping("/user/name/{name}")
    public String getUserByName(@PathVariable String name) {
        return "User: " + name;
    }
    @GetMapping("/user/surname/{surname}")
    public String getUserBySurname(@PathVariable String surname) {
        return "User: " + surname;
    }


    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) throws Exception {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}


