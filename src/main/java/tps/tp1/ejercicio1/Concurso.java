package tps.tp1.ejercicio1;

import tps.tp1.ejercicio1.comunicacion.InformarInscripcion;
import tps.tp1.ejercicio1.persistencia.RegistrarInscripcion;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Concurso {
    private List<Inscripcion> inscripciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String idConcurso;
    private RegistrarInscripcion registrarInscripcion;
    private InformarInscripcion informarInscripcion;

    public Concurso(List<Inscripcion> inscripciones, LocalDate fechaInicio, LocalDate fechaFin, String idConcurso,
                    RegistrarInscripcion registrarInscripcion, InformarInscripcion informarInscripcion) {
        this.inscripciones = inscripciones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idConcurso = idConcurso;
        this.registrarInscripcion = registrarInscripcion;
        this.informarInscripcion = informarInscripcion;
    }

    private boolean existeInscripcion(Inscripcion inscripcion) {
        return inscripciones.contains(inscripcion);
    }

    public void inscribirPersona(Participante participante) {
        if (this.sePuedenInscribir()) {
            LocalDate ahora = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = ahora.format(formato);
            Period diferencia = Period.between(fechaInicio, ahora);

            //se realiza la inscripcion
            Inscripcion inscripcion = new Inscripcion(LocalDate.now(), participante, this);
            this.inscripciones.add(inscripcion);
            //se registra la inscripcion
            registrarInscripcion.exportar(ahora, participante.getId(), this.idConcurso);
            //se informa la inscripcion
            informarInscripcion.informar("Inscripcion exitosa al concurso " + idConcurso, "El participante " + participante.getId() +
                    " se ha inscripto al concurso " + idConcurso + " el dia " + fechaFormateada);
            if (diferencia.getDays() < 1) {
                participante.sumarPuntos();
            }
        } else {
            //System.out.println("El participante no se puede inscribir al concurso.");
            //nunca usar sout en la logica de negocios
            throw new RuntimeException("El participante no se puede inscribir al concurso.");
        }
    }

    private boolean sePuedenInscribir() {
        return LocalDate.now().isBefore(this.fechaFin);
    }

    public boolean existeInscripcionParticipante(Participante participante) {
        return inscripciones.stream().anyMatch(inscripcion -> inscripcion.getParticipante().equals(participante));
    }
}
