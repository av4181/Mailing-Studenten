package studenten.view.instellingen.templates.templateeditor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;

public class TemplateEditorView extends VBox {
    private Label templateTitelLabel;
    private TextField templateTitel;
    private Label templateContentLabel;
    private HTMLEditor templateContent;
    private VBox templateOpslaanKnopWrapper;
    private Button templateOpslaanKnop;

    public TemplateEditorView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.templateTitelLabel = new Label("Titel");
        this.templateTitel = new TextField();
        this.templateContentLabel = new Label("Content");
        this.templateContent = new HTMLEditor();

        this.templateOpslaanKnopWrapper = new VBox();
        this.templateOpslaanKnop = new Button("Opslaan");
        this.templateOpslaanKnopWrapper.getChildren().addAll(this.templateOpslaanKnop);
        this.templateOpslaanKnopWrapper.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(this.templateTitelLabel, this.templateTitel, this.templateContentLabel, this.templateContent, this.templateOpslaanKnopWrapper);
    }

    private void layoutNodes() {
        this.setSpacing(10);
        this.setPadding(new Insets(10, 10, 10, 10));

        this.templateTitelLabel.setMaxWidth(800);

        this.templateContent.setMaxWidth(800);
        this.templateContent.setMaxHeight(500);
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

    VBox getTemplateOpslaanKnopWrapper() {
        return templateOpslaanKnopWrapper;
    }

    Button getTemplateOpslaanKnop() {
        return templateOpslaanKnop;
    }
}
