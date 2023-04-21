//package studenten;
//
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import studenten.model.CsvBestand;
//import studenten.model.Student;
//
//import java.util.ArrayList;
//
//public class MainMailing extends Application {
//
//    // Visualiseer de ingelezen csv in een TableView
//    // De tabelview bevat dus rijen van het type resultaat
//    private final TableView<Student> tableView = new TableView<Student>();
//
//
//    @Override
//    public void start(Stage primaryStage) {
//
//
//        primaryStage.setTitle("Mailing Studenten");
//
//
//
//        primaryStage.setScene(new Scene(root, 700, 250));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//
//        CsvBestand csv = new CsvBestand();
//        launch(args);
//    }
//}
