package com.example.libraryappinterface;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.libraryappcontroller.MYSQLConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class AdminLoginController {
    private String Password, Username;
    @FXML
    TextField UsernameTextField;
    @FXML
    TextField PasswordTextField;

    public AdminLoginController() throws SQLException {
    }

    public void getCredentials(ActionEvent e) throws IOException, SQLException {
        Password = PasswordTextField.getText();
        Username = UsernameTextField.getText();
        goToMainScene(e);
    }
Statement stmt= MYSQLConnector.statement();
    public void goToMainScene(ActionEvent e) throws IOException, SQLException {
        if (Accounts.validateAccount(Username , Password)) {
            String sqlselect= "Select privlvl from account Where username = '"+Username+"'";
            ResultSet rs = stmt.executeQuery(sqlselect);
            String privlvl="";
            while(rs.next()){
                privlvl = rs.getString("privlvl");
            }
            if (privlvl.equals("Admin")|| privlvl.equals("Keeper")) {
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

                Parent root = FXMLLoader.load(getClass().getResource("KeeperScene.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                JOptionPane.showMessageDialog(null,"Go back to Client Log in page");
            }
        }
    }

    public void goToLoginScene(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
