package be.kdg.mailingstudenten.view.uploadfile;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;

public class UploadFileView extends VBox {
    private BorderPane actionsWrapper;
    private FileChooser fileChooser;
    private File gekozenBestand;
    private Button selecteerBestandKnop;
    private Button leesCsvKnop;
    private TextField bestandNaam;
    private ChoiceBox<String> choiceBoxDelimiter;
    private UploadTableView tabel;
    private Button acceptButton;
    private Text explanationText;

    private static final int VENSTER_BREEDTE = 500;
    private static final int VENSTER_HOOGTE = 300;

    public UploadFileView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.explanationText = new Text("Selecteer uw .csv bestand met de resultaten en de delimiter dat wordt gebruikt in dit bestand. Eens dat gedaan is, kan u de file opladen.");

        this.fileChooser = new FileChooser();
        this.actionsWrapper = new BorderPane();
        this.selecteerBestandKnop = new Button("Selecteer .csv bestand");
        this.leesCsvKnop = new Button("Opladen");
        this.leesCsvKnop.setDisable(true);
        this.bestandNaam = new TextField();

        this.choiceBoxDelimiter = new ChoiceBox<>();
        this.choiceBoxDelimiter.getItems().add("Tab");
        this.choiceBoxDelimiter.getItems().add("Puntkomma");
        this.choiceBoxDelimiter.getItems().add("Spatie");
        this.choiceBoxDelimiter.setValue("Puntkomma");
        this.bestandNaam.setDisable(true);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(this.selecteerBestandKnop, this.bestandNaam, this.choiceBoxDelimiter, this.leesCsvKnop);
        hbox.setSpacing(10);
        this.tabel = new UploadTableView();
        this.acceptButton = new Button("Doorgaan");
        this.acceptButton.setDisable(true);

        this.getChildren().addAll(
                this.explanationText,
                hbox,
                tabel,
                acceptButton
        );
    }

    private void layoutNodes() {
        //Maak knoppen even breed
        this.selecteerBestandKnop.setMaxWidth(VENSTER_BREEDTE / 2);
        this.bestandNaam.setMaxWidth(VENSTER_BREEDTE / 2);
        this.bestandNaam.setPrefWidth(300);
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

    TextField getBestandNaam() {
        return bestandNaam;
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

    UploadTableView getTabel() {
        return tabel;
    }

    Text getExplanationText() {
        return explanationText;
    }
}