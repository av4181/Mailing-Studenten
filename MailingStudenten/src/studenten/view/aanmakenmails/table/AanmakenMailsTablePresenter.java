package studenten.view.aanmakenmails.table;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Callback;
import studenten.model.PeriodeResultaat;
import studenten.model.PeriodeResultaten;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Locale;

public class AanmakenMailsTablePresenter {
    private PeriodeResultaten model;
    private AanmakenMailsTableView view;

    public AanmakenMailsTablePresenter(PeriodeResultaten model, AanmakenMailsTableView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        this.view.getAchternaamKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PeriodeResultaat, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PeriodeResultaat, String> periodeResultaatStringCellDataFeatures) {
                return new SimpleStringProperty(periodeResultaatStringCellDataFeatures.getValue().getStudent().getNaam());
            }
        });
        this.view.getVoornaamKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PeriodeResultaat, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PeriodeResultaat, String> periodeResultaatStringCellDataFeatures) {
                return new SimpleStringProperty(periodeResultaatStringCellDataFeatures.getValue().getStudent().getVoornaam());
            }
        });
        this.view.getEmailKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PeriodeResultaat, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PeriodeResultaat, String> periodeResultaatStringCellDataFeatures) {
                return new SimpleStringProperty(periodeResultaatStringCellDataFeatures.getValue().getStudent().getEmail());
            }
        });
        this.view.getPuntKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PeriodeResultaat, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PeriodeResultaat, String> periodeResultaatStringCellDataFeatures) {
                return new SimpleStringProperty(String.format("%.2f", periodeResultaatStringCellDataFeatures.getValue().berekenGemiddelde()));
            }
        });
        this.view.getPuntKolom().setComparator(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);

                    double number1 = numberFormat.parse(o1).doubleValue();
                    double number2 = numberFormat.parse(o2).doubleValue();

                    if (number1 == number2) {
                        return 0;
                    }
                    if (number1 < number2) {
                        return -1;
                    }
                    return 1;
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.view.getPeriodeKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PeriodeResultaat, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PeriodeResultaat, String> periodeResultaatStringCellDataFeatures) {
                return new SimpleStringProperty(periodeResultaatStringCellDataFeatures.getValue().getPeriode());
            }
        });
        this.view.getKleurCodeKolom().setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PeriodeResultaat, Shape>, ObservableValue<Shape>>() {
            @Override
            public ObservableValue<Shape> call(TableColumn.CellDataFeatures<PeriodeResultaat, Shape> periodeResultaatShapeCellDataFeatures) {
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
            }
        });

        this.view.getItems().addAll(this.model.getPeriodeResultaten());
    }

    private void addEventHandlers() {}
}
