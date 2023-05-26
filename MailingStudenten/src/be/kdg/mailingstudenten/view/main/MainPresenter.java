package be.kdg.mailingstudenten.view.main;

import be.kdg.mailingstudenten.model.*;
import be.kdg.mailingstudenten.view.main.aanmakenmails.AanmakenMailsPresenter;
import be.kdg.mailingstudenten.view.main.about.AboutPresenter;
import be.kdg.mailingstudenten.view.main.about.AboutView;
import be.kdg.mailingstudenten.view.main.grafiek.GrafiekPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import be.kdg.mailingstudenten.view.uploadfile.UploadFilePresenter;
import be.kdg.mailingstudenten.view.uploadfile.UploadFileView;
import be.kdg.mailingstudenten.view.main.instellingen.InstellingenPresenter;
import be.kdg.mailingstudenten.view.main.instellingen.InstellingenView;

import java.util.List;

public class MainPresenter {
    private CsvBestand model;
    private MainView view;

    public MainPresenter(CsvBestand model, MainView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {
        List<Student> studenten = model.getStudenten();
        PeriodeResultaten periodeResultaten = PeriodeResultaten.forStudenten(studenten);

        new AanmakenMailsPresenter(periodeResultaten, this.view.getAanmakenMailsView());

        Grafiek grafiek = new Grafiek();
        grafiek.setgrafiekGegevens(periodeResultaten.getPeriodeResultaten());
        new GrafiekPresenter(grafiek, this.view.getGrafiekView());
    }

    private void addEventHandlers() {
        view.getBestandMenuItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UploadFileView uploadFileView = new UploadFileView();
                new UploadFilePresenter(uploadFileView);

                view.getScene().setRoot(uploadFileView);
            }
        });
        this.view.getInstellingenMenuItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InstellingenView instellingenView = new InstellingenView();
                new InstellingenPresenter(instellingenView);
                Stage instellingenStage = new Stage();
                instellingenStage.initOwner(view.getScene().getWindow());
                instellingenStage.initModality(Modality.APPLICATION_MODAL);
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

        view.getMiAbout().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AboutView aboutView = new AboutView();
                new AboutPresenter(aboutView);
                Stage aboutStage = new Stage();
                aboutStage.initOwner(view.getScene().getWindow());
                aboutStage.initModality(Modality.APPLICATION_MODAL);
                aboutStage.setScene(new Scene(aboutView));
                aboutStage.setX(view.getScene().getWindow().getX() + 100);
                aboutStage.setY(view.getScene().getWindow().getY() + 100);
                aboutStage.setTitle("Help");
                aboutStage.showAndWait();
            }
        });
    }
}
