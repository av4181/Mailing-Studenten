package studenten.view.main;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import studenten.view.aanmakenmails.table.AanmakenMailsTableView;
import studenten.view.aanmakenmails.table.GrafiekView;
import studenten.view.aanmakenmails.table.UploadTableView;

import java.io.File;

public class UploadFileView {
    private BorderPane actionsWrapper;
    private FileChooser fileChooser;
    private File gekozenBestand;
    private Button selecteerBestandKnop;
    private Button leesCsvKnop;
    private Label bestandNaamLabel;
    private ChoiceBox choiceBoxDelimiter;
    private TableView tabel;

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
        //Maak knoppen even breed
        this.selecteerBestandKnop.setMaxWidth(VENSTER_BREEDTE / 2);
        this.bestandNaamLabel.setMaxWidth(VENSTER_BREEDTE / 2);
        this.choiceBoxDelimiter.setMaxWidth(VENSTER_BREEDTE / 2);

        VBox buttonBox = new VBox();
        buttonBox.setPadding(new Insets(10, 10, 10, 10));  //Sets the space around the buttonBox.
        buttonBox.setSpacing(10);  //Sets the vertical space in pixels between buttons within the box.

        buttonBox.getChildren().addAll(
                selecteerBestandKnop,
                bestandNaamLabel,
                choiceBoxDelimiter,
                leesCsvKnop,
                tabel
        );
    }

    private void layoutNodes() {

    }

    public BorderPane getActionsWrapper() {
        return actionsWrapper;
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public Button getSelecteerBestandKnop() {
        return selecteerBestandKnop;
    }

    public Button getLeesCsvKnop() {
        return leesCsvKnop;
    }

    public Label getBestandNaamLabel() {
        return bestandNaamLabel;
    }

    public ChoiceBox getChoiceBoxDelimiter() {
        return choiceBoxDelimiter;
    }

    public File getGekozenBestand() {
        return gekozenBestand;
    }
}