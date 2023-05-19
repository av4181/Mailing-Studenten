package studenten.view.instellingen.kleurcodes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import studenten.model.Bereik;
import studenten.model.Instelling;

public class InstellingenKleurcodesPresenter {
    private Instelling model;
    private InstellingenKleurcodesView view;

    public InstellingenKleurcodesPresenter(Instelling model, InstellingenKleurcodesView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        view.getBereikGroenElement().getInputLaag().setText(Integer.toString(this.model.getBereikGroen().getLaag()));
        view.getBereikGroenElement().getInputHoog().setText(Integer.toString(this.model.getBereikGroen().getHoog()));
        view.getBereikGeelElement().getInputLaag().setText(Integer.toString(this.model.getBereikGeel().getLaag()));
        view.getBereikGeelElement().getInputHoog().setText(Integer.toString(this.model.getBereikGeel().getHoog()));
        view.getBereikOranjeElement().getInputLaag().setText(Integer.toString(this.model.getBereikOranje().getLaag()));
        view.getBereikOranjeElement().getInputHoog().setText(Integer.toString(this.model.getBereikOranje().getHoog()));
        view.getBereikRoodElement().getInputLaag().setText(Integer.toString(this.model.getBereikRood().getLaag()));
    }

    private void addEventHandlers() {
        view.getInstellingenOpslaanKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.setBereikGroen(new Bereik(Integer.parseInt(view.getBereikGroenElement().getInputLaag().getText()), Integer.parseInt(view.getBereikGroenElement().getInputHoog().getText())));
                model.setBereikGeel(new Bereik(Integer.parseInt(view.getBereikGeelElement().getInputLaag().getText()), Integer.parseInt(view.getBereikGeelElement().getInputHoog().getText())));
                model.setBereikOranje(new Bereik(Integer.parseInt(view.getBereikOranjeElement().getInputLaag().getText()), Integer.parseInt(view.getBereikOranjeElement().getInputHoog().getText())));
                model.setBereikRood(new Bereik(Integer.parseInt(view.getBereikRoodElement().getInputLaag().getText()), 9999999));

                model.opslaan();
            }
        });
    }
}
