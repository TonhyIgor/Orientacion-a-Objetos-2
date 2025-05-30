package tps.tp1.ejercicio1;

import java.time.LocalDate;

public class Inscripcion {
    private LocalDate fechaInscripcion;
    private Participante participante;
    private Concurso concurso;

    public Inscripcion(LocalDate fechaInscripcion, Participante participante, Concurso concurso) {
        this.fechaInscripcion = fechaInscripcion;
        this.participante = participante;
        this.concurso = concurso;
    }

    protected Participante getParticipante() {
        return this.participante;
    }
}
