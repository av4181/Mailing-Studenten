package studenten.view.instellingen.algemeen;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;
import javafx.util.Duration;
import studenten.model.Instelling;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class InstellingenAlgemeenPresenter {
    private Instelling model;
    private InstellingenAlgemeenView view;

    public InstellingenAlgemeenPresenter(Instelling model, InstellingenAlgemeenView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        view.getDocentVoornaamInput().setText(this.model.getDocentVoornaam());
        view.getDocentAchternaamInput().setText(this.model.getDocentAchternaam());
        view.getLinkAfspraakInput().setText(this.model.getLinkAfspraak());
        view.getMailsAanmakenBestemmingInput().setText(this.model.getMailsAanmakenBestemming());
    }

    private void addEventHandlers() {
        view.getInstellingenOpslaanKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<String> validationErrors = new ArrayList<>();
                if (view.getDocentVoornaamInput().getText().isBlank()) {
                    validationErrors.add("Docent voornaam is verplicht.");
                }
                if (view.getDocentAchternaamInput().getText().isBlank()) {
                    validationErrors.add("Docent achternaam is verplicht.");
                }
                if (view.getLinkAfspraakInput().getText().isBlank()) {
                    validationErrors.add("Link afspraak is verplicht.");
                }

                if (validationErrors.size() > 0) {
                    String validationErrorMessage = "";
                    for (String error : validationErrors) {
                        validationErrorMessage += error + "\n";
                    }
                    view.getValidatieTekst().setText(validationErrorMessage);
                    return;
                }

                model.setDocentVoornaam(view.getDocentVoornaamInput().getText());
                model.setDocentAchternaam(view.getDocentAchternaamInput().getText());
                model.setLinkAfspraak(view.getLinkAfspraakInput().getText());
                model.setMailsAanmakenBestemming(view.getMailsAanmakenBestemmingInput().getText());

                model.opslaan();

                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        view.getBevestigingsTekst().setText(null);
                    }
                });
                pause.play();

                view.getBevestigingsTekst().setText("Opgeslagen!");
            }
        });

        view.getKiesMailsAanmakenBestemmingKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DirectoryChooser directoryChooser = new DirectoryChooser();

                directoryChooser.setInitialDirectory(new File(model.getMailsAanmakenBestemming()));
                File chosenDirectory = directoryChooser.showDialog(null);
                if (chosenDirectory != null) {
                    view.getMailsAanmakenBestemmingInput().setText(chosenDirectory.getAbsolutePath());
                }
            }
        });
    }
}
