package tps.tp4.ejercicio1.model;

import tps.tp4.ejercicio1.database.ManejoParticipante;

public class ApiPersistencia implements Persistencia {
    private ManejoParticipante conexion;

    public ApiPersistencia(ManejoParticipante conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarParticipante(String nombre, String telefono, String region) {
        Participante participante = new Participante(nombre, telefono, region);
        this.conexion.agregarParticipante(participante.nombre(), participante.telefono(), participante.region());
    }
}
