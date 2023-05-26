package be.kdg.mailingstudenten.model;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class Grafiek {
    private List<PeriodeResultaat> resultaten;
    private XYChart.Series<String,Number> series = new XYChart.Series<>();;
    private final String grafiekTitel = "Overzicht";
    private final String xAsLabel = "Periode resultaten";
    private final String yAsLabel = "Aantal studenten";

    public Grafiek() {
        this.resultaten = new ArrayList<>();
    }

    public void setgrafiekGegevens(List<PeriodeResultaat> resultaten) {
        int groen = 0;
        int geel = 0;
        int oranje = 0;
        int rood = 0;
        for (PeriodeResultaat periodeResultaat : resultaten){
            switch (periodeResultaat.bepaalKleurCode()){
                case GROEN :
                    groen+= 1;
                    break;
                case GEEL:
                    geel += 1;
                    break;
                case ORANJE:
                    oranje += 1;
                    break;
                case ROOD:
                    rood += 1;
            }
        }
        this.series.setName("test");
        this.series.getData().add(new XYChart.Data<>("Groen",groen));
        this.series.getData().add(new XYChart.Data<>("Geel",geel));
        this.series.getData().add(new XYChart.Data<>("Oranje",oranje));
        this.series.getData().add(new XYChart.Data<>("Rood",rood));
    }


    public XYChart.Series<String, Number> getSeries() {
        return series;
    }
}
