package studenten.view.instellingen.templates.templateeditor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import studenten.model.Instelling;
import studenten.model.MailTemplateGroen;

public class TemplateGroenEditorPresenter extends TemplateEditorPresenter {
    public TemplateGroenEditorPresenter(Instelling model, TemplateEditorView view) {
        super(model, view);
    }

    @Override
    void setTemplateTitel() {
        this.view.getTemplateTitel().setText(model.getMailTemplateGroen().getTitel());
    }

    @Override
    void setTemplateContent() {
        this.view.getTemplateContent().setHtmlText(model.getMailTemplateGroen().getContent());
    }

    void handleSave() {
        this.view.getTemplateOpslaanKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.setMailTemplateGroen(new MailTemplateGroen(view.getTemplateTitel().getText(), view.getTemplateContent().getHtmlText()));
                model.opslaan();
            }
        });
    }
}
