package studenten.view.instellingen.algemeen;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import studenten.model.BereikElement;

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
    private BereikElement bereikGroenElement;
    private BereikElement bereikGeelElement;
    private BereikElement bereikOranjeElement;
    private BereikElement bereikRoodElement;
    private Button instellingenOpslaanKnop;

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

        this.mailsAanmakenBestemmingLabel = new Label("Bestemming");
        this.mailsAanmakenBestemmingInput = new TextField("Mails bestemming");
        this.mailsAanmakenBestemmingInput.setDisable(true);
        this.kiesMailsAanmakenBestemmingKnop = new Button("Kies bestemming");

        this.bereikGroenElement = new BereikElement("Bereik groen", 0, 0);
        this.bereikGeelElement = new BereikElement("Bereik geel", 1, 1);
        this.bereikOranjeElement = new BereikElement("Bereik oranje", 2);
        this.bereikRoodElement = new BereikElement("Bereik rood");

        this.instellingenOpslaanKnop = new Button("Opslaan");
    }

    private void layoutNodes() {
        this.add(docentVoornaamLabel, 0, 0);
        this.add(docentVoornaamInput, 1, 0);
        this.add(docentAchternaamLabel, 0, 1);
        this.add(docentAchternaamInput, 1, 1);
        this.add(linkAfspraakLabel, 0, 2);
        this.add(linkAfspraakInput, 1, 2);
        this.add(mailsAanmakenBestemmingLabel, 0, 3);
        this.add(mailsAanmakenBestemmingInput, 1, 3);
        this.add(kiesMailsAanmakenBestemmingKnop, 2, 3);

        this.add(bereikGroenElement.getLabel(), 0, 4);
        HBox bereikGroenInputs = new HBox();
        bereikGroenInputs.getChildren().addAll(new Label(">="), bereikGroenElement.getInputLaag(), bereikGroenElement.getInputHoog(), new Label("<="));
        this.add(bereikGroenInputs, 1, 4);

        this.add(bereikGeelElement.getLabel(), 0, 5);
        HBox bereikGeelInputs = new HBox();
        bereikGeelInputs.getChildren().addAll(new Label(">="), bereikGeelElement.getInputLaag(), bereikGeelElement.getInputHoog(), new Label("<="));
        this.add(bereikGeelInputs, 1, 5);

        this.add(bereikOranjeElement.getLabel(), 0, 6);
        HBox bereikOranjeInputs = new HBox();
        bereikOranjeInputs.getChildren().addAll(new Label(">="), bereikOranjeElement.getInputLaag(), bereikOranjeElement.getInputHoog(), new Label("<="));
        this.add(bereikOranjeInputs, 1, 6);

        this.add(bereikRoodElement.getLabel(), 0, 7);
        HBox bereikRoodInputs = new HBox();
        bereikRoodInputs.getChildren().addAll(new Label(">="), bereikRoodElement.getInputLaag());
        this.add(bereikRoodInputs, 1, 7);

        this.add(instellingenOpslaanKnop, 0, 8);

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

    BereikElement getBereikGroenElement() {
        return bereikGroenElement;
    }

    BereikElement getBereikGeelElement() {
        return bereikGeelElement;
    }

    BereikElement getBereikOranjeElement() {
        return bereikOranjeElement;
    }

    BereikElement getBereikRoodElement() {
        return bereikRoodElement;
    }
}
