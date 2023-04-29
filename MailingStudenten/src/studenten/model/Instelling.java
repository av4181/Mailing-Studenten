package studenten.model;

public class Instelling {
    private String docentVoornaam;
    private String docentAchternaam;
    private String linkAfspraak;

    public Instelling(String docentVoornaam, String docentAchternaam, String linkAfspraak) {
        this.docentVoornaam = docentVoornaam;
        this.docentAchternaam = docentAchternaam;
        this.linkAfspraak = linkAfspraak;
    }

    public String getDocentVoornaam() {
        return docentVoornaam;
    }

    public String getDocentAchternaam() {
        return docentAchternaam;
    }

    public String getLinkAfspraak() {
        return linkAfspraak;
    }

    public void setDocentVoornaam(String docentVoornaam) {
        this.docentVoornaam = docentVoornaam;
    }

    public void setDocentAchternaam(String docentAchternaam) {
        this.docentAchternaam = docentAchternaam;
    }

    public void setLinkAfspraak(String linkAfspraak) {
        this.linkAfspraak = linkAfspraak;
    }
}
