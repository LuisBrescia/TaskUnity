package taskunity.models;
import jakarta.persistence.*;

@Entity
@Table(name="projects")
public class Project {

    private Long id;
    private String name;
    private String description;
    private User owner;

    // * Construtores
    public Project() {
    }

    public Project(Long id, String name, String description, User owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    // * Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public User getowner() {
        return owner;
    }

    public void setowner(User owner) {
        this.owner = owner;
    }
    
}