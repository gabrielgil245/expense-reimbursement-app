package model;

public class User {
    Integer usersId;
    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    Integer userRoleId;
    String userRole;

    public User() {
    }

    //For entering user's login information
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //For creating a new account
    public User(Integer usersId, String username, String password, String firstName, String lastName, String email, Integer userRoleId) {
        this.usersId = usersId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRoleId = userRoleId;
    }

    //For getting user's result set
    public User(Integer usersId, String username, String password, String firstName, String lastName, String email,
     Integer userRoleId, String userRole) {
        this.usersId = usersId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRoleId = userRoleId;
        this.userRole = userRole;

    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserRoleId() { return userRoleId; }

    public void setUserRoleId(Integer userRoleId) { this.userRoleId = userRoleId; }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRoleId) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "usersId=" + usersId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userRoleId=" + userRoleId +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
