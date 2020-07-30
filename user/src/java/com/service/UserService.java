package java.com.service;

import java.com.model.User;
import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    void delete(User user);
    User findById(int id);
    List<User> findAll();
}
