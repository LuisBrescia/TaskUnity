package taskunity.services;

import org.springframework.stereotype.Service;
import taskunity.models.User;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import taskunity.repositories.TaskRepository;
import taskunity.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {

        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
    }

    public String getAllUsers() {
        // > Lógica para buscar e retornar todos os usuários
        return "Todos os usuários";
    }

    @Transactional
    public User create(User obj) {
        obj.setId(null);
        obj = this.userRepository.save(obj);
        return obj;
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

    // @Transactional
    // public User update(User obj) {
    //     User newObj = findById(User.getId());
    //     this.UserService.update(obj);
    //     newObj.setPassword(this.bCryptPasswordEncoder.encode(obj.getPassword()));
    //     return this.userRepository.save(newObj);
    // }


}