package com.library_database_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Library_Client_User_Connector {
    public static Connection clientconnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/libappschem","Library_Client_User","IAmAClient!");
        return conn;
    }

    public static Statement clientstatement() throws SQLException{

        Statement stmt = clientconnection().createStatement();
        return stmt;
    }

}
