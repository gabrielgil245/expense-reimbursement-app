package dao;

import model.Reimbursement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinMgrReimbDaoImpl implements FinMgrReimbDao {
    public FinMgrReimbDaoImpl() {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reimbursement> viewAllTickets() {
        List<Reimbursement> tickets = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(ConnectionUtilities.url,
                ConnectionUtilities.username,
                ConnectionUtilities.password)) {
            String sql = "SELECT * FROM reimbursement_tickets;";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                tickets.add(new Reimbursement(resultSet.getInt(1),
                        resultSet.getDouble(2),
                        resultSet.getTimestamp(3),
                        resultSet.getTimestamp(4),
                        resultSet.getString(5),
                        resultSet.getBinaryStream(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getString(12)));
            }

        }catch(SQLException e) {e.printStackTrace();}
        return tickets;
    }

    @Override
    public List<Reimbursement> viewFilteredTickets(Integer statusId) {
        List<Reimbursement> tickets = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(ConnectionUtilities.url,
                ConnectionUtilities.username,
                ConnectionUtilities.password)) {
            String sql = "SELECT * FROM reimbursement_tickets WHERE reimb_status_id = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, statusId);

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                tickets.add(new Reimbursement(resultSet.getInt(1),
                        resultSet.getDouble(2),
                        resultSet.getTimestamp(3),
                        resultSet.getTimestamp(4),
                        resultSet.getString(5),
                        resultSet.getBinaryStream(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getString(12)));
            }

        }catch(SQLException e) {e.printStackTrace();}
        return tickets;
    }

    @Override
    public Reimbursement resolveTicket(Reimbursement reimbTicket) {
        try(Connection connection = DriverManager.getConnection(ConnectionUtilities.url,
                ConnectionUtilities.username,
                ConnectionUtilities.password)) {
            String sql = "UPDATE ers_reimbursement SET reimb_resolved = DEFAULT, " +
                    "reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, reimbTicket.getReimbursementResolver());
            ps.setInt(2, reimbTicket.getReimbursementStatusId());
            ps.setInt(3, reimbTicket.getReimbursementId());

            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return reimbTicket;
    }
}
