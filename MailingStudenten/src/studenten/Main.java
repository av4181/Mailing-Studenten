package studenten;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import studenten.view.main.MainPresenter;
import studenten.view.main.MainView;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        MainView mainView = new MainView();
        MainPresenter mainPresenter = new MainPresenter(mainView);

        Scene scene = new Scene(mainView);
        stage.setScene(scene);
        stage.setTitle("MailStudenten");
        stage.setWidth(1920);
        stage.setHeight(1080);
        stage.setResizable(true);
        stage.show();
    }
}
