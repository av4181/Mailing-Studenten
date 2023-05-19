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
import studenten.view.main.UploadFilePresenter;
import studenten.view.main.UploadFileView;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) {

        // GEDEELTE SPLASHSCREEN (GEEN MVP GEBRUIKT)
        BorderPane borderPane = new BorderPane();
        Image splashImage = new Image("/files/SplashScreen.jpg");
        borderPane.setCenter(new ImageView(splashImage));
        Label label = new Label(" Splash Screen ");
        StackPane stackPane = new StackPane();
        borderPane.setBottom(stackPane);
        borderPane.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(0),new BorderWidths(6.0))));

        Scene splashScene = new Scene(borderPane, 545, 295);
        Stage splashStage = new Stage();
        splashStage.setTitle("SplashScreenDemoFX");
        splashStage.setScene(splashScene);
        splashStage.initStyle(StageStyle.UNDECORATED );

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
/*Volgend stukje code toont de stages in de juiste volgorde.
The splash stage wordt afgesloten na een zekere delay, daarna wordt het upload venster getoond en daarna de tabbladen
De delay wordt door een Timer object gemaakt.  Nu is de delay 5000 ms ofwel 5sec.
Timer object roept actionPerformed() methode van de ActionListener op na the initiele delay.
Aangezien de actionPerformed() methode op de event-dispatch thread wordt uitgevoerd, moet de code Platform.runLater()
 gebruiken om de JavaFX code te runnen op de application thread.
*/
// Creer ActionListener object met gebruik van een anonieme inner class implementing ActionListener
        ActionListener listener = new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
//Uitvoeren code voor sluiten splash stage en tonen van de volgende stage van de app.
//Anonieme inner class implementing Runnable() wordt gebruikt als parameter voor runLater()
                Platform.runLater(new Runnable(){
                                      @Override
                                      public void run() {
                                          splashStage.close();
                                          stage.show(); // Display the stage
                                      }
                                  }
                );
            }
        };

        Timer t = new Timer (5000, listener);
        t.setRepeats(false);
        t.start();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
