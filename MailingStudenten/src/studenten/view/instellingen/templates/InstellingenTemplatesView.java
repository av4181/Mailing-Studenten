package studenten.view.instellingen.templates;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class InstellingenTemplatesView extends GridPane {
    private Label templateGroenLabel;
    private Button bewerkTemplateGroenKnop;
    private Label templateGeelLabel;
    private Button bewerkTemplateGeelKnop;
    private Label templateOranjeLabel;
    private Button bewerkTemplateOranjeKnop;
    private Label templateRoodLabel;
    private Button bewerkTemplateRoodKnop;

    public InstellingenTemplatesView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.templateGroenLabel = new Label("Template groen");
        this.bewerkTemplateGroenKnop = new Button("Bewerk");

        this.templateGeelLabel = new Label("Template geel");
        this.bewerkTemplateGeelKnop = new Button("Bewerk");

        this.templateOranjeLabel = new Label("Template oranje");
        this.bewerkTemplateOranjeKnop = new Button("Bewerk");

        this.templateRoodLabel = new Label("Template rood");
        this.bewerkTemplateRoodKnop = new Button("Bewerk");
    }

    private void layoutNodes() {
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(10);
        this.setHgap(10);

        this.add(templateGroenLabel, 0, 0);
        this.add(bewerkTemplateGroenKnop, 1, 0);
        this.add(templateGeelLabel, 0, 1);
        this.add(bewerkTemplateGeelKnop, 1, 1);
        this.add(templateOranjeLabel, 0, 2);
        this.add(bewerkTemplateOranjeKnop, 1, 2);
        this.add(templateRoodLabel, 0, 3);
        this.add(bewerkTemplateRoodKnop, 1, 3);
    }

    Label getTemplateGroenLabel() {
        return templateGroenLabel;
    }

    Button getBewerkTemplateGroenKnop() {
        return bewerkTemplateGroenKnop;
    }

    Label getTemplateGeelLabel() {
        return templateGeelLabel;
    }

    Button getBewerkTemplateGeelKnop() {
        return bewerkTemplateGeelKnop;
    }

    Label getTemplateOranjeLabel() {
        return templateOranjeLabel;
    }

    Button getBewerkTemplateOranjeKnop() {
        return bewerkTemplateOranjeKnop;
    }

    Label getTemplateRoodLabel() {
        return templateRoodLabel;
    }

    Button getBewerkTemplateRoodKnop() {
        return bewerkTemplateRoodKnop;
    }
}
