package studenten.view.aanmakenmails;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import studenten.view.aanmakenmails.table.*;
import studenten.view.aanmakenmails.table.UploadTableView;

public class AanmakenMailsView extends TabPane {
    private AanmakenMailsTableView table;
    private GrafiekView barPlot;
    private BorderPane actionsWrapper;
    private Label bevestigingsTekst;
    private Button aanmakenMailsKnop;
    private HBox aanmakenMailsKnopElement;
    private VBox vBox;
    private VBox grafiekVBox;
    private Tab aanmakenMailsTab;
    private Tab grafiekTab;
    private HBox kleurCodeFilter;
    private Label kleurCodeFilterOptiesLabel;
    private ChoiceBox<String> kleurCodeFilterOpties;

    public AanmakenMailsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.table = new AanmakenMailsTableView();
        this.barPlot = new GrafiekView();

        this.bevestigingsTekst = new Label();
        this.bevestigingsTekst.setStyle("-fx-text-fill: GREEN;");
        this.aanmakenMailsKnop = new Button("Aanmaken mails");
        this.aanmakenMailsKnopElement = new HBox();
        this.aanmakenMailsKnopElement.getChildren().addAll(this.bevestigingsTekst, this.aanmakenMailsKnop);

        this.actionsWrapper = new BorderPane();

        this.kleurCodeFilter = new HBox();
        this.kleurCodeFilterOptiesLabel = new Label("Status");
        this.kleurCodeFilterOpties = new ChoiceBox<>();
        this.kleurCodeFilterOpties.getItems().add("Alle");
        this.kleurCodeFilterOpties.getItems().add("Groen");
        this.kleurCodeFilterOpties.getItems().add("Geel");
        this.kleurCodeFilterOpties.getItems().add("Oranje");
        this.kleurCodeFilterOpties.getItems().add("Rood");
        this.kleurCodeFilterOpties.setValue("Alle");
        this.kleurCodeFilter.getChildren().addAll(kleurCodeFilterOptiesLabel, kleurCodeFilterOpties);

        this.vBox = new VBox();
        this.vBox.getChildren().addAll(this.kleurCodeFilter, table, actionsWrapper);

        this.grafiekVBox = new VBox(barPlot.getBarplot());

        this.aanmakenMailsTab = new Tab("Aanmaken mails", this.vBox);
        aanmakenMailsTab.setClosable(false);
        this.grafiekTab = new Tab("Grafiek", this.grafiekVBox);
        grafiekTab.setClosable(false);

        this.getTabs().addAll(aanmakenMailsTab, grafiekTab);
    }

    private void layoutNodes() {
        this.actionsWrapper.setRight(this.aanmakenMailsKnopElement);

        this.kleurCodeFilter.setSpacing(10);

        this.aanmakenMailsKnopElement.setSpacing(10);

        this.vBox.setSpacing(10);
        this.vBox.setPadding(new Insets(10, 10, 10, 10));
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

    VBox getvBox() {
        return vBox;
    }

    Tab getAanmakenMailsTab() {
        return aanmakenMailsTab;
    }

    Tab getGrafiekTab() {return grafiekTab;}

    Label getKleurCodeFilterOptiesLabel() {
        return kleurCodeFilterOptiesLabel;
    }

    ChoiceBox<String> getKleurCodeFilterOpties() {
        return kleurCodeFilterOpties;
    }

    GrafiekView getBarPlot() {
        return barPlot;
    }

    VBox getGrafiekVBox() {
        return grafiekVBox;
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
}
