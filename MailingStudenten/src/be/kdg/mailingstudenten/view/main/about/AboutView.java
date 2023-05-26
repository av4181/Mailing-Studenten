package be.kdg.mailingstudenten.view.main.about;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class AboutView extends BorderPane {
    private Button okKnop;

    public AboutView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.okKnop = new Button("Ok");
        this.okKnop.setPrefWidth(60);
    }

    private void layoutNodes() {
        setCenter(new Label("Deze applicatie is geschreven door Steven en Andreas."));
        setPadding(new Insets(10));
        BorderPane.setAlignment(this.okKnop, Pos.CENTER_RIGHT);
        BorderPane.setMargin(this.okKnop, new Insets(10, 0, 0, 0));
        setBottom(this.okKnop);
    }

    Button getOkKnop() {
        return okKnop;
    }
}
