package com.example.libraryappinterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import static com.libraryappcontroller.MYSQLConnector.statement;

public class Accounts {
    static Statement stmt;

    static {
        try {
            stmt = statement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Accounts() throws SQLException {
    }

    static void add_a_client(String username, String first_name, String last_name, String password,
                             String date_of_birth) throws SQLException {
        /*Adds a new normal user (Client) to the database*/

        String sqlInsert = "insert into Account (username,firstName,lastName,password,dateOfBirth) values"
                + " ('" + username + "'," + "'" + first_name + "'," + "'" + last_name + "'," + "'" + password + "'," +
                "'Client'," + "STR_TO_DATE('" + date_of_birth + "', '%d-%m-%Y')" + "," + "curdate())";
        stmt.executeUpdate(sqlInsert);}


    static boolean validateAccount(String username, String password) throws SQLException {

        String sqlselect= "SELECT * from account WHERE username = '" +username+"'";

        ResultSet rs =stmt.executeQuery(sqlselect);
        rs.next();
        String passcode = rs.getString("password");

        boolean login=(Objects.equals(password, passcode));

        return login;


      	//should check if a given account is available in the data base

    }


}
