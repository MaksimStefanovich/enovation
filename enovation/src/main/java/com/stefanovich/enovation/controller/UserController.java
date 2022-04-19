package com.stefanovich.enovation.controller;


import com.stefanovich.enovation.exception.UserNotFoundException;
import com.stefanovich.enovation.model.User;
import com.stefanovich.enovation.repository.UserRepository;
import com.stefanovich.enovation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
    final UserRepository userRepository;
    final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@Valid @RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(()
                -> new UserNotFoundException("Not found user with id - " + id));
    }

    @PutMapping("{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable("id") Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    return userRepository.save(user);
                })
                .orElseGet(() -> userRepository.save(newUser));
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
