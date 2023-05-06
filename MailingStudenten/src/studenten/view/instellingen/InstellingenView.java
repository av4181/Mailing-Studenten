package studenten.view.instellingen;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class InstellingenView extends TabPane {
    private GridPane gridPane;

    private Label docentVoornaamLabel;
    private TextField docentVoornaamInput;
    private Label docentAchternaamLabel;
    private TextField docentAchternaamInput;
    private Label linkAfspraakLabel;
    private TextField linkAfspraakInput;

    private Label mailsAanmakenBestemmingLabel;

    private TextField mailsAanmakenBestemmingInput;
    private Button kiesMailsAanmakenBestemmingKnop;
    private Button instellingenOpslaanKnop;
    private Tab tabAlgemeen;

    public InstellingenView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.gridPane = new GridPane();

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

        this.instellingenOpslaanKnop = new Button("Opslaan");

        this.tabAlgemeen = new Tab("Algemeen", this.gridPane);
        tabAlgemeen.setClosable(false);
        this.getTabs().add(tabAlgemeen);
    }

    private void layoutNodes() {
        this.docentAchternaamInput.setMinWidth(500);
        this.linkAfspraakInput.setMinWidth(500);

        this.gridPane.add(docentVoornaamLabel, 0, 0);
        this.gridPane.add(docentVoornaamInput, 1, 0);
        this.gridPane.add(docentAchternaamLabel, 0, 1);
        this.gridPane.add(docentAchternaamInput, 1, 1);
        this.gridPane.add(linkAfspraakLabel, 0, 2);
        this.gridPane.add(linkAfspraakInput, 1, 2);
        this.gridPane.add(instellingenOpslaanKnop, 0, 4);
        this.gridPane.add(mailsAanmakenBestemmingLabel, 0, 3);
        this.gridPane.add(mailsAanmakenBestemmingInput, 1, 3);
        this.gridPane.add(kiesMailsAanmakenBestemmingKnop, 2, 3);

        this.gridPane.setHgap(10);
        this.gridPane.setVgap(10);
        this.gridPane.setPadding(new Insets(20, 10, 10, 10));
    }

    GridPane getGridPane() {
        return gridPane;
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

    Tab getTabAlgemeen() {
        return tabAlgemeen;
    }

    TextField getMailsAanmakenBestemmingInput() {
        return this.mailsAanmakenBestemmingInput;
    }
    Button getKiesMailsAanmakenBestemmingKnop() {
        return this.kiesMailsAanmakenBestemmingKnop;
    }
}
