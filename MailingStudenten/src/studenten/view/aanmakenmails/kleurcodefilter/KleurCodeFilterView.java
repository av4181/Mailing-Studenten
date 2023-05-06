package studenten.view.aanmakenmails.kleurcodefilter;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class KleurCodeFilterView extends HBox {
    private Label kleurCodeFilterOptiesLabel;
    private ChoiceBox<String> kleurCodeFilterOpties;

    public KleurCodeFilterView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.kleurCodeFilterOptiesLabel = new Label("Status");
        this.kleurCodeFilterOpties = new ChoiceBox<>();
        this.kleurCodeFilterOpties.getItems().add("Groen");
        this.kleurCodeFilterOpties.getItems().add("Geel");
        this.kleurCodeFilterOpties.getItems().add("Oranje");
        this.kleurCodeFilterOpties.getItems().add("Rood");
        this.getChildren().addAll(kleurCodeFilterOptiesLabel, kleurCodeFilterOpties);
    }

    private void layoutNodes() {
        this.setSpacing(5);
    }

    Label getKleurCodeFilterOptiesLabel() {
        return kleurCodeFilterOptiesLabel;
    }

    ChoiceBox<String> getKleurCodeFilterOpties() {
        return kleurCodeFilterOpties;
    }
}