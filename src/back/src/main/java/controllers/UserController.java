package controllers;

import org.springframework.web.bind.annotation.*;
import models.User;
import services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        return userService.createUser(user.getUsername(), user.getEmail());
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user.getUsername(), user.getEmail());
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}

