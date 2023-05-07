package studenten.view.aanmakenmails.table;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.shape.Shape;
import studenten.model.CsvBestand;
import studenten.model.PeriodeResultaat;
import studenten.model.Resultaat;
import studenten.model.Student;

public class UploadTableView extends TableView {

    private TableColumn<CsvBestand, String> emailklm;
    private TableColumn<CsvBestand, String> voornaamklm;
    private TableColumn<CsvBestand, String> naamklm;
    private TableColumn<CsvBestand, String> rapportonderdeelklm;
    private TableColumn<CsvBestand, String> deelgroepCodeklm;
    private TableColumn<CsvBestand, String> puntklm;
    private TableColumn<CsvBestand, String> examenkansomschrijvingklm;
    private TableColumn<CsvBestand, String> kansaandeelklm;
    private TableColumn<CsvBestand, String> periodeklm;

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

    public TableColumn<CsvBestand, String> getEmailklm() {
        return emailklm;
    }

    public TableColumn<CsvBestand, String> getVoornaamklm() {
        return voornaamklm;
    }

    public TableColumn<CsvBestand, String> getNaamklm() {
        return naamklm;
    }

    public TableColumn<CsvBestand, String> getRapportonderdeelklm() {
        return rapportonderdeelklm;
    }

    public TableColumn<CsvBestand, String> getDeelgroepCodeklm() {
        return deelgroepCodeklm;
    }

    public TableColumn<CsvBestand, String> getPuntklm() {
        return puntklm;
    }

    public TableColumn<CsvBestand, String> getExamenkansomschrijvingklm() {
        return examenkansomschrijvingklm;
    }

    public TableColumn<CsvBestand, String> getKansaandeelklm() {
        return kansaandeelklm;
    }

    public TableColumn<CsvBestand, String> getPeriodeklm() {
        return periodeklm;
    }
}
