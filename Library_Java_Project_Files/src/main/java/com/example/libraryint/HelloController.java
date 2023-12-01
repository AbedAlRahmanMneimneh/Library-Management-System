package com.example.libraryint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.book;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private VBox scene;
    @FXML
    private VBox booksHB;

    @FXML
    private Button exploreBT;

    @FXML
    private Button overviewBT;

    @FXML
    private HBox recomendationHB;

    @FXML
    private Button roomsBT;

    @FXML
    private Button searchBT;

    @FXML
    private TextField searchTF;

    @FXML
    private Button userBT;

    @FXML
    private Label userNameLabel;

    @FXML
    void goToExplore(ActionEvent event) {
        try {
            FXMLLoader fl = new FXMLLoader();
            fl.setLocation(getClass().getResource("explore.fxml"));
            VBox vb = fl.load();
            scene.getChildren().setAll(vb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void goToOverview(ActionEvent event) {
        try {
            FXMLLoader fl = new FXMLLoader();
            fl.setLocation(getClass().getResource("overview.fxml"));
            VBox vb = fl.load();
            scene.getChildren().setAll(vb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void goToRooms(ActionEvent event) {
        try {
            FXMLLoader fl = new FXMLLoader();
            fl.setLocation(getClass().getResource("rooms.fxml"));
            VBox vb = fl.load();
            scene.getChildren().setAll(vb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void openUser(ActionEvent event) {

    }

    @FXML
    void searchBook(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        goToExplore(new ActionEvent());
    }
}