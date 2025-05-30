package tps.tp1.ejercicio1.comunicacion;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class MailTrapInformar implements InformarInscripcion {
    private final String username;
    private final String password;
    private String to;
    private String from;
    private String host;

    public MailTrapInformar(String to, String from, String username, String password, String host) throws MessagingException {
        chequearVacios(to, from, username, password, host);
        this.to = to;
        this.from = from;
        this.username = username;
        this.password = password;
        this.host = host;
    }

    private void chequearVacios(String to, String from, String username, String password, String host) {
        if (to.isBlank() || from.isBlank() || username.isBlank() || password.isBlank() || host.isBlank())
            throw new RuntimeException("Alguno de los datos esta en blanco");
    }

    @Override
    public void informar(String titulo, String cuerpo) {
        enviarMail(titulo, cuerpo);
    }

    private void enviarMail(String titulo, String cuerpo) {
        // configure SMTP details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", "587");

        // create the mail Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // create a MimeMessage object
            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(this.from));
            // set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
            // set email subject field
            message.setSubject(titulo);
            // set the content of the email message
            message.setText(cuerpo);

            // send the email message
            Transport.send(message);

            System.out.println("Email Message Sent Successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
