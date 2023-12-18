package com.library_gui_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class adminPage implements Initializable {

    @FXML
    private Button ReserveButton;

    @FXML
    private DatePicker dateOfReservation;

    @FXML
    private TextField from;

    @FXML
    private TextField studyRoomNbr;

    @FXML
    private TextField to;

    @FXML
    private VBox vbm;

    @FXML
    void reserveStuyRoom(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
