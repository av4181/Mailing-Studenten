package studenten.model;

import java.io.*;
import java.util.*;

public class CsvBestand {
    public static final String pad = "/files/mailingstudenten.csv";
    public static final String delimiter = ";";

    private Map<Student,ArrayList<Resultaat>> studentLijst ;
    private List<Student> studenten;
    private final InputStream inputStream;

    public CsvBestand() {
        studentLijst = new HashMap<Student,ArrayList<Resultaat>>();
        studenten = new ArrayList<>();
        inputStream = getClass().getResourceAsStream(pad);
        leesBestand();

    }

    public void leesBestand() {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            Student student;
            Resultaat resultaat;
            int teller = 0;
            String[] kolommen;
            while (line != null) {
                if(teller==0) {
                    String[] l = line.split(";");
                    kolommen = new String[l.length - 1];
                    for (int i = 0; i < l.length - 1; i++) {
                        kolommen[i] = l[i + 1];
                    }
                }
                    else{
                        String[] fields = line.split(delimiter);
                        student = new Student(fields[0], fields[1], fields[2]);
                        resultaat = new Resultaat(fields[3],
                                fields[4],
                                fields[5],
                                fields[6],
                                fields[7],
                                fields[8]);
                        studentLijst.put(student,new ArrayList<Resultaat>());
                        studentLijst.get(student).add(resultaat);
                        line = reader.readLine();
                    }
                    teller++;
                }
            }

        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Student, ArrayList<Resultaat>> getStudentLijst() {
        return studentLijst;
    }
}
