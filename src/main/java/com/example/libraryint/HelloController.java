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

    }

    @FXML
    void goToOverview(ActionEvent event) {

    }

    @FXML
    void goToRooms(ActionEvent event) {

    }

    @FXML
    void openUser(ActionEvent event) {

    }

    @FXML
    void searchBook(ActionEvent event) {

    }

    List<book> recommendedList(){
        book b;
        List<book> bl = new ArrayList<book>();

        b=new book();
        b.setTitle("12 Rules Of Life");
        b.setAuthors("Jordan Peterson");
        b.setGenre("Philosophy");
        b.setImgSrc("D:\\abed\\projects\\libraryInt\\src\\main\\resources\\com\\example\\libraryint\\images\\OIP.jpeg");
        bl.add(b);

        b=new book();
        b.setTitle("Effective Java");
        b.setAuthors("Addison Wesley");
        b.setGenre("Programming");
        b.setImgSrc("D:\\abed\\projects\\libraryInt\\src\\main\\resources\\com\\example\\libraryint\\images\\effectiveJava.png");
        bl.add(b);

        b=new book();
        b.setTitle("Outlawed");
        b.setAuthors("Anna North");
        b.setGenre("Historical Fiction");
        b.setImgSrc("D:\\abed\\projects\\libraryInt\\src\\main\\resources\\com\\example\\libraryint\\images\\Outlawed.png");
        bl.add(b);

        b=new book();
        b.setTitle("Mona");
        b.setAuthors("Pola Oloixarac");
        b.setGenre("Literary Fiction");
        b.setImgSrc("D:\\abed\\projects\\libraryInt\\src\\main\\resources\\com\\example\\libraryint\\images\\Mona.jpg");
        bl.add(b);

        b=new book();
        b.setTitle("With Teeth");
        b.setAuthors("Kristen Arnett");
        b.setGenre("Domestic Fiction");
        b.setImgSrc("D:\\abed\\projects\\libraryInt\\src\\main\\resources\\com\\example\\libraryint\\images\\with teeth_.jpg");
        bl.add(b);

        b=new book();
        b.setTitle("After the Sun");
        b.setAuthors("Jonas Eika");
        b.setGenre("Short Stories");
        b.setImgSrc("D:\\abed\\projects\\libraryInt\\src\\main\\resources\\com\\example\\libraryint\\images\\after the sun.jpg");
        bl.add(b);

        return bl;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        List<book> recomended = new ArrayList<>(recommendedList());
        try {
            for(book b:recomended){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                HBox box = fxmlLoader.load();
                cardController sampleCardController =fxmlLoader.getController();
                sampleCardController.setData(b);
                recomendationHB.getChildren().add(box);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}