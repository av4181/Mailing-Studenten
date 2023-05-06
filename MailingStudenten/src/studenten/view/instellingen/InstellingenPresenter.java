package studenten.view.instellingen;

import javafx.stage.DirectoryChooser;
import studenten.model.Instelling;

import java.io.File;

public class InstellingenPresenter {
    private Instelling model;
    private InstellingenView view;

    public InstellingenPresenter(Instelling model, InstellingenView view) {
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
        view.getInstellingenOpslaanKnop().setOnAction(actionEvent -> {
            this.model.setDocentVoornaam(view.getDocentVoornaamInput().getText());
            this.model.setDocentAchternaam(view.getDocentAchternaamInput().getText());
            this.model.setLinkAfspraak(view.getLinkAfspraakInput().getText());
            this.model.setMailsAanmakenBestemming(view.getMailsAanmakenBestemmingInput().getText());
            this.model.opslaan();
        });
        view.getKiesMailsAanmakenBestemmingKnop().setOnAction(actionEvent -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();

            directoryChooser.setInitialDirectory(new File(this.model.getMailsAanmakenBestemming()));
            File chosenDirectory = directoryChooser.showDialog(null);
            if (chosenDirectory != null) {
                view.getMailsAanmakenBestemmingInput().setText(chosenDirectory.getAbsolutePath());
            }
        });
    }
}
