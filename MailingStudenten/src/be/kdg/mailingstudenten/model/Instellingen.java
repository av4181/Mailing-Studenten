package be.kdg.mailingstudenten.model;

import java.util.prefs.Preferences;

public abstract class Instellingen {
    protected Preferences preferences;

    public Instellingen() {
        this.preferences = Preferences.userRoot().node(this.getClass().getName());
    }

    public abstract void opslaan();
}
