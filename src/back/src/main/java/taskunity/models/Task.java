package taskunity.models;

public class Task {

    private Long id;
    private String name;
    private String description;
    private Project project;
    private User owner;
    
    // * Construtores
    public Task() {
    }

    public Task(Long id, String name, String description, Project project, User owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.project = project;
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

    public Project getproject() {
        return project;
    }

    public void setproject(Project project) {
        this.project = project;
    }

    public User getowner() {
        return owner;
    }

    public void setowner(User owner) {
        this.owner = owner;
    }

}