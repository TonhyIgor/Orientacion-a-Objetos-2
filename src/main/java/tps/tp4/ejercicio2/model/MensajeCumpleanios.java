package tps.tp4.ejercicio2.model;

import java.time.MonthDay;

public class MensajeCumpleanios {
    private RegistroEmpleados registroEmpleados;
    private Notificador notificar;

    public MensajeCumpleanios(RegistroEmpleados registroEmpleados, Notificador notificar) {
        this.registroEmpleados = registroEmpleados;
        this.notificar = notificar;
    }

    public void enviarSaludos(MonthDay fechaActual) {
        var empleados = this.registroEmpleados.empleados();
        for (Empleado empleado : empleados) {
            if (empleado.esTuCumple(fechaActual)) {
                this.notificar.enviarNotificacion(empleado.medioNotificacion());
            }
        }
    }
}
