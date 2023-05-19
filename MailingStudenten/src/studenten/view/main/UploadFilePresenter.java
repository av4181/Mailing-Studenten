package studenten.view.main;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import studenten.model.CsvBestand;
import studenten.model.CsvLijn;
import studenten.model.PeriodeResultaat;
import studenten.view.aanmakenmails.table.AanmakenMailsTablePresenter;
import studenten.view.aanmakenmails.table.UploadTablePresenter;
import studenten.view.aanmakenmails.table.UploadTableView;

import java.io.File;
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
                selectedFile = fileChooser.showOpenDialog(null);
                view.getBestandNaamLabel().setText(selectedFile.getName());
                file = new CsvBestand();
                file.setPad(selectedFile.getName());
            }
        });

        this.view.getLeesCsvKnop().setOnAction(new EventHandler<ActionEvent>() {
            // Moet de UploadTableView oproepen en de gevulde tableview tonen.
            @Override
            public void handle(ActionEvent arg0) {
                file.leesBestand();
                List<CsvLijn> csvLijnen = file.getAlleResultaten();
                UploadTableView tabel = new UploadTableView();
                UploadTablePresenter tabelPresenter = new UploadTablePresenter(csvLijnen, tabel);
                view.getTabel().setItems(tabel.getColumns());
            }
        });
        this.view.getAcceptButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainView mainView = new MainView();
                new MainPresenter(mainView);

                view.getScene().setRoot(mainView);
            }
        });
    }

}
