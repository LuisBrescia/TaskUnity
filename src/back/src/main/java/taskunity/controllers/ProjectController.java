package taskunity.controllers;

import org.springframework.web.bind.annotation.*;

import taskunity.models.Project;
import taskunity.services.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public String getProject(@PathVariable Long projectId) {
        return projectService.getProject(projectId);
    }

    @PostMapping
    public String createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{projectId}")
    public String updateProject(@PathVariable Long projectId, @RequestBody Project project) {
        return projectService.updateProject(projectId, project);
    }

    @DeleteMapping("/{projectId}")
    public String deleteProject(@PathVariable Long projectId) {
        return projectService.deleteProject(projectId);
    }

}
