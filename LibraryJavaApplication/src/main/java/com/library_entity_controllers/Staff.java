package com.library_entity_controllers;

import com.Email.Mail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.mail.MessagingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static com.Email.Mail.sendMail;
import static com.library_database_controller.Library_Staff_User_Controller.staffconnection;
import static com.library_database_controller.Library_Staff_User_Controller.staffstatement;

public class Staff {

    public static Staff staff = null;
    private int staffId;
    private String firstName;
    private String lastName;
    private String fullName;
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
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}

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

    public static boolean validateStaffAccount(String username, String password) throws SQLException {

        String sqlselect = "SELECT *, CONCAT(firstName, ' ', lastName) as fullName from staff WHERE username = '" + username + "'";

        ResultSet rs = staffstatement().executeQuery(sqlselect);
        rs.next();
        String passcode = rs.getString("password");

        boolean login = (Objects.equals(password, passcode));
        if (login == true) {
            int staffId = rs.getInt("staffId");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String fullName = rs.getString("fullName");
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
            staff.setFullName(fullName);

        }
        return login;
        //should check if a given account is available in the database and the password matches the username
    }
    public void staffLogout(){
        staff = null;
    }

    public void sendMailForAllCustomersDue() throws MessagingException {
        ObservableList<RentDue> list = FXCollections.observableArrayList();
        String sqlSelect = "Select * from libappschem.currently_in_rent_user_copynumber ";
        try {
            PreparedStatement pst = staffconnection().prepareStatement(sqlSelect);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new RentDue(rs.getString("email"), rs.getInt("userId"),
                        rs.getInt("ISBN"), rs.getString("title"), rs.getInt("copyNumber"), rs.getString("rentDate")));
            }
        } catch (Exception e) {

        }
        for (RentDue rentDue : list) {
            String subject = "Rent is Due!";
            String emailTo = rentDue.getEmail();
            String contents = "The book you (UserId: " + rentDue.getUserId() + ") rented on: " + rentDue.getRentDate() + " of Copy Number :" + rentDue.getCopyNumber() + " and ISBN:  "
                    + rentDue.getISBN() + " is due and you should return it as soon as possible \n Thank you,\n Apollo";
            sendMail(emailTo, subject, contents);

        }
    }
        public void getReservation() throws MessagingException {
            ObservableList<RoomsReservation> list = FXCollections.observableArrayList();
            String sqlSelect = "Select * from libappschem.makereservation  ";
            try{
                PreparedStatement pst = staffconnection().prepareStatement(sqlSelect);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    list.add(new RoomsReservation(rs.getInt("reservationId"),rs.getInt("studyRoomId"),rs.getInt("userid"),rs.getString("reservationDateTime"), rs.getString("reservationEndDateTime")));
                }
            } catch (Exception  e) {

                }
        }
        public void addReservation(int studyRoomId, int userId, String reservationDateTime, String reservationEndDateTime ){
        String sqlInsert = "insert into libappschem.makereservation values" + " ('" + studyRoomId + "'," + "'" + userId + "'," + "'" + reservationDateTime + "'," + "'" + reservationEndDateTime + "')";
        }

        public void deleteBook(int ISBN) throws SQLException {
        String sqlDelete ="DELETE FROM libappschem.bookcopy WHERE ISBN ="  +ISBN;
        staffstatement().executeUpdate(sqlDelete);
        sqlDelete ="DELETE FROM libappschem.book WHERE ISBN ="  +ISBN;
        staffstatement().executeUpdate(sqlDelete);
        }
    public void deleteBookCopy(int number) throws SQLException {
        String sqlDelete ="DELETE FROM libappschem.book WHERE copyNo ="  +number;
        staffstatement().executeUpdate(sqlDelete);
    }
}
