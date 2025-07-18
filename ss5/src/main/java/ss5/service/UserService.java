package ss5.service;

import ss5.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser( User user);
    void deleteUser(Long id);
}
