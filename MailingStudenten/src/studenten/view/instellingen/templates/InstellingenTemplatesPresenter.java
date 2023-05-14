package studenten.view.instellingen.templates;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Modality;
import javafx.stage.Stage;
import studenten.model.*;

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
                Stage templateStage = new Stage();
                templateStage.initOwner(view.getScene().getWindow());
                templateStage.initModality(Modality.APPLICATION_MODAL);



                // todo: separate view
                VBox vBoxGroen = new VBox();
                vBoxGroen.setSpacing(10);
                vBoxGroen.setPadding(new Insets(10, 10, 10, 10));

                Label templateGroenTitelLabel = new Label("Titel");
                TextField templateGroenTitel = new TextField();
                templateGroenTitel.setMaxWidth(800);
                Label templateGroenContentLabel = new Label("Content");
                HTMLEditor templateGroenContent = new HTMLEditor();

                templateGroenContent.setMaxWidth(800);
                templateGroenContent.setMaxHeight(500);

                VBox templateGroenOpslaanKnopWrapper = new VBox();
                Button templateGroenOpslaanKnop = new Button("Opslaan");
                templateGroenOpslaanKnopWrapper.getChildren().addAll(templateGroenOpslaanKnop);
                templateGroenOpslaanKnopWrapper.setAlignment(Pos.CENTER_RIGHT);
                vBoxGroen.getChildren().addAll(templateGroenTitelLabel, templateGroenTitel, templateGroenContentLabel, templateGroenContent, templateGroenOpslaanKnopWrapper);

                templateGroenTitel.setText(model.getMailTemplateGroen().getTitel());
                templateGroenContent.setHtmlText(model.getMailTemplateGroen().getContent());

                templateGroenOpslaanKnop.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        model.setMailTemplateGroen(new MailTemplateGroen(templateGroenTitel.getText(), templateGroenContent.getHtmlText()));
                        model.opslaan();
                    }
                });

                Scene scene = new Scene(vBoxGroen);

                templateStage.setScene(scene);
                templateStage.setX(view.getScene().getX() + 100);
                templateStage.setY(view.getScene().getY() + 100);
                templateStage.setWidth(800);
                templateStage.setHeight(500);
                templateStage.setTitle("Template groen");
                templateStage.showAndWait();
            }
        });

        this.view.getBewerkTemplateGeelKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage templateStage = new Stage();
                templateStage.initOwner(view.getScene().getWindow());
                templateStage.initModality(Modality.APPLICATION_MODAL);

                VBox vBoxGeel = new VBox();
                vBoxGeel.setSpacing(10);
                vBoxGeel.setPadding(new Insets(10, 10, 10, 10));

                Label templateGeelTitelLabel = new Label("Titel");
                TextField templateGeelTitel = new TextField();
                templateGeelTitel.setMaxWidth(800);
                Label templateGeelnContentLabel = new Label("Content");
                HTMLEditor templateGeelContent = new HTMLEditor();

                templateGeelContent.setMaxWidth(800);
                templateGeelContent.setMaxHeight(500);

                VBox templateGroenOpslaanKnopWrapper = new VBox();
                Button templateGroenOpslaanKnop = new Button("Opslaan");
                templateGroenOpslaanKnopWrapper.getChildren().addAll(templateGroenOpslaanKnop);
                templateGroenOpslaanKnopWrapper.setAlignment(Pos.CENTER_RIGHT);
                vBoxGeel.getChildren().addAll(templateGeelTitelLabel, templateGeelTitel, templateGeelnContentLabel, templateGeelContent, templateGroenOpslaanKnopWrapper);

                templateGeelTitel.setText(model.getMailTemplateGeel().getTitel());
                templateGeelContent.setHtmlText(model.getMailTemplateGeel().getContent());

                templateGroenOpslaanKnop.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        model.setMailTemplateGeel(new MailTemplateGeel(templateGeelTitel.getText(), templateGeelContent.getHtmlText()));
                        model.opslaan();
                    }
                });

                Scene scene = new Scene(vBoxGeel);

                templateStage.setScene(scene);
                templateStage.setX(view.getScene().getX() + 100);
                templateStage.setY(view.getScene().getY() + 100);
                templateStage.setWidth(800);
                templateStage.setHeight(500);
                templateStage.setTitle("Template geel");
                templateStage.showAndWait();
            }
        });

        this.view.getBewerkTemplateOranjeKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage templateStage = new Stage();
                templateStage.initOwner(view.getScene().getWindow());
                templateStage.initModality(Modality.APPLICATION_MODAL);

                VBox vBoxGeel = new VBox();
                vBoxGeel.setSpacing(10);
                vBoxGeel.setPadding(new Insets(10, 10, 10, 10));

                Label templateGeelTitelLabel = new Label("Titel");
                TextField templateGeelTitel = new TextField();
                templateGeelTitel.setMaxWidth(800);
                Label templateGeelnContentLabel = new Label("Content");
                HTMLEditor templateGeelContent = new HTMLEditor();

                templateGeelContent.setMaxWidth(800);
                templateGeelContent.setMaxHeight(500);

                VBox templateGroenOpslaanKnopWrapper = new VBox();
                Button templateGroenOpslaanKnop = new Button("Opslaan");
                templateGroenOpslaanKnopWrapper.getChildren().addAll(templateGroenOpslaanKnop);
                templateGroenOpslaanKnopWrapper.setAlignment(Pos.CENTER_RIGHT);
                vBoxGeel.getChildren().addAll(templateGeelTitelLabel, templateGeelTitel, templateGeelnContentLabel, templateGeelContent, templateGroenOpslaanKnopWrapper);

                templateGeelTitel.setText(model.getMailTemplateOranje().getTitel());
                templateGeelContent.setHtmlText(model.getMailTemplateOranje().getContent());

                templateGroenOpslaanKnop.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        model.setMailTemplateOranje(new MailTemplateOranje(templateGeelTitel.getText(), templateGeelContent.getHtmlText()));
                        model.opslaan();
                    }
                });

                Scene scene = new Scene(vBoxGeel);

                templateStage.setScene(scene);
                templateStage.setX(view.getScene().getX() + 100);
                templateStage.setY(view.getScene().getY() + 100);
                templateStage.setWidth(800);
                templateStage.setHeight(500);
                templateStage.setTitle("Template oranje");
                templateStage.showAndWait();
            }
        });

        this.view.getBewerkTemplateRoodKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage templateStage = new Stage();
                templateStage.initOwner(view.getScene().getWindow());
                templateStage.initModality(Modality.APPLICATION_MODAL);

                VBox vBoxGeel = new VBox();
                vBoxGeel.setSpacing(10);
                vBoxGeel.setPadding(new Insets(10, 10, 10, 10));

                Label templateGeelTitelLabel = new Label("Titel");
                TextField templateGeelTitel = new TextField();
                templateGeelTitel.setMaxWidth(800);
                Label templateGeelnContentLabel = new Label("Content");
                HTMLEditor templateGeelContent = new HTMLEditor();

                templateGeelContent.setMaxWidth(800);
                templateGeelContent.setMaxHeight(500);

                VBox templateGroenOpslaanKnopWrapper = new VBox();
                Button templateGroenOpslaanKnop = new Button("Opslaan");
                templateGroenOpslaanKnopWrapper.getChildren().addAll(templateGroenOpslaanKnop);
                templateGroenOpslaanKnopWrapper.setAlignment(Pos.CENTER_RIGHT);
                vBoxGeel.getChildren().addAll(templateGeelTitelLabel, templateGeelTitel, templateGeelnContentLabel, templateGeelContent, templateGroenOpslaanKnopWrapper);

                templateGeelTitel.setText(model.getMailTemplateRood().getTitel());
                templateGeelContent.setHtmlText(model.getMailTemplateRood().getContent());

                templateGroenOpslaanKnop.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        model.setMailTemplateRood(new MailTemplateRood(templateGeelTitel.getText(), templateGeelContent.getHtmlText()));
                        model.opslaan();
                    }
                });

                Scene scene = new Scene(vBoxGeel);

                templateStage.setScene(scene);
                templateStage.setX(view.getScene().getX() + 100);
                templateStage.setY(view.getScene().getY() + 100);
                templateStage.setWidth(800);
                templateStage.setHeight(500);
                templateStage.setTitle("Template rood");
                templateStage.showAndWait();
            }
        });
    }
}
