package com.library_database_controller;

import jakarta.activation.MimetypesFileTypeMap;
import org.apache.commons.io.FileUtils;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.nio.file.*;
import java.sql.*;

import static com.library_database_controller.FileDialogueSelect.openFileDialogue;

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

    public static String copyImageToProject() throws IOException, IncorrectFileTypeException {
        File f = new File(openFileDialogue().toURI());
        String mimetype = new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];
        if (type.equals("image")) {
            FileInputStream in = new FileInputStream(f);
            FileOutputStream out = new FileOutputStream("C:\\Users\\user\\Mahmoud\\GitHub Repos\\DBS_Project\\Library-Management-System\\LibraryJavaApplication\\src\\main\\resources\\com\\library_gui_controller\\images\\" + f.getName());
            BufferedInputStream bin = new BufferedInputStream(in);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bout.write(b);
            }
            bin.close();
            bout.close();
        } else {
            throw new IncorrectFileTypeException("The File is not Image");
        }

    return f.getName();
    }


}
