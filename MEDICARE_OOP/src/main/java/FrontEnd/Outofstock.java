package FrontEnd;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Outofstock {
    public static void sendEmail(String mail, String notify) {
        final String username = "venuthiru185@gmail.com";
        final String password = "ccqbgnqmvdzyptmy"; // Use App Password, not Gmail password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Use 465 for SSL
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable TLS
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Trust SMTP server

        SSLFix.disableSSLVerification();

        // Create a session with an authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject("MediCare+ Out Of Stock");
            message.setText(notify);

            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String mail = "";
        String message = "";
        
        sendEmail(mail, message);
    }
}
