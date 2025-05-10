package tps.tp4.ejercicio2.Registro;

import tps.tp4.ejercicio2.model.Empleado;
import tps.tp4.ejercicio2.model.RegistroEmpleados;

import java.util.List;

public class ArchivoRegistroEmpleados implements RegistroEmpleados {
    @Override
    public List<Empleado> empleados() {
        //logica de la obtencion de los empleados a partir de un archivo
        return List.of();
    }
}
