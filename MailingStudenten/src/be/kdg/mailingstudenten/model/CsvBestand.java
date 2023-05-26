package be.kdg.mailingstudenten.model;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CsvBestand {
    private String pad;
    private String delimiter = ";";
    private Map<Student,ArrayList<Resultaat>> studentLijst ;

    public CsvBestand() {
        studentLijst = new HashMap<Student,ArrayList<Resultaat>>();
    }

    public void leesBestand() {
        this.studentLijst = new HashMap<>();
        try (final BufferedReader reader = new BufferedReader(new FileReader(new File(this.pad)))) {
            String line = reader.readLine();
            Student student;
            int teller = 0;
            while (line != null) {
                if(teller == 0) {
                    teller++;
                    line = reader.readLine();
                    continue;
                } else {
                    String[] fields = line.split(delimiter);
                    student = new Student(fields[0], fields[1], fields[2]);
                    Resultaat resultaat = new Resultaat(fields[3],
                            fields[4],
                            fields[5],
                            fields[6],
                            fields[7],
                            fields[8]
                    );
                    if (studentLijst.containsKey(student)) {
                        ArrayList<Resultaat> resultaten = studentLijst.get(student);
                        resultaten.add(resultaat);
                    } else {
                        ArrayList<Resultaat> resultaten = new ArrayList<>();
                        resultaten.add(resultaat);
                        studentLijst.put(student, resultaten);
                    }
                    line = reader.readLine();
                }
                teller++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudenten() {
        List<Student> studenten = new ArrayList<>();
        for (Map.Entry<Student, ArrayList<Resultaat>> entry: studentLijst.entrySet()) {
            Student student = entry.getKey();
            student.setResultaten(entry.getValue());
            studenten.add(student);
        }

        return studenten;
    }

    public List<CsvLijn> getAlleResultaten(){
        List<CsvLijn> results = studentLijst.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(resultaat -> new CsvLijn(entry.getKey(),resultaat)))
                .collect(Collectors.toList());
        return results;
    }

    public void setPad(String pad) {
        this.pad = pad;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
