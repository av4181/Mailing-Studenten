package studenten.model;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Mail {
    private String bestemmingsEmailAdres;
    private String afzenderEmailAdres;
    private MailTemplate mailTemplate;

    public Mail(String bestemmingsEmailAdres, String afzenderEmailAdres, MailTemplate mailTemplate) {
        this.bestemmingsEmailAdres = bestemmingsEmailAdres;
        this.afzenderEmailAdres = afzenderEmailAdres;
        this.mailTemplate = mailTemplate;
    }

    public void opslaan() throws MessagingException, IOException {
//        MimeMessage message = new MimeMessage(Session.getInstance(System.getProperties()));
//        message.setFrom(new InternetAddress( this.afzenderEmailAdres));
//        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(bestemmingsEmailAdres));
//        message.setSubject(this.mailTemplate.getTitel());
//
//        MimeBodyPart content = new MimeBodyPart();
//        content.setText(this.mailTemplate.getContent());
//        content.setHeader("Content-Type", "text/html");
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(content);
//
//        message.setContent(multipart, "text/html");
//
//        PeriodeResultaat periodeResultaat = this.mailTemplate.periodeResultaat;
//        Student student = periodeResultaat.getStudent();
//        message.writeTo(new FileOutputStream(new File("/mails/" + periodeResultaat.getPeriode() + "-" + student.getEmail())));
    }
}
