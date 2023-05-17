package zad1;

import zad1.klasy.Lekarz;
import zad1.klasy.Pacjent;
import zad1.klasy.Wizyta;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Lekarz> wczytajLekarzy() throws IOException {
        return Files.readAllLines(Paths.get("C:\\projekty\\zadania_48\\src\\main\\resources\\lekarze.txt"), StandardCharsets.ISO_8859_1)
                .stream()
                .skip(1)
                .map(i->i.split("\t"))
                .map(Lekarz::of)
                .collect(Collectors.toList());
    }

    public static List<Pacjent> wczytajPacjentow() throws IOException {
        return Files.readAllLines(Paths.get("C:\\projekty\\zadania_48\\src\\main\\resources\\pacjenci.txt"), StandardCharsets.ISO_8859_1)
                .stream()
                .skip(1)
                .map(i->i.split("\t"))
                .map(Pacjent::of)
                .collect(Collectors.toList());
    }

    public static List<Wizyta> wczytajWizyty() throws IOException {
        return Files.readAllLines(Paths.get("C:\\projekty\\zadania_48\\src\\main\\resources\\wizyty.txt"), StandardCharsets.ISO_8859_1)
                .stream()
                .skip(1)
                .map(i->i.split("\t"))
                .map(Wizyta::of)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) throws IOException {
        List<Wizyta> wizyty = wczytajWizyty();
//        wizyty.forEach(i -> System.out.println(i));

        List<Lekarz> lekarze = wczytajLekarzy();
//        lekarze.forEach(i -> System.out.println(i));
        for (Lekarz lekarz: lekarze) {
            wizyty.stream()
                    .filter(i-> Objects.equals(lekarz.getId(), i.getIdLekarza()))
                    .forEach(lekarz::dodajWizyte);
        }
        List<Pacjent> pacjenci = wczytajPacjentow();
//        pacjenci.forEach(i -> System.out.println(i));
        for (Pacjent pacjent: pacjenci) {
            wizyty.stream()
                    .filter(i-> Objects.equals(pacjent.getId(), i.getIdPacjenta()))
                    .forEach(pacjent::dodajWizyte);
        }


/*Wykorzystując informacje zawarte w plikach wykonaj następujące polecenia:
- znajdź lekarza ktory miał najwięcej wizyt
- znajdź pacjenta który miał najwięcej wizyt
- która specalizacja cieszy się największym ppowodzeniem?
- którego roku było najwięcej wizyt?
- wypisz top 5 najstarszych lekarzy
- zwroc pacientow ktorzy byli u minumum 5ciu roznych lekarzy
- zwroc lekarzy exclusive - czyli takich ktorzy przyjmowali tylko jednego pacjenta*/


        //- znajdź lekarza ktory miał najwięcej wizyt
        lekarze.stream()
                .max(Comparator.comparing(i->i.getWizyty().size()))
                .ifPresent(i-> System.out.printf("%s mial najwiecej wizyt (%d).%n", i, i.getWizyty().size()));

        //- znajdź pacjenta który miał najwięcej wizyt
        pacjenci.stream()
                .max(Comparator.comparing(i->i.getWizyty().size()))
                .ifPresent(i-> System.out.printf("%s mial najwiecej wizyt (%d).%n", i, i.getWizyty().size()));

        //która specalizacja cieszy się największym ppowodzeniem?
        Map<String, Long> specjalnosci = lekarze.stream()
                .collect(Collectors.groupingBy(Lekarz::getSpecjalnosc, Collectors.counting()));
        List<String> topSpecjalnosci = new ArrayList<>();
        Long counter = -1L;
        for (Map.Entry<String, Long> entry: specjalnosci.entrySet()) {

            if (entry.getValue() > counter) {
                topSpecjalnosci.clear();
                topSpecjalnosci.add(entry.getKey());
                counter = entry.getValue();
            } else if (entry.getValue().equals(counter)) {
                topSpecjalnosci.add(entry.getKey());
            }
        }
        System.out.printf("Najpopularniejsze specjalnosci to %s.%n", topSpecjalnosci);



        //którego roku było najwięcej wizyt?
        Map<Integer, Long> collect = wizyty.stream().collect(Collectors.groupingBy(i -> i.getDataWizyty().getYear(), Collectors.counting()));
        collect.entrySet().stream().max(Map.Entry.comparingByValue())
                .ifPresent(i -> System.out.printf("Najwiecej wizyt bylo w %s.%n", i.getKey()));

//        - wypisz top 5 najstarszych lekarzy
        lekarze.stream()
                .sorted(Comparator.comparing(Lekarz::getDataUrodzenia))
                .limit(5)
                .forEach(i-> System.out.println("Jeden z najstarszych lekarzy: " + i));

//        - zwroc pacientow ktorzy byli u minumum 5ciu roznych lekarzy
        pacjenci.stream()
                .filter(i->i.odwiedzeniLekarze().size() >= 5)
                .forEach(i-> System.out.printf("Pacjent %s byl u conajmniej 5 lekarzy.%n", i));

//        - zwroc lekarzy exclusive - czyli takich ktorzy przyjmowali tylko jednego pacjenta
        lekarze.stream()
                .filter(i->i.pacjenci().size() == 1)
                .forEach(i-> System.out.printf("Lekarz exclusie %s.%n", i));
    }
}
