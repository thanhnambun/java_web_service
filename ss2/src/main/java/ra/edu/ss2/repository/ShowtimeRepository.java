package ra.edu.ss2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import ra.edu.ss2.entity.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMovieId(Long movieId);
    List<Showtime> findByScreenRoomId(Long screenRoomId);
}
