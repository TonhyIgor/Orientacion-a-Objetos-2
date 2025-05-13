package tps.tp4.ejercicio3.data;

import com.opencsv.CSVWriter;
import tps.tp4.ejercicio3.model.Participante;

import java.io.FileWriter;

public class ArchivoPersistenciaParticipante implements PersistenciaParticipante {
    private String path;

    public ArchivoPersistenciaParticipante(String path) {
        this.path = path;
    }

    /*private List<String[]> recuperarDatosCSV() {
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
    }*/

    private void grabarDatosCSV(String[] data) {
        try {
            FileWriter fw = new FileWriter(path, true);
            CSVWriter writer = new CSVWriter(fw);
            writer.writeNext(data);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo escribir en el archivo." + e);
        }
    }

    @Override
    public void registrarParticipante(Participante participanteNuevo, String idConcurso) {
        String[] data = new String[5];
        data[0] = participanteNuevo.apellido();
        data[1] = participanteNuevo.nombre();
        data[2] = participanteNuevo.telefono();
        data[3] = participanteNuevo.email();
        data[4] = idConcurso;

        grabarDatosCSV(data);
    }
}
