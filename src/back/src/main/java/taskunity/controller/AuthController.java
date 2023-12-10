package taskunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import taskunity.repository.UserRepository;
import taskunity.model.User;

// import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired 
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> authenticate(@RequestBody User BodyUser) {

        User user = userRepository.findByName(BodyUser.getName());

        if ( user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        if (user.getPassword().equals(BodyUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
