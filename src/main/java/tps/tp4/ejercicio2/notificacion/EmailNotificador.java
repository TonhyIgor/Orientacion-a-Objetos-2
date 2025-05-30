package tps.tp4.ejercicio2.notificacion;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import tps.tp4.ejercicio2.model.Notificador;

import java.util.Properties;

public class EmailNotificador implements Notificador {
    private final String USERNAME = "29f6804f91fc4a";
    private final String PASSWORD = "45334ae5a79f3c";
    private final String HOST = "sandbox.smtp.mailtrap.io";
    private String from;

    public EmailNotificador(String from) {
        chequearMailFrom(from);
        this.from = from;
    }


    private void chequearMailFrom(String from) {
        if (from.isBlank())
            throw new RuntimeException("Alguno de los datos esta en blanco");
    }

    private void chequearMailTo(String to) {
        if (to.isBlank())
            throw new RuntimeException("Alguno de los datos esta en blanco");
    }

    @Override
    public void enviarNotificacion(String medioNotificacion) {
        chequearMailTo(medioNotificacion);
        enviarMail(medioNotificacion);
    }

    private void enviarMail(String emailTo) {
        // configure SMTP details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", "587");

        // create the mail Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        try {
            // create a MimeMessage object
            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(this.from));
            // set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            // set email subject field
            message.setSubject("Feliz Cumpleanios!");
            // set the content of the email message
            message.setText("Te deseamos muy feliz cumpleanios!");

            // send the email message
            Transport.send(message);

            System.out.println("Email Message Sent Successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
