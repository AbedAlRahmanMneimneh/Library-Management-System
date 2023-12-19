package com.Email;
import com.library_entity_controllers.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

import static com.library_database_controller.Library_Staff_User_Controller.staffconnection;

public class Mail {
    private static String emailFrom = "apolloscriptlibrary@gmail.com";
    private static String appPassword = "tdluxehshmqybktc";
    public static void sendMail(String emailTo, String Subject, String Contents) throws MessagingException {
        Session session = createSessionAuth();
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailFrom));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(emailTo));
        message.setSubject(Subject);

        String msg = Contents;

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
    private static Properties setProperties(){
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "25");
        return prop;
    }
    private static Session createSessionAuth(){
        Session session = Session.getDefaultInstance(setProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, appPassword);
            }
        });
        return session;
    }

    public static ObservableList<Book> getStaffDataBookCopies(){

        ObservableList<Book> list = FXCollections.observableArrayList();
        String sqlSelect = "Select copyNo,ISBN,title,FullName from staff_book_bookcopy_author ";
        try{
            PreparedStatement pst = staffconnection().prepareStatement(sqlSelect);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Book(rs.getInt("CopyNumber"),rs.getInt("ISBN"),
                        rs.getString("title"),rs.getString("FullName")));
            }
        } catch (Exception  e) {

        }
        return list;
    }
}