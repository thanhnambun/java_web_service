package ss6.reopo;

import org.springframework.data.jpa.repository.JpaRepository;
import ss6.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
