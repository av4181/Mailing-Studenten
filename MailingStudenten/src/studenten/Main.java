package studenten;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import studenten.view.main.MainPresenter;
import studenten.view.main.MainView;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        MainView mainView = new MainView();
        new MainPresenter(mainView);

        Scene scene = new Scene(mainView);
        stage.setScene(scene);
        stage.setTitle("MailStudenten");
        stage.setWidth(1200);
        stage.setHeight(800);
        stage.setResizable(true);
        stage.show();
    }
}
