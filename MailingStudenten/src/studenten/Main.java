package studenten;

import studenten.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvBestand csv = new CsvBestand();
        csv.leesBestand();

        List<Student> studenten = csv.getStudenten();

        Instelling instelling = new Instelling("test", "test", "https://www.google.be");

        for (Student student: studenten) {
            for (PeriodeResultaat periodeResultaat: student.getPeriodeResultaten()) {
                MailTemplate mailTemplate = MailTemplate.voorPeriodeResultaat(periodeResultaat, instelling);
                Mail mail = new Mail(student.getEmail(), "steven.symons@student.kdg.be", mailTemplate);
            }
        }
    }

}
