package ss5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ss5.entity.DataResponse;
import ss5.entity.User;
import ss5.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse<List<User>>> getAllUsersJson() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(new DataResponse<>(users, HttpStatus.OK));
    }
    @PutMapping
    public ResponseEntity<DataResponse<User>> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(new DataResponse<>(userService.createUser(user), HttpStatus.CREATED), HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity<DataResponse<User>> createUser(@RequestBody User user) {
        return new ResponseEntity<>(new DataResponse<>(userService.createUser(user), HttpStatus.CREATED), HttpStatus.CREATED);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
