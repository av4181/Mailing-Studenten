package be.kdg.mailingstudenten.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    // csv file bevat de volgende kolommen:
    // email;voornaam;naam;rapportonderdeel;deelgroepcode;punt;puntcodeafk;exkansomschr;kansaandeel;experiodeomschr
    // elke lijn is een student object, bij het inlezen van een csv worden telkens student objecten aangemaakt
    // waarbij elke gevonden waarde tussen ; op desbetreffende lijn als argument aan de Student constructor worden
    // gegeven.
    // Een student heeft een aantal unieke gegevens en daarnaast een lijst van resultaten

    private String email;
    private String voornaam;
    private String naam;
    private List<Resultaat> resultaten;

    public Student(String email, String voornaam, String naam) {
        setEmail(email);
        setVoornaam(voornaam);
        setNaam(naam);
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

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Resultaat> getResultaten() {
        return resultaten;
    }

    public void setResultaten(List<Resultaat> resultaten) {
        this.resultaten = resultaten;
    }

    public List<PeriodeResultaat> getPeriodeResultaten() {
        HashMap<String, ArrayList<Resultaat>> resultatenPerPeriode = new HashMap<>();
        for (Resultaat resultaat: this.resultaten) {
            if (resultatenPerPeriode.containsKey(resultaat.getPeriode())) {
                resultaten = resultatenPerPeriode.get(resultaat.getPeriode());
                resultaten.add(resultaat);
            } else {
                ArrayList<Resultaat> resultaten = new ArrayList<>();
                resultaten.add(resultaat);
                resultatenPerPeriode.put(resultaat.getPeriode(), resultaten);
            }
        }

        List<PeriodeResultaat> periodeResultaten = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Resultaat>> entry: resultatenPerPeriode.entrySet()) {
            PeriodeResultaat periodeResultaat = new PeriodeResultaat(this, entry.getKey(), entry.getValue());
            periodeResultaten.add(periodeResultaat);
        }
        return periodeResultaten;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Student))
            return false;
        Student other = (Student) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (voornaam == null) {
            if (other.voornaam != null)
                return false;
        } else if (!voornaam.equals(other.voornaam))
            return false;
        if (naam == null) {
            if (other.naam != null)
                return false;
        } else if (!naam.equals(other.naam))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((email == null) ? 0 : email.hashCode());
        result = prime * result
                + ((voornaam == null) ? 0 : voornaam.hashCode());
        result = prime * result
                + ((naam == null) ? 0 : naam.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", naam='" + naam +
                '}';
    }
}