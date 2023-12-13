package com.library_database_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Library_Admin_User {
    public static Connection adminconnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/libappschem","root","Beirut-2003");
        return conn;
    }

    public static Statement clientstatement() throws SQLException{

        Statement stmt = adminconnection().createStatement();
        return stmt;
    }
}
