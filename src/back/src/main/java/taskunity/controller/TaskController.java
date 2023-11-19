package taskunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import taskunity.model.Task;
import taskunity.repository.TaskRepository;
import taskunity.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getUser(@PathVariable Integer id) {
        return taskRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createTask(@RequestBody Task newTask) {
        return taskService.createTask(newTask);
    }
    
    @PutMapping("/{taskId}")
    public String updateTask(@PathVariable Integer taskId, @RequestBody Task updatedTask) {
        return taskService.updateTask(taskId, updatedTask);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable Integer taskId) {
        return taskService.deleteTask(taskId);
    }

}