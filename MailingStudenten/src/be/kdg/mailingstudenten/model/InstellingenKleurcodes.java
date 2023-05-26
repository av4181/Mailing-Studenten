package be.kdg.mailingstudenten.model;

public class InstellingenKleurcodes extends Instellingen {
    private Bereik bereikGroen;
    private Bereik bereikGeel;
    private Bereik bereikOranje;

    public InstellingenKleurcodes() {
        this.bereikGroen = new Bereik(preferences.getInt("groenVanaf", 0), preferences.getInt("groenTotEnMet", 0));
        this.bereikGeel = new Bereik(preferences.getInt("geelVanaf", 1), preferences.getInt("geelTotEnMet", 1));
        this.bereikOranje = new Bereik(preferences.getInt("oranjeVanaf", 2), preferences.getInt("oranjeTotEnMet", 2));
    }

    @Override
    public void opslaan() throws InstellingenKleurcodeException {
        if ((bereikGeel.getLaag() - bereikGroen.getHoog()) != 1 || (bereikOranje.getLaag() - bereikGeel.getHoog()) != 1) {
            throw new InstellingenKleurcodeException("Er kunnen geen gaten zijn tussen de verschillende kleurcodes.");
        }

        preferences.putInt("groenVanaf", this.bereikGroen.getLaag());
        preferences.putInt("groenTotEnMet", this.bereikGroen.getHoog());
        preferences.putInt("geelVanaf", this.bereikGeel.getLaag());
        preferences.putInt("geelTotEnMet", this.bereikGeel.getHoog());
        preferences.putInt("oranjeVanaf", this.bereikOranje.getLaag());
        preferences.putInt("oranjeTotEnMet", this.bereikOranje.getHoog());
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

    public void setBereikGroen(Bereik bereikGroen) {
        this.bereikGroen = bereikGroen;
    }

    public void setBereikGeel(Bereik bereikGeel) {
        this.bereikGeel = bereikGeel;
    }

    public void setBereikOranje(Bereik bereikOranje) {
        this.bereikOranje = bereikOranje;
    }
}
