package com.example.libraryappinterface;

import com.libraryappcontroller.Book;
import com.libraryappcontroller.mysqlconnect;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.libraryappcontroller.Book.*;

public class KeeperSceneController {

    @FXML
    private TableView<Book> tableBooks;

    @FXML
    private TableColumn<Book, Integer> col_ISBN;

    @FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, Integer> col_edition;

    @FXML
    private TableColumn<Book, String> col_genre1;

    @FXML
    private TableColumn<Book, String> col_pubdate;

    @FXML
    private TableColumn<Book, String> col_publisher;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    private TextField AuthorTF;

    @FXML
    private TextField ISBNTF;

    @FXML
    private TextField editionTF;

    @FXML
    private TextField genreTF;

    @FXML
    private TextField pubDateTF;

    @FXML
    private TextField publisherTF;

    @FXML
    private TextField titleTF;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    String title, author, publisher, pubdate, genre;
    int ISBN, edition;

    String[] movieGenres = {"Action", "Adventure", "Comedy", "Crime", "Drama", "Fantasy", "Historical", "Horror", "Mystery", "Romance", "Science Fiction", "Thriller"};
    private ObservableList<Book> listM = null;

    public void initialize(URL url, ResourceBundle rb) {


        col_ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        col_edition.setCellValueFactory(new PropertyValueFactory<>("edition"));
        col_pubdate.setCellValueFactory(new PropertyValueFactory<>("pubdate"));
        col_genre1.setCellValueFactory(new PropertyValueFactory<>("genre1"));

        listM = Book.getDataBooks();
        tableBooks.setItems(listM);

    }
    void setVariables(){
        this.author = AuthorTF.getText();
        this.edition = Integer.parseInt(editionTF.getText());
        this.genre = genreTF.getText();
        this.ISBN = Integer.parseInt(ISBNTF.getText());
        this.publisher = publisherTF.getText();
        this.pubdate = pubDateTF.getText();
        this.title = titleTF.getText();
    }

    @FXML
    void add(ActionEvent event) throws SQLException {

        setVariables();
        add_book( ISBN, title,  author,
                publisher,edition ,  pubdate, genre);
    }

    @FXML
    void delete(ActionEvent event) throws SQLException {
        this.ISBN = Integer.parseInt(ISBNTF.getText());

        delete_book( ISBN);

    }

    @FXML
    void update(ActionEvent event) throws SQLException {

        setVariables();
        update_book( ISBN, title,  author,
                publisher,edition ,  pubdate, genre);
    }

}
