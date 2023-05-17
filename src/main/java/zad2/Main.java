package zad2;

import zad2.klasy.Figura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figura> figury = new ArrayList<>(Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10,20), Figura.stworzKwadrat(15)));
        for(Figura f : figury) {
            System.out.println(f);
        }

        for (Figura f: figury) {
            System.out.printf("Figura %s ma pole %.2f %n", f, f.pole());
            System.out.printf("Figura %s ma obwod %.2f %n", f, f.obwod());
        }

        // figura z najwiekszym polem
        figury.stream().max(Comparator.comparing(Figura::pole))
                .ifPresent(i-> System.out.printf("Najwieksze pole ma figura %s wynosi ono %.2f.%n", i, i.pole()));

        // figura z najwiekszym obwodem
        figury.stream().max(Comparator.comparing(Figura::obwod))
                .ifPresent(i-> System.out.printf("Najwiekszy obwod ma figura %s wynosi ono %.2f.%n", i, i.obwod()));
    }
}
