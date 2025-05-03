package tps.tp4.ejercicio2.archivo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManejoArchivador implements Archivador {
    @Override
    public List<String[]> guardarArchivo(String path) throws IOException, CsvValidationException {
        List<String[]> data = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(path));
        String[] row;

        while ((row = reader.readNext()) != null) {
            data.add(row);
        }
        return data;
    }

    @Override
    public List<Map<String, String>> where(Map<String, String> filtro) throws IOException {
        return List.of();
    }
}
