package tps.tp1.ejercicio1.persistencia;

import java.time.LocalDate;

public interface RegistrarInscripcion {
    void exportar(LocalDate fecha, String idParticipante, String idConcurso);
}
