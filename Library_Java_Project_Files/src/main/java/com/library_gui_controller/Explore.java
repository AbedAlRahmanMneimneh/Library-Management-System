package com.library_gui_controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.book;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Explore implements Initializable {

    @FXML
    private VBox booksHB;

    @FXML
    private HBox recomendationHB;

    List<book> recommendedList(){
        book b;
        List<book> bl = new ArrayList<book>();

        b = new book();
        b.setTitle("12 Rules Of Life");
        b.setAuthors("Jordan Peterson");
        b.setGenre("Philosophy");
        b.setImgSrc("src/main/resources/com/library_gui_controller/images/12 rules of life.jpeg");
        b.setDesc("In '12 Rules of Life,' Jordan Peterson explores profound principles derived from psychology, philosophy, mythology, and personal anecdotes. Delve into this transformative guide to discover practical wisdom for navigating the complexities of existence.");

        bl.add(b);

        b = new book();
        b.setTitle("Effective Java");
        b.setAuthors("Addison Wesley");
        b.setGenre("Programming");
        b.setImgSrc("src/main/resources/com/library_gui_controller/images/effectiveJava.png");
        b.setDesc("Written by Joshua Bloch, 'Effective Java' is a comprehensive guide for Java developers seeking to write robust and maintainable code. With practical advice and coding examples, this book is an essential resource for mastering the intricacies of Java programming.");

        bl.add(b);

        b = new book();
        b.setTitle("Outlawed");
        b.setAuthors("Anna North");
        b.setGenre("Historical Fiction");
        b.setImgSrc("src/main/resources/com/library_gui_controller/images/Outlawed.jpeg");
        b.setDesc("Anna North's 'Outlawed' is a gripping historical fiction set in a reimagined American West. Follow the journey of Ada, a young woman who becomes an outlaw to survive, as North weaves a tale of identity, resilience, and the quest for justice.");

        bl.add(b);

        b = new book();
        b.setTitle("Mona");
        b.setAuthors("Pola Oloixarac");
        b.setGenre("Literary Fiction");
        b.setImgSrc("src/main/resources/com/library_gui_controller/images/Mona.jpg");
        b.setDesc("Pola Oloixarac's 'Mona' is a literary tour de force that explores the intersection of science, art, and the human experience. With rich prose and complex characters, Oloixarac crafts a narrative that challenges conventions and captivates the reader.");

        bl.add(b);

        b = new book();
        b.setTitle("With Teeth");
        b.setAuthors("Kristen Arnett");
        b.setGenre("Domestic Fiction");
        b.setImgSrc("src/main/resources/com/library_gui_controller/images/with teeth_.jpg");
        b.setDesc("Kristen Arnett's 'With Teeth' is a poignant exploration of family dynamics, queerness, and the complexities of motherhood. Through vivid storytelling and authentic characters, Arnett invites readers to reflect on the intricacies of modern family life.");

        bl.add(b);

        b = new book();
        b.setTitle("After the Sun");
        b.setAuthors("Jonas Eika");
        b.setGenre("Short Stories");
        b.setImgSrc("src/main/resources/com/library_gui_controller/images/after the sun.jpg");
        b.setDesc("Explore the thought-provoking world of Jonas Eika's short stories in 'After the Sun.' With a blend of social commentary and imaginative storytelling, Eika takes readers on a journey through diverse landscapes, offering unique perspectives on the human condition.");

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
        try {
            for(book b:recomended){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("booksCard.fxml"));
                HBox box = fxmlLoader.load();
                bookCardController sampleCardController = fxmlLoader.getController();
                sampleCardController.setData(b);
                booksHB.getChildren().add(box);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
