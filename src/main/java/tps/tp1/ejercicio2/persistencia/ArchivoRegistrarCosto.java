package tps.tp1.ejercicio2.persistencia;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ArchivoRegistrarCosto implements RegistrarCosto {
    private String path;

    public ArchivoRegistrarCosto(String path) {
        this.path = path;
    }

    @Override
    public void registrar(LocalDate fecha, float costo) {
        gestionarArchivo(formateo(fecha, costo));
    }

    private void gestionarArchivo(String data) {
        final Path path = Paths.get(this.path);
        try {
            Files.write(path, Arrays.asList(data), StandardCharsets.UTF_8,
                    Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear o acceder al archivo.");
        }
    }

    private String formateo(LocalDate fechaMonto, float monto) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaMonto.format(formato);
        return fechaFormateada + " || " + monto;
    }
}
