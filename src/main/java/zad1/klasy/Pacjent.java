package zad1.klasy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Pacjent {
    private Long id;
    private String imie;
    private String nazwisko;
    private String pesel;
    private LocalDate dataUrodzenia;
    private List<Wizyta> wizyty = new ArrayList<>();

    public static Pacjent of(String[] dane) {
        Pacjent pacjent = new Pacjent();
        pacjent.setId(Long.valueOf(dane[0]));
        pacjent.setImie(dane[1]);
        pacjent.setNazwisko(dane[2]);
        pacjent.setPesel(dane[3]);
        pacjent.setDataUrodzenia(LocalDate.parse(dane[4], DateTimeFormatter.ofPattern("yyyy-M-d")));
        return pacjent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public List<Wizyta> getWizyty() {
        return wizyty;
    }

    public void setWizyty(List<Wizyta> wizyty) {
        this.wizyty = wizyty;
    }

    public void dodajWizyte(Wizyta wizyta) {
        this.wizyty.add(wizyta);
    }

    public Set<Long> odwiedzeniLekarze() {
        return wizyty.stream()
                .map(Wizyta::getIdLekarza)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Pacjent{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                '}';
    }
}
