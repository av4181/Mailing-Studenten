package studenten.model;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Mail {
    private String bestemmingsEmailAdres;
    private VerstuurbareMailTemplate mailTemplate;

    public Mail(String bestemmingsEmailAdres, VerstuurbareMailTemplate mailTemplate) {
        this.bestemmingsEmailAdres = bestemmingsEmailAdres;
        this.mailTemplate = mailTemplate;
    }

    public void opslaan(File bestand) throws IOException, MessagingException {
//        Path directoryPath = Paths.get(this.instelling.getMailsAanmakenBestemming() + "/mails/" + mailTemplate.periodeResultaat.getPeriode());
//        Files.createDirectories(directoryPath);

        Session session = Session.getInstance(System.getProperties());
        MimeMessage msg = new MimeMessage(session);
        msg.setRecipients(Message.RecipientType.TO, this.bestemmingsEmailAdres);
        msg.setSubject(this.mailTemplate.getTitel());
        msg.setText(this.mailTemplate.getContent());
        msg.setHeader("X-Unsent", "1");

        MimeBodyPart content = new MimeBodyPart();
        content.setText(this.mailTemplate.getContent());
        content.setHeader("Content-Type", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(content);

        msg.setContent(multipart, "text/html");

//        Path filePath = Paths.get(directoryPath.toAbsolutePath() + "/" + mailTemplate.periodeResultaat.getStudent().getEmail() + ".eml");

        File parentBestand = bestand.getParentFile();

        parentBestand.mkdirs();

        msg.writeTo(new FileOutputStream(bestand));
    }
}
