package tps.tp4.ejercicio1.model;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) {
        validarDatos(nombre, telefono, region);
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private void validarDatos(String nombre, String telefono, String region) {
        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("Debe cargar un nombre");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new RuntimeException("Debe cargar un telefono");
        }
        if (!validarTelefono(telefono)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String nombre() {
        return this.nombre;
    }

    public String telefono() {
        return this.telefono;
    }

    public String region() {
        return this.region;
    }
}
