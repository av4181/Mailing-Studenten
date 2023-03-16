package studenten.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    // csv file bevat de volgende kolommen:
    // email;voornaam;naam;rapportonderdeel;deelgroepcode;punt;puntcodeafk;exkansomschr;kansaandeel;experiodeomschr
    private String email;
    private String voornaam;
    private int naam;
    private String rapportonderdeel;
    private String deelgroepcode;
    private float punt;
    private String puntcodeafk;
    private String exkansomschr;
    private String kansaandeel;
    private String experiodeomschr;

    public Student(String email, String voornaam, int naam, String rapportonderdeel, String deelgroepcode,
                   float punt, String puntcodeafk, String exkansomschr, String kansaandeel, String experiodeomschr) {
        setEmail(email);
        setVoornaam(voornaam);
        setNaam(naam);
        setRapportonderdeel(rapportonderdeel);
        setDeelgroepcode(deelgroepcode);
        setPunt(punt);
        setPuntcodeafk(puntcodeafk);
        setExkansomschr(exkansomschr);
        setKansaandeel(kansaandeel);
        setExperiodeomschr(experiodeomschr);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public int getNaam() {
        return naam;
    }

    public void setNaam(int naam) {
        this.naam = naam;
    }

    public String getRapportonderdeel() {
        return rapportonderdeel;
    }

    public void setRapportonderdeel(String rapportonderdeel) {
        this.rapportonderdeel = rapportonderdeel;
    }

    public String getDeelgroepcode() {
        return deelgroepcode;
    }

    public void setDeelgroepcode(String deelgroepcode) {
        this.deelgroepcode = deelgroepcode;
    }

    public float getPunt() {
        return punt;
    }

    public void setPunt(float punt) {
        this.punt = punt;
    }

    public String getPuntcodeafk() {
        return puntcodeafk;
    }

    public void setPuntcodeafk(String puntcodeafk) {
        this.puntcodeafk = puntcodeafk;
    }

    public String getExkansomschr() {
        return exkansomschr;
    }

    public void setExkansomschr(String exkansomschr) {
        this.exkansomschr = exkansomschr;
    }

    public String getKansaandeel() {
        return kansaandeel;
    }

    public void setKansaandeel(String kansaandeel) {
        this.kansaandeel = kansaandeel;
    }

    public String getExperiodeomschr() {
        return experiodeomschr;
    }

    public void setExperiodeomschr(String experiodeomschr) {
        this.experiodeomschr = experiodeomschr;
    }
}