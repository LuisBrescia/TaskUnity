package taskunity.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private User[] members;

    public Team() {

    }

    public Team(String name, String description, User[] members) {
        this.name = name;
        this.description = description;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public User[] getMembers() {
        return members;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMembers(User[] members) {
        this.members = members;
    }
}
