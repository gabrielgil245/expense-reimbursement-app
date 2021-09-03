package dao;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDaoImpl();
    }

    @Test
    void getUser() {
        //Assign
        User user = new User();
        user.setUsername("emp1");
        user.setPassword("password");
        User expectedResult = user;

        //Act
        User actualResult = userDao.getUser(user);

        //Assert
        assertEquals(expectedResult.getUsername(), actualResult.getUsername());
        System.out.println(actualResult);
    }

    @Test
    void createUser() { //test will create a manipulation in data
        //Assign
        User user = new User(null, //usersId may be set to null; schema will assign an ID
                "fmgr4",
                "password",
                "James",
                "Brown",
                "j.brown1@test.com",
                2);
        User expectedResult = user;

        //Act
        User actualResult = userDao.createUser(user);

        //Assert
        assertEquals(expectedResult.toString(), actualResult.toString());
        System.out.println(expectedResult == actualResult);
    }

    @Test
    void createUserWithExistingUsername() {
        //Assign
        User user = new User(null,
                "emp2", //username exists in database
                "password",
                "Kathy",
                "Benavides",
                "kbenavides@test.com",
                1);
        User expectedResult = null;

        //Act
        User actualResult = userDao.createUser(user);

        //Assert
        assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }

    @Test
    void createUserWithExistingEmail() {
        //Assign
        User user = new User(null,
                "emp2",
                "password",
                "Kathy",
                "Benavides",
                "kbenavides@test.com", //email exists in database
                1);
        User expectedResult = null;

        //Act
        User actualResult = userDao.createUser(user);

        //Assert
        assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
}