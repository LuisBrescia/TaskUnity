package taskunity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import taskunity.model.Project;
import taskunity.model.Task;
import taskunity.repository.ProjectRepository;
import taskunity.repository.TaskRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    TaskRepository taskRepository;

    @GetMapping
    public List<Project> getAllProjects(@RequestParam(name = "owner", required = false) Integer ownerId) {

        if (ownerId != null) {
            return projectRepository.findByOwner(ownerId);
        } else {
            return projectRepository.findAll();
        }
    }

    @Transactional
    @GetMapping("/owner/{ownerId}")
    public List<Project> getProjectByIdOwner(@PathVariable Integer ownerId) {
        return projectRepository.findByOwner(ownerId);
    }

    @GetMapping("/tools/{toolName}")
    public List<Project> getProjectByTool(@PathVariable String toolName) {
        return projectRepository.findByTools(toolName);
    }

    @GetMapping("/{id}")
    public Optional<Project> getProject(@PathVariable Integer id) {
        return projectRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        project.setStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        Project savedProject = projectRepository.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Integer id, @RequestBody Project project) {
        if (projectRepository.existsById(id)) {
            project.setId(id);
            Project savedProject = projectRepository.save(project);
            return ResponseEntity.ok(savedProject);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer id) {
        if (projectRepository.existsById(id)) {
            Optional<Project> optionalProject = projectRepository.findById(id);
    
            if (optionalProject.isPresent()) {
                Project project = optionalProject.get();
    
                taskRepository.deleteByProjectId(id);
    
                projectRepository.deleteById(id);
    
                return ResponseEntity.ok("Project com ID " + id + " excluído com sucesso.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Erro interno do servidor: Projeto não encontrado.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project com ID " + id + " não encontrado.");
        }
    }
}