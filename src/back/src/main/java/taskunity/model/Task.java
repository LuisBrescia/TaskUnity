package taskunity.model;

import jakarta.persistence.*;

@Entity
@Table(name="task")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Boolean completed;
    private Integer project_id;
    private Integer user_id;

    public Task() {
    }

    public Task(String name, Boolean completed, Integer project_id, Integer user_id) {
        this.name = name;
        this.completed = completed;
        this.project_id = project_id;
        this.user_id = user_id;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getProject() {
        return this.project_id;
    }

    public Integer getUser() {
        return this.user_id;
    }

    public void setUser(Integer user_id) {
        this.user_id = user_id;
    }
}
