package dao;

import model.Reimbursement;
import model.User;

import java.util.List;

public interface EmplReimbDao {
    List<Reimbursement> getUserTickets(Integer userId);
    Reimbursement addReimbursementTicket(Reimbursement reimbursement);
}
