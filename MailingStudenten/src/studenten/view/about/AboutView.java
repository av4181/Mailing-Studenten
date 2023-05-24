package studenten.view.about;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class AboutView extends BorderPane {
    private Button btnOkeekes;

    public AboutView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        btnOkeekes = new Button("Ok");
        btnOkeekes.setPrefWidth(60);
    }

    private void layoutNodes() {
        setCenter(new Label("Deze applicatie is geschreven door Steven en Andreas."));
        setPadding(new Insets(10));
        BorderPane.setAlignment(btnOkeekes, Pos.CENTER_RIGHT);
        BorderPane.setMargin(btnOkeekes, new Insets(10, 0, 0, 0));
        setBottom(btnOkeekes);
    }

    Button getBtnOkeekes() {
        return btnOkeekes;
    }
}
