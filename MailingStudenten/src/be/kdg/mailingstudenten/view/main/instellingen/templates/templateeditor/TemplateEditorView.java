package be.kdg.mailingstudenten.view.main.instellingen.templates.templateeditor;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;

public class TemplateEditorView extends VBox {
    private Label templateTitelLabel;
    private TextField templateTitel;
    private Label templateContentLabel;
    private HTMLEditor templateContent;
    private HBox opslaanKnopElement;
    private Button templateOpslaanKnop;
    private Label bevestigingsTekst;

    public TemplateEditorView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.templateTitelLabel = new Label("Titel");
        this.templateTitel = new TextField();
        this.templateContentLabel = new Label("Content");
        this.templateContent = new HTMLEditor();
        this.templateOpslaanKnop = new Button("Opslaan");

        this.bevestigingsTekst = new Label();
        this.opslaanKnopElement = new HBox();
        this.opslaanKnopElement.getChildren().addAll(this.templateOpslaanKnop, this.bevestigingsTekst);

        this.getChildren().addAll(this.templateTitelLabel, this.templateTitel, this.templateContentLabel, this.templateContent, this.opslaanKnopElement);
    }

    private void layoutNodes() {
        this.setSpacing(10);
        this.setPadding(new Insets(10, 10, 10, 10));

        this.templateTitelLabel.setMaxWidth(800);

        this.templateContent.setMaxWidth(800);
        this.templateContent.setMaxHeight(500);

        this.opslaanKnopElement.setSpacing(10);
    }

    Label getTemplateTitelLabel() {
        return templateTitelLabel;
    }

    TextField getTemplateTitel() {
        return templateTitel;
    }

    Label getTemplateContentLabel() {
        return templateContentLabel;
    }

    HTMLEditor getTemplateContent() {
        return templateContent;
    }

    Button getTemplateOpslaanKnop() {
        return templateOpslaanKnop;
    }

    HBox getOpslaanKnopElement() {
        return opslaanKnopElement;
    }

    Label getBevestigingsTekst() {
        return bevestigingsTekst;
    }
}
