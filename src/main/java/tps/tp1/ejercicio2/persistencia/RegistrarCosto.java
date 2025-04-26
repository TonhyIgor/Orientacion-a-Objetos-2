package tps.tp1.ejercicio2.persistencia;

import java.time.LocalDate;

public interface RegistrarCosto {
    void registrar(LocalDate fecha, float costo);
}
