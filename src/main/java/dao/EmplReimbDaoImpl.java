package dao;

import model.Reimbursement;
import model.User;

import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplReimbDaoImpl implements EmplReimbDao{
    public EmplReimbDaoImpl() {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reimbursement> getUserTickets(Integer userId) {
        List<Reimbursement> tickets = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(ConnectionUtilities.url,
                ConnectionUtilities.username,
                ConnectionUtilities.password)) {
            String sql = "SELECT * FROM reimbursement_tickets WHERE reimb_author = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);

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
    public Reimbursement addReimbursementTicket(Reimbursement ticket) {
        try(Connection connection = DriverManager.getConnection(ConnectionUtilities.url,
                ConnectionUtilities.username,
                ConnectionUtilities.password)) {
            String sql = "INSERT INTO ers_reimbursement VALUES " +
                    "(DEFAULT, ?, DEFAULT, NULL, ?, NULL, ?, NULL, DEFAULT, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setDouble(1, ticket.getReimbursementAmount());
            ps.setString(2, ticket.getReimbursementDescription());
            ps.setInt(3, ticket.getReimbursementAuthor());
            ps.setInt(4, ticket.getReimbursementTypeId());

            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }
}
