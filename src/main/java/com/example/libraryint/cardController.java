package com.example.libraryint;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.book;

import java.io.File;

public class cardController {

    @FXML
    private Label authors;

    @FXML
    private Label genre;

    @FXML
    private ImageView image;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label title;

    public void setData(book b) {
        File file = new File(b.getImgSrc());
        image.setImage( new Image(file.toURI().toString()) );
        title.setText(b.getTitle());
        authors.setText(b.getAuthors());
        genre.setText(b.getGenre());
    }
}