package studenten.model;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class Grafiek {
    private List<PeriodeResultaat> resultaten;
    private XYChart.Series<String,Number> groen = new XYChart.Series<>();;
    private XYChart.Series<String,Number> geel = new XYChart.Series<>();;
    private XYChart.Series<String,Number> oranje = new XYChart.Series<>();;
    private XYChart.Series<String,Number> rood = new XYChart.Series<>();;
    private final String grafiekTitel = "Overzicht";
    private final String xAsLabel = "Periode resultaten";
    private final String yAsLabel = "Aantal studenten";

    public Grafiek() {
        this.resultaten = new ArrayList<>();
        setgrafiekGegevens(resultaten);
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
            this.groen.setName("Groen");
            this.groen.getData().add(new XYChart.Data<>("Groen",groen));
            this.geel.setName("Geel");
            this.geel.getData().add(new XYChart.Data<>("Geel",geel));
            this.oranje.setName("Oranje");
            this.oranje.getData().add(new XYChart.Data<>("Oranje",oranje));
            this.rood.setName("Rood");
            this.rood.getData().add(new XYChart.Data<>("Rood",rood));
        }

    }

    public List<PeriodeResultaat> getResultaten() {
        return resultaten;
    }

    public XYChart.Series<String, Number> getGroen() {
        return groen;
    }

    public XYChart.Series<String, Number> getGeel() {
        return geel;
    }

    public XYChart.Series<String, Number> getOranje() {
        return oranje;
    }

    public XYChart.Series<String, Number> getRood() {
        return rood;
    }

    public String getGrafiekTitel() {
        return grafiekTitel;
    }

    public String getxAsLabel() {
        return xAsLabel;
    }

    public String getyAsLabel() {
        return yAsLabel;
    }
}
