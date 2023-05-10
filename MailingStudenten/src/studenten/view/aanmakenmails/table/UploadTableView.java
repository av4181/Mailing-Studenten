package studenten.view.aanmakenmails.table;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.shape.Shape;
import studenten.model.*;

public class UploadTableView extends TableView {

    private TableColumn<CsvLijn, String> emailklm;
    private TableColumn<CsvLijn, String> voornaamklm;
    private TableColumn<CsvLijn, String> naamklm;
    private TableColumn<CsvLijn, String> rapportonderdeelklm;
    private TableColumn<CsvLijn, String> deelgroepCodeklm;
    private TableColumn<CsvLijn, Double> puntklm;
    private TableColumn<CsvLijn, String> examenkansomschrijvingklm;
    private TableColumn<CsvLijn, String> kansaandeelklm;
    private TableColumn<CsvLijn, String> periodeklm;

    public UploadTableView() {initialiseNodes();}

    private void initialiseNodes() {
        this.emailklm = new TableColumn<>("Email");
        this.voornaamklm = new TableColumn<>("Voornaam");
        this.naamklm = new TableColumn<>("Naam");
        this.rapportonderdeelklm = new TableColumn<>("RapportOnderdeel");
        this.deelgroepCodeklm = new TableColumn<>("DeelgroepCode");
        this.puntklm = new TableColumn<>("Punt");
        this.examenkansomschrijvingklm = new TableColumn<>("ExamenkansOmschrijving");
        this.kansaandeelklm = new TableColumn<>("Kansaandeel");
        this.periodeklm = new TableColumn<>("Periode");

        this.getColumns().addAll(emailklm, voornaamklm, naamklm, rapportonderdeelklm, deelgroepCodeklm,
                puntklm,examenkansomschrijvingklm,kansaandeelklm,periodeklm);
    }

    public TableColumn<CsvLijn, String> getEmailklm() {
        return emailklm;
    }

    public TableColumn<CsvLijn, String> getVoornaamklm() {
        return voornaamklm;
    }

    public TableColumn<CsvLijn, String> getNaamklm() {
        return naamklm;
    }

    public TableColumn<CsvLijn, String> getRapportonderdeelklm() {
        return rapportonderdeelklm;
    }

    public TableColumn<CsvLijn, String> getDeelgroepCodeklm() {
        return deelgroepCodeklm;
    }

    public TableColumn<CsvLijn, Double> getPuntklm() {
        return puntklm;
    }

    public TableColumn<CsvLijn, String> getExamenkansomschrijvingklm() {
        return examenkansomschrijvingklm;
    }

    public TableColumn<CsvLijn, String> getKansaandeelklm() {
        return kansaandeelklm;
    }

    public TableColumn<CsvLijn, String> getPeriodeklm() {
        return periodeklm;
    }
}
