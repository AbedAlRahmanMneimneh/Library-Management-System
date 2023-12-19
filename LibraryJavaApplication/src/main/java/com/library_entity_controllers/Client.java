package com.library_entity_controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static com.library_database_controller.Library_Client_User_Connector.clientstatement;
import static com.library_database_controller.Library_Staff_User_Controller.staffstatement;

public class Client {
    public static Client client= new Client();
    private int clientId = 3;
    private String firstName = "Guest";
    private String lastName= "Guest";
    private String fullName= "Guest";
    private int phoneNumber= 00000000, landLine= 00000000;
    private String email= "Guest@email.com";

    private String gender = "Male/Female";
    private String dateOfBirth = "00-00-0000";
    private String username= "Guest", password;
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
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}
    public static boolean validateClientAccount(String username1, String password) throws SQLException {

        String sqlselect = "SELECT *, CONCAT(firstName, ' ', lastName) as fullName from user WHERE username = '" + username1 + "'";

        ResultSet rs = clientstatement().executeQuery(sqlselect);
        rs.next();
        String passcode = rs.getString("password");

        boolean login = (Objects.equals(password, passcode));
        if (login == true) {
            int clientId = rs.getInt("userId");
            String email = rs.getString("email");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String fullName = rs.getString("fullName");
            int phoneNumber = rs.getInt("phoneNumber");
            int landLine = rs.getInt("landLine");
            String gender = rs.getString("gender");
            String dateOfBirth = rs.getString("dateOfBirth");
            client = new Client();
            client.setClientId(clientId);
            client.setUsername(username1);
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setPhoneNumber(phoneNumber);
            client.setLandLine(landLine);
            client.setEmail(email);
            client.setDateOfBirth(dateOfBirth);
            client.setFullName(fullName);
            client.setGender(gender);

        }
        return login;
        //should check if a given account is available in the database and the password matches the username
    }
    public void clientLogout(){
        client = null;
    }
    public void signUp(String username, String password,String firstName, String lastName,int phoneNumber,int landline, String email, String gender, String dateOfBirth) throws SQLException {

        String sqlInsert = "insert into libappschem.user (firstName,lastname,phoneNumber,landline,email,gender,dateOfBirth,username,password) values " + " ('" + firstName + "'," + "'" + lastName + "'," + "'" + phoneNumber + "'," + "'" + landline +"','"+email+ "','" + gender + "',"+ "(STR_TO_DATE(\"" + dateOfBirth + "\", \"%Y-%m-%d\")),'"  +username+"'," + "'"+password+"')";
        clientstatement().executeUpdate(sqlInsert);
    }

    public int getBooksRented() throws SQLException {
        int out = 0;
        String sqlSelect = "Select * from user_rented where userId="+client.clientId;
        try {
            ResultSet rs = clientstatement().executeQuery(sqlSelect);
            rs.next();
            out= rs.getInt("Count(DISTINCT book.ISBN)");
        }
        catch (Exception e){
            return out;
        }
    return out;
    }
    public int getPagesRead() throws SQLException {
        int out= 0;
        String sqlSelect = "Select * from pages_read where userId="+client.clientId;
        try{
        ResultSet rs = clientstatement().executeQuery(sqlSelect);
        rs.next();
        out= rs.getInt("Sum(book.numOfPages)");
        }
        catch (Exception e ){
            return out;
        }
        return out;

    }
    public String getFavouriteGenre() throws SQLException {
        String out = "";
        try {
            String sqlSelect = "Select genre from user_genre where userId='" + client.clientId + "' LIMIT 1";
            ResultSet rs = clientstatement().executeQuery(sqlSelect);
            rs.next();
            out = rs.getString("genre");
        }
        catch (Exception e){
            return out;
        }

        return out;

    }

}


