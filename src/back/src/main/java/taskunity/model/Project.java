package taskunity.model;

import jakarta.persistence.*;

@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer owner_id;

    public Project() {
    }

    public Project(String name, int owner_id) {
        this.name = name;
        this.owner_id = owner_id;
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

    public Integer getOwner() {
        return owner_id;
    }

    public void setOwner(int owner_id) {
        this.owner_id = owner_id;
    }
}