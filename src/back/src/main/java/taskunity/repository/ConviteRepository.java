package taskunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taskunity.model.Convite;

public interface ConviteRepository extends JpaRepository<Convite, Integer> {
    
}