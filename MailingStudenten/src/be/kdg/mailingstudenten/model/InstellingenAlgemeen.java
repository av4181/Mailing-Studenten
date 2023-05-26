package be.kdg.mailingstudenten.model;

import java.io.File;

public class InstellingenAlgemeen extends Instellingen {
    private String docentVoornaam;
    private String docentAchternaam;
    private String linkAfspraak;
    private String mailsAanmakenBestemming;

    public InstellingenAlgemeen() {
        this.docentVoornaam = preferences.get("docentVoornaam", "");
        this.docentAchternaam = preferences.get("docentAchternaam", "");
        this.linkAfspraak = preferences.get("linkAfspraak", "");
        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);
        this.mailsAanmakenBestemming = preferences.get("mailsAanmakenBestemming", userDirectory.getAbsolutePath());
    }

    @Override
    public void opslaan() {
        preferences.put("docentVoornaam", this.docentVoornaam);
        preferences.put("docentAchternaam", this.docentAchternaam);
        preferences.put("linkAfspraak", this.linkAfspraak);
        preferences.put("mailsAanmakenBestemming", this.mailsAanmakenBestemming);
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
        if (docentVoornaam == null || docentVoornaam.isBlank()) {
            throw new IllegalArgumentException("Docent voornaam kan niet leeg zijn.");
        }
        this.docentVoornaam = docentVoornaam;
    }

    public void setDocentAchternaam(String docentAchternaam) {
        if (docentVoornaam == null || docentAchternaam.isBlank()) {
            throw new IllegalArgumentException("Docent achternaam kan niet leeg zijn.");
        }
        this.docentAchternaam = docentAchternaam;
    }

    public void setLinkAfspraak(String linkAfspraak) {
        if (docentVoornaam == null || linkAfspraak.isBlank()) {
            throw new IllegalArgumentException("Link afspraak kan niet leeg zijn.");
        }
        this.linkAfspraak = linkAfspraak;
    }

    public void setMailsAanmakenBestemming(String mailsAanmakenBestemming) {
        if (docentVoornaam == null || mailsAanmakenBestemming.isBlank()) {
            throw new IllegalArgumentException("Mails aanmaken bestemming kan niet leeg zijn.");
        }
        this.mailsAanmakenBestemming = mailsAanmakenBestemming;
    }
}
