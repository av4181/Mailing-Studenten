package studenten.view.aanmakenmails.table;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import studenten.model.CsvBestand;
import studenten.model.CsvLijn;
import studenten.model.PeriodeResultaat;
import studenten.model.Student;

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
        this.view.getEmailklm().setCellValueFactory(csvLijn -> new SimpleStringProperty(csvLijn.getValue().getStudent().getEmail()));
        this.view.getVoornaamklm().setCellValueFactory(csvLijn -> new SimpleStringProperty(csvLijn.getValue().getStudent().getVoornaam()));
        this.view.getNaamklm().setCellValueFactory(csvLijn -> new SimpleStringProperty(csvLijn.getValue().getStudent().getNaam()));
        this.view.getRapportonderdeelklm().setCellValueFactory(csvLijn -> new SimpleStringProperty(csvLijn.getValue().getResultaat().getRapportonderdeel()));
        this.view.getDeelgroepCodeklm().setCellValueFactory(csvLijn -> new SimpleStringProperty(csvLijn.getValue().getResultaat().getDeelgroepCode()));
//        this.view.getPuntklm().setCellValueFactory(csvLijn -> new SimpleStringProperty(csvLijn.getValue().getResultaat().getPunt()));
        this.view.getExamenkansomschrijvingklm().setCellValueFactory(csvLijn -> new SimpleStringProperty(csvLijn.getValue().getResultaat().getExamenkansomschrijving()));
        this.view.getKansaandeelklm().setCellValueFactory(csvLijn -> new SimpleStringProperty(csvLijn.getValue().getResultaat().getKansaandeel()));
        this.view.getPeriodeklm().setCellValueFactory(csvLijn -> new SimpleStringProperty(csvLijn.getValue().getResultaat().getPeriode()));

        this.view.getItems().addAll(this.model);
    }

    private void addEventHandlers() {
        // todo: Save event handler here.
    }
}
