package taskunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import taskunity.model.Team;
import taskunity.repository.TeamRepository;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public List<Team> findAll() {
        System.out.println("Getting all teams");
        return teamRepository.findAll();
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
}
