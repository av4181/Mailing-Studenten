package studenten;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import studenten.view.uploadFile.UploadFilePresenter;
import studenten.view.uploadFile.UploadFileView;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    @Override
    public void start(Stage stage) {

        // GEDEELTE SPLASHSCREEN (GEEN MVP GEBRUIKT)
        BorderPane borderPane = new BorderPane();
        Image splashImage = new Image("/files/SplashScreen.jpg");
        borderPane.setCenter(new ImageView(splashImage));
        StackPane stackPane = new StackPane();
        borderPane.setBottom(stackPane);
        borderPane.setBorder(new Border(new BorderStroke(Color.WHITE,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6.0))));

        Scene splashScene = new Scene(borderPane, 545, 395);
        Stage splashStage = new Stage();
        splashStage.setTitle("SplashScreenDemoFX");
        splashStage.setScene(splashScene);
        splashStage.initStyle(StageStyle.UNDECORATED);

        splashStage.show();

        UploadFileView uploadFileView = new UploadFileView();
        new UploadFilePresenter(uploadFileView);

        Scene scene = new Scene(uploadFileView);
        scene.getStylesheets().add("css/Barchart.css");
        stage.setScene(scene);
        stage.setTitle("MailStudenten");
        stage.setWidth(1200);
        stage.setHeight(800);
        stage.setResizable(true);
        /* Volgend stukje code toont de stages in de juiste volgorde.
        The splash stage wordt afgesloten na een zekere delay, daarna wordt het upload venster getoond.
        De delay wordt door een Timer object gemaakt.  Nu is de delay 5000 ms ofwel 5sec.
        Aangezien de actionPerformed() methode op de event-dispatch thread wordt uitgevoerd, moet de code Platform.runLater()
         gebruiken om de JavaFX code te runnen op de application thread.
        */
        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask(){
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
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
