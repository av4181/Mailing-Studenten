package studenten.view.instellingen.templates.templateeditor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import studenten.model.Instelling;
import studenten.model.MailTemplateOranje;

public class TemplateOranjeEditorPresenter extends TemplateEditorPresenter {
    public TemplateOranjeEditorPresenter(Instelling model, TemplateEditorView view) {
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
                model.setMailTemplateOranje(new MailTemplateOranje(view.getTemplateTitel().getText(), view.getTemplateContent().getHtmlText()));
                model.opslaan();
            }
        });
    }
}
