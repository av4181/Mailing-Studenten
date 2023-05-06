package studenten.model;

import java.util.List;

public class PeriodeResultaat {
    public enum KleurCode {
        GROEN, GEEL, ORANJE, ROOD
    }

    private Student student;
    private String periode;
    private List<Resultaat> resultaten;

    public PeriodeResultaat(Student student, String periode, List<Resultaat> resultaten) {
        this.student = student;
        this.periode = periode;
        this.resultaten = resultaten;
    }

    public Student getStudent() {
        return student;
    }

    public String getPeriode() {
        return periode;
    }

    public List<Resultaat> getResultaten() {
        return resultaten;
    }

    public KleurCode bepaalKleurCode() {
        List<Resultaat> nietGeslaagdeResultaten = this.getNietGeslaagdeResultaten();
        if (nietGeslaagdeResultaten.size() == this.resultaten.size()) {
            return KleurCode.ROOD;
        } else if (nietGeslaagdeResultaten.size() > 1) {
            return KleurCode.ORANJE;
        } else if (nietGeslaagdeResultaten.size() == 1) {
            return KleurCode.GEEL;
        } else {
            return KleurCode.GROEN;
        }
    }

    public double berekenGemiddelde() {
        double totaal = 0.00;
        for (Resultaat resultaat: this.resultaten) {
            totaal += resultaat.getPunt();
        }

        return totaal / this.resultaten.size();
    }

    public List<Resultaat> getNietGeslaagdeResultaten() {
        return this.resultaten.stream().filter(resultaat -> !resultaat.isGeslaagd()).toList();
    }
}
