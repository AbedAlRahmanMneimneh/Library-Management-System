package com.library_database_controller;

import com.library_gui_controller.IncorrectFileTypeException;
import jakarta.activation.MimetypesFileTypeMap;

import java.io.*;
import java.sql.*;

import static com.library_gui_controller.FileDialogueSelect.openFileDialogue;

public class Library_Admin_User {
    public static Connection adminconnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/libappschem", "root", "Beirut-2003");
        return conn;
    }

    public static Statement adminstatement() throws SQLException {

        Statement stmt = adminconnection().createStatement();
        return stmt;
    }
}
