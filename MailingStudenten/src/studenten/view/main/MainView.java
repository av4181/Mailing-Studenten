package studenten.view.main;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import studenten.view.aanmakenmails.AanmakenMailsView;

public class MainView extends BorderPane {
    private Menu menu;
    private Menu help;
    private MenuItem instellingenMenuItem;
    private MenuItem miAbout;
    private MenuBar menuBar;
    private AanmakenMailsView aanmakenMailsView;

    public MainView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.menu = new Menu("Bewerken");
        this.help = new Menu("Help");

        this.instellingenMenuItem = new MenuItem("Instellingen");
        this.miAbout = new MenuItem("About");

        this.menu.getItems().addAll(instellingenMenuItem);
        this.help.getItems().addAll(miAbout);

        this.menuBar = new MenuBar();
        this.menuBar.getMenus().addAll(menu,help);

        this.aanmakenMailsView = new AanmakenMailsView();
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

    AanmakenMailsView getAanmakenMailsView() {
        return aanmakenMailsView;
    }

    public MenuItem getMiAbout() {
        return miAbout;
    }
}
