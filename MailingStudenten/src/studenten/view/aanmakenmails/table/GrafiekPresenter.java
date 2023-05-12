package studenten.view.aanmakenmails.table;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import studenten.model.Grafiek;
import studenten.model.PeriodeResultaat;

import java.util.List;

public class GrafiekPresenter {
    private GrafiekView view;
    private Grafiek model;

    public GrafiekPresenter(GrafiekView view, Grafiek model) {
        this.view = view;
        this.model = model;

        updateView();
    }
    private void updateView(){
        this.view.getBarplot().getData().addAll(this.model.getGroen(),this.model.getGeel(),this.model.getOranje(),this.model.getRood());

    }

    public void setView(GrafiekView view) {
        this.view = view;
    }

    public void setModel(Grafiek model) {
        this.model = model;
    }
}
