package studenten.view.main;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;

public class UploadFileView extends VBox {
    private BorderPane actionsWrapper;
    private FileChooser fileChooser;
    private File gekozenBestand;
    private Button selecteerBestandKnop;
    private Button leesCsvKnop;
    private Label bestandNaamLabel;
    private ChoiceBox choiceBoxDelimiter;
    private TableView tabel;
    private Button acceptButton;

    private static final int VENSTER_BREEDTE = 500;
    private static final int VENSTER_HOOGTE = 300;

    public UploadFileView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.fileChooser = new FileChooser();
        this.actionsWrapper = new BorderPane();
        this.selecteerBestandKnop = new Button("selecteer .csv bestand");
        this.leesCsvKnop = new Button("Lees .csv bestand");
        this.bestandNaamLabel = new Label();
        this.choiceBoxDelimiter = new ChoiceBox(FXCollections.observableArrayList(
                "Delimiter: Tab", "Delimiter: Komma", "Delimiter: Spatie")
        );
        this.tabel = new TableView<>();
        this.acceptButton = new Button("Accepteer");

        this.getChildren().addAll(
                selecteerBestandKnop,
                bestandNaamLabel,
                choiceBoxDelimiter,
                leesCsvKnop,
                tabel,
                acceptButton
        );
    }

    private void layoutNodes() {
        //Maak knoppen even breed
        this.selecteerBestandKnop.setMaxWidth(VENSTER_BREEDTE / 2);
        this.bestandNaamLabel.setMaxWidth(VENSTER_BREEDTE / 2);
        this.choiceBoxDelimiter.setMaxWidth(VENSTER_BREEDTE / 2);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(10);
    }

    BorderPane getActionsWrapper() {
        return actionsWrapper;
    }

    FileChooser getFileChooser() {
        return fileChooser;
    }

    Button getSelecteerBestandKnop() {
        return selecteerBestandKnop;
    }

    Button getLeesCsvKnop() {
        return leesCsvKnop;
    }

    Label getBestandNaamLabel() {
        return bestandNaamLabel;
    }

    ChoiceBox getChoiceBoxDelimiter() {
        return choiceBoxDelimiter;
    }

    File getGekozenBestand() {
        return gekozenBestand;
    }
    Button getAcceptButton() {
        return acceptButton;
    }
}