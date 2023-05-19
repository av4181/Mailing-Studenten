package studenten.model;

import jakarta.mail.MessagingException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class PeriodeResultaten {
    private ObservableList<PeriodeResultaat> periodeResultaten;

    public PeriodeResultaten(List<PeriodeResultaat> periodeResultaten) {
        this.periodeResultaten = FXCollections.observableArrayList(periodeResultaten);
    }

    public FilteredList<PeriodeResultaat> getGroeneResultaten() {
        return periodeResultaten.filtered(new Predicate<PeriodeResultaat>() {
            @Override
            public boolean test(PeriodeResultaat periodeResultaat) {
                return periodeResultaat.bepaalKleurCode() == PeriodeResultaat.KleurCode.GROEN;
            }
        });
    }

    public FilteredList<PeriodeResultaat> getGeleResultaten() {
        return periodeResultaten.filtered(new Predicate<PeriodeResultaat>() {
            @Override
            public boolean test(PeriodeResultaat periodeResultaat) {
                return periodeResultaat.bepaalKleurCode() == PeriodeResultaat.KleurCode.GEEL;
            }
        });
    }

    public FilteredList<PeriodeResultaat> getOranjeResultaten() {
        return periodeResultaten.filtered(new Predicate<PeriodeResultaat>() {
            @Override
            public boolean test(PeriodeResultaat periodeResultaat) {
                return periodeResultaat.bepaalKleurCode() == PeriodeResultaat.KleurCode.ORANJE;
            }
        });
    }

    public FilteredList<PeriodeResultaat> getRodeResultaten() {
        return periodeResultaten.filtered(new Predicate<PeriodeResultaat>() {
            @Override
            public boolean test(PeriodeResultaat periodeResultaat) {
                return periodeResultaat.bepaalKleurCode() == PeriodeResultaat.KleurCode.ROOD;
            }
        });
    }

    public ObservableList<PeriodeResultaat> getPeriodeResultaten() {
        return periodeResultaten;
    }

    public void mailsAanmaken(List<PeriodeResultaat> periodeResultaten) {
        Instelling instelling = new Instelling();

        for (PeriodeResultaat periodeResultaat : periodeResultaten) {
            MailTemplateVariables mailTemplateVariables = MailTemplateVariables.voorPeriodeResultaat(periodeResultaat);
            MailTemplate mailTemplate = MailTemplate.voorPeriodeResultaat(periodeResultaat);

            MailTemplatePopulator mailTemplatePopulator = new MailTemplatePopulator();
            VerstuurbareMailTemplate verstuurbareMailTemplate = mailTemplatePopulator.populate(mailTemplate, mailTemplateVariables);

            Mail mail = new Mail(periodeResultaat.getStudent().getEmail(), verstuurbareMailTemplate);
            File bestemming = new File(instelling.getMailsAanmakenBestemming() + "/mails/" + periodeResultaat.getPeriode() + "/" + periodeResultaat.getStudent().getEmail() + ".eml");

            try {
                mail.opslaan(bestemming);
            } catch (IOException | MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
