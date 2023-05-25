package be.kdg.mailingstudenten.view.main;

import be.kdg.mailingstudenten.view.main.aanmakenmails.AanmakenMailsView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {
    private Menu bestandMenu;
    private Menu editMenu;
    private Menu helpMenu;
    private MenuItem bestandMenuItem;
    private MenuItem instellingenMenuItem;
    private MenuItem miAbout;
    private MenuBar menuBar;
    private AanmakenMailsView aanmakenMailsView;

    public MainView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.bestandMenu = new Menu("Bestand");
        this.editMenu = new Menu("Bewerken");
        this.helpMenu = new Menu("Help");

        this.bestandMenuItem = new MenuItem("Nieuw bestand opladen");
        this.instellingenMenuItem = new MenuItem("Instellingen");
        this.miAbout = new MenuItem("About");

        this.bestandMenu.getItems().addAll(bestandMenuItem);
        this.editMenu.getItems().addAll(instellingenMenuItem);
        this.helpMenu.getItems().addAll(miAbout);

        this.menuBar = new MenuBar();
        this.menuBar.getMenus().addAll(bestandMenu, editMenu, helpMenu);

        this.aanmakenMailsView = new AanmakenMailsView();
    }

    private void layoutNodes() {
        this.setTop(this.menuBar);
        this.setCenter(aanmakenMailsView);
    }

    Menu getEditMenu() {
        return editMenu;
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

    MenuItem getMiAbout() {
        return miAbout;
    }

    Menu getHelpMenu() {
        return helpMenu;
    }

    MenuItem getBestandMenuItem() {
        return bestandMenuItem;
    }

    Menu getBestandMenu() {
        return bestandMenu;
    }
}
