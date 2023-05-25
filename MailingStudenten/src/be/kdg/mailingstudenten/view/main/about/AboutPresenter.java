package be.kdg.mailingstudenten.view.main.about;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import be.kdg.mailingstudenten.model.SimpleModel;

public class AboutPresenter {
    public AboutPresenter(SimpleModel model, AboutView view) {
        view.getBtnOkeekes().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getScene().getWindow().hide();
            }
        });
    }
}
