package com.example.libraryappinterface;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.libraryappcontroller.Book;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserSceneController implements Initializable {

    @FXML
    private ChoiceBox<?> genreChoiceBox;
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
    private Tab tabText;

    @FXML
    private Tab tabText1;

    ObservableList<Book> listM;

    int index = -1;
    String query = null;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Book book = null;

    public UserSceneController() {

    }


    public void initialize(URL url, ResourceBundle rb) {

        col_ISBN.setCellValueFactory(new PropertyValueFactory<Book, Integer>("ISBN"));
        col_title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        col_author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        col_publisher.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
        col_edition.setCellValueFactory(new PropertyValueFactory<Book, Integer>("edition"));
        col_pubdate.setCellValueFactory(new PropertyValueFactory<Book, String>("pubdate"));
        col_genre1.setCellValueFactory(new PropertyValueFactory<Book, String>("genre1"));
        listM = Book.getDataBooks();

        tableBooks.setItems(listM);

    }
}
