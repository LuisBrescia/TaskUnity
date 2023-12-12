package taskunity.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import taskunity.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByName(String name);
    List<Task> findByTasker(Integer tasker);
    List<Task> findByProject(Integer project);

    @Modifying
    @Query("DELETE FROM Task t WHERE t.project = :projectId")
    void deleteByProjectId(@Param("projectId") Integer projectId);
}