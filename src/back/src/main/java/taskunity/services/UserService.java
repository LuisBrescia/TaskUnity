package taskunity.services;

import org.springframework.stereotype.Service;
import taskunity.models.User;

@Service
public class UserService {

    public String getAllUsers() {
        // > Lógica para buscar e retornar todos os usuários
        return "Todos os usuários";
    }

    public String getUser(Long userId) {
        // > Lógica para buscar e retornar os detalhes do usuário com o ID especificado
        return "Detalhes do usuário com ID " + userId;
    }

    public String createUser(User newUser) {
        // > Lógica para criar um novo usuário com os dados fornecidos
        return "Usuário criado com sucesso " + newUser;
    }

    public String updateUser(Long userId, User user) {
        // > Lógica para atualizar as informações do usuário com o ID especificado
        return "Usuário com ID " + userId + " atualizado com sucesso";
    }

    public String deleteUser(Long userId) {
        // > Lógica para excluir o usuário com o ID especificado
        return "Usuário com ID " + userId + " excluído com sucesso";
    }
}
