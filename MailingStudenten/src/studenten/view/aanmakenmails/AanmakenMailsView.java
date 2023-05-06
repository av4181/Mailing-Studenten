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

import java.util.ArrayList;
import java.util.List;

public class AanmakenMailsView extends TabPane {
    private BorderPane filterAndSorteerWrapper;
    private KleurCodeFilterView kleurCodeFilterView;
    private SorteerElementView sorteerElementView;
    private AanmakenMailsTableView table;
    private BorderPane actionsWrapper;
    private Button aanmakenMailsKnop;
    private VBox vBox;
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

        this.aanmakenMailsKnop = new Button("Aanmaken mails");
        this.actionsWrapper = new BorderPane();

        this.kleurCodeFilterView = new KleurCodeFilterView();
        new KleurCodeFilterPresenter(kleurCodeFilterView);

        this.sorteerElementView = new SorteerElementView();
        new SorteerElementPresenter(sorteerElementView);

        this.filterAndSorteerWrapper = new BorderPane();

        this.vBox = new VBox();
        this.vBox.getChildren().addAll(filterAndSorteerWrapper, table, actionsWrapper);


        this.uploadBestandTab = new Tab("Upload bestand");
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
