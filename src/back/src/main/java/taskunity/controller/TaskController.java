package taskunity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import taskunity.model.Task;
import taskunity.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks(@RequestParam(name = "tasker", required = false) Integer taskerId, @RequestParam(name = "project", required = false) Integer projectId) {

        if ( taskerId != null ) {
            return taskRepository.findByTasker(taskerId);
        } 
        
        if ( projectId != null ) {
            return taskRepository.findByProject(projectId);
        }
        
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getUser(@PathVariable Integer id) {
        return taskRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            Task savedTask = taskRepository.save(task);
            return ResponseEntity.ok(savedTask);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return ResponseEntity.ok("Task com ID " + id + " excluída com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task com ID " + id + " não encontrada.");
        }
    }
}