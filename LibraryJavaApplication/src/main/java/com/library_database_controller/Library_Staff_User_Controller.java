package com.library_database_controller;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Library_Staff_User_Controller {
    public static Connection staffconnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/libappschem", "Library_Staff_User", "IAmAStaff!");
        return conn;
    }

    public static Statement staffstatement() throws SQLException {

        Statement stmt = staffconnection().createStatement();
        return stmt;
    }



}
