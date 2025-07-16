package ss6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ss6.entity.DataResponse;
import ss6.entity.Order;
import ss6.service.OrderService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<DataResponse<Order>> createOrder(@RequestBody Order order) {
        Order created = orderService.createOrder(order);
        return new ResponseEntity<>(new DataResponse<>(created, HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<Order>>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(new DataResponse<>(orders, HttpStatus.OK));
    }

    @GetMapping("/by-date")
    public ResponseEntity<DataResponse<List<Order>>> getOrdersByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        List<Order> orders = orderService.getOrdersByDate(date);
        return ResponseEntity.ok(new DataResponse<>(orders, HttpStatus.OK));
    }
}
