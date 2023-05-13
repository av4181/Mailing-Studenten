package studenten.view.main;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import studenten.model.CsvBestand;
import studenten.model.PeriodeResultaat;
import studenten.model.PeriodeResultaten;
import studenten.model.Student;
import studenten.view.aanmakenmails.AanmakenMailsPresenter;
import studenten.view.aanmakenmails.AanmakenMailsView;

import java.util.ArrayList;
import java.util.List;

public class MainView extends BorderPane {
    private Menu menu;
    private MenuItem instellingenMenuItem;
    private MenuBar menuBar;
    private AanmakenMailsView aanmakenMailsView;

    public MainView() {
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

        this.menu = new Menu("Instellingen");
        this.instellingenMenuItem = new MenuItem("Instellingen");

        this.menu.getItems().addAll(instellingenMenuItem);

        this.menuBar = new MenuBar();
        this.menuBar.getMenus().add(menu);

        this.aanmakenMailsView = new AanmakenMailsView();
        new AanmakenMailsPresenter(new PeriodeResultaten(periodeResultaten), aanmakenMailsView);
    }

    private void layoutNodes() {
        this.setTop(this.menuBar);
        this.setCenter(aanmakenMailsView);
    }

    Menu getMenu() {
        return menu;
    }

    MenuItem getInstellingenMenuItem() {
        return instellingenMenuItem;
    }

    MenuBar getMenuBar() {
        return menuBar;
    }
}
