package be.kdg.mailingstudenten.view.instellingen.templates;

import be.kdg.mailingstudenten.model.Instelling;
import be.kdg.mailingstudenten.view.instellingen.templates.templateeditor.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InstellingenTemplatesPresenter {
    private Instelling model;
    private InstellingenTemplatesView view;

    public InstellingenTemplatesPresenter(Instelling model, InstellingenTemplatesView view) {
        this.model = model;
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {}

    private void addEventHandlers() {
        this.view.getBewerkTemplateGroenKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TemplateEditorView templateEditorView = new TemplateEditorView();
                new TemplateGroenEditorPresenter(model, templateEditorView);
                createTemplateEditorModal("Template groen", templateEditorView);
            }
        });

        this.view.getBewerkTemplateGeelKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TemplateEditorView templateEditorView = new TemplateEditorView();
                new TemplateGeelEditorPresenter(model, templateEditorView);
                createTemplateEditorModal("Template geel", templateEditorView);
            }
        });

        this.view.getBewerkTemplateOranjeKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TemplateEditorView templateEditorView = new TemplateEditorView();
                new TemplateOranjeEditorPresenter(model, templateEditorView);
                createTemplateEditorModal("Template oranje", templateEditorView);
            }
        });

        this.view.getBewerkTemplateRoodKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TemplateEditorView templateEditorView = new TemplateEditorView();
                new TemplateRoodEditorPresenter(model, templateEditorView);
                createTemplateEditorModal("Template rood", templateEditorView);
            }
        });
    }

    private void createTemplateEditorModal(String modelName, TemplateEditorView templateEditorView) {
        Stage templateStage = new Stage();
        templateStage.initOwner(view.getScene().getWindow());
        templateStage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(templateEditorView);
        templateStage.setScene(scene);
        templateStage.setX(view.getScene().getX() + 100);
        templateStage.setY(view.getScene().getY() + 100);
        templateStage.setWidth(800);
        templateStage.setHeight(500);
        templateStage.setTitle(modelName);
        templateStage.showAndWait();
    }
}
