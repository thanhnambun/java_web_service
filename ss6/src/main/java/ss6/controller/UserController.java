package ss6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ss6.entity.DataResponse;
import ss6.entity.User;
import ss6.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse<List<User>>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(new DataResponse<>(users, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<DataResponse<User>> createUser(@RequestBody User user) {
        return new ResponseEntity<>(new DataResponse<>(userService.save(user), HttpStatus.ACCEPTED), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<DataResponse<User>> updateUser(@RequestBody User user, @PathVariable Long userId) {
        return new ResponseEntity<>(new DataResponse<>(userService.updateUser(user, userId), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}
