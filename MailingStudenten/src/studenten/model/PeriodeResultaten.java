package studenten.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.List;
import java.util.function.Predicate;

public class PeriodeResultaten {
    private ObservableList<PeriodeResultaat> periodeResultaten;

    public PeriodeResultaten(List<PeriodeResultaat> periodeResultaten) {
        this.periodeResultaten = FXCollections.observableArrayList(periodeResultaten);
    }

    public FilteredList<PeriodeResultaat> getGroeneResultaten() {
        return periodeResultaten.filtered(new Predicate<PeriodeResultaat>() {
            @Override
            public boolean test(PeriodeResultaat periodeResultaat) {
                return periodeResultaat.bepaalKleurCode() == PeriodeResultaat.KleurCode.GROEN;
            }
        });
    }

    public FilteredList<PeriodeResultaat> getGeleResultaten() {
        return periodeResultaten.filtered(new Predicate<PeriodeResultaat>() {
            @Override
            public boolean test(PeriodeResultaat periodeResultaat) {
                return periodeResultaat.bepaalKleurCode() == PeriodeResultaat.KleurCode.GEEL;
            }
        });
    }

    public FilteredList<PeriodeResultaat> getOranjeResultaten() {
        return periodeResultaten.filtered(new Predicate<PeriodeResultaat>() {
            @Override
            public boolean test(PeriodeResultaat periodeResultaat) {
                return periodeResultaat.bepaalKleurCode() == PeriodeResultaat.KleurCode.ORANJE;
            }
        });
    }

    public FilteredList<PeriodeResultaat> getRodeResultaten() {
        return periodeResultaten.filtered(new Predicate<PeriodeResultaat>() {
            @Override
            public boolean test(PeriodeResultaat periodeResultaat) {
                return periodeResultaat.bepaalKleurCode() == PeriodeResultaat.KleurCode.ROOD;
            }
        });
    }
}
