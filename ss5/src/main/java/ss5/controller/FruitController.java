package ss5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ss5.entity.DataResponse;
import ss5.entity.Fruit;
import ss5.entity.Product;
import ss5.service.FruitService;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {
    @Autowired
    private FruitService fruitService;
    @GetMapping(value = "/fruits", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse<List<Fruit>>> getAllFruitsJson() {
        List<Fruit> fruits = fruitService.getAllFruits();
       return ResponseEntity.ok(new DataResponse<>(fruits, HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<DataResponse<Fruit>> createFruit(@RequestBody Fruit Fruit) {
        return new ResponseEntity<>(new DataResponse<>(fruitService.createFruit(Fruit), HttpStatus.CREATED), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<DataResponse<Fruit>> updateFruit(@RequestBody Fruit Fruit) {
        return new ResponseEntity<>(new DataResponse<>(fruitService.updateFruit(Fruit), HttpStatus.OK), HttpStatus.OK);
    }
    @DeleteMapping("/{fruitId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long fruitId) {
        fruitService.deleteFruit(fruitId);
        return ResponseEntity.noContent().build();
    }
}
