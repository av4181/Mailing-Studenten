package studenten.view.instellingen.templates.templateeditor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import studenten.model.Instelling;
import studenten.model.MailTemplateRood;

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
                model.setMailTemplateRood(new MailTemplateRood(view.getTemplateTitel().getText(), view.getTemplateContent().getHtmlText()));
                model.opslaan();
            }
        });
    }
}
