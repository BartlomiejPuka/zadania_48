package zad2.klasy;

public class Kolo implements Figura {

    private int r;

    public Kolo(int r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Kolo{" +
                "r=" + r +
                '}';
    }

    @Override
    public double pole() {
        return Math.PI * r * r;
    }

    @Override
    public double obwod() {
        return 2 * Math.PI * r;
    }
}
