package dao;

import model.Reimbursement;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EmplReimbDaoImplTest {

    EmplReimbDao emplReimbDao;

    @BeforeEach
    void setUp() {
        emplReimbDao = new EmplReimbDaoImpl();
    }

    @Test
    void getUserTickets() {
        //Assign
        Integer userId = 1;
        List<Reimbursement> unexpectedResult = new ArrayList<>();

        //Act
        List<Reimbursement> actualResult = emplReimbDao.getUserTickets(userId);

        //Assert
        assertNotEquals(unexpectedResult, actualResult);
        for(Reimbursement ticket : actualResult) {
            System.out.println(ticket);
        }

    }

    @Test
    void addReimbursementTicket() { //test will currently cause a manipulation in data
        //Assign
        Reimbursement ticket = new Reimbursement(
                65.53,
                "food at hawaii",
                null,
                3,
                3);
        Reimbursement expectedResult = ticket;

        //Act
        Reimbursement actualResult = emplReimbDao.addReimbursementTicket(ticket);

        //Assert
        assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
}