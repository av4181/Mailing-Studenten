package studenten.view.instellingen.algemeen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;
import studenten.model.Instelling;

import java.io.File;

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
                model.setDocentVoornaam(view.getDocentVoornaamInput().getText());
                model.setDocentAchternaam(view.getDocentAchternaamInput().getText());
                model.setLinkAfspraak(view.getLinkAfspraakInput().getText());
                model.setMailsAanmakenBestemming(view.getMailsAanmakenBestemmingInput().getText());

                model.opslaan();
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
