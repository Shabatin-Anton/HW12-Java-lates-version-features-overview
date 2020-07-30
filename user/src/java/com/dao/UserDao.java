package java.com.dao;

import java.com.model.User;
import java.util.List;

public interface UserDao {
    void create(User user);
    void update(User user);
    void delete(User user);
    User findById(int id);
    List<User> findAll();
}
