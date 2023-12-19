package com.libraryappcontroller;
 import javafx.beans.Observable;
 import javafx.collections.FXCollections;
 import javafx.collections.ObservableList;

 import java.sql.*;
 import java.util.List;


 import static com.libraryappcontroller.MYSQLConnector.connect;
 import static com.libraryappcontroller.MYSQLConnector.statement;

public class MYSQLDatabaseManager {
static Statement stmt;

 static {
  try {
   stmt = statement();
  } catch (SQLException e) {
   throw new RuntimeException(e);
  }
 }

 public MYSQLDatabaseManager() throws SQLException {
 }

 public void view_all_books_alphabetic_order() throws SQLException {
  String sqlselect = "SELECT isbn,  title, author,  publisher,  edition ,  pubdate,  genre1 FROM book ORDER BY title desc";
  stmt.executeQuery(sqlselect);
 }
 public static void view_genre_books(String genre) throws SQLException {
  String sqlselect = "SELECT isbn,  title, author,  publisher,  edition ,  pubdate,  genre1 FROM book WHERE genre1 = '"+genre+"'"+"OR genre2='"+genre+"' OR genre3='"+genre+"'ORDER BY title desc";
  stmt.executeQuery(sqlselect);
 }
 public static void view_title_books(String title) throws SQLException {
  String sqlselect = "SELECT isbn,  title, author,  publisher,  edition ,  pubdate,  genre1 FROM book WHERE title LIKE '"+title+"'"+"ORDER BY title desc";
  stmt.executeQuery(sqlselect);
 }
 public static ObservableList<Book> getDataBooks() throws SQLException {
ObservableList<Book> list = FXCollections.observableArrayList();
  String sqlselect = "SELECT isbn,  title, author,  publisher,  edition ,  pubdate,  genre1 FROM book ORDER BY title desc";
  ResultSet rs = stmt.executeQuery(sqlselect);
 rs.next();
  while(rs.next()){
   list.add(new Book(rs.getInt("ISBN") ,  rs.getString("title"), rs.getString("author") ,rs.getString("publisher"), rs.getInt("edition"), rs.getString("pubDate") ,
          rs.getString("genre1")));
  }

  return list;
 }





}
