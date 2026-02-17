package softuni.demo.patfinderEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.demo.patfinderEx.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
