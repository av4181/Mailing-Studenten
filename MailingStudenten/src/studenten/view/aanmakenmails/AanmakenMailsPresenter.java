package studenten.view.aanmakenmails;

import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import studenten.model.*;
import studenten.view.aanmakenmails.table.AanmakenMailsTablePresenter;
import studenten.view.aanmakenmails.table.GrafiekPresenter;

public class AanmakenMailsPresenter {
    private PeriodeResultaten model;
    private AanmakenMailsView view;

    public AanmakenMailsPresenter(PeriodeResultaten model, AanmakenMailsView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        new AanmakenMailsTablePresenter(this.model, this.view.getTable());

        Grafiek grafiek = new Grafiek();
        grafiek.setgrafiekGegevens(this.model.getPeriodeResultaten());
        new GrafiekPresenter(grafiek, this.view.getBarPlot());
    }

    private void addEventHandlers() {
        this.view.getKleurCodeFilterOpties().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (observableValue.getValue() == "Alle") {
                    view.getTable().setItems(model.getPeriodeResultaten());
                }
                if (observableValue.getValue() == "Groen") {
                    view.getTable().setItems(model.getGroeneResultaten());
                }
                if (observableValue.getValue() == "Geel") {
                    view.getTable().setItems(model.getGeleResultaten());
                }
                if (observableValue.getValue() == "Oranje") {
                    view.getTable().setItems(model.getOranjeResultaten());
                }
                if (observableValue.getValue() == "Rood") {
                    view.getTable().setItems(model.getRodeResultaten());
                }
            }
        });

        this.view.getAanmakenMailsKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ObservableList<PeriodeResultaat> periodeResultaten = view.getTable().getItems();
                    model.mailsAanmaken(periodeResultaten);

                    PauseTransition pause = new PauseTransition(Duration.seconds(2));
                    pause.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            view.getBevestigingsTekst().setText(null);
                        }
                    });
                    pause.play();

                    view.getBevestigingsTekst().setText("Aangemaakt!");
                } catch (Throwable e) {
                    view.getBevestigingsTekst().setStyle("-fx-text-fill: RED;");
                    view.getBevestigingsTekst().setText("Er ging iets fout.");
                }
            }
        });
    }
}
