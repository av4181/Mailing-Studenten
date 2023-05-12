package studenten.view.aanmakenmails.table;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import studenten.model.Grafiek;
import studenten.model.PeriodeResultaat;

import java.util.Arrays;
import java.util.List;

public class GrafiekView{
    private BarChart<String, Number> barplot;
    private CategoryAxis xAs = new CategoryAxis();
    private NumberAxis yAs = new NumberAxis();


    public GrafiekView() {
        initialiseNodes();
        layoutNodes();

    }

    public void initialiseNodes(){
        xAs.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
                "Groen", "Geel", "Oranje", "Rood")));
        xAs.setLabel("Kleur");
        yAs.setLabel("Aantal studenten");
        this.barplot = new BarChart<>(xAs, yAs);
        this.barplot.setTitle("Overzicht");
    }
    public void layoutNodes(){

    }

    public BarChart<String, Number> getBarplot() {
        return barplot;
    }

    public CategoryAxis getxAs() {
        return xAs;
    }

    public NumberAxis getyAs() {
        return yAs;
    }
}
