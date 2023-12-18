package com.library_gui_controller;

import com.library_entity_controllers.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;

public class BookCardController {

    @FXML
    private Label authors;

    @FXML
    private Label desc;

    @FXML
    private Label genre;

    @FXML
    private ImageView image;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label title;

    private static BookCardController instance;

    public BookCardController(){
        instance = this;
    }

    public static BookCardController getInstance(){
        return instance;
    }

    @FXML
    void goToBookInfo(){
        FXMLLoader fl = UserMainViewController.getInstance().goToBookInfo();
        BookInfoController sampleinfoController = fl.getController();
        sampleinfoController.setData(book);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    private Book book;

    public void setData(Book b) {

        File file = new File(b.getBookImage().toURI());
        image.setImage( new Image(file.toURI().toString()) );
        title.setText(b.getTitle());
        authors.setText(b.getAuthor());
        genre.setText(b.getGenre());
        desc.setText(b.getBookDescription());
    }
}
