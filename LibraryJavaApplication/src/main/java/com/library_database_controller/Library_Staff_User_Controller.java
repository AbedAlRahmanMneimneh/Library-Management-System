package com.library_database_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Library_Staff_User_Controller {
    public static Connection staffconnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/libappschem", "Library_Client_User", "IAmAClient!");
        return conn;
    }

    public static Statement staffstatement() throws SQLException {

        Statement stmt = staffconnection().createStatement();
        return stmt;
    }
}
