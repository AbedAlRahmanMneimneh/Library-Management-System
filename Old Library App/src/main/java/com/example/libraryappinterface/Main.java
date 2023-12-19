package com.example.libraryappinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
    Statement stmt;
    @Override
    public void start(Stage primaryStage) {
        try {
            Stage log = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene loginScene = new Scene(root);
            log.setResizable(false);
            log.setScene(loginScene);
            log.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}