package com.libraryappcontroller;

import javax.swing.*;
import java.sql.*;

public class mysqlconnect {

    Connection conn = null;


    public static Connection Connectdb(){
        try{

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","Beirut-2003");
            JOptionPane.showMessageDialog(null,"Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , e);
            return null;

        }

    }

}
