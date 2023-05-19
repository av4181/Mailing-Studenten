package studenten.view.instellingen.kleurcodes;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import studenten.model.BereikElement;

public class InstellingenKleurcodesView extends GridPane {
    private BereikElement bereikGroenElement;
    private HBox bereikGroenInputs;
    private BereikElement bereikGeelElement;
    private HBox bereikGeelInputs;
    private BereikElement bereikOranjeElement;
    private HBox bereikOranjeInputs;
    private BereikElement bereikRoodElement;
    private HBox bereikRoodInputs;
    private Button instellingenOpslaanKnop;

    public InstellingenKleurcodesView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.bereikGroenElement = new BereikElement("Bereik groen", 0, 0);
        this.bereikGroenInputs = new HBox();
        bereikGroenInputs.getChildren().addAll(new Label(">="), bereikGroenElement.getInputLaag(), bereikGroenElement.getInputHoog(), new Label("<="));

        this.bereikGeelElement = new BereikElement("Bereik geel", 1, 1);
        this.bereikGeelInputs = new HBox();
        bereikGeelInputs.getChildren().addAll(new Label(">="), bereikGeelElement.getInputLaag(), bereikGeelElement.getInputHoog(), new Label("<="));

        this.bereikOranjeElement = new BereikElement("Bereik oranje", 2);
        this.bereikOranjeInputs = new HBox();
        bereikOranjeInputs.getChildren().addAll(new Label(">="), bereikOranjeElement.getInputLaag(), bereikOranjeElement.getInputHoog(), new Label("<="));

        this.bereikRoodElement = new BereikElement("Bereik rood");
        this.bereikRoodInputs = new HBox();
        bereikRoodInputs.getChildren().addAll(new Label(">="), bereikRoodElement.getInputLaag());

        this.instellingenOpslaanKnop = new Button("Opslaan");
    }

    private void layoutNodes() {
        this.add(bereikGroenElement.getLabel(), 0, 0);
        this.add(bereikGroenInputs, 1, 0);

        this.add(bereikGeelElement.getLabel(), 0, 1);
        this.add(bereikGeelInputs, 1, 1);

        this.add(bereikOranjeElement.getLabel(), 0, 2);
        this.add(bereikOranjeInputs, 1, 2);

        this.add(bereikRoodElement.getLabel(), 0, 3);
        this.add(bereikRoodInputs, 1, 3);

        this.add(instellingenOpslaanKnop, 0, 4);

        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20, 10, 10, 10));
    }
    BereikElement getBereikGroenElement() {
        return bereikGroenElement;
    }

    BereikElement getBereikGeelElement() {
        return bereikGeelElement;
    }

    BereikElement getBereikOranjeElement() {
        return bereikOranjeElement;
    }

    BereikElement getBereikRoodElement() {
        return bereikRoodElement;
    }

    Button getInstellingenOpslaanKnop() {
        return instellingenOpslaanKnop;
    }
}
