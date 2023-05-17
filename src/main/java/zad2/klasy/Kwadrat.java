package zad2.klasy;

public class Kwadrat implements Figura {
    private int bok;


    public Kwadrat(int bok) {
        this.bok = bok;
    }


    @Override
    public String toString() {
        return "Kwadrat{" +
                "bok=" + bok +
                '}';
    }

    @Override
    public double pole() {
        return bok*bok;
    }

    @Override
    public double obwod() {
        return 4*bok;
    }
}
