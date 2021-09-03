package service;

import dao.FinMgrReimbDao;
import model.Reimbursement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FinMgrReimbServiceTest {
    FinMgrReimbService finMgrReimbService;
    FinMgrReimbDao finMgrReimbDao = Mockito.mock(FinMgrReimbDao.class);

    @BeforeEach
    void setUp() {
        finMgrReimbService = new FinMgrReimbService(finMgrReimbDao);
    }

    @Test
    void getAllEmployeesTickets() {
        //Assign
        //While empty, the important part is in returning back a list of reimbursements
        List<Reimbursement> reimbursements = new ArrayList<>();
        List<Reimbursement> expectedResult = reimbursements;
        Mockito.when(finMgrReimbDao.viewAllTickets()).thenReturn(reimbursements);

        //Act
        List<Reimbursement> actualResult = finMgrReimbService.getAllEmployeesTickets();;

        //Assert
        assertEquals(expectedResult, actualResult);
        Mockito.verify(finMgrReimbDao, Mockito.times(1)).viewAllTickets();

    }

    @Test
    void getFilteredEmployeeTickets() {
        //Assign
        Integer statusId = 2;
        //While empty, the important part is in returning back a list of reimbursements
        List<Reimbursement> filteredReimbursements = new ArrayList<>();
        List<Reimbursement> expectedResult = filteredReimbursements;
        Mockito.when(finMgrReimbDao.viewFilteredTickets(statusId)).thenReturn(filteredReimbursements);

        //Act
        List<Reimbursement> actualResult = finMgrReimbService.getFilteredEmployeeTickets(statusId);

        //Assert
        assertEquals(expectedResult, actualResult);
        Mockito.verify(finMgrReimbDao, Mockito.times(1)).viewFilteredTickets(statusId);
    }

    @Test
    void resolveTicket() {
        //Assign
        Reimbursement reimbTicket = new Reimbursement();

        //Act
        finMgrReimbService.resolveTicket(reimbTicket);

        //Assert
        Mockito.verify(finMgrReimbDao, Mockito.times(1)).resolveTicket(reimbTicket);
    }
}