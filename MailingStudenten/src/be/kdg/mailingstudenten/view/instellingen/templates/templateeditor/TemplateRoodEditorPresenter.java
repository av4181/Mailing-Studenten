package be.kdg.mailingstudenten.view.instellingen.templates.templateeditor;

import be.kdg.mailingstudenten.model.Instelling;
import be.kdg.mailingstudenten.model.MailTemplateRood;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class TemplateRoodEditorPresenter extends TemplateEditorPresenter {
    public TemplateRoodEditorPresenter(Instelling model, TemplateEditorView view) {
        super(model, view);
    }

    @Override
    void setTemplateTitel() {
        this.view.getTemplateTitel().setText(model.getMailTemplateRood().getTitel());
    }

    @Override
    void setTemplateContent() {
        this.view.getTemplateContent().setHtmlText(model.getMailTemplateRood().getContent());
    }

    void handleSave() {
        this.view.getTemplateOpslaanKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String successMessage = String.format("-fx-text-fill: GREEN;");
                String errorMessage = String.format("-fx-text-fill: RED;");

                model.setMailTemplateRood(new MailTemplateRood(view.getTemplateTitel().getText(), view.getTemplateContent().getHtmlText()));
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
            }
        });
    }
}
