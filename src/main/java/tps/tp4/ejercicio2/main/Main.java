package tps.tp4.ejercicio2.main;

import tps.tp4.ejercicio2.Registro.ArchivoRegistroEmpleados;
import tps.tp4.ejercicio2.model.MensajeCumpleanios;
import tps.tp4.ejercicio2.notificacion.EmailNotificador;

import java.time.MonthDay;

public class Main {
    public static void main(String[] args) {
        var email = new EmailNotificador();
        var registroEmpleados = new ArchivoRegistroEmpleados();
        new MensajeCumpleanios(registroEmpleados, email).enviarSaludos(MonthDay.now());
    }
}
