package tps.tp1.ejercicio1.persistencia;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ArchivoRegistrarInscripcion implements RegistrarInscripcion {
    private String path;

    public ArchivoRegistrarInscripcion(String path) {
        this.path = path;
    }

    @Override
    public void exportar(LocalDate fecha, String idParticipante, String idConcurso) {
        gestionarArchivo(formateo(fecha, idParticipante, idConcurso));
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

    private String formateo(LocalDate fechaInscripcion, String idParticipante, String idConcurso) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaInscripcion.format(formato);
        return fechaFormateada + ", " + idParticipante + ", " + idConcurso;
    }

/*
    final Path path = Paths.get("path/to/filename.txt");
    Files.write(path, Arrays.asList("New line to append"), StandardCharsets.UTF_8,
            Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
 */
}
