package com.library_gui_controller;

import com.library_entity_controllers.Client;
import com.library_entity_controllers.Staff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Overview implements Initializable {

    @FXML
    private Label booksRented;

    @FXML
    private Label dob;

    @FXML
    private Button edit;

    @FXML
    private TextField email;

    @FXML
    private Label favoriteAuthor;

    @FXML
    private Label favoriteGenre;

    @FXML
    private TextField fullName;

    @FXML
    private ImageView image;

    @FXML
    private TextField landline;

    @FXML
    private Label pagesRead;

    @FXML
    private Label gender;

    @FXML
    private TextField phone;

    @FXML
    private Button submit;

    @FXML
    private Label userID;

    @FXML
    private TextField username;

    @FXML
    void edit(ActionEvent event) {
        username.setDisable(false);
        email.setDisable(false);
        phone.setDisable(false);
        fullName.setDisable(false);
        landline.setDisable(false);
    }

    @FXML
    void submit(ActionEvent event) {
        //code to change data in database
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(UserMainViewController.staff){
        username.setText("Username: "+ Staff.staff.getUsername());
        email.setText("Email: "+Staff.staff.getEmail());
        phone.setText("Phone: "+Staff.staff.getPhoneNumber());
        fullName.setText("Full Name: "+Staff.staff.getFullName());
        userID.setText("User ID: "+Staff.staff.getStaffId());
        dob.setText("Date of Birth: "+Staff.staff.getDateOfBirth());
        gender.setText("Gender: "+Staff.staff.getGender());
        landline.setText("Landline: "+Staff.staff.getLandLine());
        favoriteGenre.setText("Favorite Genre: N/A");
        booksRented.setText("Books Rented: 0");
        pagesRead.setText("Pages Read: 0");}
        else{
            username.setText("Username: "+Client.client.getUsername());
            email.setText("Email: "+Client.client.getEmail());
            phone.setText("Phone: "+Client.client.getPhoneNumber());
            fullName.setText("Full Name: "+Client.client.getFullName());
            userID.setText("User ID: "+Client.client.getClientId());
            dob.setText("Date of Birth: "+Client.client.getDateOfBirth());
            gender.setText("Gender: "+Client.client.getGender());
            landline.setText("Landline: "+Client.client.getLandLine());
            favoriteGenre.setText("Favorite Genre: N/A");
            booksRented.setText("Books Rented: 0");
            pagesRead.setText("Pages Read: 0");}

        try {
            favoriteGenre.setText("Favorite Genre: "+Client.client.getFavouriteGenre());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            booksRented.setText("Books Rented: "+Client.client.getBooksRented());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            pagesRead.setText("Pages: "+Client.client.getPagesRead());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
