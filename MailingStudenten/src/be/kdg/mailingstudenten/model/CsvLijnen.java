package be.kdg.mailingstudenten.model;

import java.util.List;

public class CsvLijnen {
    private List<CsvLijn> csvLijnen;

    public CsvLijnen(List<CsvLijn> csvLijnen) {
        this.csvLijnen = csvLijnen;
    }

    public List<CsvLijn> getCsvLijnen() {
        return this.csvLijnen;
    }
}
