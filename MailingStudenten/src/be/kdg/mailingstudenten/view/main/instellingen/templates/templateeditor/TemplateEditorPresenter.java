package be.kdg.mailingstudenten.view.main.instellingen.templates.templateeditor;

import be.kdg.mailingstudenten.model.InstellingenTemplates;

abstract public class TemplateEditorPresenter {
    protected InstellingenTemplates model;
    protected TemplateEditorView view;

    public TemplateEditorPresenter(InstellingenTemplates model, TemplateEditorView view) {
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
