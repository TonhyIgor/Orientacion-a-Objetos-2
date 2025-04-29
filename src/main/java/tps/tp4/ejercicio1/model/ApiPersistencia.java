package tps.tp4.ejercicio1.model;

public class ApiPersistencia implements Persistencia {
    private RegistroParticipante conexion;

    public ApiPersistencia(RegistroParticipante conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarParticipante(String nombre, String telefono, String region) {
        Participante participante = new Participante(nombre, telefono, region);
        this.conexion.agregarParticipante(participante.nombre(), participante.telefono(), participante.region());
    }
}
