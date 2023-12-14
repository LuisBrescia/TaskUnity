package taskunity.model;

import jakarta.persistence.*;

@Entity
@Table(name="convite")
public class Convite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer task;
    private Integer tasker;
    private Integer owner;

    @Lob
    private String message;

    public Convite() {
    }

    public Convite(Integer task, Integer tasker, Integer owner, String message) {
        this.task = task;
        this.tasker = tasker;
        this.owner = owner;
        this.message = message;
    }

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTask() {
        return this.task;
    }

    public Integer getTasker() {
        return this.tasker;
    }

    public Integer getOwner() {
        return this.owner;
    }

    public String getMessage() {
        return this.message;
    }

    public void setTask(Integer task) {
        this.task = task;
    }

    public void setTasker(Integer tasker) {
        this.tasker = tasker;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
