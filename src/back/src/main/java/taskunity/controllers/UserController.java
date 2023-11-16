package taskunity.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import taskunity.models.User;
import taskunity.services.UserService;
import taskunity.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}

