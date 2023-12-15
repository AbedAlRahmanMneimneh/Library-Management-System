package com.library_gui_controller;

import com.library_entity_controllers.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class bookInfoController {

    @FXML
    private Label author;

    @FXML
    private Label available;

    @FXML
    private Label date;

    @FXML
    private Label desc;

    @FXML
    private Label edition;

    @FXML
    private Label genre;

    @FXML
    private ImageView image;

    @FXML
    private Label nbrInStock;

    @FXML
    private Label publisher;

    @FXML
    private Label title;

    public void setData(Book b) {
        File file = b.getBookImage();
        image.setImage( new Image(file.toURI().toString()) );
        title.setText(b.getTitle());
        author.setText("Author: "+b.getAuthor());
        publisher.setText("Publisher: "+b.getPublisher());
        edition.setText("Edition: "+b.getEdition());
        nbrInStock.setText("Number In Stock: "+b.getNumberInStock());
        if(b.getNumberInStock()==0) {
            available.setDisable(true);
            available.setText("Not Available");
        } else {
            available.setText("Available");
        }
        genre.setText("Genre: "+b.getGenre());
        date.setText("Date Published: "+b.getDatePublished());
        desc.setText("\nDescription:\n\n"+b.getBookDescription());
    }

}

