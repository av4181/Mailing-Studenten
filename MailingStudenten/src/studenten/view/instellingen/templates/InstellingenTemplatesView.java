package studenten.view.instellingen.templates;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import studenten.model.PeriodeResultaat;

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
        this.setPadding(new Insets(10, 10, 10, 10));

        this.templateGroenLabel = new Label("Template groen");
        this.bewerkTemplateGroenKnop = new Button("Bewerk");
        this.bewerkTemplateGroenKnop.setId(PeriodeResultaat.KleurCode.GROEN.toString());

        this.templateGeelLabel = new Label("Template geel");
        this.bewerkTemplateGeelKnop = new Button("Bewerk");
        this.bewerkTemplateGeelKnop.setId(PeriodeResultaat.KleurCode.GEEL.toString());

        this.templateOranjeLabel = new Label("Template oranje");
        this.bewerkTemplateOranjeKnop = new Button("Bewerk");
        this.bewerkTemplateOranjeKnop.setId(PeriodeResultaat.KleurCode.ORANJE.toString());

        this.templateRoodLabel = new Label("Template rood");
        this.bewerkTemplateRoodKnop = new Button("Bewerk");
        this.bewerkTemplateRoodKnop.setId(PeriodeResultaat.KleurCode.ROOD.toString());

        this.add(templateGroenLabel, 0, 0);
        this.add(bewerkTemplateGroenKnop, 1, 0);
        this.add(templateGeelLabel, 0, 1);
        this.add(bewerkTemplateGeelKnop, 1, 1);
        this.add(templateOranjeLabel, 0, 2);
        this.add(bewerkTemplateOranjeKnop, 1, 2);
        this.add(templateRoodLabel, 0, 3);
        this.add(bewerkTemplateRoodKnop, 1, 3);
    }

    private void layoutNodes() {
        this.setVgap(10);
        this.setHgap(10);
    }

    public Label getTemplateGroenLabel() {
        return templateGroenLabel;
    }

    public Button getBewerkTemplateGroenKnop() {
        return bewerkTemplateGroenKnop;
    }

    public Label getTemplateGeelLabel() {
        return templateGeelLabel;
    }

    public Button getBewerkTemplateGeelKnop() {
        return bewerkTemplateGeelKnop;
    }

    public Label getTemplateOranjeLabel() {
        return templateOranjeLabel;
    }

    public Button getBewerkTemplateOranjeKnop() {
        return bewerkTemplateOranjeKnop;
    }

    public Label getTemplateRoodLabel() {
        return templateRoodLabel;
    }

    public Button getBewerkTemplateRoodKnop() {
        return bewerkTemplateRoodKnop;
    }
}
