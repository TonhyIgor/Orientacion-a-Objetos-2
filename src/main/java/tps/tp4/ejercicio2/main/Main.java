package tps.tp4.ejercicio2.main;

import tps.tp4.ejercicio2.Registro.ArchivoRegistroEmpleados;
import tps.tp4.ejercicio2.model.MensajeCumpleanios;
import tps.tp4.ejercicio2.notificacion.EmailNotificador;

import java.time.MonthDay;

public class Main {
    private static final String PATH_EMPLEADOS = "/home/tonhy/empleados.txt";

    public static void main(String[] args) {
        var email = new EmailNotificador("concurso@gestion.com");
        var registroEmpleados = new ArchivoRegistroEmpleados(PATH_EMPLEADOS);
        new MensajeCumpleanios(registroEmpleados, email).enviarSaludos(MonthDay.now());
    }
}
