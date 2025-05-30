package tps.tp4.ejercicio3.data;

import com.opencsv.CSVReader;
import tps.tp4.ejercicio3.model.Concurso;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArchivoPersistenciaConcurso implements PersistenciaConcurso {
    private String path;

    public ArchivoPersistenciaConcurso(String path) {
        this.path = path;
    }

    private List<String[]> recuperarDatosCSV() {
        try {
            List<String[]> csvData = new ArrayList<String[]>();
            CSVReader reader = new CSVReader(new FileReader(path));
            String[] row = null;

            while ((row = reader.readNext()) != null) {
                csvData.add(row);
            }

            reader.close();
            csvData.remove(0);

            return csvData;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo acceder al archivo." + e);
        }
    }


    @Override
    public List<Concurso> obtenerConcurso() {
        List<String[]> concursosCSV = recuperarDatosCSV();
        List<Concurso> concursosRegistrados = new ArrayList<>();
        concursosCSV.stream().forEach(c -> {
            Concurso concurso = new Concurso(c[0], c[1], LocalDate.parse(c[2],
                    DateTimeFormatter.ofPattern("yyyy/MM/dd")), LocalDate.parse(c[3], DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            concursosRegistrados.add(concurso);
        });
        return concursosRegistrados;
    }
}
