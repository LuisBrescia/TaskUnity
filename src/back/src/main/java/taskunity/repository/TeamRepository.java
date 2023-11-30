package taskunity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import taskunity.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findByOwner(Integer owner);
}