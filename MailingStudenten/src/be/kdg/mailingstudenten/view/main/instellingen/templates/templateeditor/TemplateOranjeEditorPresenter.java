package be.kdg.mailingstudenten.view.main.instellingen.templates.templateeditor;

import be.kdg.mailingstudenten.model.InstellingenTemplates;
import be.kdg.mailingstudenten.model.MailTemplateOranje;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class TemplateOranjeEditorPresenter extends TemplateEditorPresenter {
    public TemplateOranjeEditorPresenter(InstellingenTemplates model, TemplateEditorView view) {
        super(model, view);
    }

    @Override
    void setTemplateTitel() {
        this.view.getTemplateTitel().setText(model.getMailTemplateOranje().getTitel());
    }

    @Override
    void setTemplateContent() {
        this.view.getTemplateContent().setHtmlText(model.getMailTemplateOranje().getContent());
    }

    void handleSave() {
        this.view.getTemplateOpslaanKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String successMessage = String.format("-fx-text-fill: GREEN;");

                try {
                    model.setMailTemplateOranje(new MailTemplateOranje(view.getTemplateTitel().getText(), view.getTemplateContent().getHtmlText()));
                    model.opslaan();

                    PauseTransition pause = new PauseTransition(Duration.seconds(2));
                    pause.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            view.getBevestigingsTekst().setText(null);
                        }
                    });
                    pause.play();

                    view.getBevestigingsTekst().setStyle(successMessage);
                    view.getBevestigingsTekst().setText("Opgeslagen!");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Opslaan mislukt");
                    alert.setContentText("Neem contact op met KDG voor meer informatie.");
                    alert.showAndWait();
                }
            }
        });
    }
}
