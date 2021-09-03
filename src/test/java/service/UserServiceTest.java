package service;

import dao.UserDao;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService userService;
    UserDao userDao = Mockito.mock(UserDao.class);

    @BeforeEach
    void setUp() {
        userService = new UserService(userDao);
    }

    @Test
    void loginUserWhenCredentialsAreCorrect() {
        //Assign
        User user = new User();
        user.setUsername("emp1");
        user.setPassword("password");

        User currentUser = new User(1,
                "emp1", "password",
                "John", "Smith",
                "john.smith@test.com", 1);

        User expectedResult = currentUser;
        Mockito.when(userDao.getUser(user)).thenReturn(currentUser);

        //Act
        User actualResult = userService.loginUser(user);

        //Assert
        assertEquals(expectedResult, actualResult);
        Mockito.verify(userDao, Mockito.times(1)).getUser(user);
    }

    @Test
    void loginUserWhenCredentialsAreIncorrect() {
        //Assign
        User user = new User();
        user.setUsername(" ");
        user.setPassword(" ");

        User expectedResult = null;
        Mockito.when(userDao.getUser(user)).thenReturn(user);

        //Act
        User actualResult = userService.loginUser(user);

        //Assert
        assertEquals(expectedResult, actualResult);
        Mockito.verify(userDao, Mockito.times(1)).getUser(user);
    }
}