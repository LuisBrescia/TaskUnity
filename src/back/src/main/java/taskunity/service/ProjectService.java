package taskunity.service;

import org.springframework.stereotype.Service;

import taskunity.model.Project;

@Service
public class ProjectService {

    public String getAllProjects() {
        // > Lógica para buscar e retornar todos os projetos
        return "Todos os projetos";
    }

    public String getProject(Integer projectId) {
        // > Lógica para buscar e retornar os detalhes do projeto com o ID especificado
        return "Detalhes do projeto com ID " + projectId;
    }

    public String createProject(Project newProject) {
        // > Lógica para criar um novo projeto com os dados fornecidos
        return "Projeto criado com sucesso na conta do usuário com ID " + newProject;
    }

    public String updateProject(Integer projectId, Project updatedProject) {
        // > Lógica para atualizar as informações do projeto com o ID especificado
        return "Projeto com ID " + projectId + " atualizado com sucesso! " + updatedProject;
    }

    public String deleteProject(Integer projectId) {
        // > Lógica para excluir o projeto com o ID especificado
        return "Projeto com ID " + projectId + " excluído com sucesso!";
    }
}
