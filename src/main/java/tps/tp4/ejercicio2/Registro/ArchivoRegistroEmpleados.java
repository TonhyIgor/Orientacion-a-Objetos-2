package tps.tp4.ejercicio2.Registro;

import com.opencsv.CSVReader;
import tps.tp4.ejercicio2.model.Empleado;
import tps.tp4.ejercicio2.model.RegistroEmpleados;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArchivoRegistroEmpleados implements RegistroEmpleados {
    private String path;

    public ArchivoRegistroEmpleados(String path) {
        this.path = path;
    }

    private List<String[]> datosCSV() {
        try {
            List<String[]> csvData = new ArrayList<String[]>();
            CSVReader reader = new CSVReader(new FileReader(this.path));
            String[] row = null;

            while ((row = reader.readNext()) != null) {
                csvData.add(row);
            }

            reader.close();
            csvData.remove(0);

            return csvData;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo acceder al archivo.");
        }
    }

    @Override
    public List<Empleado> empleados() {
        List<String[]> empleadosCSV = datosCSV();
        List<Empleado> empleadosRegistrados = new ArrayList<>();

        empleadosCSV.stream().forEach(e -> {
            Empleado empleado = new Empleado(e[1], e[0], LocalDate.parse(e[2]), e[3]);
            empleadosRegistrados.add(empleado);
        });

        return empleadosRegistrados;
    }
}
