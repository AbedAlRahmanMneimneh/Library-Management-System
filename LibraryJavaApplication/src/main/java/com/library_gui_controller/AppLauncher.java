package com.library_gui_controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class AppLauncher extends Application {

    public static void main(String[] args) {

        SpringApplication.run(AppLauncher.class, args);
        launch();

    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("UserMainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Apollo Script");
        stage.getIcons().add(new Image("file:src/main/resources/com/library_gui_controller/Icons/search.png"));
        stage.setScene(scene);
        stage.show();
    }

}