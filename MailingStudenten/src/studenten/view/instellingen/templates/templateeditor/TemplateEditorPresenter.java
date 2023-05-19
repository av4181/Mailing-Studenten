package studenten.view.instellingen.templates.templateeditor;

import studenten.model.Instelling;

abstract public class TemplateEditorPresenter {
    protected Instelling model;
    protected TemplateEditorView view;

    public TemplateEditorPresenter(Instelling model, TemplateEditorView view) {
        this.model = model;
        this.view = view;

        this.updateView();
        this.addEventHandlers();
    }

    private void updateView() {
        this.setTemplateTitel();
        this.setTemplateContent();
    }

    private void addEventHandlers() {
        this.handleSave();
    }

    abstract void setTemplateTitel();
    abstract void setTemplateContent();
    abstract void handleSave();
}
