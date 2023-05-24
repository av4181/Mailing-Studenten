package studenten.view.uploadFile;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import studenten.model.CsvBestand;
import studenten.model.CsvLijn;
import studenten.view.aanmakenmails.table.UploadTablePresenter;
import studenten.view.main.MainPresenter;
import studenten.view.main.MainView;

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
        // We initialiseren de upload tabel met niets erin.
        new UploadTablePresenter(new ArrayList<>(), this.view.getTabel());
    }
    private void addEventHandlers() {
        this.view.getSelecteerBestandKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                // Selecteer bestand en toon naam in label, tonen zou in updateView() moeten
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Bestand");
                fileChooser.setInitialDirectory(new File("."));
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.csv"));
                setSelectedFile(fileChooser.showOpenDialog(null));
                view.getBestandNaam().setText(selectedFile.getName());
                file = new CsvBestand();
                file.setPad(selectedFile.getPath());
                view.getLeesCsvKnop().setDisable(false);
            }
        });

        this.view.getLeesCsvKnop().setOnAction(new EventHandler<ActionEvent>() {
            // Moet de UploadTableView oproepen en de gevulde tableview tonen.
            @Override
            public void handle(ActionEvent arg0) {
                file.leesBestand();
                List<CsvLijn> csvLijnen = file.getAlleResultaten();
                view.getTabel().setItems(FXCollections.observableArrayList(csvLijnen));
                view.getAcceptButton().setDisable(false);
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

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public void setFile(CsvBestand file) {
        this.file = file;
    }
}
