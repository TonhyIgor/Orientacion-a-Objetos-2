package tps.tp1.ejercicio1;

import tps.tp1.ejercicio1.persistencia.RegistrarInscripcion;

import java.time.LocalDate;

public class EnMemoriaRegistrarInscripcion implements RegistrarInscripcion {
    private String data;

    @Override
    public void exportar(LocalDate fecha, String idParticipante, String idConcurso) {
        this.data = fecha.toString() + ", " + idParticipante + ", " + idConcurso;
    }

    public String getData() {
        return this.data;
    }
}
