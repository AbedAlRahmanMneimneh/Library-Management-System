package com.library_entity_controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static com.library_database_controller.Library_Client_User_Connector.clientstatement;
import static com.library_database_controller.Library_Staff_User_Controller.staffstatement;

public class Client {
    static Client client= null;
    private int clientId;
    private String firstName,lastName;
    private int phoneNumber, landLine;
    private String email, dateOfBirth;
    private String username, password;
    public Client(int userId, String firstName, String lastName, int phoneNo, int landLine, String email, String dateOfBirth) {
        this.clientId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNo;
        this.landLine = landLine;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Client(String firstName, String lastName, int phoneNo, int landLine, String email, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNo;
        this.landLine = landLine;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    public Client() {
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getLandLine() {
        return landLine;
    }

    public void setLandLine(int landLine) {
        this.landLine = landLine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
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

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    static boolean validateClientAccount(String username, String password) throws SQLException {

        String sqlselect = "SELECT * from user WHERE username = '" + username + "'";

        ResultSet rs = clientstatement().executeQuery(sqlselect);
        rs.next();
        String passcode = rs.getString("password");

        boolean login = (Objects.equals(password, passcode));
        if (login == true) {
            int clientId = rs.getInt("userId");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            int phoneNumber = rs.getInt("phoneNumber");
            int landLine = rs.getInt("landLine");
            String email = rs.getString("email");
            String dateOfBirth = rs.getString("dateOfBirth");
            client = new Client();
            client.setClientId(clientId);
            client.setUsername(username);
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setPhoneNumber(phoneNumber);
            client.setLandLine(landLine);
            client.setEmail(email);
            client.setDateOfBirth(dateOfBirth);

        }
        return login;
        //should check if a given account is available in the database and the password matches the username
    }
    public void clientLogout(){
        client = null;
    }
    public void signUp()
}
