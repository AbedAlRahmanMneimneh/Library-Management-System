package com.libraryappcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static com.libraryappcontroller.MYSQLDatabaseManager.stmt;

public class Book {
    int ISBN, edition , numberInStock,numberInRent,numberInRefurbish;
    String title,author,publisher,pubdate,genre1 , dateAdded ;

    public Book(int ISBN,String title, String author,
                 String publisher,int edition , String pubdate, String genre1) {
        this.ISBN = ISBN;
        this.edition = edition;
        this.numberInStock = numberInStock;
        this.numberInRent = numberInRent;
        this.numberInRefurbish = numberInRefurbish;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pubdate = pubdate;
        this.genre1 = genre1;

    }

    public static ObservableList<Book> getDataBooks(){
         Connection conn = mysqlconnect.Connectdb();
         ObservableList<Book> list = FXCollections.observableArrayList();
         try{
             PreparedStatement pst = conn.prepareStatement("select * from book");
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                 list.add(new Book(rs.getInt("ISBN"),rs.getString("title"),
                         rs.getString("author"),rs.getString("publisher"),
                         rs.getInt("edition"), rs.getString("pubdate"),rs.getString("genre1") ));
             }
         } catch (Exception  e) {

         }
        return list;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public int getNumberInRent() {
        return numberInRent;
    }

    public void setNumberInRent(int numberInRent) {
        this.numberInRent = numberInRent;
    }

    public int getNumberInRefurbish() {
        return numberInRefurbish;
    }

    public void setNumberInRefurbish(int numberInRefurbish) {
        this.numberInRefurbish = numberInRefurbish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }
    public static void add_book(int ISBN,String title, String author,
                                String publisher,int edition , String pubdate, String genre1) throws SQLException {
        String sqlInsert = "insert into librarydb.book (ISBN,title,author,publisher,edition,pubdate,genre1,dateAdded) values"
                + " ('" + ISBN + "'," + "'" + title + "',"+ "'" + author + "'," + "'" + publisher
                + "',"+ "'" + edition + "',"+"STR_TO_DATE(\"" + pubdate + "\", \"%d-%m-%Y\")" + ",'" + genre1 + "'," + "curdate())";
        stmt.executeUpdate(sqlInsert);
    }
    public static void delete_book(int ISBN) throws SQLException {
        String sqldelete = "delete from librarydb.book where ISBN ='"+ ISBN + "'";
        stmt.executeUpdate(sqldelete);
    }
    public static void update_book(int ISBN,String title, String author,
                                   String publisher,int edition , String pubdate, String genre1) throws SQLException {
        String sqlUpdate = "UPDATE librarydb.book SET title = " + "'"+ title+"',"+"author = " + "'"+ author+"',"
                +"publisher = " + "'"+ publisher+"',"+"edition = " + "'"+ edition+"',"+"author = "
                + "'"+ author+"'," +"STR_TO_DATE(\"" + pubdate + "\", \"%d-%m-%Y\")" +"genre1 = " + "'"+ genre1+"' WHERE ISBN = '"+ISBN+"'";
        stmt.executeUpdate(sqlUpdate);
    }



}
