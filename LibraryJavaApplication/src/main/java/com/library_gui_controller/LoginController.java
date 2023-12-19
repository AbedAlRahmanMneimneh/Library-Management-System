package com.library_gui_controller;

import com.library_entity_controllers.Client;
import com.library_entity_controllers.Client.*;

import com.library_entity_controllers.Staff;
import com.library_entity_controllers.Staff.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.library_database_controller.Library_Client_User_Connector.clientstatement;
import static com.library_entity_controllers.Client.validateClientAccount;
import static com.library_entity_controllers.Staff.validateStaffAccount;

public class LoginController {


    @FXML
    private Label WrongCredentials;

    @FXML
    private CheckBox asStaff;

    @FXML
    private TextField confirmPass;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField email;

    @FXML
    private Label emailNoMatch;

    @FXML
    private TextField firstname;

    @FXML
    private MenuButton gender;

    @FXML
    private TextField landline;

    @FXML
    private TextField lastname;

    @FXML
    private Button login;

    @FXML
    private TextField pass;

    @FXML
    private TextField passLogin;

    @FXML
    private Label passwordNoMatch;

    @FXML
    private Label passwordNoMatch1;

    @FXML
    private TextField phone;

    @FXML
    private Button signup;

    @FXML
    private TextField username;

    @FXML
    private TextField usernameLogin;

    boolean loginMatch = false;
    boolean signupMatch = false;
    boolean isStaff=false;

    String name = "";

    public boolean isLoggedin() {
        return loggedin;
    }

    boolean loggedin = false;

    @FXML
    void login(ActionEvent event) throws SQLException {
        // to get the text from a textfield use example.getText
        String un = usernameLogin.getText();
        String pw = passLogin.getText();
        if(isStaff){
            loginMatch = validateStaffAccount(un,pw);
            if (!loginMatch) {
                WrongCredentials.setVisible(true);
            } else {
                //ktob el methods la tshayik mn el database hon.
                name = Staff.staff.getFullName();
                loggedin = true;
                if (loggedin) UserMainViewController.getInstance().goToOverview(event);
            }
        }
        loginMatch = validateClientAccount(un,  pw);
        if (!loginMatch) {
            WrongCredentials.setVisible(true);
        } else {
            //ktob el methods la tshayik mn el database hon.
            name = un;
            loggedin = true;
            if (loggedin) {UserMainViewController.getInstance().goToOverview(event);}
        }

    }

    @FXML
    void setAsStaff(ActionEvent event) {
        isStaff=!isStaff;
    }
    @FXML
    void setMale(ActionEvent event){
        gender.setText("Male");
    }
    @FXML
    void setFemale(ActionEvent event){
        gender.setText("Female");
    }

    @FXML
    private Label checker;

    @FXML
    void signup(ActionEvent event) throws SQLException {
        String un = username.getText();
        String pw = pass.getText();
        String pwConfirm = confirmPass.getText();
        String em = email.getText();
        if(username.getText().isEmpty()||pass.getText().isEmpty()||confirmPass.getText().isEmpty()||email.getText().isEmpty()
        || firstname.getText().isEmpty()||lastname.getText().isEmpty()||landline.getText().isEmpty()||phone.getText().isEmpty()||gender.getText().isEmpty()){
            checker.setText("Fill all the text fields");
            checker.setVisible(true);
        }
        else if(!checkUsername(un)){
            checker.setText("Username Already Exists!");
            checker.setVisible(true);
            signupMatch = false;
        } else if (!checkEmail(em)) {
            checker.setText("Email Already Exists!");
            checker.setVisible(true);
            signupMatch = false;
        } else if (!checkPhoneNumber(Integer.parseInt(phone.getText()))) {
            checker.setText("Phone Already Exists!");
            checker.setVisible(true);
            signupMatch = false;
        }else if (!pwConfirm.equals(pw)) {
            passwordNoMatch.setVisible(true);
            signupMatch = false;
        } else {
            signupMatch = true;
        }

        if (signupMatch) {
            Client.client.signUp(un,pw, firstname.getText(), lastname.getText(), Integer.parseInt(phone.getText()), Integer.parseInt(landline.getText()), em, gender.getText(),dob.getValue().toString() );
            name =un;
            loggedin = true;
        }
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

}
