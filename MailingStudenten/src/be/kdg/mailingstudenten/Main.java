package be.kdg.mailingstudenten;

import be.kdg.mailingstudenten.view.splash.SplashView;
import be.kdg.mailingstudenten.view.uploadfile.UploadFilePresenter;
import be.kdg.mailingstudenten.view.uploadfile.UploadFileView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        SplashView splashView = new SplashView();
        Scene splashScene = new Scene(splashView, 545, 395);
        Stage splashStage = new Stage();
        splashStage.setScene(splashScene);
        splashStage.initStyle(StageStyle.UNDECORATED);
        splashStage.show();

        /*
        Na 5 seconden wordt de splash screen gesloten en wordt het upload scherm ingeladen.
        Om op de event dispatch thread te kunnen werken met de callback in een timer maken we gebruik van Platform.runLater().
         */
        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask(){
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        UploadFileView uploadFileView = new UploadFileView();
                        new UploadFilePresenter(uploadFileView);
                        Scene scene = new Scene(uploadFileView);
                        scene.getStylesheets().add("css/Barchart.css");
                        stage.setScene(scene);
                        stage.setTitle("MailStudenten");
                        stage.setWidth(1200);
                        stage.setHeight(800);
                        stage.setResizable(true);

                        splashStage.close();
                        stage.show();
                    }
                });
            }
        }, 5000);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
