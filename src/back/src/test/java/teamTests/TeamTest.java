package teamTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import taskunity.model.Team;
import taskunity.model.User;
import taskunity.repository.TeamRepository;

public class TeamTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamRepository teamRepository;

    private Team teamTest;
    private List<User> teamMembers;

    @BeforeEach
    void setUp() {
        teamMembers = new ArrayList<>();
        teamMembers.add(new User("Usuario teste", "senha"));
        teamTest = new Team("Equipe teste", "Descrição teste", teamMembers, 1);
    }

    @Test
    void testListagemEquipes() throws Exception{
        Integer ownerId = 1;
        when(teamRepository.findByOwner(ownerId)).thenReturn(List.of(teamTest));

        mockMvc.perform(MockMvcRequestBuilders.get("/teams/{ownerId}", ownerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Equipe Exemplo"));
    }

    @Test
    void testCriarEquipe(){
        assertNotNull(teamTest, "Equipe não deve ser nula");
        assertEquals("Equipe teste", teamTest.getName(), "O nome da equipe deve ser igual");
        assertEquals("Descrição teste", teamTest.getDescription(), "A descrição da equipe deve ser igual");
        assertEquals(teamMembers, teamTest.getMembers(), "Os membros devem ser iguais");
    }

    @Test
    void testAtualizarEquipe() throws Exception{
        int teamId = 1;
        when(teamRepository.existsById(teamId)).thenReturn(true);
        when(teamRepository.save(any())).thenReturn(teamTest);

        mockMvc.perform(MockMvcRequestBuilders.put("/teams/{teamId}", teamId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Equipe Teste"));
    }

    @Test
    void testExcluirEquipe() throws Exception{
        int teamId = 1;
        when(teamRepository.existsById(teamId)).thenReturn(true);
        when(teamRepository.findById(teamId)).thenReturn(Optional.of(teamTest));

        mockMvc.perform(MockMvcRequestBuilders.delete("/teams/{teamId}", teamId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Equipe com ID 1 excluído com sucesso."));
    }
}
