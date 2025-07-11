package ra.edu.ss2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.edu.ss2.entity.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContainingIgnoreCase(String title);
}
