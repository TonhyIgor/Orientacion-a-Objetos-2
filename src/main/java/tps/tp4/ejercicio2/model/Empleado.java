package tps.tp4.ejercicio2.model;

import java.time.LocalDate;
import java.time.MonthDay;

import static java.time.MonthDay.from;

public class Empleado {
    private LocalDate fechaNacimiento;
    private String medioDeNotificacion;

    public Empleado(LocalDate fechaNacimiento, String medioDeNotificacion) {
        this.fechaNacimiento = fechaNacimiento;
        this.medioDeNotificacion = medioDeNotificacion;
    }

    public boolean esTuCumple(MonthDay fechaActual) {
        return from(this.fechaNacimiento).equals(fechaActual);
    }

    public String medioNotificacion() {
        return this.medioDeNotificacion;
    }
}
