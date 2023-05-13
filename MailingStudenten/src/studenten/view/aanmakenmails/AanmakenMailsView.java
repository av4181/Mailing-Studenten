package studenten.view.aanmakenmails;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import studenten.model.*;
import studenten.view.aanmakenmails.table.*;
import studenten.view.aanmakenmails.table.UploadTablePresenter;
import studenten.view.aanmakenmails.table.UploadTableView;

import java.util.ArrayList;
import java.util.List;

public class AanmakenMailsView extends TabPane {
    private BorderPane filterAndSorteerWrapper;
    private AanmakenMailsTableView table;

    // Toevoegen extra tab om resultaat upload te laten zien
    private UploadTableView table2;

    // Toevoegen extra tab om grafiek te laten zien
    private GrafiekView barPlot;
    private BorderPane actionsWrapper;
    private Button aanmakenMailsKnop;
    private VBox vBox;

    // Extra VBox voor tabel csv resultaten
    private VBox vBox2;

    // Extra VBox voor grafiek
    private VBox vBox3;
    private Tab uploadBestandTab;
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
        CsvBestand csv = new CsvBestand();
        csv.leesBestand();

        List<Student> studenten = csv.getStudenten();

        List<PeriodeResultaat> periodeResultaten = new ArrayList<>();
        for (Student student: studenten) {
            periodeResultaten.addAll(student.getPeriodeResultaten());
        }

        this.table = new AanmakenMailsTableView();
        new AanmakenMailsTablePresenter(periodeResultaten, this.table);

//      Toevoegen resultaten uit upload csv in tableview van de upload tab
        List<CsvLijn> csvLijnen = csv.getAlleResultaten();
        this.table2 = new UploadTableView();
        new UploadTablePresenter(csvLijnen, this.table2);

////      Tab voor de grafiek
        Grafiek grafiek = new Grafiek();
        GrafiekView plot = new GrafiekView();
        grafiek.setgrafiekGegevens(periodeResultaten);
        new GrafiekPresenter(plot,grafiek);


        this.aanmakenMailsKnop = new Button("Aanmaken mails");
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

        // Vullen Vbox2 met table2
        this.vBox2 = new VBox();
        this.vBox2.getChildren().addAll(table2);

        // Vullen Vbox3 met table3
        this.vBox3 = new VBox(plot.getBarplot());

        // Toevoegen vBox-en aan tabs
        this.uploadBestandTab = new Tab("Upload bestand",this.vBox2);
        uploadBestandTab.setClosable(false);
        this.aanmakenMailsTab = new Tab("Aanmaken mails", this.vBox);
        aanmakenMailsTab.setClosable(false);
        this.grafiekTab= new Tab("Grafiek", this.vBox3);
        grafiekTab.setClosable(false);

        this.getTabs().addAll(uploadBestandTab, aanmakenMailsTab,grafiekTab);
    }

    private void layoutNodes() {
        this.actionsWrapper.setRight(this.aanmakenMailsKnop);

        this.kleurCodeFilter.setSpacing(10);

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

    BorderPane getFilterAndSorteerWrapper() {
        return filterAndSorteerWrapper;
    }

    VBox getvBox() {
        return vBox;
    }

    Tab getUploadBestandTab() {
        return uploadBestandTab;
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
}
