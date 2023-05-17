package zad2.klasy;

public interface Figura {
    static Figura stworzKwadrat(int i) {
        return new Kwadrat(i);
    }

    static Figura stworzKolo(int i) {
        return new Kolo(i);
    }

    static Figura stworzProstokat(int i, int i1) {
        return new Prostokat(i, i1);
    }

    double pole();
    double obwod();
}
