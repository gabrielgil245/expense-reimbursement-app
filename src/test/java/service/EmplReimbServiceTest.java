package service;

import dao.EmplReimbDao;
import model.Reimbursement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmplReimbServiceTest {

    EmplReimbService emplReimbService;
    EmplReimbDao emplReimbDao = Mockito.mock(EmplReimbDao.class);

    @BeforeEach
    void setUp() {
        emplReimbService = new EmplReimbService(emplReimbDao);
    }

    @Test
    void getUserTickets() {
        //Assign
        Integer userId = 1;
        //While empty, the important part is in returning back a list of reimbursements
        List<Reimbursement> reimbursements = new ArrayList<>();
        List<Reimbursement> expectedResult = reimbursements;
        Mockito.when(emplReimbDao.getUserTickets(userId)).thenReturn(reimbursements);

        //Act
        List<Reimbursement> actualResult = emplReimbService.getUserTickets(userId);

        //Assert
        assertEquals(expectedResult, actualResult);
        Mockito.verify(emplReimbDao, Mockito.times(1)).getUserTickets(userId);
        for(Reimbursement ticket : actualResult) {
            System.out.println(ticket);
        }
    }

    @Test
    void addReimbTicket() {
        //Assign
        Reimbursement ticket = new Reimbursement(500.00,
                "description", null,
                3, 4);
        Reimbursement expectedResult = ticket;
        Mockito.when(emplReimbDao.addReimbursementTicket(ticket)).thenReturn(ticket);

        //Act
        Reimbursement actualResult = emplReimbService.addReimbTicket(ticket);

        //Assert
        assertEquals(expectedResult, actualResult);
        Mockito.verify(emplReimbDao, Mockito.times(1)).addReimbursementTicket(ticket);
    }
}