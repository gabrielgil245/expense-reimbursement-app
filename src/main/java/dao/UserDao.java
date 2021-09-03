package dao;

import model.User;

import java.util.List;

public interface UserDao {
    User getUser(User user);
    User createUser(User user);
}
