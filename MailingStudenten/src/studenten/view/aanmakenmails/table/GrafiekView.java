package studenten.view.aanmakenmails.table;

import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

import java.util.Arrays;

public class GrafiekView {
    private BarChart<String, Number> barplot;
    private CategoryAxis xAs = new CategoryAxis();
    private NumberAxis yAs = new NumberAxis();


    public GrafiekView() {
        initialiseNodes();
        layoutNodes();

    }

    public void initialiseNodes(){
        xAs.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Groen", "Geel", "Oranje", "Rood")));
        xAs.setLabel("Kleurcode");
        yAs.setLabel("Aantal studenten");
        yAs.setMinorTickVisible(false);
        yAs.setTickUnit(1);
        yAs.setAutoRanging(false);
        this.barplot = new BarChart<>(xAs, yAs);
        this.barplot.setTitle("Overzicht");
        this.barplot.setLegendVisible(false);
        this.barplot.setCategoryGap(200);
    }
    public void layoutNodes(){}

    public BarChart<String, Number> getBarplot() {
        return barplot;
    }

    CategoryAxis getxAs() {
        return xAs;
    }

    NumberAxis getyAs() {
        return yAs;
    }
}
