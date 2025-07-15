package ss5.service;

import ss5.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> getAllFruits();
    Fruit getFruitById(Long id);
    Fruit createFruit(Fruit fruit);
    Fruit updateFruit( Fruit fruit);
    void deleteFruit(Long id);
}
