package com.library_gui_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserMainViewController implements Initializable {
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

    private static UserMainViewController instance;

    public UserMainViewController(){
        instance = this;
    }

    public static UserMainViewController getInstance(){
        return instance;
    }

    FXMLLoader goToBookInfo() {
        FXMLLoader fl;
        try {
            fl = new FXMLLoader();
            fl.setLocation(getClass().getResource("booksInfo.fxml"));

            VBox vb = fl.load();
            scene.getChildren().setAll(vb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fl;
    }
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