package com.library_gui_controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.book;

import java.io.File;

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

    public void setData(book b) {
        File file = new File(b.getImgSrc());
        image.setImage( new Image(file.toURI().toString()) );
        title.setText(b.getTitle());
        author.setText(b.getAuthors());
        publisher.setText(b.getPublisher());
        edition.setText(b.getEdition());
        nbrInStock.setText(b.getNbrInStock());
        available.setDisable(!b.isAvailable());
        genre.setText(b.getGenre());
        desc.setText(b.getDesc());
    }
}

