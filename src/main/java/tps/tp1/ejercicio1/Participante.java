package tps.tp1.ejercicio1;

import java.util.Objects;

public class Participante {
    private String nombre;
    private String apellido;
    private int dni;
    private int puntos;
    private String idParticipante;

    public Participante(String nombre, String apellido, int dni, String idParticipante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.idParticipante = idParticipante;
    }

    public void sumarPuntos() {
        this.puntos += 10;
    }

    protected int getPuntos() {
        return puntos;
    }

    protected String getId() {
        return this.idParticipante;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return Objects.equals(idParticipante, that.idParticipante);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idParticipante);
    }
}
