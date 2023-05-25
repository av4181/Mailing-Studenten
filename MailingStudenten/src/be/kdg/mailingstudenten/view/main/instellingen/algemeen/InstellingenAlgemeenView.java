package be.kdg.mailingstudenten.view.main.instellingen.algemeen;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class InstellingenAlgemeenView extends GridPane {
    private Label docentVoornaamLabel;
    private TextField docentVoornaamInput;
    private Label docentAchternaamLabel;
    private TextField docentAchternaamInput;
    private Label linkAfspraakLabel;
    private TextField linkAfspraakInput;
    private Label mailsAanmakenBestemmingLabel;
    private TextField mailsAanmakenBestemmingInput;
    private Button kiesMailsAanmakenBestemmingKnop;
    private HBox opslaanKnopElement;
    private Button instellingenOpslaanKnop;
    private Label bevestigingsTekst;
    private Label validatieTekst;

    public InstellingenAlgemeenView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.docentVoornaamLabel = new Label("Docent voornaam");
        this.docentVoornaamInput = new TextField();

        this.docentAchternaamLabel = new Label("Docent achternaam");
        this.docentAchternaamInput = new TextField();

        this.linkAfspraakLabel = new Label("Link afspraak");
        this.linkAfspraakInput = new TextField();

        this.mailsAanmakenBestemmingLabel = new Label("Mails bestemming");
        this.mailsAanmakenBestemmingInput = new TextField();
        this.mailsAanmakenBestemmingInput.setDisable(true);
        this.kiesMailsAanmakenBestemmingKnop = new Button("Kies bestemming");

        this.validatieTekst = new Label();
        this.validatieTekst.setStyle("-fx-text-fill: RED;");

        this.instellingenOpslaanKnop = new Button("Opslaan");
        this.bevestigingsTekst = new Label();
        this.bevestigingsTekst.setStyle("-fx-text-fill: GREEN;");
        this.opslaanKnopElement = new HBox();
        this.opslaanKnopElement.getChildren().addAll(this.instellingenOpslaanKnop, this.bevestigingsTekst);
    }

    private void layoutNodes() {
        this.add(docentVoornaamLabel, 0, 0);
        this.add(docentVoornaamInput, 1, 0, 2, 1);
        this.add(docentAchternaamLabel, 0, 1);
        this.add(docentAchternaamInput, 1, 1, 2, 1);
        this.add(linkAfspraakLabel, 0, 2);
        this.add(linkAfspraakInput, 1, 2, 2, 1);
        this.add(mailsAanmakenBestemmingLabel, 0, 3);
        this.add(mailsAanmakenBestemmingInput, 1, 3, 2, 1);
        this.add(kiesMailsAanmakenBestemmingKnop, 3, 3);

        this.add(validatieTekst, 0, 4, 2, 1);

        this.opslaanKnopElement.setSpacing(10);
        this.add(opslaanKnopElement, 0, 5,2, 1);

        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20, 10, 10, 10));
    }

    Label getDocentVoornaamLabel() {
        return docentVoornaamLabel;
    }

    TextField getDocentVoornaamInput() {
        return docentVoornaamInput;
    }

    Label getDocentAchternaamLabel() {
        return docentAchternaamLabel;
    }

    TextField getDocentAchternaamInput() {
        return docentAchternaamInput;
    }

    Label getLinkAfspraakLabel() {
        return linkAfspraakLabel;
    }

    TextField getLinkAfspraakInput() {
        return linkAfspraakInput;
    }

    Button getInstellingenOpslaanKnop() {
        return instellingenOpslaanKnop;
    }

    Label getMailsAanmakenBestemmingLabel() {
        return mailsAanmakenBestemmingLabel;
    }

    TextField getMailsAanmakenBestemmingInput() {
        return this.mailsAanmakenBestemmingInput;
    }

    Button getKiesMailsAanmakenBestemmingKnop() {
        return this.kiesMailsAanmakenBestemmingKnop;
    }

    HBox getOpslaanKnopElement() {
        return opslaanKnopElement;
    }

    Label getBevestigingsTekst() {
        return bevestigingsTekst;
    }

    Label getValidatieTekst() {
        return validatieTekst;
    }
}
