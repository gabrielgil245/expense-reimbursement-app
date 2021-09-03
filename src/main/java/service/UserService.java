package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserService {
    UserDao userDao;

    public UserService() {
        this.userDao = new UserDaoImpl();
    }

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User loginUser(User user) {
        User currentUser = userDao.getUser(user);
        if(currentUser.getUsersId() != null) {
            System.out.println("Login successful");
            return currentUser;
        }else {
            System.out.println("Invalid username or password");
            return null;
        }
    }

}
