package taskunity.services;

import org.springframework.stereotype.Service;
import taskunity.models.Project;

@Service
public class ProjectService {

    public String getAllProjects() {
        // > Lógica para buscar e retornar todos os projetos
        return "Todos os projetos";
    }

    public String getProject(Long projectId) {
        // > Lógica para buscar e retornar os detalhes do projeto com o ID especificado
        return "Detalhes do projeto com ID " + projectId;
    }

    public String createProject(Project project) {
        // > Lógica para criar um novo projeto com os dados fornecidos
        return "Projeto criado com sucesso na conta do usuário com ID " + project.getowner().getId();
    }

    public String updateProject(Long projectId, Project project) {
        // > Lógica para atualizar as informações do projeto com o ID especificado
        return "Projeto com ID " + projectId + " atualizado com sucesso!";
    }

    public String deleteProject(Long projectId) {
        // > Lógica para excluir o projeto com o ID especificado
        return "Projeto com ID " + projectId + " excluído com sucesso!";
    }
}
