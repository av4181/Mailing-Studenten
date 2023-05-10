package studenten.model;

public class CsvLijn {
//    private String emailklm;
//    private String voornaamklm;
//    private String naamklm;
//    private String rapportonderdeelklm;
//    private String deelgroepCodeklm;
//    private String puntklm;
//    private String examenkansomschrijvingklm;
//    private String kansaandeelklm;
//    private String periodeklm;

    private Student student;
    private Resultaat resultaat;

    public CsvLijn(Student student, Resultaat resultaat) {
        this.student = student;
        this.resultaat = resultaat;
    }

    public Student getStudent() {
        return student;
    }

    public Resultaat getResultaat() {
        return resultaat;
    }
}