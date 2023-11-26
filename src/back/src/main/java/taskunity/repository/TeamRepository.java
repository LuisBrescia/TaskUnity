package taskunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskunity.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
