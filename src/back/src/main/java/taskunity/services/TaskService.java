package taskunity.services;

import org.springframework.stereotype.Service;
import taskunity.models.Task;

@Service
public class TaskService {

    public String getAllTasks() {
        return "Todas as tasks";
    }

    public String getTask(Long taskId) {
        return "Detalhes da task com ID " + taskId;
    }

    public String createTask(Task task) {
        return "Task criada com sucesso!";
    }

    public String updateTask(Long taskId, Task task) {
        return "Task com ID " + taskId + " atualizada com sucesso!";
    }

    public String deleteTask(Long taskId) {
        return "Task com ID " + taskId + " excluída com sucesso!";
    }
    
}