package com.libraryappcontroller;

import java.sql.*;
public class MYSQLConnector {
//   class to facilitate connecting the connection between the MySQL database and the classes
    public static Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/librarydb","root","Beirut-2003");
        return conn;
    }

    public static Statement statement() throws SQLException{

        Statement stmt = connect().createStatement();
        return stmt;
    }
//    public static void main(String args[]) throws SQLException {
//        Statement stmt = statement();
//        String table_name = "t1";
//        String columnname = "c1";
//        String datatype = "int";
//        String sqlcreate = "CREATE TABLE "+table_name+"("+columnname+" "+datatype+")";
//       stmt.executeUpdate(sqlcreate);
//
////        String delete = "Drop TABLE "+table_name;
////        stmt.executeUpdate(delete);
//    }

}
