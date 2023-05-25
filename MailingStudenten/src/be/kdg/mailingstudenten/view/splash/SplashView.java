package be.kdg.mailingstudenten.view.splash;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class SplashView extends BorderPane {
    private Image splashImage;

    public SplashView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.splashImage = new Image("/files/SplashScreen.jpg");
    }

    private void layoutNodes() {
        this.setCenter(new ImageView(this.splashImage));
        this.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(6.0))));
    }

    Image getSplashImage() {
        return splashImage;
    }
}
