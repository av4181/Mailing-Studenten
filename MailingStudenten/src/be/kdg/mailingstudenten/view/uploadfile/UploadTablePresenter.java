package be.kdg.mailingstudenten.view.uploadfile;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import be.kdg.mailingstudenten.model.CsvLijn;

import java.util.List;

public class UploadTablePresenter {

    private List<CsvLijn> model;
    private UploadTableView view;

    public UploadTablePresenter(List<CsvLijn> model, UploadTableView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        this.view.getEmailKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CsvLijn, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CsvLijn, String> csvLijnStringCellDataFeatures) {
                return new SimpleStringProperty(csvLijnStringCellDataFeatures.getValue().getStudent().getEmail());
            }
        });
        this.view.getVoornaamKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CsvLijn, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CsvLijn, String> csvLijnStringCellDataFeatures) {
                return new SimpleStringProperty(csvLijnStringCellDataFeatures.getValue().getStudent().getVoornaam());
            }
        });
        this.view.getNaamKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CsvLijn, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CsvLijn, String> csvLijnStringCellDataFeatures) {
                return new SimpleStringProperty(csvLijnStringCellDataFeatures.getValue().getStudent().getNaam());
            }
        });
        this.view.getRapportOnderdeelKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CsvLijn, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CsvLijn, String> csvLijnStringCellDataFeatures) {
                return new SimpleStringProperty(csvLijnStringCellDataFeatures.getValue().getResultaat().getRapportonderdeel());
            }
        });
        this.view.getDeelgroepCodeKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CsvLijn, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CsvLijn, String> csvLijnStringCellDataFeatures) {
                return new SimpleStringProperty(csvLijnStringCellDataFeatures.getValue().getResultaat().getDeelgroepCode());
            }
        });
        this.view.getExamenkansOmschrijvingKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CsvLijn, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CsvLijn, String> csvLijnStringCellDataFeatures) {
                return new SimpleStringProperty(csvLijnStringCellDataFeatures.getValue().getResultaat().getExamenkansomschrijving());
            }
        });
        this.view.getKansaandeelKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CsvLijn, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CsvLijn, String> csvLijnStringCellDataFeatures) {
                return new SimpleStringProperty(csvLijnStringCellDataFeatures.getValue().getResultaat().getKansaandeel());
            }
        });
        this.view.getPeriodeKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CsvLijn, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CsvLijn, String> csvLijnStringCellDataFeatures) {
                return new SimpleStringProperty(csvLijnStringCellDataFeatures.getValue().getResultaat().getPeriode());
            }
        });
        this.view.getPuntKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CsvLijn, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CsvLijn, String> csvLijnStringCellDataFeatures) {
                return new SimpleStringProperty(csvLijnStringCellDataFeatures.getValue().getResultaat().getPuntString());
            }
        });

        this.view.getItems().addAll(this.model);
    }

    private void addEventHandlers() {}
}
