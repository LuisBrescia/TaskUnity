package taskunity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import taskunity.model.User;
import taskunity.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userRepository.findByName(user.getName()) != null) {
            System.out.println("Já existe um usuário com o nome de:  " + user.getName());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        if (user.getName() == null || user.getPassword() == null || user.getEmail() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {

        if (userRepository.findByName(user.getName()) == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        if (userRepository.existsById(id)) {
            user.setId(id);
            User savedUser = userRepository.save(user);
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User com ID " + id + " excluído com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User com ID " + id + " não encontrado.");
        }
    }

    @GetMapping("/function/{function}")
    public List<User> getUserFunction(@PathVariable String function) {
        if (function.equals("todos")) {
            return userRepository.findAll();
        }
        return userRepository.findByFunction(function);
    }

    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }
}

