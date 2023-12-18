package com.library_gui_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
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
        username.setText("Username: "+""/*code to get data*/);
        email.setText("Email: "+""/*code to get data*/);
        phone.setText("Phone: "+""/*code to get data*/);
        fullName.setText("Full Name: "+""/*code to get data*/);
        userID.setText("User ID: "+""/*code to get data*/);
        dob.setText("Date of Birth: "+""/*code to get data*/);
        gender.setText("Gender: "+""/*code to get data*/);
        landline.setText("Landline: "+""/*code to get data*/);
        favoriteAuthor.setText("Favorite Author: "+""/*code to get data*/);
        favoriteGenre.setText("Favorite Genre: "+""/*code to get data*/);
        booksRented.setText("Books Rented: "+""/*code to get data*/);
        pagesRead.setText("Pages: "+""/*code to get data*/);

    }
}
