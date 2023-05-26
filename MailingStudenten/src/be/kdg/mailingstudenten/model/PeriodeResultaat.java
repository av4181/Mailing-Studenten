package be.kdg.mailingstudenten.model;

import java.util.List;

public class PeriodeResultaat {
    public enum KleurCode {
        GROEN, GEEL, ORANJE, ROOD, GRIJS
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

    public KleurCode bepaalKleurCode() {
        InstellingenKleurcodes instellingen = new InstellingenKleurcodes();
        List<Resultaat> nietGeslaagdeResultaten = this.getNietGeslaagdeResultaten();

        instellingen.getBereikGroen().isInBereik(nietGeslaagdeResultaten.size());

        if (nietGeslaagdeResultaten.size() == this.resultaten.size()) {
            return KleurCode.ROOD;
        } else if (instellingen.getBereikOranje().isInBereik(nietGeslaagdeResultaten.size())) {
            return KleurCode.ORANJE;
        } else if (instellingen.getBereikGeel().isInBereik(nietGeslaagdeResultaten.size())) {
            return KleurCode.GEEL;
        } if (instellingen.getBereikGroen().isInBereik(nietGeslaagdeResultaten.size())) {
            return KleurCode.GROEN;
        } else {
            return KleurCode.GRIJS;
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
