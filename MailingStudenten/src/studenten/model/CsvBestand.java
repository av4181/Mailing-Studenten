package studenten.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class CsvBestand {
//    static String pad = "/test.csv";
//    static String delimiter = ",";
    private final InputStream inputStream;
//    private List<Student> studenten;
    private final ObservableList<Student> studenten
            = FXCollections.observableArrayList();

    public CsvBestand() {
        studenten = new ObservableList<Student>() {
            @Override
            public void addListener(ListChangeListener<? super Student> listChangeListener) {

            }

            @Override
            public void removeListener(ListChangeListener<? super Student> listChangeListener) {

            }

            @Override
            public boolean addAll(Student... students) {
                return false;
            }

            @Override
            public boolean setAll(Student... students) {
                return false;
            }

            @Override
            public boolean setAll(Collection<? extends Student> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Student... students) {
                return false;
            }

            @Override
            public boolean retainAll(Student... students) {
                return false;
            }

            @Override
            public void remove(int i, int i1) {

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
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Student> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Student student) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Student> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Student> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Student get(int index) {
                return null;
            }

            @Override
            public Student set(int index, Student element) {
                return null;
            }

            @Override
            public void add(int index, Student element) {

            }

            @Override
            public Student remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Student> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Student> listIterator(int index) {
                return null;
            }

            @Override
            public List<Student> subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public void addListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void removeListener(InvalidationListener invalidationListener) {

            }
        }
        inputStream = getClass().getResourceAsStream("/files/mailingstudenten.csv");
        leesCSV();
    }

    private void leesCSV() {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            Student student;
            while (line != null) {
                String[] tokens = line.split(";");
                student = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
                studenten.add(student);
                line = reader.readLine();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
