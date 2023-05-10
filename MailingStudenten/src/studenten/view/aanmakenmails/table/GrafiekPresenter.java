package studenten.view.aanmakenmails.table;

import javafx.scene.chart.XYChart;
import studenten.model.PeriodeResultaat;

import java.util.List;

public class GrafiekPresenter {
    private List<PeriodeResultaat> model;
    private GrafiekView view;
    private int groen =0;
    private int geel =0;
    private int oranje =0;
    private int rood =0;
    private XYChart.Series<String,Number> grafiekData;

    public GrafiekPresenter(List<PeriodeResultaat> model, GrafiekView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }
    private void updateView() {
        for (PeriodeResultaat periodeResultaat : model){
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
            grafiekData.getData().add(new XYChart.Data("Groen",groen));
            grafiekData.getData().add(new XYChart.Data("Geel",geel));
            grafiekData.getData().add(new XYChart.Data("Oranje",oranje));
            grafiekData.getData().add(new XYChart.Data("Rood",rood));
        }
        view.getData().add(grafiekData);
    }
    private void addEventHandlers() {
        // todo: Save event handler here.
    }
}
