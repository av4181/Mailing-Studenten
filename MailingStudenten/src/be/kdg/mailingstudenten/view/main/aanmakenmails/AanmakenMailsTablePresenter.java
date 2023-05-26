package be.kdg.mailingstudenten.view.main.aanmakenmails;

import be.kdg.mailingstudenten.model.PeriodeResultaat;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Callback;
import be.kdg.mailingstudenten.model.PeriodeResultaten;

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
                    return -1;
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
                    rect.setId(String.valueOf(PeriodeResultaat.KleurCode.GROEN.ordinal()));
                } else if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.GEEL) {
                    rect.setFill(Color.YELLOW);
                    rect.setId(String.valueOf(PeriodeResultaat.KleurCode.GEEL.ordinal()));
                } else if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.ORANJE) {
                    rect.setFill(Color.ORANGE);
                    rect.setId(String.valueOf(PeriodeResultaat.KleurCode.ORANJE.ordinal()));
                } else if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.ROOD) {
                    rect.setFill(Color.RED);
                    rect.setId(String.valueOf(PeriodeResultaat.KleurCode.ROOD.ordinal()));
                }
                return new SimpleObjectProperty<>(rect);
            }
        });
        this.view.getKleurCodeKolom().setComparator(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int shape1Id = Integer.parseInt(o1.getId());
                int shape2Id = Integer.parseInt(o2.getId());

                if (shape1Id == shape2Id) {
                    return 0;
                }
                if (shape1Id < shape2Id) {
                    return -1;
                }
                return 1;
            }
        });

        this.view.getItems().addAll(this.model.getPeriodeResultaten());
    }
}
