package com.library_entity_controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static com.library_database_controller.Library_Client_User_Connector.clientstatement;
import static com.library_database_controller.Library_Staff_User_Controller.staffstatement;

public class Client {
    static Client client= null;
    private int clientId;
    private String firstName;
    private String lastName;
    private String fullName;
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
    public String getFullName() {return fullName;}

    public void setFullName(String fullName) {this.fullName = fullName;}

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
    static boolean validateClientAccount(String email, String password) throws SQLException {

        String sqlselect = "SELECT *, CONCAT(firstName, ' ', lastName) as fullName from user WHERE email = '" + email + "'";

        ResultSet rs = clientstatement().executeQuery(sqlselect);
        rs.next();
        String passcode = rs.getString("password");

        boolean login = (Objects.equals(password, passcode));
        if (login == true) {
            int clientId = rs.getInt("userId");
            String username = rs.getString("username");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String fullName = rs.getString("fullName");
            int phoneNumber = rs.getInt("phoneNumber");
            int landLine = rs.getInt("landLine");

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
            client.setFullName(fullName);

        }
        return login;
        //should check if a given account is available in the database and the password matches the username
    }
    public void clientLogout(){
        client = null;
    }
    public void signUp(String username, String password,String firstName, String lastName,int phoneNumber,int landline, String email, GENDER gender, String dateOfBirth) throws SQLException {

        String sqlInsert = "insert into libappschem.user values" + " ('" + firstName + "'," + "'" + lastName + "'," + "'" + phoneNumber + "'," + "'" + landline + "'," + gender.toString() + "STR_TO_DATE(\"" + dateOfBirth + "\", \"%m-%d-%Y\")" + "," + ")";
        clientstatement().executeUpdate(sqlInsert);
    }
    public boolean checkUsername(String username) throws SQLException {
        boolean canMake = false;
        int count = 1;

            String sqlSelect = "SELECT Exists(Select * from user where username ='" + username + "')";
            ResultSet rs = clientstatement().executeQuery(sqlSelect);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count == 0) canMake = true;

        return canMake;
    }
    public boolean checkPhoneNumber(int phoneNumber) throws SQLException {
        boolean canMake = false;
        int count = 1;

        String sqlSelect = "SELECT Exists(Select * from user where phoneNumber ='" + phoneNumber + "')";
        ResultSet rs = clientstatement().executeQuery(sqlSelect);
        while (rs.next()) {
            count = rs.getInt(1);
        }
        if (count == 0) canMake = true;

        return canMake;
    }
    public boolean checkEmail(String email) throws SQLException {
        boolean canMake = false;
        int count = 1;

        String sqlSelect = "SELECT Exists(Select * from user where email ='" + email+ "')";
        ResultSet rs = clientstatement().executeQuery(sqlSelect);
        while (rs.next()) {
            count = rs.getInt(1);
        }
        if (count == 0) canMake = true;

        return canMake;
    }
    public int getBooksRented() throws SQLException {
        String sqlSelect = "Select * from user_rented where userId="+client.clientId;
        ResultSet rs = clientstatement().executeQuery(sqlSelect);
        rs.next();
        return rs.getInt("Count(DISTINCT book.ISBN)");

    }
    public int getPagesRead() throws SQLException {
        String sqlSelect = "Select * from pages_read where userId="+client.clientId;
        ResultSet rs = clientstatement().executeQuery(sqlSelect);
        rs.next();
        return rs.getInt("Sum(book.numOfPages)");

    }

}