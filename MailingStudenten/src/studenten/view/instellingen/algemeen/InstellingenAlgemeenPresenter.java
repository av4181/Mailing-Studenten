package studenten.view.instellingen.algemeen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;
import studenten.model.Bereik;
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

        view.getBereikGroenElement().getInputLaag().setText(Integer.toString(this.model.getBereikGroen().getLaag()));
        view.getBereikGroenElement().getInputHoog().setText(Integer.toString(this.model.getBereikGroen().getHoog()));
        view.getBereikGeelElement().getInputLaag().setText(Integer.toString(this.model.getBereikGeel().getLaag()));
        view.getBereikGeelElement().getInputHoog().setText(Integer.toString(this.model.getBereikGeel().getHoog()));
        view.getBereikOranjeElement().getInputLaag().setText(Integer.toString(this.model.getBereikOranje().getLaag()));
        view.getBereikOranjeElement().getInputHoog().setText(Integer.toString(this.model.getBereikOranje().getHoog()));
        view.getBereikRoodElement().getInputLaag().setText(Integer.toString(this.model.getBereikRood().getLaag()));
    }

    private void addEventHandlers() {
        view.getInstellingenOpslaanKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.setDocentVoornaam(view.getDocentVoornaamInput().getText());
                model.setDocentAchternaam(view.getDocentAchternaamInput().getText());
                model.setLinkAfspraak(view.getLinkAfspraakInput().getText());
                model.setMailsAanmakenBestemming(view.getMailsAanmakenBestemmingInput().getText());
                model.setBereikGroen(new Bereik(Integer.parseInt(view.getBereikGroenElement().getInputLaag().getText()), Integer.parseInt(view.getBereikGroenElement().getInputHoog().getText())));
                model.setBereikGeel(new Bereik(Integer.parseInt(view.getBereikGeelElement().getInputLaag().getText()), Integer.parseInt(view.getBereikGeelElement().getInputHoog().getText())));
                model.setBereikOranje(new Bereik(Integer.parseInt(view.getBereikOranjeElement().getInputLaag().getText()), Integer.parseInt(view.getBereikOranjeElement().getInputHoog().getText())));
                model.setBereikRood(new Bereik(Integer.parseInt(view.getBereikRoodElement().getInputLaag().getText()), 9999999));

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
