package com.library_entity_controllers;

import com.library_gui_controller.IncorrectFileTypeException;
import jakarta.activation.MimetypesFileTypeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.library_database_controller.Library_Client_User_Connector.clientconnection;
import static com.library_database_controller.Library_Client_User_Connector.clientstatement;
import static com.library_database_controller.Library_Staff_User_Controller.staffconnection;
import static com.library_database_controller.Library_Staff_User_Controller.staffstatement;
import static com.library_gui_controller.FileDialogueSelect.openFileDialogue;

public class Book {
    private int copyNumber;
    private Integer ISBN;
    private String title;
    private Integer edition;
    private String genre;
    private Integer numOfPages;
    private String publisher;
    private String datePublished;
    private Integer numberInStock =0;
    private Integer available;
    private String bookDescription;
    private File bookImage;
    private String authorFullName;

    public Book(int copyNumber, int ISBN, String title, String authorFullName ){
        this.copyNumber= copyNumber;
        this.ISBN = ISBN;
        this.title = title;
        this.authorFullName = authorFullName;

    }
    public Book(Integer ISBN, String title, Integer edition, String genre, Integer numOfPages, String publisher, String datePublished,
                Integer numberInStock, Integer available, String bookDescription, File bookImage, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.edition = edition;
        this.genre = genre;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.numberInStock = numberInStock;
        this.available = available;
        this.bookDescription = bookDescription;
        this.bookImage = bookImage;
        this.authorFullName = author;
    }

    public Book() {
    }

    public Book(Integer ISBN, String title, Integer edition, String genre, Integer numOfPages, String publisher,
                String datePublished,  String bookDescription, File bookImage, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.edition = edition;
        this.genre = genre;
        this.numOfPages = numOfPages;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.available = available;
        this.bookDescription = bookDescription;
        this.bookImage = bookImage;
        this.authorFullName = author;
    }
    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    public Integer getISBN() {

        return ISBN;
    }

    public void setISBN(Integer ISBN) {

        this.ISBN = ISBN;
    }

    public Integer getEdition() {

        return edition;
    }

    public void setEdition(Integer edition) {

        this.edition = edition;
    }

    public Integer getNumOfPages() {

        return numOfPages;
    }

    public void setNumOfPages(Integer numOfPages) {

        this.numOfPages = numOfPages;
    }

    public String getPublisher() {

        return publisher;
    }

    public void setPublisher(String publisher) {

        this.publisher = publisher;
    }

    public String getDatePublished() {

        return datePublished;
    }

    public void setDatePublished(String datePublished) {

        this.datePublished = datePublished;
    }

    public Integer getNumberInStock() {

        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {

        this.numberInStock = numberInStock;
    }

    public Integer getAvailable() {

        return available;
    }

    public void setAvailable(Integer available) {


        this.available = available;
    }

    public String getBookDescription() {


        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {


        this.bookDescription = bookDescription;
    }

    public File getBookImage() {


        return bookImage;
    }

    public void setBookImage(File bookImage) {

        this.bookImage = bookImage;
    }
    public String getAuthorFullName() {

        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {

        this.authorFullName = authorFullName;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {

        this.genre = genre;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }



    public static ObservableList<Book> getStaffDataBookCopies(){

        ObservableList<Book> list = FXCollections.observableArrayList();
        String sqlSelect = "Select copyNo,ISBN,title,FullName from staff_book_bookcopy_author ";
        try{
            PreparedStatement pst = staffconnection().prepareStatement(sqlSelect);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Book(rs.getInt("CopyNumber"),rs.getInt("ISBN"),
                        rs.getString("title"),rs.getString("FullName")));
            }
        } catch (Exception  e) {

        }
        return list;
    }
    public static List<Book> getClientDataBooks(){

        List<Book> list = new ArrayList<>();
        String sqlSelect = "Select * from book_author ";
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
    public static void addBook(int ISBN, String title, int authorId, int edition, String genre, int numOfPages, String publisher, String datePublished, String bookDescription, String fileName) throws SQLException {
        String sqlInsert = "insert into libappschem.book values" + " ('" + ISBN + "'," + "'" + title + "',"
                + "'" + authorId + "'," + "'" + edition + "','" + genre +"','"+numOfPages+"',"+"'"+publisher+"',"
                + "STR_TO_DATE(\"" + datePublished + "\", \"%m-%d-%Y\")" +",'"+bookDescription+"','"
                +"src/main/resources/com/library_gui_controller/images/"+fileName +"')";
        staffstatement().executeUpdate(sqlInsert);

    }
    public static void addBookCopy(int bookCopy, int ISBN) throws SQLException {
        String sqlInsert = "insert into libappschem.bookCopy values" + " ("+bookCopy+","+ISBN+","+1+")";
        staffstatement().executeUpdate(sqlInsert);

    }

    public static void update_book(int ISBN, String title, int authorId, int edition, String genre, int numOfPages,String publisher, String datePublished, String bookDescription) throws SQLException {
        String sqlUpdate = "UPDATE libappschem SET title = " + "'"+ title+"',"+"authorId = " + "'"+ authorId+"',"
                +"publisher = " + "'"+ publisher+"',"+"edition = " + "'"+ edition+"',"+"numOfPages = "
                + "'"+ numOfPages+"'," +"datePublished ="+"STR_TO_DATE(\"" + datePublished + "\", \"%d-%m-%Y\")" +"genre = " + "'"+ genre+"', bookDescription='"+bookDescription+"' WHERE ISBN = '"+ISBN+"'";
        staffstatement().executeUpdate(sqlUpdate);
    }

    public static void deleteBookCopy(int number) throws SQLException {
        String sqlDelete ="DELETE FROM libappschem.book WHERE copyNo ="  +number;
        staffstatement().executeUpdate(sqlDelete);
    }

}
