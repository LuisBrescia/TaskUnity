package taskunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taskunity.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    User findByNameAndPassword(String name, String password);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}