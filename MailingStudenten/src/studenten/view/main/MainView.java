package studenten.view.main;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import studenten.view.aanmakenmails.AanmakenMailsPresenter;
import studenten.view.aanmakenmails.AanmakenMailsView;

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
        this.menu = new Menu("Instellingen");
        this.instellingenMenuItem = new MenuItem("Instellingen");

        this.menu.getItems().addAll(instellingenMenuItem);

        this.menuBar = new MenuBar();
        this.menuBar.getMenus().add(menu);

        this.aanmakenMailsView = new AanmakenMailsView();
        new AanmakenMailsPresenter(aanmakenMailsView);
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
