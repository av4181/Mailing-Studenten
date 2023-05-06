package studenten.view.aanmakenmails;

import jakarta.mail.MessagingException;
import javafx.collections.ObservableList;
import studenten.model.Instelling;
import studenten.model.Mail;
import studenten.model.MailTemplate;
import studenten.model.PeriodeResultaat;

import java.io.IOException;

public class AanmakenMailsPresenter {
    private AanmakenMailsView view;

    public AanmakenMailsPresenter(AanmakenMailsView view) {
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {}

    private void addEventHandlers() {
        this.view.getAanmakenMailsKnop().setOnAction(actionEvent -> {
            ObservableList<PeriodeResultaat> periodeResultaten = this.view.getTable().getItems();
            for (PeriodeResultaat periodeResultaat : periodeResultaten) {
                MailTemplate mailTemplate = MailTemplate.voorPeriodeResultaat(periodeResultaat);
                Mail mail = new Mail(periodeResultaat.getStudent().getEmail(), mailTemplate, new Instelling());
                try {
                    mail.opslaan();
                } catch (IOException | MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
