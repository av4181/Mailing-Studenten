package studenten.view.aanmakenmails.table;

import javafx.scene.control.*;
import javafx.scene.shape.Shape;
import studenten.model.PeriodeResultaat;

public class AanmakenMailsTableView extends TableView {
    private TableColumn<PeriodeResultaat, String> achternaamKolom;
    private TableColumn<PeriodeResultaat, String> voornaamKolom;
    private TableColumn<PeriodeResultaat, String> emailKolom;
    private TableColumn<PeriodeResultaat, String> puntKolom;
    private TableColumn<PeriodeResultaat, String> periodeKolom;
    private TableColumn<PeriodeResultaat, Shape> kleurCodeKolom;

    public AanmakenMailsTableView() {
        initialiseNodes();
    }

    private void initialiseNodes() {
        this.achternaamKolom = new TableColumn<>("Achternaam");
        this.voornaamKolom = new TableColumn<>("Voornaam");
        this.emailKolom = new TableColumn<>("Email");
        this.puntKolom = new TableColumn<>("Punt");
        this.periodeKolom = new TableColumn<>("Periode");
        this.kleurCodeKolom = new TableColumn<>("Kleurcode");

        this.getColumns().addAll(achternaamKolom, voornaamKolom, emailKolom, puntKolom, periodeKolom, kleurCodeKolom);
        this.setPlaceholder(new Label("Geen resultaten"));
    }

    TableColumn<PeriodeResultaat, String> getAchternaamKolom() {
        return achternaamKolom;
    }

    TableColumn<PeriodeResultaat, String> getVoornaamKolom() {
        return voornaamKolom;
    }

    TableColumn<PeriodeResultaat, String> getEmailKolom() {
        return emailKolom;
    }

    TableColumn<PeriodeResultaat, String> getPuntKolom() {
        return puntKolom;
    }

    TableColumn<PeriodeResultaat, String> getPeriodeKolom() {
        return periodeKolom;
    }

    TableColumn<PeriodeResultaat, Shape> getKleurCodeKolom() {
        return kleurCodeKolom;
    }
}
