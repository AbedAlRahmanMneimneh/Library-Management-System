package com.library_gui_controller;

import com.library_entity_controllers.Book;
import com.library_entity_controllers.Client;
import com.library_entity_controllers.RoomsReservation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class adminPage implements Initializable {

    @FXML
    private TextField BookCopyNumberTF;

    @FXML
    private TextField ISBNTF;

    @FXML
    private TextField ISBNcopyTF;

    @FXML
    private TextField UserID;

    @FXML
    private Button addBookCopy;

    @FXML
    private Button addButton;

    @FXML
    private TextField authorTF;

    @FXML
    private TableColumn<Book, Integer> col_ISBN;

    @FXML
    private TableColumn<RoomsReservation, Integer> col_RoomID;

    @FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, Integer> col_copyNo;

    @FXML
    private TableColumn<RoomsReservation, String> col_reservationDateTime;

    @FXML
    private TableColumn<RoomsReservation, String> col_reservationEndTime;

    @FXML
    private TableColumn<RoomsReservation, Integer> col_reservationID;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    private TableColumn<RoomsReservation, Integer> col_userID;

    @FXML
    private TextArea content;

    @FXML
    private TextField copyNumber;

    @FXML
    private Button deleteBookCopy;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField descriptionTF;

    @FXML
    private TextField editionTF;

    @FXML
    private Label fileNameLabel;

    @FXML
    private TextField genreTF;

    @FXML
    private TextField numberOfPages;

    @FXML
    private TextField pubDateTF;

    @FXML
    private TextField publisherTF;

    @FXML
    private Button rentBook;

    @FXML
    private TextField reservationEndTime;

    @FXML
    private TextField reservationTime;

    @FXML
    private Button reserveButton;

    @FXML
    private Button returnBook;

    @FXML
    private Button sendEmail;

    @FXML
    private Button sendReminder;

    @FXML
    private TextField studyRoomID;

    @FXML
    private TextField subject;

    @FXML
    private TableView<Book> tableBooks;

    @FXML
    private TableView<RoomsReservation> tableReservations;

    @FXML
    private TextField titleTF;

    @FXML
    private TextField to;

    @FXML
    private Button updateButton;

    @FXML
    private Button uploadIMG;

    @FXML
    private TextField userIDTF;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void addBookCopy(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void deletebookCopy(ActionEvent event) {

    }

    @FXML
    void rentBook(ActionEvent event) {

    }

    @FXML
    void reserveRoom(ActionEvent event) {

    }

    @FXML
    void returnBook(ActionEvent event) {

    }

    @FXML
    void send(ActionEvent event) {

    }

    @FXML
    void sendReminder(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void upload(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        col_ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("title"));

        col_author.setCellValueFactory(new PropertyValueFactory<>("authorFullName"));
        col_copyNo.setCellValueFactory(new PropertyValueFactory<>("copyNumber"));
        ObservableList<Book> listBooks = Book.getStaffDataBookCopies();
        tableBooks.setItems(listBooks);

        col_reservationID.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        col_RoomID.setCellValueFactory(new PropertyValueFactory<>("studyRoomId"));
        col_userID.setCellValueFactory(new PropertyValueFactory<>("userId"));
        col_reservationDateTime.setCellValueFactory(new PropertyValueFactory<>("reservationDateTime"));
        col_reservationEndTime.setCellValueFactory(new PropertyValueFactory<>("reservationEndDateTime"));
        ObservableList<RoomsReservation> listReservations = null; //TO BE CHANGED!!!!!!!!!!!!! TO BE CHANGED!!!!!!!!!!!!!!!
        tableReservations.setItems(listReservations);


    }
}

