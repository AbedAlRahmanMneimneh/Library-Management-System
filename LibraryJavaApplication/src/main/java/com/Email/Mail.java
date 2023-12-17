package com.Email;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;


public class Mail {

    public static void main(String[] args) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "25");
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("apolloscriptlibrary@gmail.com", "tdluxehshmqybktc");
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("apolloscriptlibrary@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("jbaradei2003@gmail.com"));
        message.setSubject("Welcome to Apollo");

        String msg = "Ayre bl LAU";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}