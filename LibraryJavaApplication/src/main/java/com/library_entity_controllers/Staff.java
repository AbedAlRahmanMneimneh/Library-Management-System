package com.library_entity_controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static com.library_database_controller.Library_Staff_User_Controller.staffstatement;

public class Staff {

    static Staff staff = null;
    private int staffId;
    private String firstName, lastName;
    private int phoneNumber, landLine;
    private String email;
    private GENDER gender;
    private int privLevel;
    private String dateOfBirth;
    private String username, password;


    public Staff(int staffId, String firstName, String lastName,
                 int phoneNumber, int landLine, String email, GENDER gender, String username, String password) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.landLine = landLine;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    public Staff() {

    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public int getPrivLevel() {
        return privLevel;
    }

    public void setPrivLevel(int privLevel) {
        this.privLevel = privLevel;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    static boolean validateStaffAccount(String username, String password) throws SQLException {

        String sqlselect = "SELECT * from staff WHERE username = '" + username + "'";

        ResultSet rs = staffstatement().executeQuery(sqlselect);
        rs.next();
        String passcode = rs.getString("password");

        boolean login = (Objects.equals(password, passcode));
        if (login == true) {
            int staffId = rs.getInt("staffId");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            int phoneNumber = rs.getInt("phoneNumber");
            int landLine = rs.getInt("landLine");
            String email = rs.getString("email");
            String dateOfBirth = rs.getString("dateOfBirth");
            int privLevel = rs.getInt("privLevel");

            staff = new Staff();
            staff.setStaffId(staffId);
            staff.setUsername(username);
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setPhoneNumber(phoneNumber);
            staff.setLandLine(landLine);
            staff.setEmail(email);
            staff.setDateOfBirth(dateOfBirth);
            staff.setPrivLevel(privLevel);

        }
        return login;
        //should check if a given account is available in the database and the password matches the username
    }
    public void staffLogout(){
        staff = null;
    }
}
