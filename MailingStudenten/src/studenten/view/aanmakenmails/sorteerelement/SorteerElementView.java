package studenten.view.aanmakenmails.sorteerelement;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SorteerElementView extends HBox {
    private Label sorteerOptiesLabel;
    private ChoiceBox<String> sorteerOpties;

    public SorteerElementView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.sorteerOptiesLabel = new Label("Sorteren op");
        this.sorteerOpties = new ChoiceBox<String>();
        this.sorteerOpties.getItems().add("Alfabet");
        this.sorteerOpties.getItems().add("Gemiddelde");
        this.getChildren().addAll(sorteerOptiesLabel, sorteerOpties);
    }

    private void layoutNodes() {
        this.setSpacing(5);
    }

    Label getSorteerOptiesLabel() {
        return sorteerOptiesLabel;
    }

    ChoiceBox<String> getSorteerOpties() {
        return sorteerOpties;
    }
}