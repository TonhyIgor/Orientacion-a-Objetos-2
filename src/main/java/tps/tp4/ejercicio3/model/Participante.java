package tps.tp4.ejercicio3.model;

public class Participante {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;

    public Participante(String nombre, String apellido, String dni, String telefono, String email) {
        validations(nombre, apellido, dni, telefono, email);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    private void validations(String nombre, String apellido, String dni, String telefono, String email) {
        if (nombre.isEmpty()) {
            throw new RuntimeException("Nombre no puede ser vacio");
        }
        if (apellido.isEmpty()) {
            throw new RuntimeException("Apellido no puede ser vacio");
        }
        if (dni.isEmpty()) {
            throw new RuntimeException("DNI no puede ser vacio");
        }
        if (!checkPhone(telefono)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!checkEmail(email)) {
            throw new RuntimeException("Email debe ser válido");
        }
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public String dni() {
        return dni;
    }

    public String telefono() {
        return telefono;
    }

    public String email() {
        return email;
    }
}
