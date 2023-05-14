package studenten.view.aanmakenmails;

import jakarta.mail.MessagingException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.apache.commons.text.StringSubstitutor;
import studenten.model.*;
import studenten.view.aanmakenmails.table.AanmakenMailsTablePresenter;
import studenten.view.aanmakenmails.table.GrafiekPresenter;
import studenten.view.aanmakenmails.table.UploadTablePresenter;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AanmakenMailsPresenter {
    private PeriodeResultaten model;
    private AanmakenMailsView view;

    public AanmakenMailsPresenter(PeriodeResultaten model, AanmakenMailsView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        CsvBestand csv = new CsvBestand();
        csv.leesBestand();

        new AanmakenMailsTablePresenter(this.model, this.view.getTable());

        List<CsvLijn> csvLijnen = csv.getAlleResultaten();
        new UploadTablePresenter(csvLijnen, this.view.getUploadTable());

        Grafiek grafiek = new Grafiek();
        grafiek.setgrafiekGegevens(this.model.getPeriodeResultaten());
        new GrafiekPresenter(grafiek, this.view.getBarPlot());
    }

    private void addEventHandlers() {
        this.view.getKleurCodeFilterOpties().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (observableValue.getValue() == "Alle") {
                    view.getTable().setItems(model.getPeriodeResultaten());
                }
                if (observableValue.getValue() == "Groen") {
                    view.getTable().setItems(model.getGroeneResultaten());
                }
                if (observableValue.getValue() == "Geel") {
                    view.getTable().setItems(model.getGeleResultaten());
                }
                if (observableValue.getValue() == "Oranje") {
                    view.getTable().setItems(model.getOranjeResultaten());
                }
                if (observableValue.getValue() == "Rood") {
                    view.getTable().setItems(model.getRodeResultaten());
                }
            }
        });

        this.view.getAanmakenMailsKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ObservableList<PeriodeResultaat> periodeResultaten = view.getTable().getItems();

                    Instelling instelling = new Instelling();

                    for (PeriodeResultaat periodeResultaat : periodeResultaten) {
                        Map<String, String> variables = new HashMap<>();
                        variables.put("student.voornaam", periodeResultaat.getStudent().getVoornaam());
                        variables.put("student.achternaam", periodeResultaat.getStudent().getNaam());
                        variables.put("student.email", periodeResultaat.getStudent().getEmail());
                        variables.put("periode_resultaat.periode", periodeResultaat.getPeriode());

                        Iterator<Resultaat> iterator = periodeResultaat.getNietGeslaagdeResultaten().iterator();
                        String nietGeslaagdResultaten = "";
                        while (iterator.hasNext()) {
                            Resultaat resultaat = iterator.next();
                            nietGeslaagdResultaten += String.format("%s (%.2f/20)", resultaat.getRapportonderdeel(), resultaat.getPunt());
                            if (iterator.hasNext()) {
                                nietGeslaagdResultaten += " en ";
                            }
                        }

                        variables.put("periode_resultaat.niet_geslaagde_vakken", nietGeslaagdResultaten);
                        variables.put("instelling.docent_voornaam", instelling.getDocentVoornaam());
                        variables.put("instelling.docent_achternaam", instelling.getDocentAchternaam());
                        variables.put("instelling.link_afspraak", instelling.getDocentAchternaam());

                        MailTemplate mailTemplate = MailTemplate.voorPeriodeResultaat(periodeResultaat);

                        StringSubstitutor stringSubstitutor = new StringSubstitutor(variables);
                        String content = stringSubstitutor.replace(mailTemplate.getContent());
                        VerstuurbareMailTemplate verstuurbareMailTemplate = new VerstuurbareMailTemplate(mailTemplate.getTitel(), content);

                        Mail mail = new Mail(periodeResultaat.getStudent().getEmail(), verstuurbareMailTemplate);
                        File bestemming = new File(instelling.getMailsAanmakenBestemming() + "/mails/" + periodeResultaat.getPeriode() + "/" + periodeResultaat.getStudent().getEmail() + ".eml");

                        try {
                            mail.opslaan(bestemming);
                        } catch (IOException | MessagingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } catch (Throwable e) {
                    System.out.println("test");
                }
            }
        });
    }
}
