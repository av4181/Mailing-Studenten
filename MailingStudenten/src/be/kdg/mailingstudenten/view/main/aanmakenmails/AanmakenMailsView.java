package be.kdg.mailingstudenten.view.main.aanmakenmails;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AanmakenMailsView extends VBox {
    private AanmakenMailsTableView table;
    private BorderPane actionsWrapper;
    private Label bevestigingsTekst;
    private Button aanmakenMailsKnop;
    private HBox aanmakenMailsKnopElement;
    private HBox kleurCodeFilter;
    private Label kleurCodeFilterOptiesLabel;
    private ChoiceBox<String> kleurCodeFilterOpties;
    private Button refreshKnop;

    public AanmakenMailsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.kleurCodeFilter = new HBox();
        this.kleurCodeFilterOptiesLabel = new Label("Status");
        this.kleurCodeFilterOpties = new ChoiceBox<>();
        this.kleurCodeFilterOpties.getItems().add("Alle");
        this.kleurCodeFilterOpties.getItems().add("Groen");
        this.kleurCodeFilterOpties.getItems().add("Geel");
        this.kleurCodeFilterOpties.getItems().add("Oranje");
        this.kleurCodeFilterOpties.getItems().add("Rood");
        this.kleurCodeFilterOpties.setValue("Alle");

        this.refreshKnop = new Button("Refresh");

        this.kleurCodeFilter.getChildren().addAll(kleurCodeFilterOptiesLabel, kleurCodeFilterOpties, refreshKnop);

        this.table = new AanmakenMailsTableView();

        this.bevestigingsTekst = new Label();
        this.bevestigingsTekst.setStyle("-fx-text-fill: GREEN;");
        this.aanmakenMailsKnop = new Button("Aanmaken mails");
        this.aanmakenMailsKnopElement = new HBox();
        this.aanmakenMailsKnopElement.getChildren().addAll(this.bevestigingsTekst, this.aanmakenMailsKnop);
        this.actionsWrapper = new BorderPane();

        this.getChildren().addAll(this.kleurCodeFilter, table, actionsWrapper);
    }

    private void layoutNodes() {
        this.actionsWrapper.setRight(this.aanmakenMailsKnopElement);

        this.kleurCodeFilter.setSpacing(10);

        this.aanmakenMailsKnopElement.setSpacing(10);

        this.setSpacing(10);
        this.setPadding(new Insets(10, 10, 10, 10));
    }

    AanmakenMailsTableView getTable() {
        return table;
    }

    Button getAanmakenMailsKnop() {
        return aanmakenMailsKnop;
    }

    BorderPane getActionsWrapper() {
        return actionsWrapper;
    }

    Label getKleurCodeFilterOptiesLabel() {
        return kleurCodeFilterOptiesLabel;
    }

    ChoiceBox<String> getKleurCodeFilterOpties() {
        return kleurCodeFilterOpties;
    }

    HBox getKleurCodeFilter() {
        return kleurCodeFilter;
    }

    Label getBevestigingsTekst() {
        return bevestigingsTekst;
    }

    HBox getAanmakenMailsKnopElement() {
        return aanmakenMailsKnopElement;
    }

    Button getRefreshKnop() {
        return refreshKnop;
    }
}
