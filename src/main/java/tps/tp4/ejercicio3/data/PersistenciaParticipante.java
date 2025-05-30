package tps.tp4.ejercicio3.data;

import tps.tp4.ejercicio3.model.Participante;

public interface PersistenciaParticipante {
    void registrarParticipante(Participante participanteNuevo, String idConcurso);
}
