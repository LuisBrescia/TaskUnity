package taskunity.models;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Task {
    
    public interface CreateTask {}
    public interface UpdateTask {}

    public static final String TABLE_NAME = "Task";

    @Id
    @Column(name = "task_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    @Column(name = "title", length = 255, nullable = false, unique = true)
    private String title;

    @Column(name = "description", length = 255, nullable = false, unique = true)
    private String description;

    @Column(name = "completed", nullable = false)
    private Integer completed;

    @Column(name = "project_id", nullable = false)
    private Integer project_id;


    public Task() {
    }


    public Task(Long task_id, String title, String description, Integer completed, Integer project_id) {
        this.task_id = task_id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.project_id = project_id;
    }

    public Long getTask_id() {
        return this.task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompleted() {
        return this.completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getProject_id() {
        return this.project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }
}
