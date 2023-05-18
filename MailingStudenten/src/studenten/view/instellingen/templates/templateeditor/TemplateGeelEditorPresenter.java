package studenten.view.instellingen.templates.templateeditor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import studenten.model.Instelling;
import studenten.model.MailTemplateGeel;

public class TemplateGeelEditorPresenter extends TemplateEditorPresenter {
    public TemplateGeelEditorPresenter(Instelling model, TemplateEditorView view) {
        super(model, view);
    }

    @Override
    void setTemplateTitel() {
        this.view.getTemplateTitel().setText(model.getMailTemplateGeel().getTitel());
    }

    @Override
    void setTemplateContent() {
        this.view.getTemplateContent().setHtmlText(model.getMailTemplateGeel().getContent());
    }

    void handleSave() {
        this.view.getTemplateOpslaanKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.setMailTemplateGeel(new MailTemplateGeel(view.getTemplateTitel().getText(), view.getTemplateContent().getHtmlText()));
                model.opslaan();
            }
        });
    }
}
