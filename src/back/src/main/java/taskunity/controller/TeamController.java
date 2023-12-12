package taskunity.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import taskunity.model.Team;
import taskunity.model.User;
import taskunity.repository.TeamRepository;
import taskunity.repository.UserRepository;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Team> findAll() {
        System.out.println("Getting all teams");
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Team> getUser(@PathVariable Integer id) {
        System.out.println("Getting team by id");
        return teamRepository.findById(id);
    }

    // @GetMapping("")
    // public List<Team> getAllTeamsFromUserId(Integer id){
    // System.out.println("Getting all teams from user: " + id);
    //
    // }

    @PostMapping
    public Team create(@RequestBody Team team) {
        System.out.println("Creating new team");
        return teamRepository.save(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Team team) {
        return teamRepository.findById(id)
                .map(record -> {
                    record.setName(team.getName());
                    record.setDescription(team.getDescription());
                    record.setOwner(team.getOwner());
                    record.setMembers(team.getMembers());
                    Team updated = teamRepository.save(record);
                    return ResponseEntity.ok(updated);
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return teamRepository.findById(id)
                .map(record -> {
                    teamRepository.deleteById(id);
                    return ResponseEntity.ok("Time excluído com sucesso!");
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time com id " + id + " não encontrado."));
    }

    @GetMapping("/{teamId}/memberNames")
    public ResponseEntity<List<String>> getMemberNamesByTeamId(@PathVariable Integer teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);

        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            List<String> memberNames = team.getMemberNames();
            return ResponseEntity.ok(memberNames);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }

    @PostMapping("/{teamId}/addMember")
    public ResponseEntity<?> addMemberToTeam(
            @PathVariable("teamId") Integer teamId,
            @RequestBody User user
    ) {
        // Optional<Team> optionalTeam = teamRepository.findById(teamId);
        // User addUser = userRepository.findByName(user.getName());

        // int id = addUser.getId();

        // if (optionalTeam.isPresent()) {
        //     Team team = optionalTeam.get();
        //     if (userRepository.existsById(id)) {
        //         team.addMembers(addUser);
        //         return ResponseEntity.ok("Member added to the team successfully on team : " + team.getName() + " with : "+ team.getMemberNames());
        //     } else {
        //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        //     }
        // } else {
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team " + teamId + " not found, mr: " + user.getName());
        // }

        User newMember = userRepository.findByName(user.getName());
        return teamRepository.findById(teamId)
            .map(record -> {
                record.addMembers(newMember);
                Team updated = teamRepository.save(record);
                return ResponseEntity.ok(updated);
            }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
