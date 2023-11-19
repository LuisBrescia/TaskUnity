package taskunity.model;

import jakarta.persistence.*;

@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer owner;

    public Project() {
    }

    public Project(String name, int owner) {
        this.name = name;
        this.owner = owner;
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

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}