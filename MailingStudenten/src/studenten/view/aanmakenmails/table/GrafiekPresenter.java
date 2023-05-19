package studenten.view.aanmakenmails.table;

import javafx.scene.chart.XYChart;
import studenten.model.Grafiek;

import java.util.List;

public class GrafiekPresenter {
    private Grafiek model;
    private GrafiekView view;

    public GrafiekPresenter(Grafiek model, GrafiekView view) {
        this.model = model;
        this.view = view;

        updateView();
    }
    private void updateView(){
        List<XYChart.Data<String, Number>> test = this.model.getSeries().getData();

        double maxValue = 0;
        for (XYChart.Data<String, Number> item : test) {
            if ((int) item.getYValue() > maxValue) {
                maxValue = (int) item.getYValue();
            }
        }

        maxValue = Math.ceil(maxValue / 10) * 10;

        this.view.getyAs().setUpperBound(maxValue);

        this.view.getBarplot().getData().addAll(this.model.getSeries());
    }
}
