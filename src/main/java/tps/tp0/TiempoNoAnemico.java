package tps.tp0;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TiempoNoAnemico {
    private LocalDateTime actual;

    public TiempoNoAnemico() {
        this.actual = LocalDateTime.now();
    }

    public void fechaFormatoLargo() {
        System.out.println(this.actual.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    }

    public void fechaFormatoCorto() {
        System.out.println(this.actual.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
    }
}
