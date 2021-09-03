package dao;

import model.Reimbursement;

import java.util.List;

public interface FinMgrReimbDao {
    List<Reimbursement> viewAllTickets();
    List<Reimbursement> viewFilteredTickets(Integer ticketStatusId);
    Reimbursement resolveTicket(Reimbursement reimbTicket);
}
