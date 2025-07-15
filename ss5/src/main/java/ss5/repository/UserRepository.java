package ss5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ss5.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
