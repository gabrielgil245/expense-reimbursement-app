package dao;

import model.Reimbursement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FinMgrReimbDaoImplTest {
    FinMgrReimbDao finMgrReimbDao;

    @BeforeEach
    void setUp() {
        finMgrReimbDao = new FinMgrReimbDaoImpl();
    }

    @Test
    void viewAllTickets() {
        //Assign
        List<Reimbursement> unexpectedResult = new ArrayList<>();

        //Act
        List<Reimbursement> actualResult = finMgrReimbDao.viewAllTickets();

        //Assert
        assertNotEquals(unexpectedResult, actualResult);
        for (Reimbursement ticket : actualResult) {
            System.out.println(ticket);
        }
    }

    @Test
    void viewFilteredTickets() {
        Integer ticketStatusId = 2;
        //Assign
        List<Reimbursement> unexpectedResult = new ArrayList<>();

        //Act
        List<Reimbursement> actualResult = finMgrReimbDao.viewFilteredTickets(ticketStatusId);

        //Assert
        assertNotEquals(unexpectedResult, actualResult);
        for (Reimbursement ticket : actualResult) {
            System.out.println(ticket);
        }
    }

    @Test
    void resolveTicket() {
        Integer ticketId = 9;
        Integer resolverId = 2;
        Integer statusId = 3;

        Reimbursement ticket = new Reimbursement();
        ticket.setReimbursementResolver(resolverId);
        ticket.setReimbursementStatusId(statusId);
        ticket.setReimbursementId(ticketId);
        //Assign
        Reimbursement expectedResult = ticket;

        //Act
        Reimbursement actualResult = finMgrReimbDao.resolveTicket(ticket);

        //Assert
        assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
}