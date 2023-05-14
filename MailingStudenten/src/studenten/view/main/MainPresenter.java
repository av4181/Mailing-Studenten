package studenten.view.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import studenten.model.*;
import studenten.view.aanmakenmails.AanmakenMailsPresenter;
import studenten.view.instellingen.InstellingenPresenter;
import studenten.view.instellingen.InstellingenView;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        CsvBestand csv = new CsvBestand();
        csv.leesBestand();

        List<Student> studenten = csv.getStudenten();

        List<PeriodeResultaat> periodeResultaten = new ArrayList<>();
        for (Student student: studenten) {
            periodeResultaten.addAll(student.getPeriodeResultaten());
        }

        new AanmakenMailsPresenter(new PeriodeResultaten(periodeResultaten), view.getAanmakenMailsView());
    }

    private void addEventHandlers() {
        this.view.getInstellingenMenuItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage instellingenStage = new Stage();
                instellingenStage.initOwner(view.getScene().getWindow());
                instellingenStage.initModality(Modality.APPLICATION_MODAL);

                InstellingenView instellingenView = new InstellingenView();
                new InstellingenPresenter(new Instelling(), instellingenView);

                Scene scene = new Scene(instellingenView);

                instellingenStage.setScene(scene);
                instellingenStage.setX(view.getScene().getX() + 100);
                instellingenStage.setY(view.getScene().getX() + 100);
                instellingenStage.setWidth(800);
                instellingenStage.setHeight(500);
                instellingenStage.setTitle("Instellingen");
                instellingenStage.showAndWait();
            }
        });
    }
}
