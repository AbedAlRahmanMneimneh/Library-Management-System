package com.library_entity_controllers;

import java.sql.SQLException;

import static com.library_database_controller.Library_Staff_User_Controller.staffstatement;

public class RentDue {

    public String email;
    public int userId;
    public int ISBN;
    public String title;
    public int copyNumber;
    public String rentDate;

    public RentDue(String email, int userId, int ISBN, String title, int copyNumber, String rentDate) {
        this.email = email;
        this.userId = userId;
        this.ISBN = ISBN;
        this.title = title;
        this.copyNumber = copyNumber;
        this.rentDate = rentDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public static void rentBook(int bookCopy, int userId) throws SQLException {
        String sqlInsert = "Insert Into libappschem.transacts values("+bookCopy+","+userId+", curdate(),'Rent'";
        staffstatement().executeUpdate(sqlInsert);
    }
    public static void returnBook(int bookCopy, int userId) throws SQLException {
        String sqlInsert = "Insert Into libappschem.transacts values("+bookCopy+","+userId+", curdate(),'Return'";
        staffstatement().executeUpdate(sqlInsert);
    }
}
