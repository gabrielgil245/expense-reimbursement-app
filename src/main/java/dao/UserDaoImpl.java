package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        try {
           Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(User user) {
        User returningUser = new User();

        try(Connection connection = DriverManager.getConnection(ConnectionUtilities.url,
                ConnectionUtilities.username,
                ConnectionUtilities.password)) {
            String sql = "SELECT * FROM user_info WHERE ers_username = ? AND ers_password = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                returningUser = new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8));
            }

        }catch(SQLException e) {
         e.printStackTrace();
        }
        return returningUser;
    }

    @Override
    public User createUser(User user) {
        try(Connection connection = DriverManager.getConnection(ConnectionUtilities.url,
                ConnectionUtilities.username,
                ConnectionUtilities.password)) {
            String sql = "INSERT INTO ers_users VALUES (DEFAULT,?,?,?,?,?,?);";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getUserRoleId());

            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
}
