package studenten.view.instellingen;

import javafx.scene.control.*;
import studenten.view.instellingen.algemeen.InstellingenAlgemeenView;
import studenten.view.instellingen.kleurcodes.InstellingenKleurcodesView;
import studenten.view.instellingen.templates.InstellingenTemplatesView;

public class InstellingenView extends TabPane {
    private InstellingenAlgemeenView instellingenAlgemeenView;
    private InstellingenTemplatesView instellingenTemplatesView;
    private InstellingenKleurcodesView instellingenKleurcodesView;
    private Tab tabAlgemeen;
    private Tab tabKleurcodes;
    private Tab tabTemplates;

    public InstellingenView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.instellingenAlgemeenView = new InstellingenAlgemeenView();
        this.tabAlgemeen = new Tab("Algemeen", this.instellingenAlgemeenView);
        tabAlgemeen.setClosable(false);

        this.instellingenKleurcodesView = new InstellingenKleurcodesView();
        this.tabKleurcodes = new Tab("Kleurcodes", this.instellingenKleurcodesView);
        tabKleurcodes.setClosable(false);

        this.instellingenTemplatesView = new InstellingenTemplatesView();
        this.tabTemplates = new Tab("Templates", this.instellingenTemplatesView);
        tabTemplates.setClosable(false);

        this.getTabs().addAll(tabAlgemeen, tabKleurcodes, tabTemplates);
    }

    private void layoutNodes() {}

    InstellingenAlgemeenView getInstellingenAlgemeenView() {
        return this.instellingenAlgemeenView;
    }

    InstellingenTemplatesView getInstellingenTemplatesView() {
        return instellingenTemplatesView;
    }

    InstellingenKleurcodesView getInstellingenKleurcodesView() {
        return instellingenKleurcodesView;
    }

    Tab getTabAlgemeen() {
        return tabAlgemeen;
    }

    Tab getTabTemplates() {
        return tabTemplates;
    }

    Tab getTabKleurcodes() {
        return tabKleurcodes;
    }
}
