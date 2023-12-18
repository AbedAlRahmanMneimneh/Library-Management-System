package com.libraryappcontroller;

import java.sql.*;

import java.util.Date;

import static com.libraryappcontroller.MYSQLConnector.statement;


//    Parent abstract class Account
public abstract class Account {

    static Statement stmt;

    static {
        try {
            stmt = statement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //    Attributes of an Account entity in the MySQL database librarydb
    protected String date_added;

    enum AccountType{Admin,Client,Keeper}
    protected String username,first_name,last_name,password;
    protected AccountType privlvl;
    protected String date_of_birth;

    protected Account(String username, String first_name, String last_name,
                   String password, AccountType privlvl, String date_of_birth, String date_added) throws SQLException {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.privlvl = privlvl;
        this.date_added = date_added;
        this.date_of_birth = date_of_birth;
    }

    final static protected void rent_a_book(int isbn, int adminaccid, int clientaccid) throws SQLException {
        String sqlselect = "SELECT * FROM book WHERE book.ISBN = "+isbn   ;

        String sqlinserttrans= "INSERT INTO transaction (isbn,adminAccId,clientAccId,transType) values("
                +isbn+","+adminaccid+","+clientaccid+","+"Rent)" ;

        ResultSet rset = stmt.executeQuery(sqlselect);

        int instock;
        int inrent;
        try{
            inrent = rset.getInt("numberInRent"); //get number of books in rent
        }
        catch(NullPointerException e){
            inrent = 0; // if no books are in rent (returns null) assume 0
        }
        try{
            instock = rset.getInt("numberInStock"); // get number of books in stock
        }
        catch(NullPointerException e){
            instock = -1; //if no books are in stock (returns null) assume -1 and print stack trance
            System.out.println(e.getStackTrace());
        }
        if(instock > 0){ // if there are books in stock
            String sqlupdate = "UPDATE book set numberInStock=" + (instock-1) + "WHERE ISBN ="+ isbn;

            stmt.executeQuery(sqlupdate); //update number of books in stock

            sqlupdate = "UPDATE book set numberInRent=" + (inrent+1) + "WHERE ISBN ="+ isbn;

            stmt.executeQuery(sqlupdate); //update number of books in rent


            stmt.executeQuery(sqlinserttrans); //insert new rent transaction in transaction table


            String sqlselect1 = "SELECT * FROM transaction WHERE ISBN ="+isbn+" ORDER BY idTransaction DESC LIMIT 1";
            ResultSet rs1=stmt.executeQuery(sqlselect1) ;
            int idtrans = rs1.getInt("idTransaction");

            String sqlinsertrel = "INSERT INTO account_transaction ("+adminaccid+","+ idtrans + ",curdate())";
            stmt.executeQuery(sqlinsertrel); //insert new entry in intermediary table account_transaction



        }
    }
    protected  static void return_a_book(int isbn, int adminaccid, int clientaccid) throws SQLException{

        String sqlselect = "SELECT * FROM book WHERE book.ISBN = "+isbn  ;
        String sqlupdate;
        ResultSet rs = stmt.executeQuery(sqlselect);
        int inrent = rs.getInt("numberInRent");
        int instock = rs.getInt("numberInStock");
        if (inrent > 0){
            sqlupdate = "UPDATE book set numberInRent="+(inrent-1)+"WHERE ISBN ="+isbn;
            stmt.executeQuery(sqlupdate);
            sqlupdate = "UPDATE book set numberInStock="+(instock+1)+"WHERE ISBN ="+isbn;
            String sqlinserttrans= "INSERT INTO transaction (bookISBN,adminAccId,clientAccId,transType) values("
                    +isbn+","+adminaccid+","+clientaccid+","+"'Return')";
            stmt.executeQuery(sqlinserttrans);
            String sqlselect1 = "SELECT * FROM transaction WHERE ISBN ="+isbn+" ORDER BY idTransaction DESC LIMIT 1";
            ResultSet rs1=stmt.executeQuery(sqlselect1) ;
            int idtrans = rs1.getInt("idTransaction");

            String sqlinsertrel = "INSERT INTO account_transaction ("+adminaccid+","+ idtrans + ",curdate())";
            stmt.executeQuery(sqlinsertrel); //insert new entry in intermediary table account_transaction


        }



    }
    protected static void discard_of_a_book(int isbn, int adminaccid)throws SQLException{
        String sqlselect = "SELECT * FROM book WHERE book.ISBN = "+isbn  ;
        String sqlupdate;
        String sqlinsert;
        ResultSet rs = stmt.executeQuery(sqlselect);
        int instock =rs.getInt("numberInStock");
        if (instock > 0) {
            sqlupdate = "UPDATE book set numberInStock ="+(instock-1)+"WHERE ISBN="+isbn;
            stmt.executeQuery(sqlupdate);
            sqlinsert = "INSERT INTO trasnaction (bookISBN,adminAccId,transType) values("
                    +isbn+","+adminaccid+","+"'Discard')";
            stmt.executeQuery(sqlinsert);
            String sqlselect1 = "SELECT * FROM transaction WHERE ISBN ="+isbn+" ORDER BY idTransaction DESC LIMIT 1";
            ResultSet rs1=stmt.executeQuery(sqlselect1) ;
            int idtrans = rs1.getInt("idTransaction");
            String sqlinsertrel = "INSERT INTO account_transaction ("+adminaccid+","+ idtrans + ",curdate())";
            stmt.executeQuery(sqlinsertrel); //insert new entry in intermediary table account_transaction

        }
    }
    protected static void refurbish_a_book(int isbn, int adminaccid)throws SQLException{
        String sqlselect = "SELECT * FROM book WHERE book.ISBN = "+isbn  ;
        String sqlupdate;
        String sqlinsert;
        ResultSet rs = stmt.executeQuery(sqlselect);

        int instock =rs.getInt("numberInStock");
        int inrefurbish = rs.getInt("numberInRefurbish");
        if (instock > 0) {
            sqlupdate = "UPDATE book set numberInStock ="+(instock-1)+"WHERE ISBN="+isbn;
            stmt.executeQuery(sqlupdate);
            sqlupdate = "UPDATE book set numberInRefurbish ="+(inrefurbish+1)+"WHERE ISBN="+isbn;
            stmt.executeQuery(sqlupdate);
            sqlinsert = "INSERT INTO trasnaction (bookISBN,adminAccId,transType) values("
                    +isbn+","+adminaccid+","+"'Refurbish')";
            stmt.executeQuery(sqlinsert);
            String sqlselect1 = "SELECT * FROM transaction WHERE ISBN ="+isbn+" ORDER BY idTransaction DESC LIMIT 1";
            ResultSet rs1=stmt.executeQuery(sqlselect1) ;
            int idtrans = rs1.getInt("idTransaction");
            String sqlinsertrel = "INSERT INTO account_transaction ("+adminaccid+","+ idtrans + ",curdate())";
            stmt.executeQuery(sqlinsertrel); //insert new entry in intermediary table account_transaction

        }

    }
    protected static void replenish(int isbn, int numadded, int adminaccid)throws SQLException{
        String sqlselect = "SELECT * FROM book WHERE ISBN ="+isbn;

        ResultSet rs = stmt.executeQuery(sqlselect);
        try {
            int instock = rs.getInt("numberInStock");
            String sqlupdate = "UPDATE book set numberInStock ="+(instock+numadded)+"WHERE ISBN="+isbn;
            stmt.executeQuery(sqlupdate);
            sqlupdate = "INSERT INTO  transaction (bookISBN,adminAccId,transtype) values ("+isbn+","+adminaccid+",'Add')";
            String sqlselect1 = "SELECT * FROM transaction WHERE ISBN ="+isbn+" ORDER BY idTransaction DESC LIMIT 1";
            ResultSet rs1=stmt.executeQuery(sqlselect1) ;
            int idtrans = rs1.getInt("idTransaction");
            String sqlinsertrel = "INSERT INTO account_transaction ("+adminaccid+","+ idtrans + ",curdate())";
            stmt.executeQuery(sqlinsertrel); //insert new entry in intermediary table account_transaction

        }catch(NullPointerException e){
            System.out.println("Book does not exist in database");
        }


    }
    protected static void add_book(int isbn, String title,String author, String publisher, int edition , String pubdate,
                            String genre1, int numberInStock) throws SQLException {
        String sqlinsert = "INSERT INTO book( isbn,  title, author,  publisher,  edition ,  pubdate,  genre1, dateAdded,  numberInStock) " +
                " values("+isbn+","+"'"+title+"',"+"'"+author+"',"+"'"+ publisher+"',"+edition+","+"To_DATE('"+pubdate+"', '%d-%m-%Y'),'" +genre1+"',"+"cur_date(),"+ numberInStock+")";
        stmt.executeQuery(sqlinsert);


    }


    }


