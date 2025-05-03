package tps.tp4.ejercicio2.archivo;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Archivador {
    List<String[]> guardarArchivo(String path) throws IOException, CsvValidationException;

    List<Map<String, String>> where(Map<String, String> filtro) throws IOException;
}
