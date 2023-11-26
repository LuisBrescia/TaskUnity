package taskunity.model;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String tools;
    private String startDate;
    private Integer owner;

    public Project() {
    }

    public Project(String name, String description, String tools, int owner) {
        this.name = name;
        this.description = description;
        this.tools = tools;
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

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String gettools() {
        return tools;
    }

    public void settools(String tools) {
        this.tools = tools;
    }

    public String getstDartate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}