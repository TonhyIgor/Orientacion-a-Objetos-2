package tps.tp4.model;

import tps.tp4.database.JdbcABMParticipante;

public class Api implements Persistencia {
    private JdbcABMParticipante conexion;

    @Override
    public void agregarParticipante(String nombre, String telefono, String region) {
        Participante participante = new Participante(nombre, telefono, region);

        conexion =
    }
}
