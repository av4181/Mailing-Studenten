package be.kdg.mailingstudenten.view.main.instellingen.kleurcodes;

import be.kdg.mailingstudenten.model.Bereik;
import be.kdg.mailingstudenten.model.InstellingenKleurcodes;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.ArrayList;

public class InstellingenKleurcodesPresenter {
    private InstellingenKleurcodes model;
    private InstellingenKleurcodesView view;

    public InstellingenKleurcodesPresenter(InstellingenKleurcodes model, InstellingenKleurcodesView view) {
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
    }

    private void addEventHandlers() {
        view.getInstellingenOpslaanKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<String> validationErrors = new ArrayList<>();
                if (view.getBereikGroenElement().getInputLaag().getText().isBlank() || view.getBereikGroenElement().getInputHoog().getText().isBlank()) {
                    validationErrors.add("Bereik groen is verplicht.");
                }
                if (view.getBereikGeelElement().getInputLaag().getText().isBlank() || view.getBereikGeelElement().getInputHoog().getText().isBlank()) {
                    validationErrors.add("Bereik geel is verplicht.");
                }
                if (view.getBereikOranjeElement().getInputLaag().getText().isBlank() || view.getBereikOranjeElement().getInputHoog().getText().isBlank()) {
                    validationErrors.add("Bereik oranje is verplicht.");
                }

                if (validationErrors.size() > 0) {
                    String validationErrorMessage = "";
                    for (String error : validationErrors) {
                        validationErrorMessage += error + "\n";
                    }
                    view.getValidatieTekst().setText(validationErrorMessage);
                    return;
                }

                try {
                    int bereikGroenLaag = Integer.parseInt(view.getBereikGroenElement().getInputLaag().getText());
                    int bereikGroenHoog = Integer.parseInt(view.getBereikGroenElement().getInputHoog().getText());
                    int bereikGeelLaag = Integer.parseInt(view.getBereikGeelElement().getInputLaag().getText());
                    int bereikGeelHoog = Integer.parseInt(view.getBereikGeelElement().getInputHoog().getText());
                    int bereikOranjeLaag = Integer.parseInt(view.getBereikOranjeElement().getInputLaag().getText());
                    int bereikOranjeHoog = Integer.parseInt(view.getBereikOranjeElement().getInputHoog().getText());

                    if (bereikGroenLaag > bereikGroenHoog) {
                        validationErrors.add("Bereik groen eindwaarde kan niet lager zijn dan startwaarde.");
                    }
                    if (bereikGeelLaag > bereikGeelHoog) {
                        validationErrors.add("Bereik geel eindwaarde kan niet lager zijn dan startwaarde.");
                    }
                    if (bereikOranjeLaag > bereikOranjeHoog) {
                        validationErrors.add("Bereik oranje eindwaarde kan niet lager zijn dan startwaarde.");
                    }

                    if ((bereikGeelLaag - bereikGroenHoog) != 1 || (bereikOranjeLaag - bereikGeelHoog) != 1) {
                        validationErrors.add("Er kunnen geen gaten zijn tussen de verschillende kleurcodes.");
                    }

                    if (validationErrors.size() > 0) {
                        String validationErrorMessage = "";
                        for (String error : validationErrors) {
                            validationErrorMessage += error + "\n";
                        }
                        view.getValidatieTekst().setText(validationErrorMessage);
                        return;
                    }

                    model.setBereikGroen(new Bereik(bereikGroenLaag, bereikGroenHoog));
                    model.setBereikGeel(new Bereik(bereikGeelLaag, bereikGeelHoog));
                    model.setBereikOranje(new Bereik(bereikOranjeLaag, bereikOranjeHoog));

                    model.opslaan();

                    view.getValidatieTekst().setText(null);

                    PauseTransition pause = new PauseTransition(Duration.seconds(2));
                    pause.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            view.getBevestigingsTekst().setText(null);
                        }
                    });
                    pause.play();

                    view.getBevestigingsTekst().setText("Opgeslagen!");
                } catch (NumberFormatException e) {
                    view.getValidatieTekst().setText("Velden mogen enkel numerieke waarden bevatten.");
                }
            }
        });
    }
}
