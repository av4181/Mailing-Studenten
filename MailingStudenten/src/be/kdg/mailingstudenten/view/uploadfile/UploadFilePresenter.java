package be.kdg.mailingstudenten.view.uploadfile;

import be.kdg.mailingstudenten.model.CsvLijn;
import be.kdg.mailingstudenten.model.CsvLijnen;
import be.kdg.mailingstudenten.view.main.MainPresenter;
import be.kdg.mailingstudenten.view.main.MainView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import be.kdg.mailingstudenten.model.CsvBestand;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UploadFilePresenter {
    private UploadFileView view;
    private File selectedFile;
    private CsvBestand file;

    public UploadFilePresenter(UploadFileView view) {
        this.view = view;

        updateView();
        addEventHandlers();
    }
    private void updateView() {
        new UploadTablePresenter(new CsvLijnen(new ArrayList<>()), this.view.getTabel());
    }
    private void addEventHandlers() {
        this.view.getSelecteerBestandKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open Bestand");
                    fileChooser.setInitialDirectory(new File("."));
                    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.csv"));
                    selectedFile = fileChooser.showOpenDialog(null);

                    if (selectedFile == null) {
                        return;
                    }
                    view.getBestandNaam().setText(selectedFile.getName());
                    file = new CsvBestand();
                    file.setPad(selectedFile.getPath());
                    view.getLeesCsvKnop().setDisable(false);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Bestand kiezen mislukt");
                    alert.setContentText("Neem contact op met KDG voor meer informatie.");
                    alert.showAndWait();
                }
            }
        });

        this.view.getLeesCsvKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    file.leesBestand();
                    List<CsvLijn> csvLijnen = file.getAlleResultaten();
                    view.getTabel().setItems(FXCollections.observableArrayList(csvLijnen));
                    view.getAcceptButton().setDisable(false);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Bestand uitlezen mislukt");
                    alert.setContentText("Het bestand kon niet worden uitgelezen. Neem contact op met KDG voor meer informatie.");
                    alert.showAndWait();
                }
            }
        });

        this.view.getChoiceBoxDelimiter().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try {
                    if (observableValue.getValue() == "Tab") {
                        file.setDelimiter("\t");
                    }
                    if (observableValue.getValue() == "Puntkomma") {
                        file.setDelimiter(";");
                    }
                } catch (IllegalArgumentException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Bestand uitlezen mislukt");
                    alert.setContentText("Er ging iets mis tijdens het kiezen van de delimiter. Neem contact op met KDG voor meer informatie.");
                    alert.showAndWait();
                }
            }
        });

        this.view.getAcceptButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainView mainView = new MainView();
                new MainPresenter(file, mainView);

                view.getScene().setRoot(mainView);
            }
        });
    }
}
