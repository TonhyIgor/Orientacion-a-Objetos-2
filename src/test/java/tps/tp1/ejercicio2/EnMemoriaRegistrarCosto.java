package tps.tp1.ejercicio2;

import tps.tp1.ejercicio2.persistencia.RegistrarCosto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EnMemoriaRegistrarCosto implements RegistrarCosto {
    private String data;

    @Override
    public void registrar(LocalDate fecha, float costo) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data = fecha.format(formato) + " || " + costo;
    }

    public String getData() {
        return this.data;
    }
}
