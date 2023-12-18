package com.library_gui_controller;

import com.library_entity_controllers.Client;
import com.library_entity_controllers.Client.*;
import com.library_entity_controllers.Staff;
import com.library_entity_controllers.Staff.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

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
            if (loggedin) UserMainViewController.getInstance().goToOverview(event);
        }

    }

    @FXML
    void setAsStaff(ActionEvent event) {
        isStaff=!isStaff;
    }

    @FXML
    void signup(ActionEvent event) {
        String un = username.getText();
        String pw = pass.getText();
        String pwConfirm = confirmPass.getText();
        String em = email.getText();

        if (!pwConfirm.equals(pw)) {
            passwordNoMatch.setVisible(true);
            signupMatch = false;
        } else {
            signupMatch = true;
        }

        if (signupMatch) {
            //ktob el methods la tshayik mn el database hon.
            name =un;
            loggedin = true;
        }
    }

}
