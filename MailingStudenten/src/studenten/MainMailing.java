package studenten;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import studenten.model.Resultaat;
import studenten.view.CSVPane;
import studenten.view.Presenter;

public class MainMailing extends Application {

    // Visualiseer de ingelezen csv in een TableView
    // De tabelview bevat dus rijen van het type resultaat
    private final TableView<Resultaat> tableView = new TableView<>();
    private final ObservableList<Resultaat> dataList
            = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mailing Studenten");

        Group root = new Group();

        TableColumn column1 = new TableColumn("email");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        TableColumn column2 = new TableColumn("voornaam");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("voornaam"));

        TableColumn column3 = new TableColumn("naam");
        column3.setCellValueFactory(
                new PropertyValueFactory<>("naam"));

        TableColumn column4 = new TableColumn("rapportonderdeel");
        column4.setCellValueFactory(
                new PropertyValueFactory<>("rapportonderdeel"));

        TableColumn column5 = new TableColumn("deelgroepcode");
        column5.setCellValueFactory(
                new PropertyValueFactory<>("deelgroepcode"));

        TableColumn column6 = new TableColumn("punt");
        column6.setCellValueFactory(
                new PropertyValueFactory<>("punt"));

        TableColumn column7 = new TableColumn("puntcodeafk");
        column7.setCellValueFactory(
                new PropertyValueFactory<>("puntcodeafk"));

        TableColumn column8 = new TableColumn("exkansomschr");
        column8.setCellValueFactory(
                new PropertyValueFactory<>("exkansomschr"));

        TableColumn column9 = new TableColumn("kansaandeel");
        column9.setCellValueFactory(
                new PropertyValueFactory<>("kansaandeel"));

        TableColumn column10 = new TableColumn("examenperiodeomschr");
        column10.setCellValueFactory(
                new PropertyValueFactory<>("examenperiodeomschr"));


        tableView.setItems(dataList);
        tableView.getColumns().addAll(
                column1, column2, column3, column4, column5, column6, column7, column8, column9, column10);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().add(tableView);

        root.getChildren().add(vBox);

        primaryStage.setScene(new Scene(root, 700, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
