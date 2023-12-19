package com.example.libraryappinterface;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    private String Username = "", Password = "";

    @FXML
    protected TextField UsernameTextField;

    protected String getUsername() {
        return Username;
    }

    protected String getPassword() {
        return Password;
    }

    @FXML
    protected TextField PasswordTextField;

    public void Credentials(ActionEvent e) throws IOException, SQLException {
        Username = UsernameTextField.getText();
        Password = PasswordTextField.getText();
        goToMainScene(e);
    }

    public void goToSignUpScene(ActionEvent e) throws IOException, SQLException {

            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }

    public void goToAdminLoginScene(ActionEvent e) throws IOException, SQLException {

            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }

    public void goToMainScene(ActionEvent e) throws IOException, SQLException {
        if (Accounts.validateAccount(Username,Password)) {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("UserScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}