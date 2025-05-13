package tps.tp4.ejercicio2.model;

import java.time.LocalDate;
import java.time.MonthDay;

import static java.time.MonthDay.from;

public class Empleado {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;

    public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public boolean esTuCumple(MonthDay fechaActual) {
        return from(this.fechaNacimiento).equals(fechaActual);
    }

    public String medioNotificacion() {
        return this.email;
    }
}
