package studenten.view.aanmakenmails.table;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import studenten.model.*;

public class UploadTableView extends TableView {

    private TableColumn<CsvLijn, String> emailKolom;
    private TableColumn<CsvLijn, String> voornaamKolom;
    private TableColumn<CsvLijn, String> naamKolom;
    private TableColumn<CsvLijn, String> rapportOnderdeelKolom;
    private TableColumn<CsvLijn, String> deelgroepCodeKolom;
    private TableColumn<CsvLijn, Double> puntKolom;
    private TableColumn<CsvLijn, String> examenkansOmschrijvingKolom;
    private TableColumn<CsvLijn, String> kansaandeelKolom;
    private TableColumn<CsvLijn, String> periodeKolom;

    public UploadTableView() {initialiseNodes();}

    private void initialiseNodes() {
        this.emailKolom = new TableColumn<>("Email");
        this.voornaamKolom = new TableColumn<>("Voornaam");
        this.naamKolom = new TableColumn<>("Naam");
        this.rapportOnderdeelKolom = new TableColumn<>("Rapportonderdeel");
        this.deelgroepCodeKolom = new TableColumn<>("Deelgroepcode");
//        this.puntKolom = new TableColumn<>("Punt");
        this.examenkansOmschrijvingKolom = new TableColumn<>("Examenkans omschrijving");
        this.kansaandeelKolom = new TableColumn<>("Kansaandeel");
        this.periodeKolom = new TableColumn<>("Periode");

        this.getColumns().addAll(emailKolom, voornaamKolom, naamKolom, rapportOnderdeelKolom, deelgroepCodeKolom, examenkansOmschrijvingKolom, kansaandeelKolom, periodeKolom);
    }

    TableColumn<CsvLijn, String> getEmailKolom() {
        return emailKolom;
    }

    TableColumn<CsvLijn, String> getVoornaamKolom() {
        return voornaamKolom;
    }

    TableColumn<CsvLijn, String> getNaamKolom() {
        return naamKolom;
    }

    TableColumn<CsvLijn, String> getRapportOnderdeelKolom() {
        return rapportOnderdeelKolom;
    }

    TableColumn<CsvLijn, String> getDeelgroepCodeKolom() {
        return deelgroepCodeKolom;
    }

    TableColumn<CsvLijn, Double> getPuntKolom() {
        return puntKolom;
    }

    TableColumn<CsvLijn, String> getExamenkansOmschrijvingKolom() {
        return examenkansOmschrijvingKolom;
    }

    TableColumn<CsvLijn, String> getKansaandeelKolom() {
        return kansaandeelKolom;
    }

    TableColumn<CsvLijn, String> getPeriodeKolom() {
        return periodeKolom;
    }
}
