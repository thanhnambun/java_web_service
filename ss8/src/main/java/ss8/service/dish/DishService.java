package ss8.service.dish;

import org.springframework.stereotype.Service;
import ss8.model.dto.DishDTO;
import ss8.model.entity.Dish;

import java.util.List;

@Service
public interface DishService{
    Dish findByName(String name);
    Dish createDish(DishDTO dto);
    Dish updateDish(Long id, DishDTO dto);
    void deleteDish(Long id);
    List<Dish> getAllDishes();
}