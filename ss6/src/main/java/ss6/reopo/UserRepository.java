package ss6.reopo;

import org.springframework.data.jpa.repository.JpaRepository;
import ss6.entity.User;

public interface UserRepository  extends JpaRepository<User,Long> {
}
