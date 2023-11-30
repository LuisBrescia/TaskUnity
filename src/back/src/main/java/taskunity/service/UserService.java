package taskunity.service;

import org.springframework.stereotype.Service;

import taskunity.model.User;

@Service
public class UserService {

    public String getAllUsers() {
        // > Lógica para buscar e retornar todos os usuários
        return "Todos os usuários";
    }

    public String getUser(Integer userId) {
        // > Lógica para buscar e retornar os detalhes do usuário com o ID especificado
        return "Detalhes do usuário com ID " + userId;
    }

    // > Lógica para criar um novo usuário com os dados fornecidos
    public User createUser(User newUser) {
        return newUser;
    }

    public String updateUser(Integer userId, User updatedUser) {
        // > Lógica para atualizar as informações do usuário com o ID especificado
        return "Usuário com ID " + userId + " atualizado com sucesso";
    }

    public String deleteUser(Integer userId) {
        // > Lógica para excluir o usuário com o ID especificado
        return "Usuário com ID " + userId + " excluído com sucesso";
    }

    public String getUserFunction(String function) {
        // > Lógica para buscar usuário com função específicas
        return "Usuário exerce a função de: "+ function;
    }
}