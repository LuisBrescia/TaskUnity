package taskunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import taskunity.repository.UserRepository;
import taskunity.model.User;

// import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired 
    private UserRepository userRepository;

    @PostMapping
    public String authenticate(@RequestBody User BodyUser) {

        User user = userRepository.findByName(BodyUser.getName());

        if ( user == null) {
            return "Usuário não encontrado";
        }

        if (user.getPassword().equals(BodyUser.getPassword())) {
            return "token";
        } else {
            return "Senha incorreta";
        }
    }
}
