package com.Email;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;


public class Mail {
    private String emailFrom = "apolloscriptlibrary@gmail.com";
    private String appPassword = "tdluxehshmqybktc";
    public  void sendmail(String emailTo, String Subject, String Contents) throws MessagingException {
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
    private Properties setProperties(){
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "25");
        return prop;
    }
    private Session createSessionAuth(){
        Session session = Session.getDefaultInstance(setProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, appPassword);
            }
        });
        return session;
    }
}