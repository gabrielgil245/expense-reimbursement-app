package service;

import dao.EmplReimbDao;
import dao.EmplReimbDaoImpl;
import model.Reimbursement;

import java.util.List;

public class EmplReimbService {
    EmplReimbDao emplReimbDao;

    public EmplReimbService() {
        this.emplReimbDao = new EmplReimbDaoImpl();
    }

    public EmplReimbService(EmplReimbDao emplReimbDao) {
        this.emplReimbDao = emplReimbDao;
    }

    public List<Reimbursement> getUserTickets(Integer userId) {
        return emplReimbDao.getUserTickets(userId);
    }

    public Reimbursement addReimbTicket(Reimbursement reimbursement) {
        return emplReimbDao.addReimbursementTicket(reimbursement);
    }

}
