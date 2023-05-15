package studenten.view.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

import java.io.File;

public class UploadFilePresenter {
    private UploadFileView view;

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
                File selectedFile = fileChooser.showOpenDialog(null);
                view.getBestandNaamLabel().setText(selectedFile.getName());
            }
        });

        this.view.getLeesCsvKnop().setOnAction(new EventHandler<ActionEvent>() {
            // Moet de UploadTableView oproepen en de gevulde tableview tonen.
            @Override
            public void handle(ActionEvent arg0) {
                // TO DO
            }
        });
    }

}
