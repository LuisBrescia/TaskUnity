package taskunity.service;

import org.springframework.stereotype.Service;

import taskunity.model.Task;

@Service
public class TaskService {

    public String getAllTasks() {
        return "Todas as tasks";
    }

    public String getTask(Integer taskId) {
        return "Detalhes da task com ID " + taskId;
    }

    public String createTask(Task newTask) {
        return "Task criada com sucesso!" + newTask;
    }

    public String updateTask(Integer taskId, Task updatedTask) {
        return "Task com ID " + taskId + " atualizada com sucesso!";
    }

    public String deleteTask(Integer taskId) {
        return "Task com ID " + taskId + " excluída com sucesso!";
    }
    
}