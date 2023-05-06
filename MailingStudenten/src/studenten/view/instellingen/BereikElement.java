package studenten.view.instellingen;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BereikElement {
    private Label label;
    private TextField inputLaag;
    private TextField inputHoog;

    public BereikElement(String label, int inputLaag, int inputHoog) {
        this.label = new Label(label);
        this.inputLaag = new TextField();
        this.inputLaag.setText(Integer.toString(inputLaag));
        this.inputHoog = new TextField();
        this.inputHoog.setText(Integer.toString(inputHoog));
    }

    public BereikElement(String label, int inputLaag) {
        this.label = new Label(label);
        this.inputLaag = new TextField();
        this.inputLaag.setText(Integer.toString(inputLaag));
        this.inputHoog = new TextField();
    }

    public BereikElement(String label) {
        this.label = new Label(label);
        this.inputLaag = new TextField();
        this.inputHoog = new TextField();
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TextField getInputLaag() {
        return inputLaag;
    }

    public void setInputLaag(TextField inputLaag) {
        this.inputLaag = inputLaag;
    }

    public TextField getInputHoog() {
        return inputHoog;
    }

    public void setInputHoog(TextField inputHoog) {
        this.inputHoog = inputHoog;
    }
}
