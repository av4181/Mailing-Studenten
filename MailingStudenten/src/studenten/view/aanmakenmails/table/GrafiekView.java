package studenten.view.aanmakenmails.table;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import studenten.model.PeriodeResultaat;

import java.util.List;

public class GrafiekView {
    private BarChart<String, Number> grafiek;
    private final String grafiekTitel = "Periode Resultaten";
    private CategoryAxis xAs;
    private NumberAxis yAs;
    private final String xLabel = "Perioderesultaat";
    private final String yLabel = "Aantal studenten";
    private XYChart.Series<String,Number> grafiekData;
    private List<PeriodeResultaat> gegevens;
    private int groen =0;
    private int geel =0;
    private int oranje =0;
    private int rood =0;


    public GrafiekView() {
        initialiseNodes();
    }
    private void initialiseNodes(){
        this.grafiek = new BarChart<>(xAs,yAs);
        this.grafiekData = new XYChart.Series<>();
        this.xAs = new CategoryAxis();
        this.yAs = new NumberAxis();
        xAs.setLabel(xLabel);
        yAs.setLabel(yLabel);
    }

    public void setGrafiekData(){

    }

    public XYChart.Series<String, Number> getGrafiekData() {
        return grafiekData;
    }
}
