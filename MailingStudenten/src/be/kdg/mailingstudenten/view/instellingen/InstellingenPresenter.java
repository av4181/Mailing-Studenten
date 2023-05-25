package be.kdg.mailingstudenten.view.instellingen;

import be.kdg.mailingstudenten.model.Instelling;
import be.kdg.mailingstudenten.view.instellingen.kleurcodes.InstellingenKleurcodesPresenter;
import be.kdg.mailingstudenten.view.instellingen.algemeen.InstellingenAlgemeenPresenter;
import be.kdg.mailingstudenten.view.instellingen.templates.InstellingenTemplatesPresenter;

public class InstellingenPresenter {
    private Instelling model;
    private InstellingenView view;

    public InstellingenPresenter(Instelling model, InstellingenView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        new InstellingenAlgemeenPresenter(this.model, view.getInstellingenAlgemeenView());
        new InstellingenKleurcodesPresenter(this.model, view.getInstellingenKleurcodesView());
        new InstellingenTemplatesPresenter(this.model, view.getInstellingenTemplatesView());
    }

    private void addEventHandlers() {}
}
