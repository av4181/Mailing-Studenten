package studenten.model;

import javafx.beans.property.SimpleStringProperty;

public class Resultaat {
    // veronderstel dat de csv file steeds 10 kolommen heeft per student, alle vakjes zijn Strings ?
    private SimpleStringProperty k1, k2, k3, k4, k5, k6, k7, k8, k9, k10;

    // Constructor
    public Resultaat(String k1, String k2,
                     String k3, String k4,
                     String k5, String k6,
                     String k7, String k8,
                     String k9, String k10) {
        this.k1 = new SimpleStringProperty(k1);
        this.k2 = new SimpleStringProperty(k2);
        this.k3 = new SimpleStringProperty(k3);
        this.k4 = new SimpleStringProperty(k4);
        this.k5 = new SimpleStringProperty(k5);
        this.k6 = new SimpleStringProperty(k6);
        this.k7 = new SimpleStringProperty(k7);
        this.k8 = new SimpleStringProperty(k8);
        this.k9 = new SimpleStringProperty(k9);
        this.k10 = new SimpleStringProperty(k10);
    }

    public String getK1() {
        return k1.get();
    }

    public SimpleStringProperty k1Property() {
        return k1;
    }

    public String getK2() {
        return k2.get();
    }

    public SimpleStringProperty k2Property() {
        return k2;
    }

    public String getK3() {
        return k3.get();
    }

    public SimpleStringProperty k3Property() {
        return k3;
    }

    public String getK4() {
        return k4.get();
    }

    public SimpleStringProperty k4Property() {
        return k4;
    }

    public String getK5() {
        return k5.get();
    }

    public SimpleStringProperty k5Property() {
        return k5;
    }

    public String getK6() {
        return k6.get();
    }

    public SimpleStringProperty k6Property() {
        return k6;
    }

    public String getK7() {
        return k7.get();
    }

    public SimpleStringProperty k7Property() {
        return k7;
    }

    public String getK8() {
        return k8.get();
    }

    public SimpleStringProperty k8Property() {
        return k8;
    }

    public String getK9() {
        return k9.get();
    }

    public SimpleStringProperty k9Property() {
        return k9;
    }

    public String getK10() {
        return k10.get();
    }

    public SimpleStringProperty k10Property() {
        return k10;
    }
}
