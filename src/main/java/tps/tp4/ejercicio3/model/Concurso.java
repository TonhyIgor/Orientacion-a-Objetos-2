package tps.tp4.ejercicio3.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Participante> participantes;


    public Concurso(String id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.participantes = new ArrayList<>();
    }

    public boolean estaActivo() {
        return LocalDate.now().isAfter(this.fechaInicio) && LocalDate.now().isBefore(this.fechaFin);
    }

    boolean concursoExiste(String id) {
        return this.id.equals(id);
    }

    void agregarParticipante(Participante participante) {
        this.participantes.add(participante);
    }

    public String id() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
