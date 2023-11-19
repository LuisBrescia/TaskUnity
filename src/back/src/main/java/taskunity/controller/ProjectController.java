package taskunity.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import taskunity.model.Project;
import taskunity.repository.ProjectRepository;
import taskunity.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    
    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Project> getUser(@PathVariable Integer id) {
        return projectRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{projectId}")
    public String updateProject(@PathVariable Integer projectId, @RequestBody Project project) {
        return projectService.updateProject(projectId, project);
    }

    @DeleteMapping("/{projectId}")
    public String deleteProject(@PathVariable Integer projectId) {
        return projectService.deleteProject(projectId);
    }
}