package studenten.view.main;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import studenten.model.Instelling;
import studenten.view.instellingen.InstellingenPresenter;
import studenten.view.instellingen.InstellingenView;

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;

        addEventHandlers();
    }

    private void addEventHandlers() {
        this.view.getInstellingenMenuItem().setOnAction(actionEvent -> {
            Stage instellingenStage = new Stage();
            instellingenStage.initOwner(this.view.getScene().getWindow());
            instellingenStage.initModality(Modality.APPLICATION_MODAL);

            InstellingenView instellingenView = new InstellingenView();
            InstellingenPresenter instellingenPresenter = new InstellingenPresenter(new Instelling(), instellingenView);

            Scene scene = new Scene(instellingenView);

            instellingenStage.setScene(scene);
            instellingenStage.setX(this.view.getScene().getX() + 100);
            instellingenStage.setY(this.view.getScene().getX() + 100);
            instellingenStage.setWidth(800);
            instellingenStage.setHeight(500);
            instellingenStage.setTitle("Instellingen");
            instellingenStage.showAndWait();
        });
    }
}
