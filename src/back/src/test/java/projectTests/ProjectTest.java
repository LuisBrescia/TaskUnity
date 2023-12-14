package projectTests;

import org.junit.jupiter.api.Test;

import taskunity.model.Project;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void testCriacaoDoProjeto() {
        Project project = new Project();
        assertNotNull(project, "O projeto não deve ser nulo");
    }

    @Test
    void testPropriedadesDoProjeto() {
        Project project = new Project();
        project.setId(1);
        project.setName("Projeto de Exemplo");

        assertEquals(1, project.getId(), "O ID do projeto deve ser igual");
        assertEquals("Projeto de Exemplo", project.getName(), "O nome do projeto deve ser igual");
    }

    @Test
    void testProjetosIguais() {
        Project project1 = new Project();
        project1.setId(1);
        project1.setName("Projeto de Exemplo");

        Project project2 = new Project();
        project2.setId(1);
        project2.setName("Projeto de Exemplo");

        assertEquals(project1, project2, "Projetos com o mesmo ID e nome devem ser iguais");
    }

    @Test
    void testProjetosDiferentes() {
        Project project1 = new Project();
        project1.setId(1);
        project1.setName("Projeto de Exemplo");

        Project project2 = new Project();
        project2.setId(2);
        project2.setName("Projeto Diferente");

        assertNotEquals(project1, project2, "Projetos com ID ou nome diferentes não devem ser iguais");
    }

}

