package taskunity.model;

import jakarta.persistence.*;

@Entity
@Table(name="task")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Boolean completed;
    private Integer project;
    private Integer tasker;
    private boolean publico;
    private String link;

    public Task() {
    }

    public Task(String name, Boolean completed, Integer project, Integer tasker) {
        this.name = name;
        this.completed = completed;
        this.project = project;
        this.tasker = tasker;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return this.project;
    }

    public Integer getTasker() {
        return this.tasker;
    }

    public void setTasker(Integer tasker) {
        this.tasker = tasker;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getPublico(){
        return this.publico;
    }

    public void setPublico(boolean publico){
        this.publico = publico;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
