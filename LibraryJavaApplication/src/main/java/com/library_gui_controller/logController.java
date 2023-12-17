package com.library_gui_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class logController {

    @FXML
    private Label WrongCredentials;

    @FXML
    private TextField confirmEmail;

    @FXML
    private TextField confirmPass;

    @FXML
    private Label emailNoMatch;

    @FXML
    private TextField email;

    @FXML
    private Button login;

    @FXML
    private TextField pass;

    @FXML
    private TextField passLogin;

    @FXML
    private Label passwordNoMatch;

    @FXML
    private Button signup;

    @FXML
    private TextField username;

    @FXML
    private TextField usernameLogin;

    boolean loginMatch=false;
    boolean signupMatch=false;

    public boolean isLoggedin() {
        return loggedin;
    }

    boolean loggedin=false;
    @FXML
    void login(ActionEvent event) {
        // to get the text from a textfield use example.getText
        String un = usernameLogin.getText();
        String pw = passLogin.getText();
        if(loginMatch){WrongCredentials.setVisible(true);}
        else{
            //ktob el methods la tshayik mn el database hon.
            loggedin=true;
            if(loggedin)UserMainViewController.getInstance().goToOverview(event);
        }

    }

    @FXML
    void signup(ActionEvent event) {
        String un = username.getText();
        String pw = pass.getText();
        String pwConfirm = confirmPass.getText();
        String em = email.getText();
        String emConfirm = confirmEmail.getText();
        if(!pwConfirm.equals(pw)){passwordNoMatch.setVisible(true);signupMatch=false;}else{signupMatch=true;}
        if(!emConfirm.equals(em)){emailNoMatch.setVisible(true);signupMatch=false;}else{signupMatch=true;}
        if(signupMatch){
            //ktob el methods la tshayik mn el database hon.
            loggedin=true;
        }
    }


}
