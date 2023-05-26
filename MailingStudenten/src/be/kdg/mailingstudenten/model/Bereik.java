package be.kdg.mailingstudenten.model;

public class Bereik {
    private int laag;

    private int hoog;

    public Bereik(int laag, int hoog) {
        if (laag > hoog) {
            throw new IllegalArgumentException("Startwaarde van bereik kan niet groter zijn dan eindwaarde.");
        }

        this.laag = laag;
        this.hoog = hoog;
    }

    public boolean isInBereik(int nummer) {
        return (nummer >= laag && nummer <= hoog);
    }

    public int getLaag() {
        return laag;
    }

    public int getHoog() {
        return hoog;
    }
}
