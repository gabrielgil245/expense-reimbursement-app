package service;

import dao.FinMgrReimbDao;
import dao.FinMgrReimbDaoImpl;
import model.Reimbursement;

import java.util.List;

public class FinMgrReimbService {
    FinMgrReimbDao finMgrReimbDao;

    public FinMgrReimbService() {
        this.finMgrReimbDao = new FinMgrReimbDaoImpl();
    }

    public FinMgrReimbService(FinMgrReimbDao finMgrReimbDao) {
        this.finMgrReimbDao = finMgrReimbDao;
    }

    public List<Reimbursement> getAllEmployeesTickets() {
        return finMgrReimbDao.viewAllTickets();
    }

    public List<Reimbursement> getFilteredEmployeeTickets(Integer statusId) {
        return finMgrReimbDao.viewFilteredTickets(statusId);
    }

    public void resolveTicket(Reimbursement reimbTicket) {
        finMgrReimbDao.resolveTicket(reimbTicket);
    }

}
