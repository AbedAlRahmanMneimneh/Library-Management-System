package com.example.libraryappinterface;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.libraryappcontroller.MYSQLConnector;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController  {
    String Username, Password, FirstName, LastName, ConfirmationOfPassword,DateOfBirth;

    @FXML
    private TextField FirstNameField;
    @FXML
    private TextField LastNameField;
    @FXML
    private TextField UsernameField;
    @FXML
    private TextField PasswordField;
    @FXML
    private TextField PasswordConfirmationField;

    @FXML
    private Label AlreadyExist;
    @FXML
    private TextField DateOfBirthField;
    @FXML
    private ChoiceBox TypeOfAccountChoiceBox;
    @FXML
    private Label PasswordDont;
    @FXML
    private Label match;


    protected String TypeChosen;

    protected String AccountPriority;

    Statement stmt =  MYSQLConnector.statement();

    public SignupController() throws SQLException {
    }

    private void getType(Event e) {
        TypeChosen = (String) TypeOfAccountChoiceBox.getValue();
    }

    public void getCredentials(ActionEvent e) throws SQLException, IOException {
        match.setVisible(false);
        AlreadyExist.setVisible(false);
            FirstName = FirstNameField.getText();
            LastName = LastNameField.getText();
            Username = UsernameField.getText();
            Password = PasswordField.getText();
            ConfirmationOfPassword = PasswordConfirmationField.getText();
            DateOfBirth = DateOfBirthField.getText();
            boolean matching = ConfirmationOfPassword.equals(Password);
        int count = 0;
        boolean canmake = false;
           if(!matching) {
               match.setVisible(true);}
               else {
               String sqlselect = "SELECT Exists(Select * from account where username ='" + Username + "')";
               ResultSet rs = stmt.executeQuery(sqlselect);
               while (rs.next()) {
                   count = rs.getInt(1);
               }
               if (count == 0) canmake = true;


               if (canmake == false) {
                   AlreadyExist.setVisible(true);
               } else {
                   String sqlInsert = "insert into librarydb.account (username,firstName,lastName,password,privLvl,dateOfBirth,dateAdded) values" + " ('" + Username + "'," + "'" + FirstName + "'," + "'" + LastName + "'," + "'" + Password + "'," + "'Client'," + "STR_TO_DATE(\"" + DateOfBirth + "\", \"%m-%d-%Y\")" + "," + "curdate())";
                   stmt.executeUpdate(sqlInsert);
                   Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                   Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                   Scene scene = new Scene(root);
                   stage.setScene(scene);
                   stage.show();


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

    public boolean PasswordConfirmed() {
        return ConfirmationOfPassword.equals(Password);
    }
}
