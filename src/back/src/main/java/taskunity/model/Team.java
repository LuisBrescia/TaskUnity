package taskunity.model;

import java.util.List;

import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Integer owner;

    @ManyToMany
    private List<User> members;

    public Team() {

    }

    public Team(String name, String description, List<User> members) {
        this.name = name;
        this.description = description;
        this.members = members;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<String> getMemberNames() {
        return members.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public void addMembers(User user) {
        this.members.add(user);
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
