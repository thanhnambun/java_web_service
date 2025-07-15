package ss5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ss5.entity.Fruit;
import ss5.entity.User;
import ss5.repository.FruitRepository;

import java.util.List;
@Service
public class FruitServiceImp implements  FruitService {
    @Autowired
    private FruitRepository fruitRepository;
    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getFruitById(Long id) {
        return fruitRepository.getReferenceById(id);
    }

    @Override
    public Fruit createFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        if (fruit.getId() == null) {
            throw new IllegalArgumentException("Product ID must not be null for update.");
        }

        Fruit existingFruit = fruitRepository.findById(fruit.getId())
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + fruit.getId()));
        existingFruit.setName(fruit.getName());
        existingFruit.setPrice(fruit.getPrice());
        existingFruit.setStatus(fruit.getStatus());
        existingFruit.setStock(fruit.getStock());
        existingFruit.setCreated_at(fruit.getCreated_at());
        return fruitRepository.save(existingFruit);
    }

    @Override
    public void deleteFruit(Long id) {
        fruitRepository.deleteById(id);
    }
}
