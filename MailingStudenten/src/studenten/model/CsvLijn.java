package studenten.model;

public class CsvLijn {
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