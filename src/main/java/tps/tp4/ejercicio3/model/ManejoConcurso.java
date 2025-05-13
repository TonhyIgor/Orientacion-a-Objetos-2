package tps.tp4.ejercicio3.model;

import tps.tp4.ejercicio3.data.PersistenciaConcurso;
import tps.tp4.ejercicio3.data.PersistenciaParticipante;

import java.util.List;

public class ManejoConcurso {
    private List<Concurso> concursos;
    private PersistenciaParticipante datosParticipantes;
    private PersistenciaConcurso datosConcursos;

    public ManejoConcurso(PersistenciaParticipante datosParticipantes, PersistenciaConcurso datosConcursos) {
        this.datosParticipantes = datosParticipantes;
        this.datosConcursos = datosConcursos;
    }

    public void agregarParticipante(String nombre, String apellido, String dni, String telefono, String email, String idConcurso) {
        Concurso concursoAInscribirse = concursos.stream().filter(c -> c.concursoExiste(idConcurso)).findFirst().get();
        Participante participanteNuevo = new Participante(nombre, apellido, dni, telefono, email);
        concursoAInscribirse.agregarParticipante(participanteNuevo);
        datosParticipantes.registrarParticipante(participanteNuevo, idConcurso);
    }

    public List<Concurso> concursosActivos() {
        return concursos.stream().filter(Concurso::estaActivo).toList();
    }

    public void cargarConcursos() {
        this.concursos = datosConcursos.obtenerConcurso();
    }
}
