package zad1.klasy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lekarz {
    private Long id;
    private String nazwisko;
    private String imie;
    private String specjalnosc;
    private LocalDate dataUrodzenia;
    private String nip;
    private String pesel;
    private List<Wizyta> wizyty = new ArrayList<>();

    public static Lekarz of(String[] dane) {
        Lekarz lekarz = new Lekarz();
        lekarz.setId(Long.valueOf(dane[0]));
        lekarz.setNazwisko(dane[1]);
        lekarz.setImie(dane[2]);
        lekarz.setSpecjalnosc(dane[3]);
        lekarz.setDataUrodzenia(LocalDate.parse(dane[4], DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        lekarz.setNip(dane[5]);
        lekarz.setPesel(dane[6]);
        return lekarz;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getSpecjalnosc() {
        return specjalnosc;
    }

    public void setSpecjalnosc(String specjalnosc) {
        this.specjalnosc = specjalnosc;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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

    public Set<Long> pacjenci() {
        return wizyty.stream().map(Wizyta::getIdPacjenta)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Lekarz{" +
                "id=" + id +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", specjalnosc='" + specjalnosc + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", nip='" + nip + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
