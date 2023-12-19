package com.library_gui_controller;

import com.library_entity_controllers.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.library_database_controller.Library_Client_User_Connector.clientconnection;

public class Search implements Initializable {

    @FXML
    private VBox booksHB;

    @FXML
    private HBox recomendationHB;

    public List<Book> recommendedList(){
        Book b;
        List<Book> bl = new ArrayList<Book>();
        //change in this method to make it so that you add the books to the list in this way(b.setTitle();b.set....) but retrieve the data from sql
        b = new Book();
        b.setTitle("12 Rules Of Life");
        b.setAuthorFullName("Jordan Peterson");
        b.setGenre("Philosophy");
        b.setBookImage(new File("src/main/resources/com/library_gui_controller/images/12 Rules Of Life.jpeg"));
        b.setBookDescription("In '12 Rules of Life,' Jordan Peterson explores profound principles derived from psychology, philosophy, mythology, and personal anecdotes. Delve into this transformative guide to discover practical wisdom for navigating the complexities of existence.");

        bl.add(b);

        return bl;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        List<Book> recomended = new ArrayList<>( searchClientDataBooks(UserMainViewController.getInstance().searchTF.getText()));

        try {
            for(Book b:recomended){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("booksCard.fxml"));
                HBox box = fxmlLoader.load();
                BookCardController sampleCardController = fxmlLoader.getController();
                sampleCardController.setData(b);
                sampleCardController.setBook(b);
                booksHB.getChildren().add(box);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static  List<Book> searchClientDataBooks(String searchStatement){

        List<Book> list = new ArrayList<>();
        String sqlSelect = "Select * from book_author where ISBN = '" + searchStatement +"' UNION "+"Select * from book_author where FullName like '" + searchStatement +"%' UNION " +"Select * from book_author where genre like '%" + searchStatement +"%' UNION "+"Select * from book_author where publisher like '%" + searchStatement +"%'";
        try{
            PreparedStatement pst = clientconnection().prepareStatement(sqlSelect);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Book(rs.getInt("ISBN"),rs.getString("title"),rs.getInt("edition")
                        ,rs.getString("genre"),rs.getInt("numOfPages"),rs.getString("publisher")
                        ,rs.getString("datePublished"),rs.getString("bookDescription"),
                        new File(rs.getString("booKImage")),rs.getString("FullName")));
            }
        } catch (Exception  e) {

        }
        return list;
    }
}
