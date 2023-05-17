package zad2.klasy;

public class Prostokat implements Figura{

    private int boka;
    private int bokb;

    public Prostokat(int boka, int bokb) {
        this.boka = boka;
        this.bokb = bokb;
    }

    @Override
    public double pole() {
        return boka*bokb;
    }

    @Override
    public double obwod() {
        return 2*bokb + 2*boka;
    }

    @Override
    public String toString() {
        return "Prostokat{" +
                "boka=" + boka +
                ", bokb=" + bokb +
                '}';
    }
}
