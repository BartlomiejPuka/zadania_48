package zad1.klasy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Wizyta {
    private Long idLekarza;
    private Long idPacjenta;
    private LocalDate dataWizyty;

    public static Wizyta of(String[] dane) {
        Wizyta wizyta = new Wizyta();
        wizyta.setIdLekarza(Long.valueOf(dane[0]));
        wizyta.setIdPacjenta(Long.valueOf(dane[1]));
        wizyta.setDataWizyty(LocalDate.parse(dane[2], DateTimeFormatter.ofPattern("yyyy-M-d")));
        return wizyta;
    }

    public Long getIdLekarza() {
        return idLekarza;
    }

    public void setIdLekarza(Long idLekarza) {
        this.idLekarza = idLekarza;
    }

    public Long getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(Long idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public LocalDate getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(LocalDate dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    @Override
    public String toString() {
        return "Wizyta{" +
                "idLekarza=" + idLekarza +
                ", idPacjenta=" + idPacjenta +
                ", dataWizyty=" + dataWizyty +
                '}';
    }
}
