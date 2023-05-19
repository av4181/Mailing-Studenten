package studenten.view.instellingen;

import studenten.model.Instelling;
import studenten.view.instellingen.algemeen.InstellingenAlgemeenPresenter;
import studenten.view.instellingen.kleurcodes.InstellingenKleurcodesPresenter;
import studenten.view.instellingen.templates.InstellingenTemplatesPresenter;

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
