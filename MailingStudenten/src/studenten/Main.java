package studenten;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import studenten.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
//    public static void main(String[] args) {
//        CsvBestand csv = new CsvBestand();
//        csv.leesBestand();
//
//        List<Student> studenten = csv.getStudenten();
//
//
////
////        Instelling instelling = new Instelling();
////
////        instelling.opslaan();
////
////        for (Student student: studenten) {
////            for (PeriodeResultaat periodeResultaat: student.getPeriodeResultaten()) {
////                MailTemplate mailTemplate = MailTemplate.voorPeriodeResultaat(periodeResultaat, instelling);
////                Mail mail = new Mail(student.getEmail(), mailTemplate);
////
////                mail.opslaan();
////            }
////        }
//    }

    @Override
    public void start(Stage stage) throws Exception {
                CsvBestand csv = new CsvBestand();
        csv.leesBestand();

        List<Student> studenten = csv.getStudenten();

        Instelling instelling = new Instelling();

        instelling.opslaan();

        for (Student student: studenten) {
            for (PeriodeResultaat periodeResultaat: student.getPeriodeResultaten()) {
                MailTemplate mailTemplate = MailTemplate.voorPeriodeResultaat(periodeResultaat, instelling);
                Mail mail = new Mail(student.getEmail(), mailTemplate);

                mail.opslaan();
            }
        }


        List<PeriodeResultaat> periodeResultaten = new ArrayList<>();
        for (Student student: studenten) {
            periodeResultaten.addAll(student.getPeriodeResultaten());
        }


        BorderPane generalPane = new BorderPane();

        Menu menu = new Menu("Instellingen");
        MenuItem instellingenMenuItem = new MenuItem("Instellingen");
        instellingenMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage instellingenStage = new Stage();
                instellingenStage.initOwner(generalPane.getScene().getWindow());
                instellingenStage.initModality(Modality.APPLICATION_MODAL);

                GridPane test = new GridPane();

                HBox docentVoornaam = new HBox();
                Label docentVoornaamLabel = new Label("Docent voornaam");
                TextField docentVoornaamInput = new TextField();
                docentVoornaamInput.setMinWidth(500);
                docentVoornaam.getChildren().addAll(docentVoornaamLabel, docentVoornaamInput);

                HBox docentAchternaam = new HBox();
                Label docentAchternaamLabel = new Label("Docent achternaam");
                TextField docentAchternaamInput = new TextField();
                docentAchternaamInput.setMinWidth(500);
                docentAchternaam.getChildren().addAll(docentAchternaamLabel, docentAchternaamInput);

                HBox linkAfspraak = new HBox();
                Label linkAfspraakLabel = new Label("Link afspraak");
                TextField linkAfspraakInput = new TextField();
                linkAfspraakInput.setMinWidth(500);
                linkAfspraak.getChildren().addAll(linkAfspraakLabel, linkAfspraakInput);

                Button instellingenOpslaanKnop = new Button("Opslaan");


                test.add(docentVoornaamLabel, 0, 0);
                test.add(docentVoornaamInput, 1, 0);
                test.add(docentAchternaamLabel, 0, 1);
                test.add(docentAchternaamInput, 1, 1);
                test.add(linkAfspraakLabel, 0, 2);
                test.add(linkAfspraakInput, 1, 2);
                test.add(instellingenOpslaanKnop, 0, 3);

                test.setHgap(10);
                test.setVgap(10);

                test.setPadding(new Insets(20, 10, 10, 10));

                TabPane tab = new TabPane();
                Tab tabAlgemeen = new Tab("Algemeen", test);
                tabAlgemeen.setClosable(false);
                tab.getTabs().add(tabAlgemeen);

                Scene scene = new Scene(tab);

                instellingenStage.setScene(scene);
                instellingenStage.setX(generalPane.getScene().getX() + 100);
                instellingenStage.setY(generalPane.getScene().getX() + 100);
                instellingenStage.setWidth(800);
                instellingenStage.setHeight(500);
                instellingenStage.setTitle("Instellingen");
                instellingenStage.showAndWait();
            }
        });

        menu.getItems().addAll(instellingenMenuItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        generalPane.setTop(menuBar);

        TableView table = new TableView();
        TableColumn<PeriodeResultaat, String> achternaamKolom = new TableColumn("Achternaam");
        achternaamKolom.setCellValueFactory(periodeResultaat -> new SimpleStringProperty(periodeResultaat.getValue().getStudent().getNaam()));

        TableColumn<PeriodeResultaat, String> voornaamKolom = new TableColumn("Voornaam");
        voornaamKolom.setCellValueFactory(periodeResultaat -> new SimpleStringProperty(periodeResultaat.getValue().getStudent().getVoornaam()));

        TableColumn<PeriodeResultaat, String> emailKolom = new TableColumn("Email");
        emailKolom.setCellValueFactory(periodeResultaat -> new SimpleStringProperty(periodeResultaat.getValue().getStudent().getEmail()));

        TableColumn<PeriodeResultaat, String> puntKolom = new TableColumn("Punt");
        puntKolom.setCellValueFactory(periodeResultaat -> new SimpleStringProperty(String.format("%.2f", periodeResultaat.getValue().berekenGemiddelde())));

        TableColumn<PeriodeResultaat, String> periodeKolom = new TableColumn("Periode");
        periodeKolom.setCellValueFactory(periodeResultaat -> new SimpleStringProperty(periodeResultaat.getValue().getPeriode()));

        TableColumn<PeriodeResultaat, Shape> kleurCodeKolom = new TableColumn("Kleurcode");
        kleurCodeKolom.setCellValueFactory(new Callback<>() {
            @Override
            public ObservableValue<Shape> call(TableColumn.CellDataFeatures<PeriodeResultaat, Shape> periodeResultaatShapeCellDataFeatures) {
                Rectangle rect = new Rectangle(30, 10, 10, 10);
                if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.GROEN) {
                    rect.setFill(Color.GREEN);
                } else if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.GEEL) {
                    rect.setFill(Color.YELLOW);
                } else if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.ORANJE) {
                    rect.setFill(Color.ORANGE);
                } else if (periodeResultaatShapeCellDataFeatures.getValue().bepaalKleurCode() == PeriodeResultaat.KleurCode.ROOD) {
                    rect.setFill(Color.RED);
                }
                return new SimpleObjectProperty<>(rect);
            }
        });

        table.getColumns().addAll(achternaamKolom, voornaamKolom, emailKolom, puntKolom, periodeKolom, kleurCodeKolom);
        table.setPlaceholder(new Label("Geen resultaten"));

        table.getItems().addAll(periodeResultaten);

        Button createMailsButton = new Button("Aanmaken mails");
        BorderPane borderPane = new BorderPane();
        borderPane.setRight(createMailsButton);

        HBox kleurCodeFilterElement = new HBox();
        kleurCodeFilterElement.setSpacing(5);
        Label kleurCodeFilterOptiesLabel = new Label("Status");
        ChoiceBox kleurCodeFilterOpties = new ChoiceBox();
        kleurCodeFilterOpties.getItems().add("Groen");
        kleurCodeFilterOpties.getItems().add("Geel");
        kleurCodeFilterOpties.getItems().add("Oranje");
        kleurCodeFilterOpties.getItems().add("Rood");
        kleurCodeFilterElement.getChildren().addAll(kleurCodeFilterOptiesLabel, kleurCodeFilterOpties);

        HBox sorteerElement = new HBox();
        sorteerElement.setSpacing(5);
        Label sorteerOptiesLabel = new Label("Sorteren op");
        ChoiceBox sorteerOpties = new ChoiceBox();
        sorteerOpties.getItems().add("Alfabet");
        sorteerOpties.getItems().add("Gemiddelde");
        sorteerElement.getChildren().addAll(sorteerOptiesLabel, sorteerOpties);
        BorderPane borderPane2 = new BorderPane();
        borderPane2.setLeft(kleurCodeFilterElement);
        borderPane2.setRight(sorteerElement);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(borderPane2, table, borderPane);

        TabPane tabPane = new TabPane();

        Tab tab2 = new Tab("Upload bestand");
        tab2.setClosable(false);
        Tab tab1 = new Tab("Aanmaken mails", vbox);
        tab1.setClosable(false);

        tabPane.getTabs().addAll(tab2, tab1);

        generalPane.setCenter(tabPane);

        Scene scene = new Scene(generalPane);

        stage.setScene(scene);

        stage.setTitle("MailStudenten");
        stage.setWidth(1920);
        stage.setHeight(1080);
        stage.setResizable(true);
        stage.show();
    }
}
