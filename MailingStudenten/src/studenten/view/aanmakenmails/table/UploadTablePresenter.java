package studenten.view.aanmakenmails.table;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import studenten.model.CsvBestand;
import studenten.model.PeriodeResultaat;
import studenten.model.Student;

import java.util.List;

public class UploadTablePresenter {

    private CsvBestand model;
    private UploadTableView view;

    public UploadTablePresenter(List<Student> model, UploadTableView view) {
        this.model = (CsvBestand) model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
//        this.view.getEmailklm().setCellValueFactory(csv -> new SimpleStringProperty(csv.);
        // todo: hier zit ik in de problemen


//        this.view.getItems().addAll(this.model);
    }

    private void addEventHandlers() {
        // todo: Save event handler here.
    }
}
