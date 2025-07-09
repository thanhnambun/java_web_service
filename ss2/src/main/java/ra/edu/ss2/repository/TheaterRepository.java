package ra.edu.ss2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.edu.ss2.entity.Theater;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    List<Theater> findByNameContainingIgnoreCase(String name);
    List<Theater> findByAddressContainingIgnoreCase(String address);
}
