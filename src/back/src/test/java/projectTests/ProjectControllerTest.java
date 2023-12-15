package projectTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import taskunity.controller.ProjectController;
import taskunity.model.Project;
import taskunity.repository.ProjectRepository;
import taskunity.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectRepository projectRepository;

    @MockBean
    private TaskRepository taskRepository;

    private Project projetoExemplo;

    @BeforeEach
    void setUp() {
        projetoExemplo = new Project();
        projetoExemplo.setId(1);
        projetoExemplo.setName("Projeto de Exemplo");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetProjetoPorIdOwner() throws Exception {
        int ownerId = 1;
        when(projectRepository.findByOwner(ownerId)).thenReturn(List.of(projetoExemplo));

        mockMvc.perform(MockMvcRequestBuilders.get("/projects/owner/{ownerId}", ownerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Projeto de Exemplo"));
    }

    @Test
    void testGetProjetoPorTool() throws Exception {
        String toolName = "FerramentaExemplo";
        when(projectRepository.findByTools(toolName)).thenReturn(List.of(projetoExemplo));

        mockMvc.perform(MockMvcRequestBuilders.get("/projects/tools/{toolName}", toolName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Projeto de Exemplo"));
    }

    @Test
    void testGetProjeto() throws Exception {
        int projectId = 1;
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(projetoExemplo));

        mockMvc.perform(MockMvcRequestBuilders.get("/projects/{id}", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Projeto de Exemplo"));
    }

    @Test
    void testCriarProjeto() throws Exception {
        when(projectRepository.save(any())).thenReturn(projetoExemplo);

        mockMvc.perform(MockMvcRequestBuilders.post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Projeto de Exemplo"));
    }

    @Test
    void testAtualizarProjeto() throws Exception {
        int projectId = 1;
        when(projectRepository.existsById(projectId)).thenReturn(true);
        when(projectRepository.save(any())).thenReturn(projetoExemplo);

        mockMvc.perform(MockMvcRequestBuilders.put("/projects/{id}", projectId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Projeto de Exemplo"));
    }

    @Test
    void testAtualizarProjetoNaoEncontrado() throws Exception {
        int projectId = 1;
        when(projectRepository.existsById(projectId)).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.put("/projects/{id}", projectId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testExcluirProjeto() throws Exception {
        int projectId = 1;
        when(projectRepository.existsById(projectId)).thenReturn(true);
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(projetoExemplo));

        mockMvc.perform(MockMvcRequestBuilders.delete("/projects/{id}", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Projeto com ID 1 excluído com sucesso."));
    }

    @Test
    void testExcluirProjetoNaoEncontrado() throws Exception {
        int projectId = 1;
        when(projectRepository.existsById(projectId)).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.delete("/projects/{id}", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("Projeto com ID 1 não encontrado."));
    }
}
