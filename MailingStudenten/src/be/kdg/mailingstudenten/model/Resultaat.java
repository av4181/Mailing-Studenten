package be.kdg.mailingstudenten.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Resultaat implements Map<Student, ArrayList<Resultaat>> {
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

    @Override
    public String toString() {
        return "Resultaat{" +
                "rapportonderdeel='" + rapportonderdeel + '\'' +
                ", deelgroepCode='" + deelgroepCode + '\'' +
                ", punt='" + punt + '\'' +
                ", examenkansomschrijving='" + examenkansomschrijving + '\'' +
                ", kansaandeel='" + kansaandeel + '\'' +
                ", periode='" + periode + '\'' +
                '}';
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public ArrayList<Resultaat> get(Object key) {
        return null;
    }

    @Override
    public ArrayList<Resultaat> put(Student key, ArrayList<Resultaat> value) {
        return null;
    }

    @Override
    public ArrayList<Resultaat> remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends Student, ? extends ArrayList<Resultaat>> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Student> keySet() {
        return null;
    }

    @Override
    public Collection<ArrayList<Resultaat>> values() {
        return null;
    }

    @Override
    public Set<Entry<Student, ArrayList<Resultaat>>> entrySet() {
        return null;
    }
}
