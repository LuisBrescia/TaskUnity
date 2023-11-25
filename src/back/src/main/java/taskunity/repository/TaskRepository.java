package taskunity.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import taskunity.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByName(String name);
}