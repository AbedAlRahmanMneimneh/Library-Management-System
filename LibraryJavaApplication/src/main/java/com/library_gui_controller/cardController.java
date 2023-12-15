package com.library_gui_controller;

import com.library_entity_controllers.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    private Book book;
    @FXML
    void goToBookInfo(){
        FXMLLoader fl = UserMainViewController.getInstance().goToBookInfo();
        bookInfoController sampleinfoController = fl.getController();
        sampleinfoController.setData(book);
    }
    public void setData(Book b) {
        File file = new File(b.getBookImage().toURI());
        image.setImage( new Image(file.toURI().toString()) );
        title.setText(b.getTitle());
        authors.setText(b.getAuthor());
        genre.setText(b.getGenre());
    }
}
