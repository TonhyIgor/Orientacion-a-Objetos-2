package tps.tp4.ejercicio1.model;

public class ApiPersistencia implements Persistencia {
    private RegistroParticipante registrar;

    public ApiPersistencia(RegistroParticipante registrar) {
        this.registrar = registrar;
    }

    @Override
    public void agregarParticipante(String nombre, String telefono, String region) {
        Participante participante = new Participante(nombre, telefono, region);
        this.registrar.agregarParticipante(participante.nombre(), participante.telefono(), participante.region());
    }
}
