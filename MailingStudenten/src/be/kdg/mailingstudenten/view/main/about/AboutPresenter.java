package be.kdg.mailingstudenten.view.main.about;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AboutPresenter {
    public AboutPresenter(AboutView view) {
        view.getOkKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getScene().getWindow().hide();
            }
        });
    }
}
