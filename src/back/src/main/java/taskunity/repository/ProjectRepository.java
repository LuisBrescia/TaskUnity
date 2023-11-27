package taskunity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import taskunity.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByTools(String tool);

    List<Project> findByOwner(Integer owner);
}