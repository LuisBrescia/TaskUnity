package taskunity.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import taskunity.model.Convite;

public interface ConviteRepository extends JpaRepository<Convite, Integer> {
    List<Convite> findByTasker(Integer tasker);
    List<Convite> findByOwner(Integer Owner);
    List<Convite> findByTask(Integer task);
}