package taskunity.controllers;

import org.springframework.web.bind.annotation.*;

import taskunity.models.Task;
import taskunity.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public String getTask(@PathVariable Long taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping
    public String createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    
    @PutMapping("/{taskId}")
    public String updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        return taskService.deleteTask(taskId);
    }

}
