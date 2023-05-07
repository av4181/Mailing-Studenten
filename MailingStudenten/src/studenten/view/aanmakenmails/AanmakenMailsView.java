package studenten.view.aanmakenmails;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import studenten.model.CsvBestand;
import studenten.model.PeriodeResultaat;
import studenten.model.Student;
import studenten.view.aanmakenmails.kleurcodefilter.KleurCodeFilterPresenter;
import studenten.view.aanmakenmails.kleurcodefilter.KleurCodeFilterView;
import studenten.view.aanmakenmails.sorteerelement.SorteerElementPresenter;
import studenten.view.aanmakenmails.sorteerelement.SorteerElementView;
import studenten.view.aanmakenmails.table.AanmakenMailsTablePresenter;
import studenten.view.aanmakenmails.table.AanmakenMailsTableView;
import studenten.view.aanmakenmails.table.UploadTablePresenter;
import studenten.view.aanmakenmails.table.UploadTableView;

import java.util.ArrayList;
import java.util.List;

public class AanmakenMailsView extends TabPane {
    private BorderPane filterAndSorteerWrapper;
    private KleurCodeFilterView kleurCodeFilterView;
    private SorteerElementView sorteerElementView;
    private AanmakenMailsTableView table;

    // Toevoegen extra tabel om resultaat upload te laten zien
    private UploadTableView table2;
    private BorderPane actionsWrapper;
    private Button aanmakenMailsKnop;
    private VBox vBox;

    // Extra VBox voor tabel csv resultaten
    private VBox vBox2;
    private Tab uploadBestandTab;
    private Tab aanmakenMailsTab;

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

        // Toevoegen resultaten uit upload csv in tableview van de upload tab

        this.table2 = new UploadTableView();
        new UploadTablePresenter(studenten, this.table2);

        this.aanmakenMailsKnop = new Button("Aanmaken mails");
        this.actionsWrapper = new BorderPane();

        this.kleurCodeFilterView = new KleurCodeFilterView();
        new KleurCodeFilterPresenter(kleurCodeFilterView);

        this.sorteerElementView = new SorteerElementView();
        new SorteerElementPresenter(sorteerElementView);

        this.filterAndSorteerWrapper = new BorderPane();

        this.vBox = new VBox();
        this.vBox.getChildren().addAll(filterAndSorteerWrapper, table, actionsWrapper);

        // Vullen Vbox2 met table2
        this.vBox2 = new VBox();
        this.vBox2.getChildren().addAll(table2);


        // Toevoegen vBox2 aan uploadTab
        this.uploadBestandTab = new Tab("Upload bestand",this.vBox2);
        uploadBestandTab.setClosable(false);
        this.aanmakenMailsTab = new Tab("Aanmaken mails", this.vBox);
        aanmakenMailsTab.setClosable(false);

        this.getTabs().addAll(uploadBestandTab, aanmakenMailsTab);
    }

    private void layoutNodes() {
        this.actionsWrapper.setRight(this.aanmakenMailsKnop);

        this.filterAndSorteerWrapper.setLeft(this.kleurCodeFilterView);
        this.filterAndSorteerWrapper.setRight(this.sorteerElementView);

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

    KleurCodeFilterView getKleurCodeFilterView() {
        return kleurCodeFilterView;
    }

    SorteerElementView getSorteerElementView() {
        return sorteerElementView;
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
}
