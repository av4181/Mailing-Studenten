package studenten.view.aanmakenmails.table;

import studenten.model.Grafiek;

public class GrafiekPresenter {
    private Grafiek model;
    private GrafiekView view;

    public GrafiekPresenter(Grafiek model, GrafiekView view) {
        this.model = model;
        this.view = view;

        updateView();
    }
    private void updateView(){
        this.view.getBarplot().getData().addAll(this.model.getGroen(),this.model.getGeel(),this.model.getOranje(),this.model.getRood());
    }
}
