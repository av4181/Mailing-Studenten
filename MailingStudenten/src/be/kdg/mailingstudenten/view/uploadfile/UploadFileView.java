package be.kdg.mailingstudenten.view.uploadfile;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class UploadFileView extends VBox {
    private Button selecteerBestandKnop;
    private Button leesCsvKnop;
    private TextField bestandNaam;
    private ChoiceBox<String> choiceBoxDelimiter;
    private UploadTableView tabel;
    private Button acceptButton;
    private Text explanationText;

    private HBox select;

    private static final int VENSTER_BREEDTE = 500;

    public UploadFileView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.explanationText = new Text("Selecteer uw .csv bestand met de resultaten en de delimiter dat wordt gebruikt in dit bestand. Eens dat gedaan is, kan u de file opladen.");

        this.selecteerBestandKnop = new Button("Selecteer .csv bestand");
        this.bestandNaam = new TextField();
        this.bestandNaam.setDisable(true);

        this.choiceBoxDelimiter = new ChoiceBox<>();
        this.choiceBoxDelimiter.getItems().add("Tab");
        this.choiceBoxDelimiter.getItems().add("Puntkomma");
        this.choiceBoxDelimiter.setValue("Puntkomma");

        this.leesCsvKnop = new Button("Opladen");
        this.leesCsvKnop.setDisable(true);

        this.select = new HBox();
        this.select.getChildren().addAll(this.selecteerBestandKnop, this.bestandNaam, this.choiceBoxDelimiter, this.leesCsvKnop);

        this.tabel = new UploadTableView();

        this.acceptButton = new Button("Doorgaan");
        this.acceptButton.setDisable(true);

        this.getChildren().addAll(
            this.explanationText,
            this.select,
            this.tabel,
            this.acceptButton
        );
    }

    private void layoutNodes() {
        // Maak knoppen even breed
        this.selecteerBestandKnop.setMaxWidth(VENSTER_BREEDTE / 2);
        this.bestandNaam.setMaxWidth(VENSTER_BREEDTE / 2);
        this.choiceBoxDelimiter.setMaxWidth(VENSTER_BREEDTE / 2);
        this.select.setSpacing(10);

        this.bestandNaam.setPrefWidth(300);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(10);
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

    Button getAcceptButton() {
        return acceptButton;
    }

    UploadTableView getTabel() {
        return tabel;
    }

    Text getExplanationText() {
        return explanationText;
    }

    HBox getSelect() {
        return select;
    }
}