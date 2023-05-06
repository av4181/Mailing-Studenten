package studenten.view.instellingen;

import javafx.stage.DirectoryChooser;
import studenten.model.Bereik;
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

        view.getBereikGroenElement().getInputLaag().setText(Integer.toString(this.model.getBereikGroen().getLaag()));
        view.getBereikGroenElement().getInputHoog().setText(Integer.toString(this.model.getBereikGroen().getHoog()));
        view.getBereikGeelElement().getInputLaag().setText(Integer.toString(this.model.getBereikGeel().getLaag()));
        view.getBereikGeelElement().getInputHoog().setText(Integer.toString(this.model.getBereikGeel().getHoog()));
        view.getBereikOranjeElement().getInputLaag().setText(Integer.toString(this.model.getBereikOranje().getLaag()));
        view.getBereikOranjeElement().getInputHoog().setText(Integer.toString(this.model.getBereikOranje().getHoog()));
        view.getBereikRoodElement().getInputLaag().setText(Integer.toString(this.model.getBereikRood().getLaag()));
    }

    private void addEventHandlers() {
        view.getInstellingenOpslaanKnop().setOnAction(actionEvent -> {
            this.model.setDocentVoornaam(view.getDocentVoornaamInput().getText());
            this.model.setDocentAchternaam(view.getDocentAchternaamInput().getText());
            this.model.setLinkAfspraak(view.getLinkAfspraakInput().getText());
            this.model.setMailsAanmakenBestemming(view.getMailsAanmakenBestemmingInput().getText());
            this.model.setBereikGroen(new Bereik(Integer.parseInt(view.getBereikGroenElement().getInputLaag().getText()), Integer.parseInt(view.getBereikGroenElement().getInputHoog().getText())));
            this.model.setBereikGeel(new Bereik(Integer.parseInt(view.getBereikGeelElement().getInputLaag().getText()), Integer.parseInt(view.getBereikGeelElement().getInputHoog().getText())));
            this.model.setBereikOranje(new Bereik(Integer.parseInt(view.getBereikOranjeElement().getInputLaag().getText()), Integer.parseInt(view.getBereikOranjeElement().getInputHoog().getText())));
            this.model.setBereikRood(new Bereik(Integer.parseInt(view.getBereikRoodElement().getInputLaag().getText()), 9999999));

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
