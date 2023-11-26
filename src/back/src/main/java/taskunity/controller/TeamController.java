package taskunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import taskunity.model.Team;
import taskunity.repository.TeamRepository;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public List<Team> findAll(){
        System.out.println("Getting all teams");
        return teamRepository.findAll();
    }

//    @GetMapping("")
//    public List<Team> getAllTeamsFromUserId(Integer id){
//        System.out.println("Getting all teams from user: " + id);
//
//    }

    @PostMapping
    public Team create(@RequestBody Team team){
        System.out.println("Creating new team");
        return teamRepository.save(team);
    }
}
