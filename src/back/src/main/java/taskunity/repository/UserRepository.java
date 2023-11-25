package taskunity.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import taskunity.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
}