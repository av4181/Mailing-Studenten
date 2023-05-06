package studenten.view.aanmakenmails.table;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import studenten.model.PeriodeResultaat;

import java.util.List;

public class AanmakenMailsTablePresenter {
    private List<PeriodeResultaat> model;
    private AanmakenMailsTableView view;

    public AanmakenMailsTablePresenter(List<PeriodeResultaat> model, AanmakenMailsTableView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        this.view.getAchternaamKolom().setCellValueFactory(periodeResultaat -> new SimpleStringProperty(periodeResultaat.getValue().getStudent().getNaam()));
        this.view.getVoornaamKolom().setCellValueFactory(periodeResultaat -> new SimpleStringProperty(periodeResultaat.getValue().getStudent().getVoornaam()));
        this.view.getEmailKolom().setCellValueFactory(periodeResultaat -> new SimpleStringProperty(periodeResultaat.getValue().getStudent().getEmail()));
        this.view.getPuntKolom().setCellValueFactory(periodeResultaat -> new SimpleStringProperty(String.format("%.2f", periodeResultaat.getValue().berekenGemiddelde())));
        this.view.getPeriodeKolom().setCellValueFactory(periodeResultaat -> new SimpleStringProperty(periodeResultaat.getValue().getPeriode()));
        this.view.getKleurCodeKolom().setCellValueFactory(periodeResultaatShapeCellDataFeatures -> {
            Rectangle rect = new Rectangle(30, 10, 10, 10);
            if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.GROEN) {
                rect.setFill(Color.GREEN);
            } else if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.GEEL) {
                rect.setFill(Color.YELLOW);
            } else if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.ORANJE) {
                rect.setFill(Color.ORANGE);
            } else if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.ROOD) {
                rect.setFill(Color.RED);
            }
            return new SimpleObjectProperty<>(rect);
        });

        this.view.getItems().addAll(this.model);
    }

    private void addEventHandlers() {
        // todo: Save event handler here.
    }
}
