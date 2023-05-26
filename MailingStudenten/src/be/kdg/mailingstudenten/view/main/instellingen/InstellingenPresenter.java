package be.kdg.mailingstudenten.view.main.instellingen;

import be.kdg.mailingstudenten.model.InstellingenAlgemeen;
import be.kdg.mailingstudenten.model.InstellingenKleurcodes;
import be.kdg.mailingstudenten.model.InstellingenTemplates;
import be.kdg.mailingstudenten.view.main.instellingen.kleurcodes.InstellingenKleurcodesPresenter;
import be.kdg.mailingstudenten.view.main.instellingen.algemeen.InstellingenAlgemeenPresenter;
import be.kdg.mailingstudenten.view.main.instellingen.templates.InstellingenTemplatesPresenter;

public class InstellingenPresenter {
    private InstellingenView view;

    public InstellingenPresenter(InstellingenView view) {
        this.view = view;

        updateView();
    }

    private void updateView() {
        new InstellingenAlgemeenPresenter(new InstellingenAlgemeen(), view.getInstellingenAlgemeenView());
        new InstellingenKleurcodesPresenter(new InstellingenKleurcodes(), view.getInstellingenKleurcodesView());
        new InstellingenTemplatesPresenter(new InstellingenTemplates(), view.getInstellingenTemplatesView());
    }
}
