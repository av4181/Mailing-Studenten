package studenten;

import studenten.model.CsvBestand;
import studenten.model.Resultaat;
import studenten.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvBestand csv = new CsvBestand();
        csv.leesBestand();


        System.out.println(csv.getStudentLijst());
    }

}