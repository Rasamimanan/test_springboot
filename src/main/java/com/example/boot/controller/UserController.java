package com.example.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.entity.User;
import com.example.boot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // POST create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // GET user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User deleted with id: " + id;
    }
    //mise a jour
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUserData) {
        return userRepository.findById(id)
            .map(user -> {
                user.setNom(newUserData.getNom());
                user.setEmail(newUserData.getEmail());
                return userRepository.save(user);
            })
            .orElseGet(() -> {
                // Raha tsy misy ilay id, afaka mamorona vaovao koa
                newUserData.setId(id);
                return userRepository.save(newUserData);
            });
}

}