package studenten.model;

import java.io.File;
import java.util.prefs.Preferences;

public class Instelling {
    private String docentVoornaam;
    private String docentAchternaam;
    private String linkAfspraak;
    private String mailsAanmakenBestemming;
    private Bereik bereikGroen;
    private Bereik bereikGeel;
    private Bereik bereikOranje;

    private Bereik bereikRood;

    public Instelling() {
        Preferences preferences = Preferences.userRoot().node(this.getClass().getName());
        this.docentVoornaam = preferences.get("docentVoornaam", "");
        this.docentAchternaam = preferences.get("docentAchternaam", "");
        this.linkAfspraak = preferences.get("linkAfspraak", "");
        this.bereikGroen = new Bereik(preferences.getInt("groenVanaf", 0), preferences.getInt("groenTotEnMet", 0));
        this.bereikGeel = new Bereik(preferences.getInt("geelVanaf", 0), preferences.getInt("geelTotEnMet", 0));
        this.bereikOranje = new Bereik(preferences.getInt("oranjeVanaf", 0), preferences.getInt("oranjeTotEnMet", 0));
        this.bereikRood = new Bereik(preferences.getInt("roodVanaf", 0), preferences.getInt("roodTotEnMet", 0));

        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);
        this.mailsAanmakenBestemming = preferences.get("mailsAanmakenBestemming", userDirectory.getAbsolutePath());
    }

    public void opslaan() {
        Preferences preferences = Preferences.userRoot().node(this.getClass().getName());
        preferences.put("docentVoornaam", this.docentVoornaam);
        preferences.put("docentAchternaam", this.docentAchternaam);
        preferences.put("linkAfspraak", this.linkAfspraak);
        preferences.put("mailsAanmakenBestemming", this.mailsAanmakenBestemming);

        preferences.putInt("groenVanaf", this.bereikGroen.getLaag());
        preferences.putInt("groenTotEnMet", this.bereikGroen.getHoog());
        preferences.putInt("geelVanaf", this.bereikGeel.getLaag());
        preferences.putInt("geelTotEnMet", this.bereikGeel.getHoog());
        preferences.putInt("oranjeVanaf", this.bereikOranje.getLaag());
        preferences.putInt("oranjeTotEnMet", this.bereikOranje.getHoog());
        preferences.putInt("roodVanaf", this.bereikRood.getLaag());
        preferences.putInt("roodTotEnMet", this.bereikRood.getHoog());
    }

    public String getDocentVoornaam() {
        return this.docentVoornaam;
    }

    public String getDocentAchternaam() {
        return this.docentAchternaam;
    }

    public String getLinkAfspraak() {
        return this.linkAfspraak;
    }

    public String getMailsAanmakenBestemming() {
        return this.mailsAanmakenBestemming;
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

    public void setMailsAanmakenBestemming(String mailsAanmakenBestemming) {
        this.mailsAanmakenBestemming = mailsAanmakenBestemming;
    }

    public Bereik getBereikGroen() {
        return bereikGroen;
    }

    public Bereik getBereikGeel() {
        return bereikGeel;
    }

    public Bereik getBereikOranje() {
        return bereikOranje;
    }

    public Bereik getBereikRood() {
        return bereikRood;
    }

    public void setBereikGroen(Bereik bereikGroen) {
        this.bereikGroen = bereikGroen;
    }

    public void setBereikGeel(Bereik bereikGeel) {
        this.bereikGeel = bereikGeel;
    }

    public void setBereikOranje(Bereik bereikOranje) {
        this.bereikOranje = bereikOranje;
    }

    public void setBereikRood(Bereik bereikRood) {
        this.bereikRood = bereikRood;
    }
}
