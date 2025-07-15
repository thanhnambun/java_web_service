package ss5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ss5.entity.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
}
