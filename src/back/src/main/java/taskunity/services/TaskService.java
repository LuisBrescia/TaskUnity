package taskunity.services;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import taskunity.models.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import taskunity.models.Task;
import taskunity.models.User;
import taskunity.repositories.TaskRepository;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findById(Long id) {
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Tarefa não encontrada! Id: " + id + ", Tipo: " + Task.class.getName()));

        return task;
    }

    @Transactional
    public Task create(Task obj) {

        obj.setTask_id(null);
        obj.setTitle(obj.getTitle());
        obj = this.taskRepository.save(obj);
        return obj;
    }

    @Transactional
    public Task update(Task obj) {
        Task newObj = findById(obj.getTask_id());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

    
}





