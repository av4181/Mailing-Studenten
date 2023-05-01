package studenten;

import jakarta.mail.MessagingException;
import org.json.simple.parser.ParseException;
import studenten.model.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, URISyntaxException, MessagingException {
        CsvBestand csv = new CsvBestand();
        csv.leesBestand();

        List<Student> studenten = csv.getStudenten();

        Instelling instelling = new Instelling();

        instelling.opslaan();

        for (Student student: studenten) {
            for (PeriodeResultaat periodeResultaat: student.getPeriodeResultaten()) {
                MailTemplate mailTemplate = MailTemplate.voorPeriodeResultaat(periodeResultaat, instelling);
                Mail mail = new Mail(student.getEmail(), mailTemplate);

                mail.opslaan();
            }
        }
    }

}
