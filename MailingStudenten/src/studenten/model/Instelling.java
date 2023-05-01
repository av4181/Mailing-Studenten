package studenten.model;

import java.util.prefs.Preferences;

public class Instelling {
    private Preferences preferences;

    public Instelling() {
        this.preferences = Preferences.userRoot().node(this.getClass().getName());
    }

    public String getDocentVoornaam() {
        return preferences.get("docentVoornaam", "");
    }

    public String getDocentAchternaam() {
        return preferences.get("docentAchternaam", "");
    }

    public String getLinkAfspraak() {
        return preferences.get("linkAfspraak", "");
    }

    public void opslaan() {
        Preferences preferences = Preferences.userRoot().node(this.getClass().getName());
        preferences.put("docentVoornaam", "test");
        preferences.put("docentAchternaam", "test");
        preferences.put("linkAfspraak", "test");
    }

    public void setDocentVoornaam(String docentVoornaam) {
        preferences.put("docentVoornaam", docentVoornaam);
    }

    public void setDocentAchternaam(String docentAchternaam) {
        preferences.put("docentAchternaam", docentAchternaam);
    }

    public void setLinkAfspraak(String linkAfspraak) {
        preferences.put("linkAfspraak", linkAfspraak);
    }
}
