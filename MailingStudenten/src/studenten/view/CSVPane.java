package studenten.view;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CSVPane extends VBox {
    private RadioButton normal;
    private RadioButton blackAndWhite;
    private RadioButton sepia;

    public CSVPane() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.setPadding(new Insets(15.0, 15.0, 15.0, 15.0));
        this.setSpacing(15.0);

        final ToggleGroup group = new ToggleGroup();

        this.normal = new RadioButton("Normal");
        this.normal.setToggleGroup(group);
        this.normal.setSelected(true);

        this.blackAndWhite = new RadioButton("Black & White");
        this.blackAndWhite.setToggleGroup(group);

        this.sepia = new RadioButton("Sepia");
        this.sepia.setToggleGroup(group);
    }

    private void layoutNodes() {
        this.getChildren().add(this.normal);
        this.getChildren().add(this.blackAndWhite);
        this.getChildren().add(this.sepia);
    }

    RadioButton getNormal() {
        return normal;
    }

    RadioButton getBlackAndWhite() {
        return blackAndWhite;
    }

    RadioButton getSepia() {
        return sepia;
    }

}

