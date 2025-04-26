package org.example;

import tps.tp0.TiempoAnemico;
import tps.tp0.TiempoNoAnemico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        LocalDateTime hoy = LocalDateTime.now();

        //NO ANEMICO
        TiempoNoAnemico actualNoAnemico = new TiempoNoAnemico();
        actualNoAnemico.fechaFormatoLargo();
        actualNoAnemico.fechaFormatoCorto();

        //ANEMICO
        TiempoAnemico actualAnemico = new TiempoAnemico(hoy);

        System.out.println(actualAnemico.getActual().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(actualAnemico.getActual().format(DateTimeFormatter.ofPattern("dd/MM/yy")));

    }
}