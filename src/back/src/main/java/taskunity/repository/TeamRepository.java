package taskunity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import taskunity.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
