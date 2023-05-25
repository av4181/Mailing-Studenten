package be.kdg.mailingstudenten.model;

public class Resultaat {
    private String rapportonderdeel;
    private String deelgroepCode;
    private String punt;
    private String examenkansomschrijving;
    private String kansaandeel;
    private String periode;

    public Resultaat(String rapportonderdeel, String deelgroepCode, String punt, String examenkansomschrijving, String kansaandeel, String periode) {
        this.rapportonderdeel = rapportonderdeel;
        this.deelgroepCode = deelgroepCode;
        this.punt = punt;
        this.examenkansomschrijving = examenkansomschrijving;
        this.kansaandeel = kansaandeel;
        this.periode = periode;
    }

    public String getRapportonderdeel() {
        return rapportonderdeel;
    }

    public String getDeelgroepCode() {
        return deelgroepCode;
    }

    public Double getPunt() {
        if (this.punt.equals("NAANG") || this.punt.equals("--") || this.punt.equals("xx")) {
            return 0.00;
        } else {
            return Double.parseDouble(this.punt);
        }
    }
    public String getPuntString(){
        return punt;
    }

    public String getExamenkansomschrijving() {
        return examenkansomschrijving;
    }

    public String getKansaandeel() {
        return kansaandeel;
    }

    public String getPeriode() {
        return periode;
    }

    public boolean isGeslaagd() {
        return this.getPunt() >= 10;
    }
}
