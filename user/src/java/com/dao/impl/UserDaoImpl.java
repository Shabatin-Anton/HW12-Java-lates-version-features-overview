package java.com.dao.impl;

import java.com.dao.UserDao;
import java.com.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private static UserDao UserDao = new UserDaoImpl();

    public UserDaoImpl(){
    }

    public static UserDao getInstance(){
        return UserDao;
    }

    private static Map<Integer, User> userMap = new HashMap<>();

    static {
        userMap.put(1,new User(1, "Anton","Shabatin",26));
    }

    private static int count = 1;
    @Override
    public void create(User user) {
        count++;
        user.setId(count);
        userMap.put(count,user);
    }

    @Override
    public void update(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        userMap.remove(user.getId());
    }

    @Override
    public User findById(int id) {
        return userMap.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}
